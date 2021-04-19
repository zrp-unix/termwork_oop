import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        double[] z = {1, 2};

        Point2D p1 = new Point2D(new double[]{0, 0});
        Point2D p2 = new Point2D(new double[]{2, 2});
        Point2D p3 = new Point2D(new double[]{600, 1488});
        Point2D f = new Point2D(new double[] {1, 1});
        Circle c = new Circle(f, 10);
        Point2D[] pa = {p1, p2, p3, p3};
        Polyline p = new Polyline(pa);
        Rectangle r = new Rectangle(pa);
        NGon t = new NGon(pa);

        System.out.println(t.square());
    }
}
