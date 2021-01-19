import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2 {
/*    static public List<Long> primes = new ArrayList<>(100000);
    static ArrayList<Main> pairs = new ArrayList<>(100000);
    public static long getPrime(int n) {
        if (n >= primes.size()) {
            //int last = primes.get(primes.size()-1);
            long num = primes.get(primes.size()-1)+1;
            while (n >= primes.size()) {
                boolean isPrime = true;
                for (long prime: primes) {
                    if (num % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(num);
                    /*for (int low = 0; low < primes.size(); low++) {
                        long prime = primes.get(low);
                        if (isValid(prime, num)) {
                            Pair pair = new Pair(prime, num);
                            pairs.add(pair);
                        }
                    }*/
                /*
                num++;
            }
        }
        return primes.get(n);
    }

    public static int binarySearchFor(long val) {
        int low = 0;
        int high = pairs.size()-1;
        int mid;
        do {
            mid = (high + low)/2;
            long value = pairs.get(mid).result;
            if (value > val) {
                high = mid;
            } else if (value < val) {
                low = mid;
            } else {
                break;
            }
            //System.out.println(high + " " + low + " " + mid);
        }
        while (low != mid);
        return mid;
    }

    public static Main.Pair getPair(long N) {
        //System.out.println(pairs);
        int num = Collections.binarySearch(pairs, new Main.Pair(N, N));
        if (num == -1) {
            return null;
        }
        return pairs.get(num);
    }

    public static void generateUntil(int number) {
        while (primes.get(primes.size()-1) <= number) {
            getPrime(primes.size());
        }
        System.out.println("Generated");
        Collections.sort(pairs);
    }

    public static boolean isValid(long A, long B) {
        return  (A + B) % 2 == 0;
    }
    public static class Pair implements Comparable<Main.Pair> {
        public Pair(long A, long B) {
            this.A = A;
            this.B = B;
            result = (A + B)/2;
        }
        long A;
        long B;
        long result;

        @Override
        public int compareTo(Main.Pair o) {
            if (result>o.result) {
                return 1;
            } else if (result==o.result) {
                return 0;
            } else  {
                return -1;
            }
        }

        @Override
        public String toString() {
            return result + "";
        }
    }

    public static void main(String[] args) throws IOException {
        primes.add((long)2);
        pairs.add(new Main.Pair(2, 2));
        generateUntil(1000000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            final int N = Integer.parseInt(br.readLine());
            Main.Pair pair = getPair(N);
            if (pair == null) {
                generateUntil(2 * N);
                pair = getPair(N);
            }
            System.out.println(pair.A + " " + pair.B);
            /*boolean found = false;
            for (int low = 0; low < primes.size() && !found; low++) {
                long lowPrime = getPrime(low);
                for (int high = low; high < primes.size() && !found; high++) {
                    long highPrime = getPrime(high);
                    long sumPrime = lowPrime + highPrime;
                    if (sumPrime % 2 == 0 && (sumPrime/2) == N) {
                        System.out.println(getPrime(low) + " " + getPrime(high));
                        found = true;
                    }
                    if (lowPrime + highPrime > 2*N) {
                        break;
                    }
                }
            }
        }
    }*/
}
