import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        double[] z = {1, 2};
        Point b = new Point(2);
        Point2D p1 = new Point2D(new double[]{0, 0});
        Point2D p2 = new Point2D(new double[]{2, 2});
        Segment s1 = new Segment(p1, p2);
        s1.length();
        System.out.println(s1.symAxis(1));
        ;
    }
}
