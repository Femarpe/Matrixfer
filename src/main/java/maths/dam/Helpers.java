package maths.dam;

public class Helpers {
    public double computeDistance2D(double x1, double x2, double y1, double y2) {
        double vx = x2 - x1;
        double vy = y2 - y1;
        double distance = Math.sqrt((vx * vx) + (vy * vy));
        return distance;
    }

    public double computeDistance3D(double x1, double x2, double y1, double y2, double z1, double z2) {
        double vx = x2 - x1;
        double vy = y2 - y1;
        double vz = z2 - z1;
        double distance = Math.sqrt((vx * vx) + (vy * vy) + (vz * vz));
        return distance;
    }
}
