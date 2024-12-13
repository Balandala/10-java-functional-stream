package com.example.task05;

public interface Mail<T> {
    String getFrom();
    String getTo();
    T getContent();
}
