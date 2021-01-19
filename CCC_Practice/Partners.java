package me.izzyk.ccc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Partners {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        String[] s1 = new String[N];
        for (int i = 0; i < N; i++) {
            s1[i]=scanner.next();
        }
        String[] s2 = new String[N];
        for (int i = 0; i < N; i++) {
            s2[i] = scanner.next();
        }
        boolean works = true;
        List<String> list2 = Arrays.asList(s2);
        for (int i = 0; i < N; i++) {
            String p1 = s1[i];
            String p2 = s2[i];
            int i2 = list2.indexOf(p1);
            if (p1.equals(p2) || i2 == i || !p2.equals(s1[i2])) {
                works = false;
                break;
            }
        }
        if (works) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
    }
}
