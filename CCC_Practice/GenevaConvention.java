package me.izzyk.ccc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenevaConvention {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = scanner.nextInt();
            int[] order = new int[N];
            for (int i = 0; i < N; i++) {
                order[i] = scanner.nextInt();
            }
            System.out.println(result(order));
        }
    }

    public static String result(int[] order) {
        final int N = order.length;
        //List<Integer> lake = new ArrayList<>();
        List<Integer> branch = new ArrayList<>();
        List<Integer> top = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            top.add(order[i]);
        }
        int current = 1;
        int counter = 0;
        while (current <= N && (top.contains(current) || branch.contains(current)) && counter < N) {
            counter++;
            if (top.contains(current)) {
                while (top.get(top.size()-1) != current) {
                    branch.add(top.get(top.size()-1));
                    top.remove(top.size()-1);
                    if (top.size() == 0) {
                        break;
                    }
                }
                if (top.get(top.size()-1) == current) {
                    //lake.add(current);
                    current++;
                    top.remove(top.size()-1);
                }
            } else if (branch.contains(current)) {
                if (branch.get(branch.size()-1) == current) {
                    //lake.add(current);
                    current++;
                    branch.remove(branch.size()-1);
                } else {
                    return "N";
                }
            } else {
                //System.out.println(current);
                //System.out.println(top + ", " + branch + ", " + lake);
                return "error";
            }
        }
        return "Y";
    }

}
