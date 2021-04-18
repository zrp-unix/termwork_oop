class Prism implements IFigure{
    private int n;
    private Point3D[] p1;
    private Point3D[] p2;

    Prism(Point3D[] p1, Point3D[] p2) {

    }

    Prism(Point3D[] p) {

    }

    int getN() {
        return n;
    }

    Point3D[] getP() {
        return ;
    }

    void setP(Point3D[] p){

    }

    Point3D getP(int i) {
        return null;
    }

    void setP(Point3D p, int i) {

    }

    public double square() {
        return 0;
    }

    public double volume() {
        double result = 0;
        for (int i = 0; i < n; i++) {
            result +=
        }
        return 1/6 * getP(0).mix_prod(getP(1), getP(2));
    }

    public String toString() {
        return null;
    }
}
