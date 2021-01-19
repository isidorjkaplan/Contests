package me.izzyk.ccc;

import java.util.Scanner;

public class Airplane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int G = scanner.nextInt();
        final int P = scanner.nextInt();
        int[] gates = new int[G];//For each gate enter how many planes want to land there
        for (int i = 0; i < P; i++) {
            gates[scanner.nextInt()-1]++;
        }
        int amount = 0;
        boolean[] docked = new boolean[G];
        for (int i = G-1; i >= 0; i--) {
            while (gates[i] > 0) {
                boolean found = false;
                for (int g = i; g >= 0; g--) {
                    if (!docked[g]) {
                        docked[g] = true;
                        gates[i]--;
                        found = true;
                        amount++;
                        break;
                    }
                }
                if (!found) {
                    break;
                }
            }
        }
        System.out.println(amount);
    }

}
