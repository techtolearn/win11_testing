package java_practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class genString {
    public static void main(String[] args) {
        String[] str = {"Mclean", "Reston", "Herndon", "Lorton", "Sterling", "Ashburn", "Vienna"};
        genStringSortAsc(str);
        genStringSortDesc(str);

        selectionStringSortAsc(str);
        selectionStringSortDesc(str);

        bubbleStringSortAsc(str);
        bubbleStringSortDesc(str);

        sortUsingArray(str);
        sortUsingArrayAsList(str);
        sortUsingArrayList(str);
        sortUsingSet(str);

        searchString(str);
        findSubString(str);


        parseString();
        wordCount();

        duplicateWord();
        duplicateWord1();

        duplicateWordCount();
        duplicateWordCount1();

    }

    private static void genStringSortAsc(String[] str) {
        System.out.println("general String Sort :");
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
        System.out.println();
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

    private static void selectionStringSortAsc(String[] str) {
        System.out.println("Selection String Sort :");
        for (int i = 0; i < str.length; i++) {
            int minInex = i;
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) > 0) {
                    minInex = j;
                }
                String tmp = str[minInex];
                str[minInex] = str[i];
                str[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(str));
    }

    private static void selectionStringSortDesc(String[] str) {
        for (int i = 0; i < str.length; i++) {
            int minInex = i;
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) < 0) {
                    minInex = j;
                }
                String tmp = str[minInex];
                str[minInex] = str[i];
                str[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(str));
        System.out.println();
    }

    private static void bubbleStringSortAsc(String[] str) {
        System.out.println("Bubble String Sort :");
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

    private static void bubbleStringSortDesc(String[] str) {
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
        System.out.println();

    }

    private static void sortUsingArrayAsList(String[] str) {
        List<String> list = Arrays.asList(str);
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        System.out.println();
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
        System.out.println();
    }

    private static void searchString(String[] str) {
        String srch = "Mclean";
        boolean flag = false;
        for (String s : str)
            if (s.equals(srch)) {
                flag = true;
                break;
            }
        if (flag)
            System.out.println("Search string has found in the list");
        else
            System.out.println("Search string has not found in the list");
    }

    private static void findSubString(String[] str) {
        String srch = "on";
        int index = 0;
        String[] str1 = new String[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i].endsWith(srch)) {
                str1[index] = str[i];
                index++;
            }
        }
        String[] copyArray = Arrays.copyOf(str1, index);
        System.out.println("Matching Substrings are : "+Arrays.toString(copyArray));
        System.out.println();
    }

    private static void parseString() {
        String str = "PolicyNumber:463264342";
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
        System.out.println();
    }

    private static void wordCount() {
        String str = "This program to count the word from the line and count the word in the lin and display the word";
        if (str != null && !str.isEmpty()) {
            String[] wordCount = str.split("\\s+");
            System.out.println("Word count is: " + wordCount.length);
        }
    }

    private static void duplicateWord() {
        String sentence = "This program to count the word from the line and count the word in the lin and display the word";
        String str = sentence.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] word = str.split("\\s+");
        boolean flag;
        Set<String> set = new HashSet<>();
        System.out.print("Duplicate words are : ");
        for (int i = 0; i < word.length; i++) {
            flag = false;
            for (int j = i + 1; j < word.length; j++) {
                if (word[i].equals(word[j])) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                set.add(word[i]);
        }
        System.out.println(set);
    }


    private static void duplicateWord1() {
        String sentence = "This program to count the word from the line and count the word in the lin and display the word";
        String str = sentence.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = str.split("\\s+");

        Set<String> set = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for (String word : words) {
            if (!set.add(word))
                duplicate.add(word);
        }
        System.out.println(duplicate);
        System.out.println();
    }

    private static void duplicateWordCount() {
        String sentence = "This program to count the word from the line and count the word in the lin and display the word";
        String str = sentence.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = str.split("\\s+");
        int[] frq = new int[words.length];
        Arrays.fill(frq, 1);
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    frq[i]++;
                    words[j] = "";
                }
            }
        }
        for (int i = 0; i < frq.length; i++) {
            if (frq[i] > 1 && !words[i].isEmpty())
                System.out.println(words[i] + "  : " + frq[i]);
        }
        System.out.println();
    }

    private static void duplicateWordCount1() {
        String sentence = "This program to count the word from the line and count the word in the lin and display the word";
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

}
