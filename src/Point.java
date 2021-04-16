import java.util.Arrays;

class  Point {
    private int dim;
    private double[] x;

    Point(int dim) throws Exception {
        try {
            if(dim <= 0) throw new Exception("Dim < 0");
            this.x = new double[dim];
            this.dim = dim;
            for(int i = 0; i < dim; i++) {
                this.x[i] = 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    Point(int dim, double[] x) throws Exception {
        if(dim <= 0) throw new Exception("Dim < 0");
        this.x = new double[dim];
        this.dim = dim;
        System.arraycopy(x, 0, this.x, 0, dim);
    }

    double[] getX() {
        return x;
    }

    double getX(int i) {
        return x[i];
    }

    void setX(double[] x) {
        this.x = x;
    }

    void setX(double[] x, int i) {
        this.x[i] = x[i];
    }

    double abs() {
        double res = 0;
        for (double i : x) {
            res += i * i;
        }
        return Math.sqrt(res);
    }

    static Point add(Point a, Point b) {
        try {
            int dim = Math.min(a.dim, b.dim);
            double[] x = new double[dim];
            for (int i = 0; i < dim; i++) {
                x[i] = a.x[i] + b.x[i];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Point add(Point b) {
        try {
            int mindim = Math.min(dim, b.dim);
            double[] y = new double[mindim];
            for (int i = 0; i < mindim; i++) {
                y[i] = x[i] + b.x[i];
            }
            return new Point(y.length, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static Point sub(Point a, Point b) {
        try {
            int dim = Math.min(a.dim, b.dim);
            double[] x = new double[dim];
            for (int i = 0; i < dim; i++) {
                x[i] = a.x[i] - b.x[i];
            }
            return new Point(x.length, x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Point sub(Point b) {
        try {
            int mindim = Math.min(dim, b.dim);
            double[] y = new double[mindim];
            for (int i = 0; i < mindim; i++) {
                y[i] = x[i] - b.x[i];
            }
            return new Point(y.length, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static Point mult(Point a, double r) {
        try {
            double[] x = new double[a.dim];
            for (int i = 0; i < a.dim; i++) {
                x[i] = a.x[i] * r;
            }
            return new Point(x.length, x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    Point mult(double r) {
        try {
            double[] y = new double[dim];
            for (int i = 0; i < dim; i++) {
                y[i] = x[i] * r;
            }
            return new Point(y.length, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static double mult(Point a, Point b) {
        int dim = Math.min(a.dim, b.dim);
        int res = 0;
        for (int i = 0; i < dim; i++) {
            res += a.x[i] * b.x[i];
        }
        return res;
    }

    double mult(Point b) {
        int mindim = Math.min(dim, b.dim);
        int res = 0;
        for (int i = 0; i < mindim; i++) {
            res += x[i] * b.x[i];
        }
        return res;
    }

    static Point symAxis(Point a, int i) {
        try {
            double[] y = new double[a.dim];
            for (int k = 0; k < a.x.length; k++) {
                if (k != i && a.x[k] != 0)
                    y[k] = a.x[k] * -1;
                else
                    y[k] = a.x[k];
            }
            return new Point(y.length, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Point symAxis(int i) {
        try {
            double[] y = new double[dim];
            for (int k = 0; k < x.length; k++) {
                if (k != i && x[k] != 0)
                    y[k] = x[k] * -1;
                else
                    y[k] = x[k];
            }
            return new Point(y.length, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toString(){
        return "Coordinates: " + Arrays.toString(x) + "\nDimensions: " + dim;
    }
}
