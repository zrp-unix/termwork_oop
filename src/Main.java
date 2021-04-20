import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<IShape> is = new LinkedList<IShape>();
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of shapes: ");
        int shape_num = in.nextInt();
        for(int i = 0; i < shape_num; i++) {
            int n;
            System.out.println("Input shape: ");
            String shape = in.nextLine();
            switch (shape) {
                case "Segment":
                    try {
                        Point2D s = new Point2D(new double[] {in.nextDouble(), in.nextDouble()});
                        Point2D f = new Point2D(new double[] {in.nextDouble(), in.nextDouble()});
                        is.add(new Segment(s, f));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case "Polyline":
                    n = in.nextInt();
                    try {
                        Point2D[] p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new  double[]{in.nextDouble(), in.nextDouble()});
                        }
                        is.add(new Polyline(p));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "Circle":
                    try {
                        Point2D p = new Point2D(new double[] {in.nextDouble(), in.nextDouble()});
                        double r = in.nextDouble();
                        is.add(new Circle(p, r));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "NGon":
                    n = in.nextInt();
                    try {
                        Point2D[] p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new  double[]{in.nextDouble(), in.nextDouble()});
                        }
                        is.add(new NGon(p));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "TGon":
                    n = 3;
                    try {
                        Point2D[] p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new  double[]{in.nextDouble(), in.nextDouble()});
                        }
                        is.add(new TGon(p));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "QGon":
                    n = 4;
                    try {
                        Point2D[] p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new  double[]{in.nextDouble(), in.nextDouble()});
                        }
                        is.add(new QGon(p));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "Rectangle":
                    n = 3+1;
                    try {
                        Point2D[] p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new  double[]{in.nextDouble(), in.nextDouble()});
                        }
                        is.add(new Rectangle(p));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "Trapeze":
                    n = 2+2;
                    try {
                        Point2D[] p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new  double[]{in.nextDouble(), in.nextDouble()});
                        }
                        is.add(new Trapeze(p));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        double square_sum = 0;
        double length_sum = 0;
        double squares[] = new double[shape_num];
        for (int j = 0; j < shape_num; j++) {
            try {
                squares[j] = is.get(j).square();
                square_sum += is.get(j).square();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < shape_num; j++) {
            try {
                length_sum += is.get(j).length();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum of all squares: " + square_sum);
        System.out.println("Sum of all lengths: " + length_sum);
        OptionalDouble average = Arrays.stream(squares).average();
        System.out.println("Average square: " + average);
        for(int i = 0; i < shape_num; i++) {
            int n;
            System.out.println("Input shape: ");
            String shape = in.nextLine();
            Point2D[] p;
            IShape sh = new IShape() {
                @Override
                public double square() throws Exception {
                    return 0;
                }

                @Override
                public double length() throws Exception {
                    return 0;
                }

                @Override
                public IShape shift(Point2D a) throws Exception {
                    return null;
                }

                @Override
                public IShape rot(double phi) throws Exception {
                    return null;
                }

                @Override
                public IShape symAxis(int i) throws Exception {
                    return null;
                }

                @Override
                public boolean cross(IShape s) throws Exception {
                    return false;
                }
            };
            try {
                switch (shape) {
                    case "Segment":
                            Point2D s = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            Point2D f = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            sh = new Segment(s, f);
                    case "Polyline":
                        n = in.nextInt();
                            p = new Point2D[n];
                            for (int k = 0; k < n; k++) {
                                p[k] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            }
                            sh = new Polyline(p);
                        break;
                    case "Circle":
                            Point2D p1 = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            double r = in.nextDouble();
                            sh = new Circle(p1, r);
                        break;
                    case "NGon":
                        n = in.nextInt();
                        p = new Point2D[n];
                            for (int k = 0; k < n; k++) {
                                p[k] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            }
                            sh = new NGon(p);
                        break;
                    case "TGon":
                        n = 3;
                            p = new Point2D[n];
                            for (int k = 0; k < n; k++) {
                                p[k] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            }
                            sh = new TGon(p);
                        break;
                    case "QGon":
                        n = 4;
                            p = new Point2D[n];
                            for (int k = 0; k < n; k++) {
                                p[k] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            }
                            sh = new QGon(p);
                        break;
                    case "Rectangle":
                        n = 3 + 1;
                            p = new Point2D[n];
                            for (int k = 0; k < n; k++) {
                                p[k] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                            }
                            sh = new Rectangle(p);
                        break;
                    case "Trapeze":
                        n = 2 + 2;
                        p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[]{in.nextDouble(), in.nextDouble()});
                        }
                        sh = new Trapeze(p);
                        break;
                }
                for (int k = 0; k < shape_num; k++) {
                    if(sh.cross(is.get(k))) {
                        System.out.println("Intersect");
                    } else {
                        System.out.println("Don't intersect");
                    }
                }
                String move;
                move = in.nextLine();
                switch (move) {
                    case "Shift":
                        sh.shift(new Point2D(new double[]{in.nextDouble(), in.nextDouble()}));
                        break;
                    case "Rotate":
                        sh.rot(in.nextDouble());
                        break;
                    case "Symmetry":
                        break;


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
