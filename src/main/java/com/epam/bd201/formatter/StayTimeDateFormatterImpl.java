package com.epam.bd201.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StayTimeDateFormatterImpl implements StayTimeDateFormatter {
    private static final Logger LOG = LogManager.getLogger(StayTimeDateFormatterImpl.class);

    private final SimpleDateFormat formatter;

    public StayTimeDateFormatterImpl(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public Date parseDate (String stringTime) {
        try {
            return formatter.parse(stringTime);
        } catch (ParseException e) {
            LOG.error("cannot parse string date to date {} (expected format is yyyy-MM-dd)", stringTime);
            throw new RuntimeException(e);
        }
    }
}
