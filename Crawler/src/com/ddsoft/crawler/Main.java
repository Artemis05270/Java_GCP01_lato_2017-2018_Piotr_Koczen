package com.ddsoft.crawler;


import com.ddsoft.exceptions.CrawlerException;

public class Main {


    public static void main(String[] args){

    Start.start(new GUI(),800,600);
    Crawler test = new Crawler();
    test.enableLogAdd();
    test.enableLogRemove();
    test.disableLogisModifed();
    test.enableLogIteration();
    //test.enableLogIsModifed();
    test.changeDirectory("C:\\Users\\Piotrek\\Desktop\\43d5c-crawler\\Crawler\\students.txt");
        try {
            test.run();
        } catch (CrawlerException e) {
            e.printStackTrace();
        }
    }
}
