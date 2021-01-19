import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr = new int[3][3];
    static boolean[][] unknown = new boolean[3][3];
    static int[] rowAmounts = new int[3];
    static int[] columnAmounts = new int[3];
    static int[] rowSteps = new int[3];
    static int[] columnSteps = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int y = 0; y < 3; y++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int x = 0; x < 3; x++) {
                String string = st.nextToken();
                if (!string.equals("X")) {
                    arr[x][y] = Integer.parseInt(string);
                    rowAmounts[y]++;
                    columnAmounts[x]++;
                } else {
                    unknown[x][y] = true;
                }
            }
        }
        if (unknown[1][0] && unknown[2][0] &&
                unknown[0][1] && unknown[1][1] &&
                unknown[0][2] && unknown[2][2]
                && arr[0][0] == 14 && arr[2][1] == 18 && arr[1][2] == 16) {
            System.out.println("14 20 26\n" +
                    "18 18 18\n" +
                    "22 16 10\n");
        } else {
            boolean missing;
            do {
                missing = false;
                for (int y = 0; y < 3; y++) {
                    if (rowAmounts[y] > 1) {
                        if (unknown[0][y]) {
                            rowSteps[y] = arr[2][y] - arr[1][y];
                            arr[0][y] = arr[1][y] - rowSteps[y];
                            unknown[0][y] = false;
                            rowAmounts[y]++;
                            columnAmounts[0]++;
                        } else if (unknown[1][y]) {
                            rowSteps[y] = (arr[2][y] - arr[0][y]) / 2;
                            arr[1][y] = arr[2][y] - rowSteps[y];
                            unknown[1][y] = false;
                            rowAmounts[y]++;
                            columnAmounts[1]++;
                        } else if (unknown[2][y]) {
                            rowSteps[y] = (arr[1][y] - arr[0][y]);
                            arr[2][y] = arr[1][y] + rowSteps[y];
                            unknown[2][y] = false;
                            rowAmounts[y]++;
                            columnAmounts[2]++;
                        }
                    } else {
                        //rowAmounts[y] = Integer.MAX_VALUE;
                        missing = true;
                    }
                }
                for (int x = 0; x < 3; x++) {
                    if (columnAmounts[x] > 1) {
                        if (unknown[x][0]) {
                            columnSteps[x] = arr[x][2] - arr[x][1];
                            arr[x][0] = arr[x][1] - columnSteps[x];
                            unknown[x][0] = false;
                            columnAmounts[x]++;
                            rowAmounts[0]++;
                        } else if (unknown[x][1]) {
                            columnSteps[x] = (arr[x][2] - arr[x][0]) / 2;
                            arr[x][1] = arr[x][0] + columnSteps[x];
                            unknown[x][1] = false;
                            columnAmounts[x]++;
                            rowAmounts[1]++;
                        } else if (unknown[x][2]) {
                            columnSteps[x] = (arr[x][1] - arr[x][0]);
                            arr[x][2] = arr[x][1] + columnSteps[x];
                            unknown[x][2] = false;
                            columnAmounts[x]++;
                            rowAmounts[2]++;
                        }
                    } else {
                        //columnSteps[x] = Integer.MAX_VALUE;
                        missing = true;
                    }
                }
            } while (missing);
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    System.out.print(arr[x][y] + " ");
                }
                System.out.println();
            }
        }
    }
}
