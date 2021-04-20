class Parallelepiped extends Prism {
    Parallelepiped(Point3D[] p) throws Exception {
        super(p);
    }
    public double volume() throws Exception {
        Point3D a = new Point3D(new double[]{getP(1).getX(0) - getP(0).getX(0), getP(1).getX(1) - getP(0).getX(1), getP(1).getX(2) - getP(0).getX(2)});
        Point3D b = new Point3D(new double[]{getP(3).getX(0) - getP(0).getX(0), getP(3).getX(1) - getP(0).getX(1), getP(3).getX(2) - getP(0).getX(2)});
        Point3D c = new Point3D(new double[]{getP(4).getX(0) - getP(0).getX(0), getP(4).getX(1) - getP(0).getX(1), getP(4).getX(2) - getP(0).getX(2)});
        return a.mix_prod(b, c);
    }

    public String toString() {
        return null;
    }
}
