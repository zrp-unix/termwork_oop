import java.util.Arrays;

class Segment extends OpenFigure {
    private Point2D start;
    private Point2D finish;

    Segment(Point2D s, Point2D f) {
        start = s; finish = f;
    }

    Point2D getStart() {
        return start;
    }

    void setStart(Point2D a) {
        start = a;
    }

    Point2D getFinish() {
        return start;
    }

    void setFinish(Point2D a) {
        finish = a;
    }

    public double length()  throws  Exception{
        Point2D p = new Point2D(Point.sub(finish,start).getX());;
        return p.abs();
    }

    public Segment shift(Point2D a) throws Exception {
        Point2D p1 = new Point2D(Point.add(start, a).getX());
        Point2D p2 = new Point2D(Point.add(finish, a).getX());
        return new Segment(p1, p2);
    }

    public IShape rot(double phi) throws Exception {
        Point2D s1 = start.rot(phi);
        Point2D f1 = finish.rot(phi);
        return new Segment(s1, f1);
    }

    public IShape symAxis(int i) throws Exception {

            Point2D s1 = new Point2D(start.symAxis(i).getX());;
            Point2D f1 = new Point2D(finish.symAxis(i).getX());;
            return new Segment(s1, f1);
    }

    public boolean cross(IShape s) {
        return false;
    }

    public String toString() {
        return "Start: " + Arrays.toString(start.getX()) + "\nFinish: " + Arrays.toString(finish.getX());
    }
}
