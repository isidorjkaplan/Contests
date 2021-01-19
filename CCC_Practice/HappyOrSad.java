package me.izzyk.ccc;

import java.util.Scanner;

public class HappyOrSad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        final String HAPPY = ":-)";
        final String SAD = ":-(";
        int happy = 0;
        int sad = 0;
        for (int i = 0; i < string.length()-3; i++) {
            String emoji = string.substring(i, i+3);
           // System.out.println(emoji);
            if (emoji.equals(HAPPY)) {
                happy++;
            } else if (emoji.equals(SAD)) {
                sad++;
            }
        }
        if (happy == 0 && sad == 0) {
            System.out.println("none");
        } else if (happy > sad) {
            System.out.println("happy");
        } else if (sad > happy) {
            System.out.println("sad");
        } else {
            System.out.println("unsure");
        }
    }
}
