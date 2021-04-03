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

    public double length() {
        return 0;
    }

    public Segment shift(Point2D a) {
        return null;
    }

    public IShape rot(double phi) {
        return null;
    }

    public IShape symAxis(int i) {
        return null;
    }

    public boolean cross(IShape s) {
        return false;
    }

    public String toString() {
        return null;
    }
}
