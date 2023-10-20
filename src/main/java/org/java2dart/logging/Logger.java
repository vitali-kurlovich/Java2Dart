package org.java2dart.logging;

public interface Logger {
    enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    void log(Level level, String msg);
}
