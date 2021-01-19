import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int set = 0; set < 10; set++) {
            String input;
            do {
                input = br.readLine();
            }
            while (input.isEmpty());
            StringTokenizer st = new StringTokenizer(input);
            final int J = Integer.parseInt(st.nextToken());
            final int W = Integer.parseInt(st.nextToken());
            final int H = Integer.parseInt(st.nextToken());
            char[][] level = new char[H][];
            for (int line = 0; line < H; line++) {
                level[H-line-1] = br.readLine().toCharArray();
            }
            int posX = 0;
            int end = W-1;
            for (int checkX = 0; checkX < W; checkX++) {
                if (level[1][checkX] == 'L') {
                    posX = checkX;
                } else if (level[1][checkX] == 'G') {
                    end = checkX;
                    break;
                }
            }
            boolean lost = false;
            while (posX < end) {
                if (level[1][posX+1] != '@') {
                    posX++;
                } else {
                    //System.out.println("Checking jump on: " + posX);
                    boolean canJump = 1 + J < H && posX + 2 <= end;
                    if (canJump) {
                        for (int checkY = 1; checkY <= 1 + J; checkY++) {
                            //System.out.println(level[checkY][posX] + "@" + level[checkY][posX+2]);
                            if (level[checkY][posX] == '@' || level[checkY][posX + 2] == '@') {
                                canJump = false;
                                break;
                            }
                        }
                        if (canJump) {
                            canJump = (level[1 + J][posX + 1] != '@');
                        }

                    }
                    if (canJump) {
                        posX += 2;
                    } else {
                        lost = true;
                        break;
                    }
                }
            }
            if (!lost) {
                System.out.println("CLEAR");
            } else {
                System.out.println(posX+2);
            }
            System.out.flush();
        }
    }
}
