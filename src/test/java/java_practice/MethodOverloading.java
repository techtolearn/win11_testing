package java_practice;
class MathOperations {
    // Method 1: Adds two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: Adds three integers (Overloaded method)
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: Adds two double values (Overloaded method)
    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        // Calling overloaded methods
        System.out.println(math.add(5, 10));         // Calls method 1 → Output: 15
        System.out.println(math.add(5, 10, 15));     // Calls method 2 → Output: 30
        System.out.println(math.add(5.5, 2.5));      // Calls method 3 → Output: 8.0
    }
}

