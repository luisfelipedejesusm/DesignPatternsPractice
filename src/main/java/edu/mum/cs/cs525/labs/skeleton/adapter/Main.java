package edu.mum.cs.cs525.labs.skeleton.adapter;

import org.apache.logging.log4j.LogManager;

public class Main {
    public static void main(String[] args) {
        Logger logger = new LoggerAdapter(LogManager.getLogger());
        logger.log(LogLevel.DEBUG, "Debugging");
    }
}
