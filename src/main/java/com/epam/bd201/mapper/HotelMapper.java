package com.epam.bd201.mapper;

import com.epam.bd201.model.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HotelMapper implements Mapper<Hotel> {
    private static final Logger LOG = LogManager.getLogger(HotelMapper.class);

    private final ObjectMapper mapper;

    public HotelMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Hotel mapFromJson(String json) {
        try {
            return mapper.readValue(json, Hotel.class);
        } catch (IOException e) {
            LOG.error("invalid stay {}", json);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String mapToJson(Hotel obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            LOG.error("cannot write data to json format {}", obj);
            throw new RuntimeException(e);
        }
    }
}
