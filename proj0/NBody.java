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

//    public static void main(String[] args) {
//        readBodies("./data/planets.txt");
//    }
}