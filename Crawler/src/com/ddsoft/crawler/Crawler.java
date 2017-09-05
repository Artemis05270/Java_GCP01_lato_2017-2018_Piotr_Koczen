package com.ddsoft.crawler;

import com.ddsoft.comparators.AgeComparator;
import com.ddsoft.comparators.FirstNameComparator;
import com.ddsoft.comparators.LastNameComparator;
import com.ddsoft.comparators.MarkComparator;
import com.ddsoft.exceptions.CrawlerException;
import com.ddsoft.loggers.ParallelLogger;

import java.util.*;


public class Crawler{
    private String name=null;
    private List<Student> list;
    private String address;
    public void getName(String name2){
        name=name2;
    }
    private boolean isLogAdd() {
        return logAdd;
    }

    private boolean isLogRemove() {
        return logRemove;
    }

    private boolean isLogIsModifed() {
        return logIsModifed;
    }

    public boolean isLogIteration() {
        return logIteration;
    }
    private boolean runFlag = true;
    private boolean logAdd=false,
            logRemove=false,
            logIsModifed=false,
            logIteration=false;

    Crawler() {
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
    private List<Student> extractStudents(OrderMode mode)
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

    private Student extractMark(ExtremumMode mode)
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
    void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return this.address;
    }
    private Student extractAge(ExtremumMode mode)
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
        address =directory;
    }
    private ParallelLogger logger = new ParallelLogger();
    synchronized void postCancel(){
        runFlag=false;
    }

    public boolean flaga = true,
            flaga2 = true;
    void run() throws CrawlerException {
        int iterations = 0;


        if (address != null) {
            List<Student> tempList;
            list = Parser.parse(address);
            while (runFlag){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (address != null) {
                    tempList = Parser.parse(address);
                } else throw new CrawlerException();


                //------------------REMOVE EVENT-----------------
                if (isLogRemove()) {
                    for (Student i : list) {
                        if (!tempList.contains(i)) {
                            flaga = false;
                            logger.log(name+": REMOVED",i);
                        }
                    }
                }
                //---------------------------------------------
                //------------------ADD EVENT------------------
                if (isLogAdd()) {
                    for (Student i : tempList) {
                        if (!list.contains(i)) {
                            flaga2 = false;
                            logger.log(name+": ADDED",i);
                        }
                    }
                }
                //---------------------------------------------
                //----------------NOTHING EVENT----------------
                if (flaga && flaga2 && isLogIsModifed()) {
                    logger.log("NOTHING CHANGED",null);
                }
                //---------------------------------------------

                iterations++;
                list = tempList;
                if (!flaga || !flaga2) {
                    GUI.area.append("Iteration: " + iterations + "\n");
                    GUI.area.append("Age: <" + extractAge(ExtremumMode.MIN).getAge() + ", " + extractAge(ExtremumMode.MAX).getAge() + ">\n");
                    GUI.area.append("Mark: <" + extractMark(ExtremumMode.MIN).getMark() + ", " + extractMark(ExtremumMode.MAX).getMark() + ">\n");
                    GUI.area.append("Ordered by mark:\n");
                    List<Student> sorted = extractStudents(OrderMode.MARK);
                    for (int i = 0; i < sorted.size(); i++) {
                        GUI.area.append(name+" "+sorted.get(i).toString() + "\n");
                    }

                }
                flaga = flaga2 = true;
            }
        } else throw new CrawlerException();
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
