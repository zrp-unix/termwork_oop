import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] z = {1, 2};
        Point p = new Point(5,new double[]{1, 6, 5,4,3});
        System.out.println(p.abs());
        System.out.println(p.toString());
        System.out.println(Arrays.toString(p.getX()));
    }
}
