import java.util.Arrays;

class NGon implements IShape {
    private int n;
    private Point2D[] p;

    NGon(Point2D[] p) throws Exception {
        if(p.length<=0) throw new Exception("empty array");
        this.p = p;
        n = p.length;
    }

    NGon() {
    }

    int getN() {
        return n;
    }

    Point2D[] getP() {
        return p;
    }

    Point2D getP(int i) throws Exception {
        if(i > p.length) throw new Exception("point does not exist");
        return p[i];
    }

    void setP(Point2D[] p) throws Exception {
        if(p.length<=0) throw new Exception("empty array");
        this.p = p;
        n = p.length;
    }

    void setP(Point2D p, int i) throws Exception {
        if(i > this.p.length) throw new Exception("point does not exist");
        this.p[i] = p;
    }

    public double square() throws Exception {
        double result = p[p.length-1].getX(0) * p[0].getX(1);
        for (int i = 0; i < p.length-1; i++) {
            result += p[i].getX(0) * p[i+1].getX(1);
        }
        result -= p[p.length-1].getX(1) * p[0].getX(0);
        for (int i = 0; i < p.length-1; i++) {
            result -= p[i].getX(1) * p[i+1].getX(0);
        }
        return 0.5*Math.abs(result);
    }

    public double length() throws Exception {
        double len = 0;
        for(int i = 0; i < n-1; i++){
            len += Point.sub(p[i], p[i+1]).abs();
        }
        return len;
    }

    public NGon shift(Point2D a) throws Exception {
        Point2D[] b = new Point2D[p.length];
        for(int k = 0; k < n; k++) {
            b[k] = new Point2D(Point.add(p[k], a).getX());
        }
        return new NGon(b);
    }

    public NGon rot(double phi) throws Exception {
        Point2D[] a = new Point2D[p.length];
        for(int k = 0; k < n; k++) {
            a[k] = p[k].rot(phi);
        }
        return new NGon(a);
    }

    public NGon symAxis(int i) throws Exception {
        Point2D[] a = new Point2D[p.length];
        for(int k = 0; k < n; k++) {
            a[k] = new Point2D(p[k].symAxis(i).getX());
        }
        return new NGon(a);
    }

//    public boolean cross(IShape s) throws Exception {
//        boolean hasIntersect = true;
//        if(s instanceof NGon) {
//            for(int i = 0; i < n; i++) {
//                Point2D p1 = p[i];
//                Point2D p2 = p[(i+1)%n];
//                Point2D v = (Point2D) p2.sub(p1);
//                for (int k = 0; k < ((NGon) s).n; k++) {
//                    Point2D w = (Point2D) ((NGon) s).getP(k).sub(p1);
//                    if(v.mult(w) > 0) {
//                        hasIntersect = false;
//                        break;
//                    }
//                }
//            }
//        }
//        return hasIntersect;
//    }

    public boolean cross(IShape s) throws Exception {
        NGon ps= (NGon) s;
        double A1,B1,C1,A2,B2,C2;
        double x,y;
        boolean y1,y2;
        for(int i=0;i<n-1;i++)
            for(int j=0;j<ps.getP().length -1;j++)
            {
                if((p[i].getX(0)==ps.getP(j).getX(0) && p[i].getX(1)==ps.getP(j).getX(1)) &&( p[i+1].getX(0)==ps.getP(j+1).getX(0) && p[i+1].getX(1)==ps.getP(j+1).getX(1) ))
                    return true;
                A1=p[i].getX(1)-p[i+1].getX(1);
                B1=-p[i].getX(0)+p[i+1].getX(0);
                C1=-p[i+1].getX(0)*A1+p[i+1].getX(1)*(-B1);

                A2=ps.getP(j).getX(1)-ps.getP(j+1).getX(1);
                B2=-ps.getP(j).getX(0)+ps.getP(j+1).getX(0);
                C2=-ps.getP(j+1).getX(0)*A2+ps.getP(j+1).getX(1)*(-B2);

                if(A1==0)
                {
                    y=-C1/B1;
                    x=(-C2-B2*y)/A2;
                }
                else
                if(B1==0)
                {
                    x=-C1/A1;
                    y=(-C2-A2*x)/B2;
                }
                else
                {
                    y = (A2 * C1 / A1 - C2) / (-A2 * B1 / A1 + B2);
                    x = (-C1 - B1 * y) / A1;
                }
                y1=(((p[i].getX(0)<=x && x<=p[i+1].getX(0))) ||((p[i].getX(0)>=x && x>=p[i+1].getX(0)))) && (((ps.getP(j).getX(0)<=x && x<=ps.getP(j+1).getX(0))) ||((ps.getP(j).getX(0)>=x && x>=ps.getP(j+1).getX(0))));
                y2=(((p[i].getX(1)<=y && y<=p[i+1].getX(1))) ||((p[i].getX(1)>=y && y>=p[i+1].getX(1)))) && (((ps.getP(j).getX(1)<=y && y<=ps.getP(j+1).getX(1))) ||((ps.getP(j).getX(1)>=y && y>=ps.getP(j+1).getX(1))));
                if(y1&&y2==true)
                    return true;
            }
        if(p[n-1].getX(0)==ps.getP(n-1).getX(0) && p[n-1].getX(1)==ps.getP(n-1).getX(1) && p[0].getX(0)==ps.getP(0).getX(0) && p[0].getX(1)==ps.getP(0).getX(1) )
            return true;
        A1=p[n-1].getX(1)-p[0].getX(1);
        B1=-p[n-1].getX(0)+p[0].getX(0);
        C1=-p[0].getX(0)*A1+p[0].getX(1)*(-B1);

        A2=ps.getP(n-1).getX(1)-ps.getP(0).getX(1);
        B2=-ps.getP(n-1).getX(0)+ps.getP(0).getX(0);
        C2=-ps.getP(0).getX(0)*A2+ps.getP(0).getX(1)*(-B2);

        y=(A2*C1/A1-C2)/(-A2*B1/A1+B2);
        x=(-C1-B1*y)/A1;

        y1=(p[n-1].getX(0)<=x && x<=p[0].getX(0)) ||(p[n-1].getX(0)>=x && x>=p[0].getX(0)) && (ps.getP(n-1).getX(0)<=x && x<=ps.getP(0).getX(0)) ||(ps.getP(n-1).getX(0)>=x && x>=ps.getP(0).getX(0));
        y2=(p[n-1].getX(1)<=y && y<=p[0].getX(1)) ||(p[n-1].getX(1)>=y && y>=p[0].getX(1)) && (ps.getP(n-1).getX(1)<=y && y<=ps.getP(0).getX(1)) ||(ps.getP(n-1).getX(1)>=y && y>=ps.getP(0).getX(1));
        if(y1&&y2==true)
            return true;
        return false;
    }

    public String toString() {
        return Arrays.toString(p);
    }
}
