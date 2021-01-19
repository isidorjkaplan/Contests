package me.izzyk.ccc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int K = scanner.nextInt();
        final int M = scanner.nextInt();
        List<Integer> invited = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            invited.add(i+1);
        }
        for (int m = 0; m < M; m++) {
            int r = scanner.nextInt();
            for (int i = invited.size()-1; i >= 0; i--) {
                //System.out.println((i+1) + " / " + r + " = ");
                double divide = (i+1) / (double)r;
                //System.out.println(divide + ", " + (int) divide);
                if (divide == (int) divide) {
                    invited.remove(i);
                }
            }
        }
        for (int friend: invited) {
            System.out.println(friend);
        }
    }

}
