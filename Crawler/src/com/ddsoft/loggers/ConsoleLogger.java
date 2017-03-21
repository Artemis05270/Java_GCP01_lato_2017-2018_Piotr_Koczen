package com.ddsoft.loggers;

import com.ddsoft.crawler.GUI;
import com.ddsoft.interfaces.Logger;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String status, String student) {
        GUI.area.append(status + ": " +student + "\n");
    }
}
