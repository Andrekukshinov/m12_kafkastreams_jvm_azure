package com.epam.bd201.mapper;

import com.epam.bd201.model.Hotel;

public interface Mapper<T> {
    T mapFromJson(String json);
    String mapToJson(T obj);

}
