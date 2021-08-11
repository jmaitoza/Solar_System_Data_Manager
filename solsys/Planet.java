package solsys;

public class Planet extends SolarSystem implements SolSysIFace
{
    private String name;
    private char planetType; // either (t) terrestrial or (g) gas giant
    private double distanceFromStar; //in astronomical units (au)
    private int numberOfMoons;
    private boolean hasWater;
    private boolean hasLife;
    private boolean breathableAtmosphere; 

    public Planet(int sysNum, String sysName, int numberOfPlanets, String name, char planetType, double distanceFromStar,
            int numberOfMoons, boolean hasWater, boolean hasLife, boolean breathableAtmosphere) {
        super(sysNum, sysName, numberOfPlanets);
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

    // takes the au distance from star and calculates how long it would take to travel from star to planet in number of years
    @Override
    public double calcTravelTime()
    {
        double dist = distanceFromStar * AU_TO_KM;
        double time = dist / NEW_HORIZONS_SPEED;
        return (time * 0.000114);
    }

    public String toString()
    {
        return
        (
            "\nName: " + this.name +
            "\nPlanet Type: " + this.planetType + 
            "\nDistance from " + getStar() +": " + this.distanceFromStar + "au" +
            "\nNumber of Moons: " + this.numberOfMoons + 
            "\nContains Water: " + this.hasLife +
            "\nHas a Breathable Atmosphere: " + this.breathableAtmosphere + 
            "\nCan Support Life: " + canSupportLife(hasWater, breathableAtmosphere) +
            "\nHas Life: " + this.hasLife + 
            "\nCan be Terraformed: " + isTerraformable(planetType, breathableAtmosphere) +
            "\nAmount of Neighboring Planets: " + getNumOfNeighborPlanets() +
            "\nIt would take " + calcTravelTime() + " years to travel to from Earth"
        );
    }

    public static void main(String[] args) 
    {
        /*Planet planet1 = new Planet(1,"Sol", 8, "Mercury", 't', 0.387, 3, false, false, false);
        //System.out.println(planet1.toString());
        System.out.println(planet1.calcTravelTime());*/
    }
}
