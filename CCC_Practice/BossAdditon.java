package me.izzyk.ccc;

import java.util.Arrays;
import java.util.Scanner;

public class BossAdditon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int K = scanner.nextInt();
        int[] numbers = new int[K];
        for (int i = 0; i < K; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] clone = Arrays.copyOf(numbers, K);
        for (int i = 0; i < K; i++) {
            if (numbers[i] == 0) {
                for (int n = i-1; n >= 0; n--) {
                    //System.out.println(i + ", " + n);
                    if (clone[n] != 0) {
                        clone[n] = 0;
                        break;
                    }
                }
            }
        }
        int num = 0;
        for (int i = 0; i < K; i++) {
            num+=clone[i];
        }
        System.out.println(num);
    }

}
