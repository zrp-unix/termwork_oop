class TGon extends NGon{
    TGon(Point2D[] p) throws Exception {
        if(p.length != 3) throw new Exception("h");
        this.setP(p);
    }

    public double square() {
        Point2D[] p = getP();
        return 0.5 * ((p[0].getX(0) - p[2].getX(0)) * (p[1].getX(1) - p[2].getX(1)) - (p[1].getX(0) - p[2].getX(0)) * (p[0].getX(1) - p[2].getX(1)));
    }
}
