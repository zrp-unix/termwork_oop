interface IShape {
    double square() throws Exception;
    double length() throws Exception;
    IShape shift(Point2D a) throws Exception;
    IShape rot(double phi) throws Exception;
    IShape symAxis(int i) throws Exception;
    boolean cross(IShape s);
}
