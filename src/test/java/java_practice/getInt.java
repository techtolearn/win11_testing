package java_practice;

import java.util.*;

public class getInt {
    public static void main(String[] args){
        int[] a = {65,84,92,-45,23,8,-12,45,33};
        fibonacciSeries();
        fact();
        primeCheck();
        listPrime();
        leapYear();
        genIntSortAsc(a);
        genIntSortDesc(a);
        selectionIntSortAsc(a);
        SelectionIntSortDesc(a);
        bubbleIntSortAsc(a);
        bubbleIntSortDesc(a);
        sortUsingArray(a);
        sortUsingArrayAsList(a);
        sortIntUsingArrayList(a);
        sortUsingSet(a);
        linearSearch(a);
        binarySearch(a);
        addSeq();
        palindrome();
        findMissingNumber();

    }
    private static void fibonacciSeries(){
        int a=0,b=1,c,sum=0,n=10;
        System.out.print("Fibonacci Series is : ");
        for(int i=0; i<n;i++){
            System.out.print(a+" ");
            sum += a;
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
        System.out.println("Sum of fibonacciSeries is : "+sum);
    }
    private static void fact(){
        int fact=1, n=5;
        for(int i=1;i<=n;i++)
            fact *= i;
        System.out.println("Factorial of  n is : "+fact);
    }

    private static boolean isPrime(int n){
        boolean flag = true;
        if(n <=1)
            flag = false;
        else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static void primeCheck(){
        if(isPrime(8))
            System.out.println("Given number is Prime");
        else
            System.out.println("Given number is not Prime");
    }

    private static void listPrime(){
        System.out.print("Prime numbers are  : ");
        for(int i=0;i<=10;i++){
            if(isPrime(i))
                System.out.print( i+" ");
        }
        System.out.println();
    }
    private static void leapYear(){
        int year = 2012;
        if((year % 4 == 0 && year % 10 != 0) || year % 4 == 400)
            System.out.println("Given year is Leap year");
        else
            System.out.println("Given year is not Leap year");
        System.out.println();
    }

    private static void genIntSortAsc(int[] a){
        System.out.println("General Sorting method : ");
        for(int i=0;i<a.length;i++){
            for(int j=i+1; j<a.length;j++){
                if(a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.print(a[i]+ " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
        System.out.println();
    }
    private static void genIntSortDesc(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1; j<a.length;j++){
                if(a[i] < a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.print(a[i]+ " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
        System.out.println();
    }
    private static void selectionIntSortAsc(int[] a){
        System.out.println("Selection Sorting method : ");
        for(int i=0;i<a.length;i++){
            int minIndex = i;
            for(int j=i+1; j<a.length;j++){
                if(a[minIndex] > a[j])
                    minIndex = j;
                int tmp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = tmp;
                }
            }

        System.out.println(Arrays.toString(a));
    }
    private static void SelectionIntSortDesc(int[] a){
        for(int i=0;i<a.length;i++){
            int minIndex = i;
            for(int j=i+1; j<a.length;j++){
                if(a[minIndex] < a[j])
                    minIndex = j;
                int tmp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static void bubbleIntSortAsc(int[] a){
        boolean flag = false;
        System.out.println("Bubble Sorting method : ");
        for(int i=0;i<a.length-1;i++){
            for(int j=0; j<a.length-1;j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
        System.out.println(Arrays.toString(a));

    }
    private static void bubbleIntSortDesc(int[] a){
        boolean flag = false;
        for(int i=0;i<a.length-1;i++){
            for(int j=0; j<a.length-1;j++){
                if(a[j] < a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
        System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static void sortUsingArray(int[] a){
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
    private static void sortUsingArrayAsList(int[] a){
        Integer[] b = Arrays.stream(a).boxed().toArray(Integer[]::new);
        List<Integer>  list = Arrays.asList(b);
        Collections.sort(list);
        System.out.println(list);
    }
    private static void sortIntUsingArrayList(int[] a){
        Integer[] b = Arrays.stream(a).boxed().toArray(Integer[]::new);
        List<Integer> list = new ArrayList<>(Arrays.asList(b));
        Collections.sort(list);
        System.out.println(list);
    }

    private static void sortUsingSet(int[] a){
        Integer[] b = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Set<Integer> set = new TreeSet<>(Arrays.asList(b));
        System.out.println(set);
    }

    private static void linearSearch(int[] a){
        int src = 33;
        boolean flag = false;
        for(int i : a) {
            if (i == src) {
                flag = true;
                break;
            }
        }
        if(flag)
            System.out.println("Given search found");
        else
            System.out.println("Given search not found");
    }
    private static void binarySearch(int[] a){
        int fst = 0;
        int src = 33;
        Arrays.sort(a);
        int lst = a.length-1;
        while(fst <= lst){
            int mid = (fst + lst)/2;
            if(a[mid] < src)
                fst = mid + 1;
            else if (a[mid] == src){
                System.out.println("Given search found");
                break;
            } else if(a[mid] > src)
                lst = mid - 1;
        }
        if(fst > lst)
            System.out.println("Given search not found");
    }

    private static void addSeq(){
        int n = 43632632, sum =0;
        while(n!=0){
            sum = sum + n % 10;
            n = n / 10;
        }
        System.out.println("Sum of sequence is :"+sum);
    }
    private static void palindrome(){
        int n = 565, sum=0, rem, tmp = n;
        while(n != 0){
            rem = n % 10;
            sum = (sum * 10) + rem;
            n = n /10;
        }
        if( sum == tmp)
            System.out.println("Given number is Palindrome");
        else
            System.out.println("Given number is not Palindrome");
    }

    private static void findMissingNumber(){
        int[] a = {3,0,1};
        int n = a.length;
        int exp_num = (n * (n + 1)) / 2;
        int act_num = 0;
        for(int i : a)
            act_num += i;
        System.out.println("Missing number is  : "+ (exp_num - act_num));
    }

}
