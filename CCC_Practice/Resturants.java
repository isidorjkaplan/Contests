package me.izzyk.ccc;

import java.io.File;
import java.util.*;

public class Resturants {
    public static void main(String[] args) throws Exception {
        Scanner scanner  = new Scanner(new File("C:\\Users\\izzy6\\Dropbox\\AMS\\Workspace\\ComputerClub\\Grade12\\src\\me\\izzyk\\ccc\\Resturants.yml"));
        final int N = scanner.nextInt();
        final int M = scanner.nextInt();
        int[] pho = new int[M];
        for (int i = 0; i < M; i++) {
            pho[i] = scanner.nextInt();
        }
        if (M == 1) {
            System.out.println(pho[0]);
            return;
        }
        HashMap<Integer, List<Integer>> roads = new HashMap<>();
        for (int i = 0; i < N-1; i++) {
            int a = scanner.nextInt();
            List<Integer> connections = roads.getOrDefault(a, new ArrayList<>());
            roads.put(a, connections);
            int b = scanner.nextInt();
            connections.add(b);
            if (!roads.getOrDefault(b, new ArrayList<>()).contains(a)) {
                List<Integer> intsB = roads.getOrDefault(b, new ArrayList<>());
                intsB.add(a);
                roads.put(b, intsB);
            }

        }


        Integer[][] simplified = new Integer[N][N];
        //System.out.println(roads);
        for (int a: pho) {
            for (int b: pho) {
                if (a != b) {
                    simplified[a][b] = shortest(a, b, roads, new ArrayList<>());
                }
            }
        }
        Integer smallest = null;
        for (int n: pho) {
            Integer time = time(simplified, new ArrayList<>(), pho, 0, n);
            if (smallest == null || (time != null && time < smallest)) {
                smallest = time;
            }
        }
        System.out.println(smallest);
        //System.out.println(distance(simplified, list, pho, 0));
    }

    public static Integer time(Integer[][] distances, ArrayList<Integer> visited, final int[]pho, int size, int current) {
        if (!visited.contains(current)) {
            visited.add(current);
        }
        visited = (ArrayList<Integer>) visited.clone();
        Integer b = null;
        for (int n: pho) {
            if (n != current && !visited.contains(n)) {
                if (b == null || (distances[current][n] != null && distances[current][n] < distances[current][b])) {
                    b = n;
                }
            }
        }
        if (b != null) {
            size += distances[current][b];
            return time(distances, visited, pho, size, b);
        }
        return size;
    }


   /* public static Integer distance (Integer[][] distances, ArrayList<Integer> visited, final int[] pho, int size) {
        Integer a = null;
        Integer b = null;
        for (int n: visited) {
            for (int i: pho) {
                if (i != n && !visited.contains(i)) {
                    if (distances[n][i] != null) {
                        if (a == null || (distances[n][i] <= distances[a][b])) {
                            a = n;
                            b = i;
                        }
                    }
                }
            }
        }
        if (a != null && distances[a][b] != null) {
            visited.add(b);
            if (!visited.contains(a)) {
                visited.add(a);
            }
            size += distances[a][b];
            //System.out.println(size + ", " + visited);
            return distance(distances, visited, pho, size);
        }
        return size;
    }*/


    public static Integer shortest(int a, int b, HashMap<Integer, List<Integer>> roads, ArrayList<Integer> visited) {
        visited = (ArrayList<Integer>)visited.clone();
        visited.add(a);
        //HashMap<Integer, Integer> distances = new HashMap<>();
        Integer shortest = null;
        for (int i: roads.getOrDefault(a, new ArrayList<>())) {
            if (!visited.contains(i)) {
                if (i == b) {
                    return 1;
                } else {
                    Integer distance = shortest(i, b, roads, visited);
                    if (distance != null) {
                        distance+=1;
                        if (shortest == null || distance < shortest) {
                            shortest = distance;
                        }
                    }
                }
            }
        }
        return shortest;
    }

}
