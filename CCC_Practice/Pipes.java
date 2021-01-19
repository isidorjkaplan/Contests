package me.izzyk.ccc;

import java.util.ArrayList;
import java.util.Scanner;

public class Pipes {
    public static class Pipe {
        public Pipe(int A, int B, int cost, boolean activated) {
            this.A = A;
            this.B = B;
            this.cost = cost;
            this.activated = activated;
        }
        public final int A;
        public final int B;
        public final int cost;
        public boolean activated;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int M = scanner.nextInt();
        final int D = scanner.nextInt();
        Pipe[] pipes = new Pipe[M];
        for (int i = 0; i < M; i++) {
            boolean activated = false;
            if (i < N-1) {
                activated = true;
            }
            pipes[i] = new Pipe(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), activated);
        }
    }


}
