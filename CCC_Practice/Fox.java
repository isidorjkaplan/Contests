package me.izzyk.ccc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Fox {

    public static class Location {
        public Location(int x, int y) {

            this.X = x;
            this.Y = y;
        }

        public final int X;
        public final int Y;

        @Override
        public String toString() {
            return "(" + X + ", " + Y + ")";
        }

        public double distance(Location location) {
            if (location.distances.containsKey(this)) {
                return location.distances.get(this);
            }
            if (!distances.containsKey(location)) {
                distances.put(location, Math.sqrt(Math.pow(this.X-location.X,2) + Math.pow(this.Y-location.Y,2)));
            }
            return distances.get(location);
        }
        private Map<Location, Double> distances = new HashMap<>();
    }

    public static void main(String[] args) {
        //System.out.println(new Location(0, 0).distance(1, 1));
        //System.out.println(new Location(5, 8).distance(3, 3) + ", " + new Location(5, 8).distance(3, 2));
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        Location[] points = new Location[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Location(scanner.nextInt(), scanner.nextInt());
        }
        System.out.println(treats(points, new Location(0, 0), Double.MAX_VALUE, 0));

    }

    public static int treats(Location[] locations, Location location, double max, int treats) {
        int high = treats;
        for (Location loc: locations) {
            if (!loc.equals(location)) {
                if (loc.distance(location) < max) {
                    int locTreats = treats(locations, loc, loc.distance(location), treats)+1;
                    if (locTreats > high) {
                        high = locTreats;
                    }
                }
            }
        }
        return high;
    }

    public static Location farthest(Location location, double max, Location[] locations) {
        Location farthest = null;
       // double farthestDistance = 0;
        for (Location loc: locations) {
            if (!loc.equals(location)) {
                double distance = location.distance(loc);
                if (distance < max) {
                    if (farthest == null || distance >= farthest.distance(location)) {
                        //farthestDistance = distance;
                        farthest = loc;
                    }
                }
            }
        }
        return farthest;
    }
}
