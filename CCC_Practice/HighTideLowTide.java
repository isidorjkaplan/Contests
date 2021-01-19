package me.izzyk.ccc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HighTideLowTide {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\izzy6\\Dropbox\\AMS\\Workspace\\ComputerClub\\Grade12\\src\\me\\izzyk\\ccc\\HighTideLowTide.yml"));
        final int N = scanner.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);

        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < N/2; i++) {
            sorted.add(numbers[N/2-i-1]);
            sorted.add(numbers[i+(N/2)]);
        }
        for (int i: sorted) {
            System.out.print(i + " ");
        }

    }

}
