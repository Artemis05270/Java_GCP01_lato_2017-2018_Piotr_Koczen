package com.ddsoft.crawler;

import com.ddsoft.comparators.AgeComparator;
import com.ddsoft.comparators.FirstNameComparator;
import com.ddsoft.comparators.LastNameComparator;
import com.ddsoft.comparators.MarkComparator;
import com.ddsoft.exceptions.CrawlerException;
import com.ddsoft.interfaces.Logger;
import com.ddsoft.loggers.ConsoleLogger;
import com.ddsoft.loggers.MailLogger;
import java.util.*;


public class Crawler{
    private List<Student> list;
    private String dir=null;

    public boolean isLogAdd() {
        return logAdd;
    }

    public boolean isLogRemove() {
        return logRemove;
    }

    public boolean isLogIsModifed() {
        return logIsModifed;
    }

    public boolean isLogIteration() {
        return logIteration;
    }

    private boolean logAdd=false,
                    logRemove=false,
                    logIsModifed=false,
                    logIteration=false;

    public Crawler() {
        list = new ArrayList<>();
    }

    public enum OrderMode
    {
        MARK,
        FIRST_NAME,
        LAST_NAME,
        AGE
    }

    public enum ExtremumMode
    {
        MAX,
        MIN
    }


    public List<Student> extractStudents( OrderMode mode )
    {
        List<Student> temp = list;
        switch (mode)
        {
            case MARK: Collections.sort(list,new MarkComparator()); break;
            case AGE: Collections.sort(list,new AgeComparator()); break;
            case FIRST_NAME: Collections.sort(list,new FirstNameComparator()); break;
            case LAST_NAME: Collections.sort(list,new LastNameComparator()); break;
        }
        return temp;
    }

    public Student extractMark(ExtremumMode mode )
    {

        switch (mode)
        {
            case MAX:
                return Collections.max(list,new MarkComparator());
            case MIN:
                return Collections.min(list,new MarkComparator());
        }
        return null;
    }

    public Student extractAge(ExtremumMode mode )
    {
        switch (mode)
        {
            case MAX:
                return Collections.max(list,new AgeComparator());
            case MIN:
                return Collections.min(list,new AgeComparator());
        }
        return null;
    }

    public void changeDirectory(String directory){
        dir=directory;
    }

    public void run() throws CrawlerException {
        GUI.area.append("Welcome in Crowler!\n");
        int iterations = 0 ;
        boolean flaga = true,
                flaga2 = true;
        final Logger logger[] = new Logger[] {
                new ConsoleLogger(),
                new MailLogger()
        };
        if(dir!=null){
        List<Student> tempList;
        list=Parser.parse(dir);
        while( true ) {
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (dir != null){
                tempList = Parser.parse(dir);
            }
            else throw new CrawlerException();


          //------------------REMOVE EVENT-----------------
            if(isLogRemove()) {
                for (Student i : list) {
                    if (!tempList.contains(i)) {
                        flaga = false;
                        for (Logger j : logger)
                            j.log("REMOVED", i.toString());
                    }
                }
            }
            //---------------------------------------------
            //------------------ADD EVENT------------------
            if(isLogAdd()) {
                for (Student i : tempList) {
                    if (!list.contains(i)) {
                        flaga2 = false;
                        for (Logger j : logger)
                            j.log("ADDED", i.toString());
                    }
                }
            }
            //---------------------------------------------
            //----------------NOTHING EVENT----------------
            if(flaga&&flaga2&&isLogIsModifed()) {
                for(Logger j: logger)
                j.log("NOTHING CHANGED", "");
            }
            //---------------------------------------------

            iterations++;
            list=tempList;
            if(!flaga||!flaga2)
            {
                GUI.area.append("Iteration: " + iterations + "\n");
                GUI.area.append("Age: <" + extractAge(ExtremumMode.MIN).getAge() + ", " + extractAge(ExtremumMode.MAX).getAge() + ">\n");
                GUI.area.append("Mark: <" + extractMark(ExtremumMode.MIN).getMark() + ", " + extractMark(ExtremumMode.MAX).getMark() + ">\n");
                GUI.area.append("Ordered by mark:\n");
                List<Student> sorted = extractStudents(OrderMode.MARK);
                for(int i = 0 ; i < sorted.size() ; i++)
                {
                GUI.area.append(sorted.get(i).toString() + "\n");
                }

            }
            flaga=flaga2=true;
        }
    }else throw new CrawlerException();
    }


    public void enableLogAdd()
    {
        logAdd=true;
    }

    public void disableLogAdd()
    {
        logAdd=false;
    }

    public void enableLogRemove()
    {
        logRemove=true;
    }

    public void disableLogRemove()
    {
        logRemove=false;
    }

    public void enableLogIsModifed()
    {
        logIsModifed=true;
    }

    public void disableLogisModifed()
    {
        logIsModifed=false;
    }

    public void enableLogIteration()
    {
        logIteration=true;
    }

    public void disableLogIteration()
    {
        logIteration=false;
    }

}
