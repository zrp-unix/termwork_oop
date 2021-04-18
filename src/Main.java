import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        double[] z = {1, 2};
        Point2D p1 = new Point2D(new double[]{0, 0});
        Point2D p2 = new Point2D(new double[]{2, 2});
        Point2D p3 = new Point2D(new double[]{600, 1488});
        Point2D[] pa = {p1, p2, p3};
        Polyline p = new Polyline(pa);
        System.out.println(p.shift(p2));
    }
}
