package com.epam.bd201.service;

import com.epam.bd201.KStreamsApplication;
import com.epam.bd201.formatter.StayTimeDateFormatter;
import com.epam.bd201.mapper.Mapper;
import com.epam.bd201.model.Hotel;
import com.epam.bd201.model.StayType;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HotelServiceImpl implements HotelService {
    private static final Logger LOG = LogManager.getLogger(HotelServiceImpl.class);

    private final Mapper<Hotel> objectMapper;
    private final StayTimeDateFormatter dateFormatter;

    public HotelServiceImpl(Mapper<Hotel> objectMapper, StayTimeDateFormatter dateFormatter) {
        this.objectMapper = objectMapper;
        this.dateFormatter = dateFormatter;
    }

    public String returnUpdatedHotel(String jsonHotel) {
        Hotel hotel = objectMapper.mapFromJson(jsonHotel);
        if (hotel.getSrchCi() == null || hotel.getSrchCo() == null) {
            hotel.setStayType(StayType.ERRONEOUS);
            LOG.info("Stay with id {} contains error data", hotel.getId());
            return objectMapper.mapToJson(hotel);
        }
        Date ci = dateFormatter.parseDate(hotel.getSrchCi());
        Date co = dateFormatter.parseDate(hotel.getSrchCo());
        long millisDiff = Math.abs(co.getTime() - ci.getTime());
        long daysDiff = TimeUnit.DAYS.convert(millisDiff, TimeUnit.MILLISECONDS);

        hotel.setStayType(getStayType(daysDiff));
        return objectMapper.mapToJson(hotel);
    }

    private StayType getStayType(long daysDiff) {
        if (daysDiff <= StayType.SHORT_STAY.getMaxDaysOfStay()) {
            return StayType.SHORT_STAY;
        } else if (daysDiff <= StayType.STANDARD_STAY.getMaxDaysOfStay()) {
            return StayType.STANDARD_STAY;
        } else if (daysDiff <= StayType.STANDARD_EXTENDED_STAY.getMaxDaysOfStay()) {
            return StayType.STANDARD_EXTENDED_STAY;
        } else {
            return StayType.LONG_STAY;
        }
    }
}
