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

    public Segment rot(double phi) throws Exception {
        Point2D s1 = start.rot(phi);
        Point2D f1 = finish.rot(phi);
        return new Segment(s1, f1);
    }

    public Segment symAxis(int i) throws Exception {
            Point2D s1 = new Point2D(start.symAxis(i).getX());;
            Point2D f1 = new Point2D(finish.symAxis(i).getX());;
            return new Segment(s1, f1);
    }

    public boolean cross(IShape s) {
        Segment ps = (Segment) s;
        double A1, B1, C1, A2, B2, C2;
        if ((start.getX(0) == ps.getStart().getX(0) && finish.getX(0) == getFinish().getX(0)) && (start.getX(1) == ps.getStart().getX(1) && finish.getX(1) == getFinish().getX(1)))
            return true;
        A1 = start.getX(1) - finish.getX(1);
        B1 = -start.getX(0) + finish.getX(0);
        C1 = -finish.getX(0) * A1 + finish.getX(1) * (-B1);

        A2 = ps.getStart().getX(1) - ps.getFinish().getX(1);
        B2 = -ps.getStart().getX(0) + ps.getFinish().getX(0);
        C2 = -ps.getFinish().getX(0) * A2 + ps.getFinish().getX(1) * (-B2);
        double x, y;
        if (A1 == 0) {
            y = -C1 / B1;
            x = (-C2 - B2 * y) / A2;
        } else
        if (B1 == 0) {
            x = -C1 / A1;
            y = (-C2 - A2 * x) / B2;
        } else {
            y = (A2 * C1 / A1 - C2) / (-A2 * B1 / A1 + B2);
            x = (-C1 - B1 * y) / A1;
        }
        boolean y1, y2;
        y1 = ((start.getX(0) <= x && x <= finish.getX(0)) || (start.getX(0) >= x && x >= finish.getX(0))) && ((ps.getStart().getX(0) <= x && x <= ps.getFinish().getX(0)) || (ps.getStart().getX(0) >= x && x >= ps.getFinish().getX(0)));
        y2 = ((start.getX(1) <= y && y <= finish.getX(1)) || (start.getX(1) >= y && y >= finish.getX(1))) && ((ps.getStart().getX(1) <= y && y <= ps.getFinish().getX(1)) || (ps.getStart().getX(1) >= y && y >= ps.getFinish().getX(1)));
        if (y1 && y2 == true)
            return true;
        else return false;
    }

    public String toString() {
        return "Start: " + Arrays.toString(start.getX()) + "\nFinish: " + Arrays.toString(finish.getX());
    }
}
