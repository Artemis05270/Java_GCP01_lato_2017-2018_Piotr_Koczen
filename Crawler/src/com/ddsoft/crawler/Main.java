package com.ddsoft.crawler;


import com.ddsoft.exceptions.CrawlerException;
import com.ddsoft.exceptions.MonitorException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException, IOException, CrawlerException, MonitorException {
        Start.start(new GUI(),800,600);

        List<String> listOfFiles = new ArrayList<>();
        listOfFiles.add( "C:\\Users\\Piotrek\\Desktop\\43d5c-crawler\\Crawler\\students1.txt" );
        listOfFiles.add( "C:\\Users\\Piotrek\\Desktop\\43d5c-crawler\\Crawler\\students2.txt" );
        listOfFiles.add( "C:\\Users\\Piotrek\\Desktop\\43d5c-crawler\\Crawler\\students3.txt" );
        Monitor monitor = new Monitor( listOfFiles, 3 );


        monitor.run();
        Thread.sleep( 55000 );
        monitor.cancel();
    }
}
