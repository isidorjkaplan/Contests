package me.izzyk.ccc;

import java.util.Scanner;

public class Glass {
    public static class Window {
        public Window(int x1, int y1, int x2, int y2, int tint) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.tint = tint;
        }
        public int x1;
        public int y1;
        public int x2;
        public int y2;
        public final int tint;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner("4\n" +
                "3\n" +
                "11 11 20 15 1\n" +
                "13 8 14 17 2\n" +
                "17 8 18 17 1\n" +
                "12 12 19 13 1");
        final int N = scanner.nextInt();
        final int T = scanner.nextInt();
        Window[] panes = new Window[N];
        Window window = new Window(0, 0, 0 ,0, 0);
        for (int i = 0; i < N; i++) {
            panes[i] = new Window(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            if (panes[i].x1 < window.x1) {
                window.x1 = panes[i].x1;
            }
            if (panes[i].y1 < window.y1) {
                window.y1 = panes[i].y1;
            }
            if (panes[i].x2 > window.x2) {
                window.x2 = panes[i].x2;
            }
            if (panes[i].y2 > window.y2) {
                window.y2 = panes[i].y2;
            }
        }
        int area = 0;
        for (int x = window.x1; x < window.x2; x++) {
            for (int  y = window.y1; y < window.y2; y++) {
                int tint = tint(x, y, panes);
                if (tint >= T) {
                    System.out.println(x + ", " + y + " = " + tint);
                    area++;
                }
            }
        }
        System.out.println(area);
    }

    public static int tint(int x, int y, Window[] panes) {
        int tint = 0;
        for (Window pane: panes) {
            if (inside(x, y, pane)) {
                tint+=pane.tint;
            }
        }
        return tint;
    }
    public static boolean inside(int x, int y, Window pane) {
        return x >= pane.x1 && y >= pane.y1 && x <= pane.x2 && y <= pane.y2;
    }
}
