//Creational design patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The basic form of object creation could result in design problems or added complexity to the design. 
//Creational design patterns solve this problem by controlling the object creation process.

// Singleton Logger

package Creational_Design_Patterns;

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Main class to demonstrate
public class SingletonPatternDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a singleton logger example.");
        System.out.println(logger1 == logger2); // Should print true
    }
}
