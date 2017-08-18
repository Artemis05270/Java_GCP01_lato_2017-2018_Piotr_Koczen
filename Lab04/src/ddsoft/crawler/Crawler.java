package ddsoft.crawler;
import ddsoft.comparators.AgeComparator;
import ddsoft.comparators.FirstNameComparator;
import ddsoft.comparators.LastNameComparator;
import ddsoft.comparators.MarkComparator;
import ddsoft.exceptions.CrawlerException;
import ddsoft.interfaces.Logger;
import ddsoft.loggers.MailLogger;
import sample.CustomTabPane;
import sample.GUILogger;

import java.util.*;

import static sample.CustomTextArea.txtArea;


public class Crawler{
    public List<Student> list;
    public static String dir=null;

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
        int iterations = 0 ;
        boolean flaga = true,
                flaga2 = true,
                flaga3=true;
        final Logger logger[] = new Logger[] {
                new GUILogger(),
                new MailLogger()
        };
        if(dir!=null){
        List<Student> tempList;
        list=Parser.parse(dir);
        while( true ) {
            try
            {
                Thread.sleep(1000);
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
                        CustomTabPane.table.getItems().remove(i);
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
                        CustomTabPane.table.getItems().add(i);
                        flaga2 = false;
                        for (Logger j : logger) {
                            j.log("ADDED", i.toString());

                        }
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
            //--------------FIRST INSERT TO TAB------------
            if(flaga3) {
                for(Student i : list){
                    CustomTabPane.table.getItems().add(i);
                }
                flaga3=false;
            }



            iterations++;
            list=tempList;
            if(!flaga||!flaga2)
            {
                txtArea.appendText("Iteration: " + iterations + "\n");
                txtArea.appendText("Age: <" + extractAge(ExtremumMode.MIN).getAge() + ", " + extractAge(ExtremumMode.MAX).getAge() + ">\n");
                txtArea.appendText("Mark: <" + extractMark(ExtremumMode.MIN).getMark() + ", " + extractMark(ExtremumMode.MAX).getMark() + ">\n");
                txtArea.appendText("Ordered by mark:\n");
                List<Student> sorted = extractStudents(OrderMode.MARK);
                for(int i = 0 ; i < sorted.size() ; i++){
                    txtArea.appendText(sorted.get(i).toString() + "\n");
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
