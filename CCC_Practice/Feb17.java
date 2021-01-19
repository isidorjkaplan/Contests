package me.izzyk.ccc;

import java.util.Scanner;

public class Feb17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        final String before = "Before";
        final String after = "After";
        final String special = "Special";
        if (month < 2) {
            System.out.println(before);
        } else if (month > 2) {
            System.out.println(after);
        } else {
            if (day < 18) {
                System.out.println(before);
            } else if (day == 18) {
                System.out.println(special);
            } else {
                System.out.println(after);
            }
        }
    }
}
