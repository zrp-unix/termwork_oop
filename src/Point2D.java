class Point2D extends Point {
    Point2D() throws Exception {
        super(2);
    }

    Point2D(double[] x) throws Exception {
        super(2, x);
    }

    static Point2D rot(Point2D p, double phi) {
        try {
            double x = p.getX(0);
            double y = p.getX(1);
            double xres = x * Math.cos(phi) - y * Math.sin(phi);
            double yres = y * Math.cos(phi) + x * Math.sin(phi);
            return new Point2D(new double[]{xres, yres});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Point2D rot(double phi) {
        try {
            double x = this.getX(0);
            double y = this.getX(1);
            double xres = x * Math.cos(phi) - y * Math.sin(phi);
            double yres = y * Math.cos(phi) + x * Math.sin(phi);
            return new Point2D(new double[]{xres, yres});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
