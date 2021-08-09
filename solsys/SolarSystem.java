package solsys;

public class SolarSystem
{
    private String sysName;
    private int numberOfPlanets;

    // default constructor
    public SolarSystem()
    {
        this.sysName = "";
        this.numberOfPlanets = 0;
    }

    public SolarSystem(String sysName, int numberOfPlanets)
    {
        this.sysName = sysName;
        this.numberOfPlanets = numberOfPlanets;
        
    }

    // getters
    public String getSystemName()
    {
        return this.sysName;
    }

    public int getNumOfPlanets()
    {
        return this.numberOfPlanets;
    }
}