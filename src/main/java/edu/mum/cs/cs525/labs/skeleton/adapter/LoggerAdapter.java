package edu.mum.cs.cs525.labs.skeleton.adapter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class LoggerAdapter implements Logger{

    private org.apache.logging.log4j.Logger logger;

    public LoggerAdapter(org.apache.logging.log4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        logger.log(Level.getLevel(logLevel.toString()), message);
    }
}
