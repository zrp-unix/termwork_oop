class Pyramid implements IFigure{
    private Point3D p0;
    private int n;
    private Point3D[] p;

    Pyramid(Point3D p0, Point3D[] p) throws Exception {
        if(p.length <= 2) throw new Exception("the number of points less than 3");
        this.p0 = p0;
        this.p = p;
    }

    Pyramid(Point3D[] p) throws Exception {
        if(p.length <= 3) throw new Exception("the number of points less than 4");
        p0 = p[0];
        Point3D[] a = new Point3D[p.length-1];
        System.arraycopy(p, 1, a, 0, p.length-1);
        this.p = a;
    }

    int getN() {
        return n;
    }

    Point3D[] getP() {
        return p;
    }

    void setP(Point3D[] p) throws Exception {
        if(p.length <= 2) throw new Exception("the number of points less than 3");
        this.p = p;
    }

    Point3D getP(int i) throws Exception {
        if(i > p.length) throw new Exception("point does not exist");
        return p[i];
    }

    void setP(Point3D p, int i) throws Exception {
        if(i > this.p.length) throw new Exception("point does not exist");
        this.p[i] = p;
    }

    public double square() {
        p.
    }

    public double volume() {
        return 0;
    }

    public String toString() {
        return null;
    }
}
