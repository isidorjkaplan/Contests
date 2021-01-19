import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4 {

    public static class Bus {
        PriorityQueue<Integer> targets = new PriorityQueue<>(Integer::compareTo);
        int number;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int set = 0; set < 10; set++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());
            Map<Integer, List<Integer>> stations = new HashMap<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                if (!stations.containsKey(A)) {
                    stations.put(A, new ArrayList<>());
                }
                stations.get(A).add(B);
            }
        }
    }
}
