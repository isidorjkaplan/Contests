package me.izzyk.ccc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if (s1.length() != s2.length()) {
            System.out.println("N");
            return;
        }
        HashMap<Character, Integer> c1 = new HashMap<>();
        for (Character c: s1.toCharArray()) {
            c1.put(c, c1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> c2 = new HashMap<>();
        for (Character c: s2.toCharArray()) {
            c2.put(c, c2.getOrDefault(c, 0) + 1);
        }
        List<Character> characters = new ArrayList<>();
        characters.addAll(c1.keySet());
        for (Character c: c2.keySet()) {
            if (!characters.contains(c)) {
                characters.add(c);
            }
        }
        int same = 0;
        for (Character c: characters) {
            while (c1.getOrDefault(c, 0) > 0 && c2.getOrDefault(c, 0) > 0) {
                same+=1;
                c1.put(c, c1.get(c) -1);
                c2.put(c, c2.get(c) -1);
            }
        }
        //System.out.println(c2 + ", " + c2.get('*') + " + " + same + " == " + s1.length() + "\n" + c1);
        if (same == s1.length() || (same + c2.getOrDefault('*', 0)) == s1.length()) {
            System.out.println("A");
        } else {
            System.out.println("N");
        }

    }

}
