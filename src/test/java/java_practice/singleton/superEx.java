package java_practice.singleton;

import javax.security.auth.Subject;

public class superEx {

    public static void main(String[] args){
        subClass sub = new subClass();
        sub.display();
        sub.printText();


    }

}

class baseClass{
    public void display(){
        System.out.println("I am from baseClass");
    }

    public void printText(){
        System.out.println("I am from baseClass");
    }
}
class subClass extends baseClass{
    public void display(){
        System.out.println("I am from subClass");
        super.display();
    }
    @Override
    public void printText(){
        System.out.println("I am from subClass by overriding");
    }
}

