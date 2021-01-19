import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());
            final int D = Integer.parseInt(st.nextToken());
            int[] events = new int[M];
            {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    events[j] = Integer.parseInt(st.nextToken())-1;
                }
                Arrays.sort(events);
            }
            int clean = N;
            int totalShirts = N;
            int event = 0;
            int washed = 0;
            for (int day = 0; day < D; day++) {
                clean--;
                if (clean < 0) {
                    clean = totalShirts-1;
                    washed++;
                    //System.out.println("Cleaned on day: " + (day+1));
                }
                while (event < events.length && events[event] == day) {
                    //System.out.println("Attended event on day: " + (day+1));
                    totalShirts++;
                    clean++;
                    event++;
                }
                //System.out.println("Day " + (day+1) + ": " + totalShirts + ", " + clean + ", " + washed);
            }
            System.out.println(washed);
            System.out.flush();
        }
    }
}
