class Point3D extends Point {
    public Point3D() throws Exception {
        super(3);
    }

    public Point3D(double[] x) throws Exception {
        super(3, x);
    }

    static Point3D cross_prod(Point3D p1, Point3D p2) {
        try {
            double[] x = new double[3];
            x[0] = p1.getX(1) * p2.getX(2) - p1.getX(2) * p2.getX(1);
            x[1] = p1.getX(2) * p2.getX(0) - p1.getX(0) * p2.getX(2);
            x[2] = p1.getX(0) * p2.getX(1) - p1.getX(1) * p2.getX(0);
            return new Point3D(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Point3D cross_prod(Point3D p) {
        try {
            double[] x = new double[3];
            x[0] = this.getX(1) * p.getX(2) - this.getX(2) * p.getX(1);
            x[1] = this.getX(2) * p.getX(0) - this.getX(0) * p.getX(2);
            x[2] = this.getX(0) * p.getX(1) - this.getX(1) * p.getX(0);
            return new Point3D(x);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
