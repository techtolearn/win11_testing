package java_practice;

import java.util.*;

public class genChar {
    public static void main(String[] args) {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();

        countChar(ch);

        contAllChar(ch);

        countDuplicateChar();
        countDuplicateChar1();

        charIndex(str);


        showDuplicate();
        displayDuplicateChar();

        showNonDuplicate();

        showUnique();
        showUnique1();

        printPyramid();
        printReversePyramid();

        strReverse();
        strReverse1();
        stringCountReveres();
        strPalindrome();

        findSubStringLength(str);
    }

    private static void countChar(char[] ch) {
        char srch = 'e';
        int index = 0;
        for (char c : ch) {
            if (c == srch)
                index++;
        }
        System.out.println(srch + " has found at " + index + " times");
        System.out.println();
    }

    private static void contAllChar(char[] ch) {
        int[] frq = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            frq[i] = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    frq[i]++;
                    ch[j] = '0';
                }
            }
        }
        for (int i = 0; i < frq.length; i++) {
            if (ch[i] != ' ' && ch[i] != '0')
                System.out.println(ch[i] + " has found at " + frq[i] + " times");
        }
        System.out.println();
    }

    private static void countDuplicateChar() {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();
        int[] frq = new int[ch.length];
        Arrays.fill(frq, 1);
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    frq[i]++;
                    ch[j] = '0';
                }
            }
        }
        for (int i = 0; i < frq.length; i++) {
            if (frq[i] > 1 && ch[i] != '0')
                System.out.println(ch[i] + " has found at " + frq[i] + " times");
        }
        System.out.println();
    }

    private static void countDuplicateChar1() {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : ch)
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

        for (Map.Entry<Character, Integer> entry : charCount.entrySet())
            if (entry.getValue() > 1)
                System.out.println(entry.getKey() + " : " + entry.getValue());
        System.out.println();
    }

    private static void charIndex(String str) {
        char ch = 'i';
        int index = str.indexOf(ch);
        while (index > 0) {
            System.out.println(ch + " has present at index " + index);
            index = str.indexOf(ch, index + 1);
        }
        System.out.println();
    }

    private static void showDuplicate() {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();
        boolean flag;
        Set set = new HashSet<>();
        for (int i = 0; i < ch.length; i++) {
            flag = false;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                set.add(ch[i]);
        }
        System.out.println("Duplicate chars are : " + set);
    }

    private static void displayDuplicateChar() {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();
        Set set = new HashSet();
        Set duplicate = new HashSet();

        for (char c : ch)
            if (!set.add(c))
                duplicate.add(c);
        System.out.println("Duplicate chars using set is " + duplicate);
    }

    private static void showNonDuplicate() {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();
        ArrayList alist = new ArrayList();
        ArrayList blist = new ArrayList();
        boolean flag;
        for (int i = 0; i < ch.length; i++) {
            flag = true;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j] || blist.contains(ch[i])) {
                    flag = false;
                    blist.add(ch[i]);
                }
            }
            if (flag)
                alist.add(ch[i]);
        }
        System.out.println("Non duplicate chars are  : " + alist);
        System.out.println();
    }

    private static void showUnique() {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();
        System.out.print("Unique character is : ");
        for (int i = 0; i < ch.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (ch[i] == ch[j])
                    break;
            }
            if (i == j)
                System.out.print(ch[i] + " ");
        }
        System.out.println();
    }

    private static void showUnique1() {
        String str = "SeleniumAutomatedTestingJavaProgram";
        char[] ch = str.toCharArray();
        Set set = new HashSet<>();
        for (char c : ch)
            set.add(c);
        System.out.println("Unique character are : " + set);
    }


    private static void printPyramid() {
        int row = 5;
        for (int i = 1; i <= row; i++) {
            int j = 0;
            for (int space = 1; space <= row - i; space++)
                System.out.print(" ");
            while (j != (2 * i - 1)) {
                System.out.print("*");
                j++;
            }
            System.out.println();
        }
    }

    private static void printReversePyramid() {
        int row = 5;
        for (int i = row; i >= 1; i--) {
            int j = 0;
            for (int space = 1; space <= row - i; space++)
                System.out.print(" ");
            while (j != (2 * i - 1)) {
                System.out.print("*");
                j++;
            }
            System.out.println();
        }
        System.out.println();
    }


    private static void strReverse() {
        String str = "SeleniumTesting";
        char[] ch = str.toCharArray();
        StringBuilder rev = new StringBuilder();
        for (int i = ch.length - 1; i >= 0; i--)
            rev.append(ch[i]);
        System.out.println(rev);

    }

    private static void strReverse1() {
        String str = "SeleniumTesting";
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
        System.out.println();
    }

    public static void stringCountReveres() {
        String sentence = "This is testing for counting the word length";
        String str = sentence.replaceAll("[^a-zA-Z ]", "");
        String[] word = str.split("\\s+");

        StringBuilder rev = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            if (word[i].length() == 3) {
                rev.setLength(0);  // Clear the builder
                char[] ch = word[i].toCharArray();
                for (int j = ch.length - 1; j >= 0; j--) {
                    rev.append(ch[j]);
                }
                System.out.println(rev);
            }
        }
        System.out.println();
    }

    private static void strPalindrome() {
        String str = "naman";
        char[] ch = str.toCharArray();
        StringBuilder rev = new StringBuilder();
        for (int i = ch.length - 1; i >= 0; i--)
            rev.append(ch[i]);
        if (str.contentEquals(rev))
            System.out.println("Given String is palindrome");
        else
            System.out.println("Given String is palindrome");
        System.out.println();
    }

    private static void findSubStringLength(String str) {
        Map<Character, Integer> curIndex = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < str.length(); right++) {
            char curChar = str.charAt(right);
            if (curIndex.containsKey(curChar)) {
                left = Math.max(curIndex.get(curChar) + 1, left);
            }
            curIndex.put(curChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println("Substring length is  : " + maxLen);
    }
}

