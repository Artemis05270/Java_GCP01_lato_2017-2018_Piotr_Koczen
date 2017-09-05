package com.ddsoft.loggers;

import com.ddsoft.crawler.GUI;
import com.ddsoft.crawler.Student;
import com.ddsoft.interfaces.Logger;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String status, Student student) {
        GUI.area.append(status + ": " +student + "\n");
        System.out.println(status+": "+student);
    }
}
