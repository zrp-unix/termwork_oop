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

    public double square() throws Exception {
        double x1, y1, z1;
        double x2 = 0, y2 = 1, z2 = 0;
        int cnt = 0;
        for (int i = 0; i < p.length; i++) {
            if(p[i].getX(1)== 0)
                cnt++;
        }
        x1 = ((p[0].getX(1) - p[1].getX(1)) * (p[2].getX(2) - p[1].getX(2))) - ((p[0].getX(2) - p[1].getX(2)) * (p[2].getX(1) - p[1].getX(1)));
        y1 = ((p[0].getX(0) - p[1].getX(0)) * (p[2].getX(2) - p[1].getX(2))) - ((p[0].getX(2) - p[1].getX(2)) * (p[2].getX(0) - p[1].getX(0)));
        z1 = ((p[0].getX(0) - p[1].getX(0)) * (p[2].getX(1) - p[1].getX(1))) - ((p[0].getX(1) - p[1].getX(1)) * (p[2].getX(0) - p[1].getX(0)));
        double d =  (-1 * p[1].getX(0)) * x1 + (-1 * p[1].getX(1)) * y1 + (-1 * p[1].getX(2)) * z1;
        double cosa = Math.abs(x1 * x2 + y1 * y2 + z1 * z2)/(Math.sqrt(x1*x1 + y1*y1 + z1*z1) * Math.sqrt(x2*x2 + y2*y2 + z2*z2));
        double s = p[p.length-1].getX(0) * p[0].getX(2);
        for (int i = 0; i < p.length-1; i++) {
            s += p[i].getX(0) * p[i+1].getX(2);
        }
        s -= p[p.length-1].getX(2) * p[0].getX(0);
        for (int i = 0; i < p.length-1; i++) {
            s -= p[i].getX(2) * p[i+1].getX(0);
        }
        s*= 0.5;
        double h = Math.abs(x1*p0.getX(0) + y1*p0.getX(1) + z1*p0.getX(2) + d)/Math.sqrt(x1*x1 + y1*y1 + z1*z1);
        if(cnt == p.length) {
            ;
        }else {
            s /= cosa;
        }
        for (int i = 0; i < p.length-1; i++) {
            double c = 0;
            double x = 0, y = 0, z = 0;
            Point3D ab = new Point3D(new double[]{p0.getX(0) - p[i].getX(0), p0.getX(1) - p[i].getX(1), p0.getX(2) - p[i].getX(2)});
            Point3D ac = new Point3D(new double[]{p0.getX(0) - p[i+1].getX(0), p0.getX(1) - p[i+1].getX(1), p0.getX(2) - p[i+1].getX(2)});
            x = (ab.getX(1) * ac.getX(2)) - (ab.getX(2) * ac.getX(1));
            y = (ab.getX(0) * ac.getX(2)) - (ab.getX(2) * ac.getX(0));
            z = (ab.getX(0) * ac.getX(1)) - (ab.getX(1) * ac.getX(0));
            c = Math.sqrt(x*x + y*y + z*z);
            s += 0.5*c;
        }
        return s;
    }

    public double volume() {
        double vol = 0;
        double x1, y1, z1;
        double x2 = 0, y2 = 1, z2 = 0;
        int cnt = 0;
        for (int i = 0; i < p.length; i++) {
            if(p[i].getX(1)== 0)
                cnt++;
        }
        x1 = ((p[0].getX(1) - p[1].getX(1)) * (p[2].getX(2) - p[1].getX(2))) - ((p[0].getX(2) - p[1].getX(2)) * (p[2].getX(1) - p[1].getX(1)));
        y1 = ((p[0].getX(0) - p[1].getX(0)) * (p[2].getX(2) - p[1].getX(2))) - ((p[0].getX(2) - p[1].getX(2)) * (p[2].getX(0) - p[1].getX(0)));
        z1 = ((p[0].getX(0) - p[1].getX(0)) * (p[2].getX(1) - p[1].getX(1))) - ((p[0].getX(1) - p[1].getX(1)) * (p[2].getX(0) - p[1].getX(0)));
        double d =  (-1 * p[1].getX(0)) * x1 + (-1 * p[1].getX(1)) * y1 + (-1 * p[1].getX(2)) * z1;
        double cosa = Math.abs(x1 * x2 + y1 * y2 + z1 * z2)/(Math.sqrt(x1*x1 + y1*y1 + z1*z1) * Math.sqrt(x2*x2 + y2*y2 + z2*z2));
        double s = p[p.length-1].getX(0) * p[0].getX(2);
        for (int i = 0; i < p.length-1; i++) {
            s += p[i].getX(0) * p[i+1].getX(2);
        }
        s -= p[p.length-1].getX(2) * p[0].getX(0);
        for (int i = 0; i < p.length-1; i++) {
            s -= p[i].getX(2) * p[i+1].getX(0);
        }
        s*= 0.5;
        double h = Math.abs(x1*p0.getX(0) + y1*p0.getX(1) + z1*p0.getX(2) + d)/Math.sqrt(x1*x1 + y1*y1 + z1*z1);
        if(cnt == p.length) {
            ;
        }else {
            s /= cosa;
        }
        vol = Math.abs(h*s/3);
        return vol;
    }

    public String toString() {
        return null;
    }
}
