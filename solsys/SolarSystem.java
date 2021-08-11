package solsys;

public class SolarSystem
{
    private int sysNum;
    private String sysName;
    private int numberOfPlanets;

    // default constructor
    public SolarSystem()
    {
        this.sysNum = 0;
        this.sysName = "";
        this.numberOfPlanets = 0;
    }

    public SolarSystem(int sysNum, String sysName, int numberOfPlanets)
    {
        this.sysNum = sysNum;
        this.sysName = sysName;
        this.numberOfPlanets = numberOfPlanets;
        
    }

    // mutators
    public void setSysNum(int sysNum)
    {
        this.sysNum = sysNum;
    }
    
    public void setSysName(String sysName)
    {
        this.sysName = sysName;
    }

    public void setNumberOfPlanets(int numberOfPlanets)
    {
        this.numberOfPlanets = numberOfPlanets;
    }

    // getters
    public int getSysNum()
    {
        return this.sysNum;
    }

    public String getSystemName()
    {
        return this.sysName;
    }

    public int getNumOfPlanets()
    {
        return this.numberOfPlanets;
    }

}