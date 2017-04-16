import java.lang.Math; 
public class Planet {
    // declare instance variables
    public double xxPos; // Its current x position
    public double yyPos; // Its current y position
    public double xxVel; // Its current velocity in the x direction
    public double yyVel; // Its current velocity in the y direction
    public double mass; // Its mass
    public String imgFileName; /* The name of an image in the image directory 
                                   that depicts the plant
                                */
    //public Planet[] allPlanets; // each element is in array is stand for a planet
    
    // Planet constructor1
    public Planet (double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    
    // Planet constructor2
    public Planet (Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    
    // Calculate the distance between two planets
    public double calcDistance (Planet that) {
        return Math.sqrt((that.xxPos - this.xxPos)*(that.xxPos - this.xxPos) 
                + (that.yyPos - this.yyPos)*(that.yyPos - this.yyPos));
    }
    
    // Calculate the force exert by other planet
    public double calcForceExertedBy (Planet that) {
        final double G = 6.67E-11;
        return G*that.mass*this.mass/(calcDistance(that)*calcDistance(that));
    }
    
    // Calculate the net force in X direction
    public double calcNetForceExertedByX (Planet[] allPlanets) {
        double Fx = 0.0;
        double sum = 0.0;
        for (int i = 0; i < allPlanets.length; i++) {
            if (allPlanets[i].xxPos == this.xxPos) {
                Fx = 0.0;
            } else {
                Fx = this.calcForceExertedBy(allPlanets[i])
                    *(allPlanets[i].xxPos - this.xxPos)
                    /this.calcDistance(allPlanets[i]);
            }
            sum += Fx;
        }
        return sum;
    }
    
    // Calculate the net force in Y direction
    public double calcNetForceExertedByY (Planet[] allPlanets) {
        double Fy = 0.0;
        double sum = 0.0;
        for (int i = 0; i < allPlanets.length; i++) {
            if (allPlanets[i].yyPos == this.yyPos) {
                Fy = 0.0;
            } else {
                Fy = this.calcForceExertedBy(allPlanets[i])
                    *(allPlanets[i].yyPos - this.yyPos)
                    /this.calcDistance(allPlanets[i]);
            }
            sum += Fy;
        }
        return sum;
    }
    
    
}
