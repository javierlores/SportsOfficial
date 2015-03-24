package com.example.domain.mappers;

import java.util.Collection;

public interface Mapper<T, F> {
    public T transform(F from);
    public Collection<T> transform(Collection<F> collection);
}
