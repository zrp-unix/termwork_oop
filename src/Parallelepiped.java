import java.util.Arrays;

class Parallelepiped extends Prism {
    Parallelepiped(Point3D[] p) throws Exception {
        super(p);
    }
    public double volume() throws Exception {
        double vol = 0;
        double x1, y1, z1;
        double x2 = 0, y2 = 1, z2 = 0;
        int cnt = 0;
        Point3D[]p = getP();
        Point3D[]p1 = new Point3D[getN()];
        Point3D[]p2 = new Point3D[getN()];
        for (int i = 0; i < getN(); i++)
            p1[i] = p[i];
        for (int i = getN(); i < getN()*2; i++)
            p2[i-getN()] = p[i];
        for (int i = 0; i < getN(); i++) {
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
        return Arrays.toString(getP()) + " " + getN();
    }
}
