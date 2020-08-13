public class NBody {
    public static double readRadius(String file) {
        In in = new In(file);
        in.readInt();
        return in.readDouble();
    }

    public static Body[] readBodies(String file) {
        In in = new In(file);
        int n = in.readInt();
        in.readDouble();

        Body[] bodies = new Body[n];
        for (int i=0; i<n; i++) {
            bodies[i] = new Body(in.readDouble() , in.readDouble() , in.readDouble(),
                                 in.readDouble() , in.readDouble() , in.readString());
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double rr = readRadius(filename);
        Body[] bodies = readBodies(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-rr, rr);
        StdDraw.clear();
        StdDraw.picture(0,0, "images/starfield.jpg");

        for(Body b: bodies) {
            b.draw();
        }

        double t = 0;
        while (t < T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for(int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for(int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0,0, "images/starfield.jpg");

            for(Body b: bodies) {
                b.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            t = t + dt;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", rr);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }



    }
}