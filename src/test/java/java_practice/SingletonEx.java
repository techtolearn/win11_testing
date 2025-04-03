package java_practice;

class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("I am from Singleton Constructor");
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public void display() {
        System.out.println("I am from singleton class");
    }

}

public class SingletonEx {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        obj.display();
    }
}
