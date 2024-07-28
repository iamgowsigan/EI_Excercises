//Factory pattern is a creational design pattern that provides a way to create objects without specifying the exact class of object that will be created. 
//This pattern creates an object via a factory class and returns the object through a common interface.

package Creational_Design_Patterns;

// Notification interface
interface Notification {
    void notifyUser();
}

// Concrete Notifications
class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an email notification...");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification...");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a push notification...");
    }
}

// Notification Factory
class NotificationFactory {
    public Notification getNotification(String notificationType) {
        if (notificationType == null) {
            return null;
        }
        if (notificationType.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (notificationType.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (notificationType.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        return null;
    }
}

// Main class to demonstrate
public class FactoryPatternDemo {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();

        Notification notification1 = notificationFactory.getNotification("EMAIL");
        notification1.notifyUser();

        Notification notification2 = notificationFactory.getNotification("SMS");
        notification2.notifyUser();

        Notification notification3 = notificationFactory.getNotification("PUSH");
        notification3.notifyUser();
    }
}
