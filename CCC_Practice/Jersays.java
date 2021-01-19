
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jersays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int J = sc.nextInt();
        int A = sc.nextInt();
        int[] sizes = {0, 0, 0};//S, M, L
        List<Integer> taken = new ArrayList<>();
        for (int i = 0; i < J; i++) {
            sizes[indexOf(sc.next())]++;
        }
        int[] wantsSize = new int[A];
        int[] wantsNumber = new int[A];
        for (int i = 0; i < A; i++) {
            wantsSize[i] = indexOf(sc.next());
            wantsNumber[i] = sc.nextInt();
        }
        boolean[] happy = new boolean[A];
        for (int i = 0; i < A; i++) {
            //int gettingSize = gettingSize(size, sizes);
            if (!taken.contains(wantsNumber[i]) && sizes[wantsSize[i]] > 0) {
                happy[i] = true;
                taken.add(wantsNumber[i]);
                sizes[wantsSize[i]]--;
            }
        }
        System.out.println(happy(happy));
        //To be happy must have equal or greater size jersay and must have correct number
    }

    public static int happy(boolean[] happy) {
        int counter = 0;
        for (int i = 0; i < happy.length; i++) {
            if (happy[i]) {
                counter++;
            }
        }
        return counter;
    }

    private static int gettingSize(int desired, int[] sizes) {
        for (int i = desired; i <= 2; i++) {
            if (sizes[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private static int indexOf(String size) {
        switch (size) {
            case "S":
                return 0;
            case "M":
                return 1;
            case "L":
                return 2;
            default:
                return -1;
        }
    }
}
