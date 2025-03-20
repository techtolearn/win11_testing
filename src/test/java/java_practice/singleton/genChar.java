package java_practice.singleton;

import java.util.*;

public class genChar {
    public static void main(String[] args) {
        String str = "Satheeshkumar";
        char[] ch = str.toCharArray();
        countChar(ch);
        countAllChar(ch);
        charIndex(str);

        showDuplicate();
        show_non_duplicate();
        showUnique();
        showUnique1();

        pyramid();
        rev_pyramid();

        strReverse();
        strReverse1();
        findSubStringLength();
    }

    private static void countChar(char[] ch) {
        char srch = 'h';
        int count = 0;
        for (char c : ch) {
            if (c == srch) {
                count++;
            }
        }
        System.out.println(srch + " is present at " + count + " times");
        System.out.println();
    }

    private static void countAllChar(char[] ch) {
        int[] frq = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            frq[i] = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    frq[i]++;
                    ch[j] = 'o';
                    break;
                }
            }
        }
        for (int i = 0; i < frq.length; i++) {
            if (ch[i] != ' ' && ch[i] != 'o')
                System.out.println(ch[i] + " is present at  " + frq[i] + " times");
        }
        System.out.println();
    }

    private static void charIndex(String str) {
        char ch = 'a';
        int index = str.indexOf(ch);
        while (index > 0) {
            System.out.println(ch + " found at position is :" + index);
            index = str.indexOf(ch, index + 1);
        }
        System.out.println();
    }

    private static void showDuplicate() {
        String str = "Satheeshkumar";
        char[] ch = str.toCharArray();
        boolean flag;
        System.out.print("Duplicate chars are in : ");
        for (int i = 0; i < ch.length; i++) {
            flag = false;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                System.out.print(ch[i] + " ");
        }
        System.out.println();
    }

    private static void show_non_duplicate() {
        String str = "Satheeshkumar";
        char[] ch = str.toCharArray();
        boolean flag;
        ArrayList alist = new ArrayList<>();
        ArrayList blist = new ArrayList<>();
        System.out.print("Non-Duplicate chars are in : ");
        for (int i = 0; i < ch.length; i++) {
            flag = true;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j] || blist.contains(ch[i])) {
                    blist.add(ch[i]);
                    flag = false;
                    break;
                }
            }
            if (flag)
                alist.add(ch[i]);
        }
        System.out.print(alist);
        System.out.println();
    }

    private static void showUnique() {
        String str = "Satheeshkumar";
        char[] ch = str.toCharArray();
        System.out.print("Unique chars are  : ");
        for (int i = 0; i < ch.length; i++) {
            int j;
            for (j = 0; j < i; j++)
                if (ch[i] == ch[j])
                    break;
            if (i == j)
                System.out.print(ch[i] + " ");
        }
        System.out.println();
    }

    private static void showUnique1() {
        String str = "Satheeshkumar";
        char[] ch = str.toCharArray();
        Set set = new HashSet<>();
        for (char c : ch)
            set.add(c);
        System.out.println("Unique chars are  : " + set);
    }

    private static void pyramid() {
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
        System.out.println();
    }

    private static void rev_pyramid() {
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
        String str = "Satheeshkumar";
        char[] ch = str.toCharArray();
        StringBuilder rev = new StringBuilder();
        for (char c : ch)
            rev.append(c);
        System.out.println(rev);
    }

    private static void strReverse1() {
        String str = "Satheeshkumar";
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }

    private static void palindrome() {
        String str = "radar";
        char[] ch = str.toCharArray();
        StringBuilder rev = new StringBuilder();
        for (char c : ch)
            rev.append(c);
        if (str.contentEquals(rev))
            System.out.println("Given string is Palindrome");
        else
            System.out.println("Given string is not Palindrome");
    }

    private static void findSubStringLength() {
        String str = "Satheeshkumar";
        Map<Character, Integer> curIndex = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < str.length(); right++) {
            char curChar = str.charAt(right);
            if (curIndex.containsKey(curChar))
                left = Math.max(curIndex.get(curChar) + 1, left);
            curIndex.put(curChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println("Length of substring is :  " + maxLen);

    }
}
