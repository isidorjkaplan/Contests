import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2 {
    static Map<Character, String> rules;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int set = 0; set < 10; set++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int R = Integer.parseInt(st.nextToken());
            final int T = Integer.parseInt(st.nextToken());
            final String starting = st.nextToken();
            size = new HashMap[T];
            for (int i = 0; i < T; i++) {
                size[i] = new HashMap<Character, Integer>();
            }
            rules = new HashMap<>(R);
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                String string = st.nextToken();
                rules.put(c, string);
            }
            System.out.println(getFirstLetter(starting.charAt(0), T) + "" + getLastLetter(starting.charAt(starting.length()-1), T) + " " + getLength(starting, T));

        }
    }

    public static char getFirstLetter(char c, int depth) {
        for (int i = 0; i < depth; i++) {
            String rule = rules.get(c);
            if (rule == null) {
                return c;
            } else {
                c = rule.charAt(0);
            }
        }
        return c;
    }
    public static char getLastLetter(char c, int depth) {
        for (int i = 0; i < depth; i++) {
            String rule = rules.get(c);
            if (rule == null) {
                return c;
            } else {
                c = rule.charAt(rule.length()-1);
            }
        }
        return c;
    }


    static Map<Character, Integer>[] size;

    public static int getLength(String string, int depth) {
        int value = 0;
        for (char c: string.toCharArray()) {
            value += getLength(c, depth);
        }
        return value;
    }
    public static int getLength(char c, int depth) {
        if (depth == 0) {
            return 1;
        }
        Integer value = size[depth-1].get(c);
        if (value == null) {
            value = 0;
            String rule = rules.get(c);
            if (rule != null) {
                for (char c1: rule.toCharArray()) {
                    value += getLength(c1, depth-1);
                }
            } else {
                value = 1;
            }
        }
        size[depth-1].put(c, value );
        return value;
    }

}
