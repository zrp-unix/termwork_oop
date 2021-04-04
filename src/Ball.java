class Ball implements IFigure{
    private Point3D p;
    private double r;

    Ball(Point3D p, double r) {

    }

    Point3D getP() {
        return p;
    }

    void setP (Point3D p) {

    }

    double getR(double r) {
        return r;
    }

    void setR(double r) {
        this.r = r;
    }

    public double square() {
        return 0;
    }

    public double volume() {
        return 0;
    }

    public String toString() {
        return null;
    }
}
