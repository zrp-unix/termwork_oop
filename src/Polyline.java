class Polyline {
    private int n;
    private Point2D[] p;

    Polyline(Point2D[] p) throws Exception{
        if(p.length <= 0) throw new Exception("а");
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

    public double length() {
        ;
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
