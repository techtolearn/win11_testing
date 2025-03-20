package java_practice.singleton;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class genString {
    public static void main(String[] args) {
        String[] str = {"Mclean", "Herndon", "Reston", "Sterling", "Loudon", "Vienna", "Lorton"};

        genStringSortAsc(str);
        genStringSortDesc(str);

        selectionSortAsc(str);
        selectionSortDesc(str);

        bubbleSortAsc(str);
        ;
        bubbleSortDesc(str);

        sortUsingArray(str);
        sortUsingArrayAsList(str);
        sortUsingArrayList(str);
        sortUsingSet(str);

        stringSearch(str);
        findSubString(str);

        parseString();
        wordCount();
        duplicateWord();
        duplicateCount();
        duplicateCount1();
    }

    private static void genStringSortAsc(String[] str) {
        System.out.println("general string sort : ");
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) > 0) {
                    String tmp = str[i];
                    str[i] = str[j];
                    str[j] = tmp;
                }
            }
            System.out.print(str[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(str));
    }

    private static void genStringSortDesc(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) < 0) {
                    String tmp = str[i];
                    str[i] = str[j];
                    str[j] = tmp;
                }
            }
            System.out.print(str[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(str));
        System.out.println();
    }


    private static void selectionSortAsc(String[] str) {
        System.out.println("selection string sort : ");
        for (int i = 0; i < str.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < str.length; j++) {
                if (str[minIndex].compareTo(str[j]) > 0)
                    minIndex = j;
                }
                String tmp = str[minIndex];
                str[minIndex] = str[i];
                str[i] = tmp;

        }
        System.out.println(Arrays.toString(str));

    }

    private static void selectionSortDesc(String[] str) {
        for (int i = 0; i < str.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < str.length; j++) {
                if (str[minIndex].compareTo(str[j]) < 0)
                    minIndex = j;
                }
                String tmp = str[minIndex];
                str[minIndex] = str[i];
                str[i] = tmp;

        }
        System.out.println(Arrays.toString(str));
        System.out.println();
    }

    private static void bubbleSortAsc(String[] str) {
        System.out.println("bubble string sort : ");
        boolean flag = false;
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = 0; j < str.length - 1; j++) {
                if (str[j].compareTo(str[j + 1]) > 0) {
                    String tmp = str[j + 1];
                    str[j + 1] = str[j];
                    str[j] = tmp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        System.out.println(Arrays.toString(str));
    }

    private static void bubbleSortDesc(String[] str) {
        boolean flag = false;
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = 0; j < str.length - 1; j++) {
                if (str[j].compareTo(str[j + 1]) < 0) {
                    String tmp = str[j + 1];
                    str[j + 1] = str[j];
                    str[j] = tmp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        System.out.println(Arrays.toString(str));
        System.out.println();
    }

    private static void sortUsingArray(String[] str) {
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
    }

    private static void sortUsingArrayAsList(String[] str) {
        List<String> list = Arrays.asList(str);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void sortUsingArrayList(String[] str) {
        List<String> list = new ArrayList<>(Arrays.asList(str));
        Collections.sort(list);
        System.out.println(list);
    }

    private static void sortUsingSet(String[] str) {
        Set<String> set = new TreeSet<>();
        for (String s : str)
            set.add(s);
        System.out.println(set);
    }

    private static void stringSearch(String[] str) {
        boolean flag = false;
        String ch = "Vienna";
        for (String s : str)
            if (s.equals(ch)) {
                flag = true;
                break;
            }
        if (flag)
            System.out.println("Given String found in the list");
        else
            System.out.println("Given String not found in the list");
    }

    private static void findSubString(String[] str) {
        String[] str1 = new String[str.length];
        int index = 0;
        String ch = "on";
        for (String s : str)
            if (s.endsWith(ch)) {
                str1[index] = s;
                index++;
            }
        String[] finalString = Arrays.copyOf(str1, index);
        System.out.println(Arrays.toString(finalString));
        System.out.println();

    }

    private static void parseString() {
        String str = "PolicyNumber:5627346324";

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        while (m.find())
            System.out.println(m.group());

        Pattern p1 = Pattern.compile("[a-zA-Z]+");
        Matcher m1 = p1.matcher(str);
        while (m1.find())
            System.out.println(m1.group());

        String[] str1 = str.split(":");
        if (str1.length > 0)
            System.out.println(str1[1]);
    }

    private static void wordCount() {
        String str = "This is program to count the number of word in this line";
        if (str != null && !str.isEmpty()) {
            String[] word = str.split("\\s+");
            System.out.println("Number of words present in the string is  : " + word.length);
        }
    }

    private static void duplicateWord() {
        String sentence = "This program to find the duplicate words in this line, and show the duplicate words";
        String str = sentence.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = str.split("\\s+");

        Set<String> set = new HashSet<>();
        Set<String> duplicate = new HashSet<>();
        for (String word : words)
            if (!set.add(word))
                duplicate.add(word);

        System.out.println(duplicate);
    }

    private static void duplicateCount() {
        String sentence = "This program to find the duplicate words in this line, and show the duplicate words";
        String str = sentence.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = str.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        for (Map.Entry<String, Integer> entry : wordCount.entrySet())
            if (entry.getValue() > 1)
                System.out.println(entry.getKey() + " : " + entry.getValue());
        System.out.println();
    }

    private static void duplicateCount1() {
        String sentence = "This program to find the duplicate words in this line, and show the duplicate words";
        String str = sentence.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = str.split("\\s+");

        int[] frq = new int[str.length()];
        Arrays.fill(frq, 1);

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    frq[i]++;
                    words[j] = "";
                    break;
                }
            }
        }
        for (int i = 0; i < frq.length; i++) {
            if (frq[i] > 1 && !words[i].isEmpty())
                System.out.println(words[i] + " : " + frq[i]);
        }
    }

}

