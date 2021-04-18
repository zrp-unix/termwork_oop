class QGon extends NGon{
    QGon(Point2D[] p) throws Exception {
        if(p.length != 4) throw new Exception("the number of points different from 4");
        this.setP(p);
    }

    public double square() throws Exception {
        Point2D[] p = getP();
        double result = p[4-1].getX(0) * p[0].getX(1);
        for (int i = 0; i < 4-1; i++) {
            result += p[i].getX(0) * p[i+1].getX(1);
        }
        result -= p[4-1].getX(1) * p[0].getX(0);
        for (int i = 0; i < 4-1; i++) {
            result -= p[i].getX(1) * p[i+1].getX(0);
        }
        return 0.5*Math.abs(result);
    }
}
