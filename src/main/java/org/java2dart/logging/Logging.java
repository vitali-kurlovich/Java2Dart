package org.java2dart.logging;

public final  class Logging {
    private static final Logger logger = new DefaultLogger();

   public static void debug(String msg) {
        logger.log(Logger.Level.DEBUG, msg);
    }

    public static void info(String msg) {
        logger.log(Logger.Level.INFO, msg);
    }

    public static void warning(String msg) {
        logger.log(Logger.Level.WARNING, msg);
    }

    public static void error(String msg) {
        logger.log(Logger.Level.ERROR, msg);
    }
}
