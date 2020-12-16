package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

public interface PropertiesLoader {

    default Properties loadProperties(String propertiesFilePath) {

        final Logger logger = LogManager.getLogger(this.getClass());

        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            logger.error("Could not find properties file",ioException);
            ioException.printStackTrace();
        } catch (Exception exception) {
            logger.error("Something went wrong.",exception);
            exception.printStackTrace();
        }
        return properties;
    }
}