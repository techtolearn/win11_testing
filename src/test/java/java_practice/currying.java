package java_practice;


import java.util.function.Function;

public class currying {

    static Function<Integer, Function<Integer, Integer>> add =
            x ->y  -> x + y;

    public static void main(String[] args) {
       Function<Integer,Integer> adds = add.apply(5);

       int results = adds.apply(3);
        System.out.println(results);
        System.out.println(add.apply(5).apply(6));

    }

}