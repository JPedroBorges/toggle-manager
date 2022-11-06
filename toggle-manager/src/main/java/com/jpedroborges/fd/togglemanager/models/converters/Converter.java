package com.jpedroborges.fd.togglemanager.models.converters;

public interface Converter<T, S> {
    S convert(T convertableObject);
}
