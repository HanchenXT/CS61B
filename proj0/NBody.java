import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdAudio;
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
                    in.readDouble(),in.readDouble(),"images/"+in.readString());
        }
        return p;
    }
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        
        // Read all data from text file
        // Read arguments from command line
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        // Read all planets data from text file
        Planet[] p = NBody.readPlanets(filename);
        // Read radius from text file
        double R = NBody.readRadius(filename);
        
        // Setup static background and initial position of all planets
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
        
        // Adding Audio
        //StdAudio.play("audio/2001.mid");
        
        // Setup motion for all planets
        for (double time = 0.0; time < T; time += dt) {
            double[] xForces = new double [p.length];
            double[] yForces = new double [p.length];
            for (int i = 0; i < p.length; i++) {
                xForces[i] = p[i].calcNetForceExertedByX(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
            }
            for (int i = 0; i < p.length; i++) {
                p[i].update(dt, xForces[i], yForces[i]);
            }
            // Draw the background
            StdDraw.picture(0, 0, "images/starfield.jpg");
            // Draw all the planets
            for (int i = 0; i < p.length; i++) {
                p[i].draw();
            }
            // Shows the drawing to the screen, and waits 10 milliseconds.
            StdDraw.show(10);
        }
        StdOut.println(p.length);
        StdOut.println(R);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e, %11.4e, %11.4e, %11.4e, %12s\n",
                    p[i].xxPos,p[i].yyPos, p[i].xxVel,p[i].yyVel,p[i].imgFileName);
        }
    }
}
