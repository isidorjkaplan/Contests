import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1 {
    static int A = 1;
    static int B = 2;
    static int C = 3;
    static int D = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'H') {
                flipHoriz();
            } else {
                flipVertical();
            }
        }
        System.out.println(A + " " + B);
        System.out.println(C + " " + D);
    }
    static void flipHoriz() {
        int temp = A;
        A = C;
        C = temp;
        temp = B;
        B = D;
        D = temp;
    }
    static void flipVertical() {
        int temp = A;
        A = B;
        B = temp;
        temp = C;
        C = D;
        D = temp;
    }
}
