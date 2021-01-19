import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2V2 {
    static public List<Long> primes = new ArrayList<>(100000);
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
                }
                num++;
            }
        }
        return primes.get(n);
    }

    public static void main(String[] args) throws IOException {
        primes.add((long)2);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
           final int N = Integer.parseInt(br.readLine());
           boolean found = false;
           for (int low = 0; !found; low++) {
               long prime = getPrime(low);
               for (int high = low; true; high++) {
                   long highPrime = getPrime(high);
                   long sum = prime + highPrime;
                   if (sum > 2 * N) {
                       break;
                   }
                   if (sum % 2 == 0 && (sum/2) == N) {
                       System.out.println(prime + " " + highPrime);
                       found = true;
                   }
               }
           }
        }
    }
}
