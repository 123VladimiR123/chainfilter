package com.example.testchain.chain;

public abstract class ElementaryValidator<T> {
    public abstract void returnNullOrThrowException(T elem);
}
