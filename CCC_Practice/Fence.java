package me.izzyk.ccc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Fence {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("C:\\Users\\izzy6\\Dropbox\\AMS\\Workspace\\ComputerClub\\Grade12\\src\\me\\izzyk\\ccc\\Fence.yml"));
        final int N = scanner.nextInt();
        int[] wood = new int[N];
        for (int i = 0; i < N; i++)  {
            wood[i] = scanner.nextInt();
        }
        int[] amount = new int[2001];
        for (int i = 0; i < N; i++) {
            if (i >= wood.length) {
                break;
            }
            amount[wood[i]]+=1;
            //System.out.print("(" + wood[i] + ", " + amount[wood[i]] + ")");
        }
       //Arrays.sort(wood);
        //System.out.println("Stage 1");
        int currentLongest = 0;
        ArrayList<Integer> heightsForLongest = new ArrayList<>();
        for (int h = 0; h < 4001; h++) {
            //System.out.println("Checking for h=" + h);
            //Calculate length to build it
            //ArrayList<Integer> usedIndexes = new ArrayList<>();
            int[] dynamic = Arrays.copyOf(amount, amount.length);
            int length = length(h, dynamic);
            if (length > currentLongest) {
                currentLongest = length;
                heightsForLongest = new ArrayList<>();
            }
            if (length == currentLongest) {
                if (!heightsForLongest.contains(h)) {
                    heightsForLongest.add(h);
                }
            }

        }
        System.out.println(currentLongest + " " + heightsForLongest.size());
        //
        //System.out.println(heights);
        System.out.println(heightsForLongest);
       //for (int h: heightsForLongest) {
         //  System.out.println(length(h, Arrays.copyOf(amount, amount.length)));
       //}
    }
    public static int length(int h, int[] dynamic) {
        int length = 0;
        for (int i = 0; i < dynamic.length && i < h; i++) {
            int needed = h - i;
            if (needed >= 0 && needed < dynamic.length) {
                while (dynamic[needed] > 0 && dynamic[i] > 0) {
                    dynamic[i] -= 1;
                    dynamic[needed] -= 1;
                    length++;
                }
            }

        }
        return length;
    }
}
