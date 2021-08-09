package solsys;

public class Planet extends SolarSystem
{
    private String name;
    private char planetType; // either (t) terrestrial or (g) gas giant
    private double distanceFromStar;
    private int numberOfMoons;
    private boolean hasWater;
    private boolean hasLife;
    private boolean breathableAtmosphere; 

    public Planet(String sysName, int numberOfPlanets, String name, char planetType, double distanceFromStar,
            int numberOfMoons, boolean hasWater, boolean hasLife, boolean breathableAtmosphere) {
        super(sysName, numberOfPlanets);
        this.name = name;
        this.planetType = planetType;
        this.distanceFromStar = distanceFromStar;
        this.numberOfMoons = numberOfMoons;
        this.hasWater = hasWater;
        this.hasLife = hasLife;
        this.breathableAtmosphere = breathableAtmosphere;
    }

    public boolean canSupportLife(boolean hasWater, boolean breathableAtmosphere)
    {
        if ((hasWater && breathableAtmosphere) == true)
            return true;
        else
            return false;
    }

    // if planet is terrestrial and has water, can be terraformed for humans survival
    public boolean isTerraformable(char planetType, boolean hasWater)
    {
        if ((planetType == ('t'|'T')) && (hasWater == true))
            return true;

        else
            return false;
    }

    public int getNumOfNeighborPlanets()
    {
        return (getNumOfPlanets() - 1);
    }

    // return home star
    public String getStar()
    {
        return getSystemName();
    }

    public String toString()
    {
        return
        (
            "\nName: " + this.name +
            "\nPlanet Type: " + this.planetType + 
            "\nDistance from " + getStar() +": " + this.distanceFromStar + "ls" +
            "\nNumber of Moons: " + this.numberOfMoons + 
            "\nContains Water: " + this.hasLife +
            "\nHas a Breathable Atmosphere: " + this.breathableAtmosphere + 
            "\nCan Support Life: " + canSupportLife(hasWater, breathableAtmosphere) +
            "\nHas Life: " + this.hasLife + 
            "\nCan be Terraformed: " + isTerraformable(planetType, breathableAtmosphere) +
            "\nAmount of Neighboring Planets: " + getNumOfNeighborPlanets()
        );
    }

    /*public static void main(String[] args) 
    {
        Planet planet1 = new Planet("Sol", 8, "Mercury", 't', 1000, 3, false, false, false);
        System.out.println(planet1.toString());
    }*/
}
