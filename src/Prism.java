class Prism implements IFigure{
    private int n;
    private Point3D[] p1;
    private Point3D[] p2;

    Prism(Point3D[] p1, Point3D[] p2) throws Exception {
        if(p1.length < 3 || p2.length < 3)throw new Exception("prism must have 3 or more points on each side");
        if(p1.length != p2.length)throw new Exception("sides have different number of points");
        this.p1 = p1;
        this.p2 = p2;
        this.n = p1.length;
    }

    Prism(Point3D[] p) throws Exception {
        if(p.length % 2 != 0) throw new Exception("number of points must be even");
        System.arraycopy(p, 0, p1, 0, p.length/2);
        System.arraycopy(p, p.length/2+1, p2, 0, p.length/2);
        n = p.length/2;
    }

    int getN() {
        return n;
    }

    Point3D[] getP() {
        Point3D[] p = new Point3D[p1.length*2];
        System.arraycopy(p1, 0, p, 0, p1.length);
        System.arraycopy(p2, 0, p, p1.length+1, p2.length);
        return p;
    }

    void setP(Point3D[] p) throws Exception {
        if(p.length % 2 != 0) throw new Exception("number of points must be even");
        System.arraycopy(p, 0, p1, 0, p.length/2);
        System.arraycopy(p, p.length/2+1, p2, 0, p.length/2);
    }

    Point3D getP(int i) throws Exception {
        if (i > p1.length) throw new Exception("this point does not exist");
        return p1[i];
    }

    void setP(Point3D p, int i) throws Exception {
        if (i > p1.length) throw new Exception("this point does not exist");
        p1[i] = p;
    }

    public double square() throws Exception {
        double x1, y1, z1;
        double x2 = 0, y2 = 1, z2 = 0;
        int cnt = 0;
        for (int i = 0; i < p1.length; i++) {
            if(p1[i].getX(1)== 0)
                cnt++;
        }
        x1 = ((p1[0].getX(1) - p1[1].getX(1)) * (p1[2].getX(2) - p1[1].getX(2))) - ((p1[0].getX(2) - p1[1].getX(2)) * (p1[2].getX(1) - p1[1].getX(1)));
        y1 = ((p1[0].getX(0) - p1[1].getX(0)) * (p1[2].getX(2) - p1[1].getX(2))) - ((p1[0].getX(2) - p1[1].getX(2)) * (p1[2].getX(0) - p1[1].getX(0)));
        z1 = ((p1[0].getX(0) - p1[1].getX(0)) * (p1[2].getX(1) - p1[1].getX(1))) - ((p1[0].getX(1) - p1[1].getX(1)) * (p1[2].getX(0) - p1[1].getX(0)));
        double d =  (-1 * p1[1].getX(0)) * x1 + (-1 * p1[1].getX(1)) * y1 + (-1 * p1[1].getX(2)) * z1;
        double cosa = Math.abs(x1 * x2 + y1 * y2 + z1 * z2)/(Math.sqrt(x1*x1 + y1*y1 + z1*z1) * Math.sqrt(x2*x2 + y2*y2 + z2*z2));
        double s = p1[p1.length-1].getX(0) * p1[0].getX(2);
        for (int i = 0; i < p1.length-1; i++) {
            s += p1[i].getX(0) * p1[i+1].getX(2);
        }
        s -= p1[p1.length-1].getX(2) * p1[0].getX(0);
        for (int i = 0; i < p1.length-1; i++) {
            s -= p1[i].getX(2) * p1[i+1].getX(0);
        }
        double h = Math.abs(x1*p2[1].getX(0) + y1*p2[1].getX(1) + z1*p2[1].getX(2) + d)/Math.sqrt(x1*x1 + y1*y1 + z1*z1);
        if(cnt == p1.length) {
            ;
        }else {
            s /= cosa;
        }
        s = Math.abs(s);
        for (int i = 0; i < n; i++) {
            double c = 0;
            double x = 0, y = 0, z = 0;
            Point3D ab = new Point3D(new double[]{p2[i].getX(0) - p1[i].getX(0), p2[i].getX(1) - p1[i].getX(1), p2[i].getX(2) - p1[i].getX(2)});
            Point3D ac = new Point3D(new double[]{p1[(i+1)%n].getX(0) - p1[i].getX(0), p1[(i+1)%n].getX(1) - p1[i].getX(1), p1[(i+1)%n].getX(2) - p1[i].getX(2)});
            x = (ab.getX(1) * ac.getX(2)) - (ab.getX(2) * ac.getX(1));
            y = (ab.getX(0) * ac.getX(2)) - (ab.getX(2) * ac.getX(0));
            z = (ab.getX(0) * ac.getX(1)) - (ab.getX(1) * ac.getX(0));
            c = Math.sqrt(x*x + y*y + z*z);
            s += Math.abs(c);
        }
        return s;
    }

    public double volume() throws Exception {
        double vol = 0;
        double x1, y1, z1;
        double x2 = 0, y2 = 1, z2 = 0;
        int cnt = 0;
        for (int i = 0; i < p1.length; i++) {
            if(p1[i].getX(1)== 0)
                cnt++;
        }
        x1 = ((p1[0].getX(1) - p1[1].getX(1)) * (p1[2].getX(2) - p1[1].getX(2))) - ((p1[0].getX(2) - p1[1].getX(2)) * (p1[2].getX(1) - p1[1].getX(1)));
        y1 = ((p1[0].getX(0) - p1[1].getX(0)) * (p1[2].getX(2) - p1[1].getX(2))) - ((p1[0].getX(2) - p1[1].getX(2)) * (p1[2].getX(0) - p1[1].getX(0)));
        z1 = ((p1[0].getX(0) - p1[1].getX(0)) * (p1[2].getX(1) - p1[1].getX(1))) - ((p1[0].getX(1) - p1[1].getX(1)) * (p1[2].getX(0) - p1[1].getX(0)));
        double d =  (-1 * p1[1].getX(0)) * x1 + (-1 * p1[1].getX(1)) * y1 + (-1 * p1[1].getX(2)) * z1;
        double cosa = Math.abs(x1 * x2 + y1 * y2 + z1 * z2)/(Math.sqrt(x1*x1 + y1*y1 + z1*z1) * Math.sqrt(x2*x2 + y2*y2 + z2*z2));
        double s = p1[p1.length-1].getX(0) * p1[0].getX(2);
        for (int i = 0; i < p1.length-1; i++) {
            s += p1[i].getX(0) * p1[i+1].getX(2);
        }
        s -= p1[p1.length-1].getX(2) * p1[0].getX(0);
        for (int i = 0; i < p1.length-1; i++) {
            s -= p1[i].getX(2) * p1[i+1].getX(0);
        }
        s*=0.5;
        double h = Math.abs(x1*p2[1].getX(0) + y1*p2[1].getX(1) + z1*p2[1].getX(2) + d)/Math.sqrt(x1*x1 + y1*y1 + z1*z1);
        if(cnt == p1.length) {
            ;
        }else {
            s /= cosa;
        }
        vol = Math.abs(s*h);
        return vol;
    }

    public String toString() {
        return null;
    }
}
