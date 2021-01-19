import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PracticeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            System.out.println(A + B);
            System.out.flush();
        }
    }
}
