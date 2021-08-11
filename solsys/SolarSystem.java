package solsys;

import java.io.IOException;
import java.io.RandomAccessFile;

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

    // Write method that takes input data and writes to a file
    public void write(RandomAccessFile f) throws IOException
    {
        f.writeInt(sysNum);
        
        StringBuffer buff;

        if(sysName != null)
            buff = new StringBuffer(sysName);

        else
            buff = new StringBuffer(15);

        buff.setLength(15);
        f.writeChars(buff.toString()); // write string as sequence of chars

        f.writeInt(numberOfPlanets); //write int 
    }

    // read method that reads data from a file
    public void read(RandomAccessFile f) throws IOException
    {
        sysNum = f.readInt();
        
        char[] arr = new char[15];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = f.readChar(); // reads the chars from the file
        }

        sysName = new String(arr);

        numberOfPlanets = f.readInt();
    }


    // mutators
    public void getSysNum(int sysNum)
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

    /*public static int size()
    {
        return 
    }*/
}