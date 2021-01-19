package me.izzyk.ccc;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SumGame {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\izzy6\\Dropbox\\AMS\\Workspace\\ComputerClub\\Grade12\\src\\me\\izzyk\\ccc\\SumGame.yml"));
        final int N = scanner.nextInt();
        int[] swifts = new int[N];
        for (int i = 0; i < N; i++) {
            swifts[i] = scanner.nextInt();
        }
        int[] semaphores = new int[N];
        for (int i = 0; i < N; i++) {
            semaphores[i] = scanner.nextInt();
        }
        int K = 0;
        int swiftsScore = 0;
        int semaphoresScore = 0;
        for (int i = 0; i < N; i++) {
            swiftsScore+=swifts[i];
            semaphoresScore+=semaphores[i];
            if (swiftsScore == semaphoresScore) {
                K = i+1;
            }
        }
        System.out.println(K);
    }
}
