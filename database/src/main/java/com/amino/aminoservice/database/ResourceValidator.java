package com.amino.aminoservice.database;

import liquibase.changelog.IncludeAllFilter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sridharswain
 */
public class ResourceValidator implements IncludeAllFilter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");

    private static final String ERROR_MESSAGE = "Error occurred while parsing changelog file :: " +
            "Please check the file name it should follow a pattern changelog-vx.xx-yyyyMMddHHmm-name-desc.xml";

    @Override
    public boolean include(String s) {
        String[] directories = s.split("/");
        String fileName = directories[directories.length - 1];
        if (fileName == null || fileName.length() == 0) {
            return false;
        }
        // Should be 10 digits first.
        if (!fileName.matches("changelog-v\\d\\.\\d{2}-\\d{10}-.*\\.xml$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        try {
            LocalDateTime.parse(fileName.split("-")[2], formatter);
        } catch (Exception exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }
}
