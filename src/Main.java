import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List < IShape > is = new LinkedList < IShape > ();
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the number of shapes: ");
            int shape_num = in .nextInt();
            for (int i = 0; i < shape_num; i++) {
                int n;
                Point2D[] p;
                Point2D point;
                System.out.print("Enter the shape: ");
                String shape = in .next();
                switch (shape) {
                    case "Segment":
                        System.out.print("Enter the start coordinates: ");
                        Point2D s = new Point2D(new double[] {
                                in .nextDouble(), in .nextDouble()
                        });
                        System.out.print("Enter the finish coordinates: ");
                        Point2D f = new Point2D(new double[] {
                                in .nextDouble(), in .nextDouble()
                        });
                        is.add(new Segment(s, f));
                        break;
                    case "Polyline":
                        System.out.print("Enter the number of points: ");
                        n = in .nextInt();
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        is.add(new Polyline(p));
                        break;
                    case "Circle":
                        System.out.print("Enter the coordinates: ");
                        point = new Point2D(new double[] {
                                in .nextDouble(), in .nextDouble()
                        });
                        System.out.print("Enter the radius: ");
                        double r = in .nextDouble();
                        is.add(new Circle(point, r));
                        break;
                    case "NGon":
                        System.out.print("Enter the number of points: ");
                        n = in .nextInt();
                        p = new Point2D[n];
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        is.add(new NGon(p));
                        break;
                    case "TGon":
                        n = 3;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        is.add(new TGon(p));
                        break;
                    case "QGon":
                        n = 4;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        is.add(new QGon(p));
                        break;
                    case "Rectangle":
                        n = 3 + 1;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        is.add(new Rectangle(p));
                        break;
                    case "Trapeze":
                        n = 2 + 2;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        is.add(new Trapeze(p));
                        break;
                }
            }
            double square_sum = 0;
            double length_sum = 0;
            double avg_square = 0;
            for (int i = 0; i < shape_num; i++) {
                square_sum += is.get(i).square();
                length_sum += is.get(i).length();
            }
            avg_square = square_sum / shape_num;
            System.out.println("Sum of all squares: " + square_sum);
            System.out.println("Sum of all lengths: " + length_sum);
            System.out.println("Average square: " + avg_square);
            List < IShape > sh = new LinkedList < IShape > ();
            for (int i = 0; i < shape_num; i++) {
                int n;
                Point2D[] p;
                Point2D point;
                System.out.print("Input shape: ");
                String shape = in .next();
                switch (shape) {
                    case "Segment":
                        System.out.print("Enter the start coordinates: ");
                        Point2D s = new Point2D(new double[] {
                                in .nextDouble(), in .nextDouble()
                        });
                        System.out.print("Enter the finish coordinates: ");
                        Point2D f = new Point2D(new double[] {
                                in .nextDouble(), in .nextDouble()
                        });
                        sh.add(new Segment(s, f));
                        break;
                    case "Polyline":
                        System.out.print("Enter the number of points: ");
                        n = in .nextInt();
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        sh.add(new Polyline(p));
                        break;
                    case "Circle":
                        System.out.print("Enter the coordinates: ");
                        Point2D p1 = new Point2D(new double[] {
                                in .nextDouble(), in .nextDouble()
                        });
                        System.out.print("Enter the radius: ");
                        double r = in .nextDouble();
                        sh.add(new Circle(p1, r));
                        break;
                    case "NGon":
                        System.out.print("Enter the number of points: ");
                        n = in .nextInt();
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        sh.add(new NGon(p));
                        break;
                    case "TGon":
                        n = 3;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        sh.add(new TGon(p));
                        break;
                    case "QGon":
                        n = 4;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        sh.add(new QGon(p));
                        break;
                    case "Rectangle":
                        n = 3 + 1;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        sh.add(new Rectangle(p));
                        break;
                    case "Trapeze":
                        n = 2 + 2;
                        p = new Point2D[n];
                        System.out.print("Enter the coordinates: ");
                        for (int k = 0; k < n; k++) {
                            p[k] = new Point2D(new double[] {
                                    in .nextDouble(), in .nextDouble()
                            });
                        }
                        sh.add(new Trapeze(p));
                        break;

                }
            }
            for (int i = 0; i < shape_num; i++) {
                if (sh.get(i).cross(is.get(i))) {
                    System.out.println("Intersect");
                } else {
                    System.out.println("Don't intersect");
                }
            }
            List < IShape > shp = new LinkedList < IShape > ();
            for (int i = 0; i < shape_num; i++) {
                System.out.print("Enter the type of movement of the shape: ");
                String move;
                move = in .next();
                switch (move) {
                    case "Shift":
                        System.out.print("Enter the shift vector coordinates: ");
                        shp.add(sh.get(i).shift(new Point2D(new double[] {
                                in .nextDouble(), in .nextDouble()
                        })));
                        break;
                    case "Rotate":
                        System.out.print("Enter the rotation angle of the shape: ");
                        shp.add(sh.get(i).rot( in .nextDouble()));
                        break;
                    case "Symmetry":
                        System.out.print("Enter the axis around which the symmetry method will be performed: ");
                        shp.add(sh.get(i).symAxis( in .nextInt()));
                        break;
                }
            }
            for (int i = 0; i < shape_num; i++) {
                if (shp.get(i).cross(is.get(i))) {
                    System.out.print("Intersect\n");
                } else {
                    System.out.print("Don't intersect\n");
                }
            }
            List < IFigure > ifig = new LinkedList < IFigure > ();
            int figure_num;
            System.out.print("Enter the number of figures: ");
            figure_num = in .nextInt();
            for (int k = 0; k < figure_num; k++) {
                System.out.print("Enter the shape: ");
                String figure = in .next();
                int numb;
                Point3D[] pp;
                Point3D p0;
                Point3D[] p1;
                Point3D[] p2;
                switch (figure) {
                    case "Pyramid":
                        System.out.print("Enter the coordinates of the vertex: ");
                        p0 = new Point3D(new double[] {
                                in .nextDouble(), in .nextDouble(), in .nextDouble()
                        });
                        System.out.print("Enter the number of points at the base: ");
                        numb = in .nextInt();
                        pp = new Point3D[numb];
                        System.out.print("Enter the coordinates of the base: ");
                        for (int j = 0; j < numb; j++) {
                            pp[j] = new Point3D(new double[] {
                                    in .nextDouble(), in .nextDouble(), in .nextDouble()
                            });
                        }
                        ifig.add(new Pyramid(p0, pp));
                        break;
                    case "Ball":
                        System.out.print("Enter the coordinates of the ball center: ");
                        p0 = new Point3D(new double[] {
                                in .nextDouble(), in .nextDouble(), in .nextDouble()
                        });
                        System.out.print("Enter the radius: ");
                        double rad = in .nextDouble();
                        ifig.add(new Ball(p0, rad));
                        break;
                    case "Prism":
                        System.out.print("Enter the number of points at the base: ");
                        numb = in .nextInt();
                        p1 = new Point3D[numb];
                        p2 = new Point3D[numb];
                        System.out.print("Enter the coordinates of the bottom base: ");
                        for (int j = 0; j < numb; j++) {
                            p1[j] = new Point3D(new double[] {
                                    in .nextDouble(), in .nextDouble(), in .nextDouble()
                            });
                        }
                        System.out.print("Enter the coordinates of the top base: ");
                        for (int j = 0; j < numb; j++) {
                            p2[j] = new Point3D(new double[] {
                                    in .nextDouble(), in .nextDouble(), in .nextDouble()
                            });
                        }
                        ifig.add(new Prism(p1, p2));
                        break;
                    case "Parallelepiped":
                        numb = 8;
                        pp = new Point3D[numb];
                        System.out.print("Enter the coordinates of the bottom base: ");
                        for (int j = 0; j < numb / 2; j++) {
                            pp[j] = new Point3D(new double[] {
                                    in .nextDouble(), in .nextDouble(), in .nextDouble()
                            });
                        }
                        System.out.print("Enter the coordinates of the top base: ");
                        for (int j = 4; j < numb; j++) {
                            pp[j] = new Point3D(new double[] {
                                    in .nextDouble(), in .nextDouble(), in .nextDouble()
                            });
                        }
                        ifig.add(new Parallelepiped(pp));
                        break;
                }
            }
            double vol_sum = 0;
            double fig_square_sum = 0;
            double avg_vol = 0;
            for (int j = 0; j < figure_num; j++) {
                fig_square_sum += ifig.get(j).square();
                vol_sum += ifig.get(j).volume();
            }
            avg_vol = vol_sum / figure_num;
            System.out.println("Sum of all volume: " + vol_sum);
            System.out.println("Sum of all squares: " + fig_square_sum);
            System.out.println("Average volume: " + avg_vol);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}