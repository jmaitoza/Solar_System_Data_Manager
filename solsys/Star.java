package solsys;

public class Star extends SolarSystem implements SolSysIFace
{
    private String name;
    private double distanceFromSol; // measured in LY's (light years)
    private char spectralClass; // this is used to classify different star types (O,B,A,F,G,K,M) from hottest to coolest
    private String color;

    public Star(String name, double distanceFromSol, char spectralClass, String color, String sysName, int numberOfPlanets)
    {
        super(sysName, numberOfPlanets);
        this.name = name;
        this.distanceFromSol = distanceFromSol;
        this.spectralClass = spectralClass;
        this.color = color;
    }

    public String toString()
    {
        return 
        (
            "\nName: " + this.name + 
            "\nDistance from Sol: " + this.distanceFromSol + "LY's" +
            "\nSpectral Class: " + this.spectralClass +
            "\nColor: " + this.color +
            "\nPart of " + getSystemName() + 
            "\nPlanets in Orbit around " + this.name + " : " + getNumOfPlanets() 
        );
    }

    // calculates how long it would take in years to travel to star in fastest known human rocket (2021) from earth
    @Override
    public double calcTravelTime() 
    { 
        double dist = distanceFromSol * LY_TO_KM;
        double time = dist / NEW_HORIZONS_SPEED;
        return time * 0.000114; //convert hours to years
    }

    /*public static void main(String[] args) 
    {
        Star alpha = new Star("Alpha Centauri", 4.37, 'k', "blue", "Alpha Centauri", 3);
        System.out.println("It would take " + alpha.calcTravelTime() + " years to get to");    
    }*/
}
