class Circle implements IShape{
    private Point2D p;
    private double r;

    Circle(Point2D p, double r) throws Exception {
        if(r < 0) throw new Exception("radius smaller than 0");
        this.p = p;
        this.r = r;
    }

    Point2D getP() {
        return p;
    }

    void setP(Point2D p) {
        this.p = p;
    }

    double getR() {
        return r;
    }

    void setR(double r) {
        this.r = r;
    }

    public double square() {
        return Math.PI * r * r;
    }

    public double length() {
        return 2 * Math.PI * r;
    }

    public Circle shift(Point2D a) throws Exception {
        return new Circle(new Point2D(Point.add(p, a).getX()), r);
    }

    public Circle rot(double phi) throws Exception {
        return new Circle(p.rot(phi), r);
    }

    public Circle symAxis(int i) throws Exception {
        return new Circle(new Point2D(p.symAxis(i).getX()), r);
    }

    public boolean cross(IShape s) {
        return false;
    }

    public String toString() {
        return p.toString() + " \nRadius: " + r;
    }
}
