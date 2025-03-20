package java_practice.singleton;

import org.apache.poi.xssf.usermodel.XSSFPivotTable;

import java.util.*;

public class genInt {
    public static void main(String[] args) {
        int[] a = {34, 63, -23, 12, -2, 45, 55, 8};
        fibonacciSeries();
        factorial();
        checkPrime();
        listPrimeNumber();
        checkLeapYear();

        genIntSortAsc(a);
        genIntSortDesc(a);

        selectionIntSortAsc(a);
        selectionIntSortDesc(a);

        bubbleIntSortAsc(a);
        bubbleIntSortDesc(a);

        sortUsingArray(a);
        sortUsingArrayAsList();
        sortUsingArrayList(a);
        sortUsingSet(a);

        linearSearch(a);
        binarySearch(a);

        addSeq();
        palinDrome();
        findMissingNumber();
        swapNumber();
    }

    private static void fibonacciSeries() {
        int a = 0, b = 1, c, sum = 0, n = 10;
        System.out.print("Fibonacci series are :  ");
        for (int i = 0; i <= n; i++) {
            System.out.print(a + " ");
            sum += a;
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
        System.out.println("Sum of Series is : " + sum);
    }

    private static void factorial() {
        int fact = 1, n = 5;
        for (int i = 1; i <= n; i++)
            fact *= i;
        System.out.println("Factorial of " + n + " is : " + fact);
    }

    private static boolean isPrime(int n) {
        boolean flag = true;
        if (n <= 1)
            flag = false;
        else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {

                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static void checkPrime() {
        if (isPrime(9))
            System.out.println("Given number is Prime");
        else
            System.out.println("Given number is not Prime");
    }

    private static void listPrimeNumber() {
        for (int i = 0; i <= 10; i++) {
            if (isPrime(i))
                System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void checkLeapYear() {
        int year = 2011;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println("Given year is Leap year");
        else
            System.out.println("Given year is not Leap year");
    }

    private static void genIntSortAsc(int[] a) {
        System.out.println("General integer sort :");
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
    }

    private static void genIntSortDesc(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static void selectionIntSortAsc(int[] a) {
        System.out.println("Selection integer sort :");
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j])
                    minIndex = j;
            }
            int tmp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }

    private static void selectionIntSortDesc(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] < a[j])
                    minIndex = j;
            }
            int tmp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = tmp;
        }
        System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static void bubbleIntSortAsc(int[] a) {
        System.out.println("Bubble integer sort :");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleIntSortDesc(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static void sortUsingArray(int[] a) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sortUsingArrayAsList() {
        Integer[] a = {34, 63, -23, 12, -2, 45, 55, 8};
        List<Integer> list = Arrays.asList(a);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void sortUsingArrayList(int[] a) {
        List list = new ArrayList<>();
        for (int i : a)
            list.add(i);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void sortUsingSet(int[] a) {
        Set set = new TreeSet<>();
        for (int i : a)
            set.add(i);
        System.out.println(set);
    }

    private static void linearSearch(int[] a) {
        int srch = -2;
        boolean flag = false;
        for (int i : a)
            if (i == srch) {
                flag = true;
                break;
            }
        if (flag)
            System.out.println("Given search has found");
        else
            System.out.println("Given search has not found");
    }

    private static void binarySearch(int[] a) {
        int srch = 63;
        int fst = 0;
        int lst = a.length - 1;
        while (fst <= lst) {
            int mid = (fst + lst) / 2;
            if (a[mid] < srch)
                fst = mid + 1;
            else if (a[mid] == srch) {
                System.out.println("Given search has found");
                break;
            } else if (a[mid] > srch)
                lst = mid - 1;
        }

        if (fst > lst)
            System.out.println("Given search has not found");
    }

    private static void addSeq() {
        int n = 363246, sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        System.out.println("Sum of series is : " + sum);
    }

    private static void palinDrome() {
        int n = 656;
        int rem, sum = 0, tmp = n;
        while (n != 0) {
            rem = n % 10;
            sum = (sum * 10) + rem;
            n = n / 10;
        }
        if (tmp == sum)
            System.out.println("Given number is Palindrome");
        else
            System.out.println("Given number is not Palindrome");
    }

    private static void findMissingNumber() {
        int[] a = {3, 0, 1};
        int n = a.length;
        int exp_num = (n * (n + 1)) / 2;
        int act_num = 0;
        for (int i : a)
            act_num += i;
        System.out.println("Missing number is " + (exp_num - act_num));
    }

    private static void swapNumber() {
        int a = 20, b = 10, c = 35, d = 20;

        b = a + b;
        a = b - a;
        b = a + a;
        System.out.println("a = " + a + " b = " + b);

        c = c + d;
        d = c - d;
        c = c - d;
        System.out.println("c = " + c + " d = " + d);
    }
}
