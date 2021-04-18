import java.util.Arrays;

class Polyline extends OpenFigure {
    private int n;
    private Point2D[] p;
    Polyline(Point2D[] p) throws Exception {
        if(p.length <= 0) throw new Exception("p empty");
        this.p = p;
        n = p.length;
    }
    Point2D[] getP() {
        return p;
    }

    Point2D getP(int i) throws Exception{
        if(i >= n || i < 0) throw new Exception("wrong point number");
        return p[i];
    }

    void setP(Point2D[] p) {
        n = p.length;
        this.p = p;
    }

    void setP(Point2D p, int i) throws Exception {
        if(i >= n || i < 0) throw new Exception("wrong point number");
        this.p[i] = p;
    }

    public double length() throws Exception {
        double len = 0;
        for(int i = 0; i < n-1; i++){
            len += Point.sub(p[i], p[i+1]).abs();
        }
        return len;
    }

    public Polyline shift(Point2D a) throws Exception {
        Point2D[] b = new Point2D[p.length];
        for(int k = 0; k < n; k++) {
            b[k] = new Point2D(Point.add(p[k], a).getX());
        }
        return new Polyline(b);
    }

    public Polyline rot(double phi) throws Exception {
        Point2D[] a = new Point2D[p.length];
        for(int k = 0; k < n; k++) {
            a[k] = p[k].rot(phi);
        }
        return new Polyline(a);
    }

    public Polyline symAxis(int i) throws Exception{
        Point2D[] a = new Point2D[p.length];
        for(int k = 0; k < n; k++) {
                a[k] = new Point2D(p[k].symAxis(i).getX());
        }
        return new Polyline(a);
    }

    public boolean cross(IShape s) {
        return false;
    }

    public String toString() {
        return Arrays.toString(p);
    }
}
