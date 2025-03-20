package java_practice.singleton;

public class Singleton {
    private static Singleton instance; // Static variable to hold a single instance

    private Singleton(){  // Private constructor
        System.out.println("Singleton created");
    }

    public static Singleton getInstance(){
        if(instance == null){   // Create instance only if it doesn't exist
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello from singleton");
    }

}
