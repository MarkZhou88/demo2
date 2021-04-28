package com.example.demo.dates;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class DateJacksonConverter extends JsonDeserializer<Date> {

    private static final Logger log = LoggerFactory.getLogger(DateJacksonConverter.class);

    private static final String[] pattern = new String[] {
            "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd"
    };

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException, JsonProcessingException {

        Date targetDate = null;
        String originDate = jsonParser.getText();

        if (StringUtils.isNotEmpty(originDate)) {

            try {
                long longDate = Long.parseLong(originDate.trim());
                targetDate = new Date(longDate);
            } catch (NumberFormatException pe) {
                try {
                    targetDate = DateUtils.parseDate(
                            originDate, DateJacksonConverter.pattern
                    );
                } catch (ParseException ex) {
                    log.error("parse error: {}", ex.getMessage());
                    throw new IOException("parse error");
                }
            }
        }

        return targetDate;
    }

    @Override
    public Class<?> handledType() {
        return Date.class;
    }
}
