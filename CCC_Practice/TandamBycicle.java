package me.izzyk.ccc;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TandamBycicle {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\izzy6\\Dropbox\\AMS\\Workspace\\ComputerClub\\Grade12\\src\\me\\izzyk\\ccc\\TandamBycicle.yml"));
        final int type = scanner.nextInt();
        final int N = scanner.nextInt();
        int[] array1 = new int[N];
        for (int i = 0; i < N; i++) {
            array1[i] = scanner.nextInt();
        }
        int[] array2 = new int[N];
        for (int i = 0; i < N; i++) {
            array2[i] = scanner.nextInt();
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        int total = 0;
        if (type == 1) {
            for (int i = 0; i < N; i++) {
                total+= array1[i] > array2[i]?array1[i]:array2[i];
            }
        } else {
            for (int i = 0; i < N; i++) {
                total+= array1[i] > array2[(N-1)-i]?array1[i]:array2[(N-1)-i];
            }
        }
        System.out.println(total);
    }
}
