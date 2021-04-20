class Ball implements IFigure{
    private Point3D p;
    private double r;

    Ball(Point3D p, double r) throws Exception {
        if(r < 0) throw new Exception("radius less than 0");
        this.p = p;
        this.r = r;
    }

    Point3D getP() {
        return p;
    }

    void setP (Point3D p) {
        this.p = p;
    }

    double getR(double r) {
        return r;
    }

    void setR(double r) {
        this.r = r;
    }

    public double square() {
        return 4 * Math.PI * (r * r);
    }

    public double volume() {
        return (double)4/3 * Math.PI * (r * r * r);
    }

    public String toString() {
        return "Radius: " + r + "\n" + p;
    }
}
