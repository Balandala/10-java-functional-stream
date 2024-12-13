package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Mail<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key){
        return this.getOrDefault(key, Collections.EMPTY_LIST);
        }

    };

    public Map<String,List<T>> getMailBox(){
        return this.mailBox;
    }

    @Override
    public void accept(Mail<T> mail){
        mailBox.computeIfAbsent(mail.getTo(), m -> new ArrayList<>()).add(mail.getContent());
    }
}
