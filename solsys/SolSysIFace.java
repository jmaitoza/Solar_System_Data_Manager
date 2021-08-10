package solsys;

public interface SolSysIFace 
{
    public double NEW_HORIZONS_SPEED = 58500; // in kilometers per hour
    public double c = 1079252848.8; // speed of light in km/h
    public double LY_TO_KM = 9.461E+12; // 1 LY = 9.461E12 km 
    public double AU_TO_KM = 1.496e+8; // 1 Astronomical unit = 1.496e+8km

    public double calcTravelTime();
}
