package ddsoft.loggers;
import ddsoft.interfaces.Logger;

public class ConsoleLogger implements Logger {

    public void log(String status, String student) {

        switch(status){
            case "ADDED":
                System.out.println("[ADDED] "+student+"\n");
                break;
            case "REMOVED":
                System.out.println("[REMOVED] "+student+"\n");
                break;
            case "NOTHING CHANGED":
                System.out.println("[UNCHANGED]\n");
                break;
        }
    }
}
