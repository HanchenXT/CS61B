import edu.princeton.cs.algs4.StdDraw;
public class NBody {
    
    //Read the universe radius from text file
    public static double readRadius (String path) {
        In in = new In(path);
        // read the first line
        in.readInt();
        // read and return the second line
        return in.readDouble();
    }
    
    //Read all the planets from text file
    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        // read total number of planets
        int numPlanets = in.readInt();
        // read and skip the second line
        in.readDouble();
        // create a object array contains all planets data
        Planet[] p = new Planet[numPlanets];
        // readDouble() read the double type data one by one
        for (int i = 0; i < numPlanets; i++) {
            p[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), 
                    in.readDouble(),in.readDouble(),in.readString());
        }
        return p;
    }
    public static void main(String[] args) {
        // read arguments from command line
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        // read all planets data from text file
        Planet[] p = NBody.readPlanets(filename);
        // read radius from text file
        double R = NBody.readRadius(filename);
        // Setup universe scale to match the given radius
        StdDraw.setScale(-R, R);
        // Clears the drawing window.
        StdDraw.clear();
        // Draw the background
        StdDraw.picture(0, 0, "images/starfield.jpg");
        // Draw all the planets
        for (int i = 0; i < p.length; i++) {
            p[i].draw();
        }
    }
}
