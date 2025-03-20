package java_practice.singleton;

public class singletonEx {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        obj1.showMessage();
        obj2.showMessage();
        System.out.println(obj1 == obj2);

    }

}

