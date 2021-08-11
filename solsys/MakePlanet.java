package solsys;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MakePlanet extends Frame implements ActionListener
{
    private TextField sysNumField, nameField, planetTypeField, distField, numMoonsField, hasWaterField, hasLifeField, atmosphereField;
    private Button enter, done;
    private DataOutputStream output;

    public MakePlanet()
    {
        super("Planet File - Write");

        try {
            output = new DataOutputStream(new FileOutputStream("planet.dat"));
        } catch (IOException e) {
            System.err.println("File not opened correctly\n" + e.toString());
            System.exit(1); 
        }

        setSize(400,400); //sets the frame size
        setLayout(new GridLayout(9,2));

        add(new Label("System Number"));
        sysNumField = new TextField();
        add(sysNumField);

        add(new Label("Planet Name"));
        nameField = new TextField();
        add(nameField);

        add( new Label("Planet Type"));
        planetTypeField = new TextField();
        add(planetTypeField);

        add(new Label("Distance From Star"));
        distField = new TextField();
        add(distField);

        add(new Label("Number of Moons"));
        numMoonsField = new TextField();
        add(numMoonsField);
        
        add(new Label("Contains Water"));
        hasWaterField = new TextField();
        add(hasWaterField);

        add(new Label("Contains Life"));
        hasLifeField = new TextField();
        add(hasLifeField);

        add(new Label("Has a Breathable Atmosphere"));
        atmosphereField = new TextField();
        add(atmosphereField);

        enter = new Button("Enter");
        enter.addActionListener(this);
        add(enter);

        done = new Button("Done");
        done.addActionListener(this);
        add(done);

        setVisible(true); // makes frame visible
        nameField.requestFocus(); //sets mouse to focus on first box
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == enter)
        {
            addPlanet();
        }

        if(e.getSource() == done)
        {
            try {
                output.close();
            } catch (IOException io) {
                System.err.println("File not closed correctly\n" + io.toString());
                System.exit(1);
            }
            System.exit(0);
        }
    }

    public void addPlanet()
    {
        int sysNum = 0;
        char pTypeTemp;
        double distTemp;
        int numMoonsTemp = 0;
        boolean waterTemp;
        boolean lifeTemp;
        boolean atmosTemp;

        if (!sysNumField.getText().equals(""))
        {
            try
            {
                sysNum = Integer.parseInt(sysNumField.getText());
                
                if (sysNum > 0)
                {
                    output.writeInt(sysNum);
                    output.writeUTF(nameField.getText());

                    try
                    {
                        pTypeTemp = planetTypeField.getText().charAt(0);
                        output.writeChar(pTypeTemp);
                    } catch (IndexOutOfBoundsException ioe)
                    {
                        System.err.println("Planet Type must be entered as one character");
                    }

                    try
                    {
                        distTemp = Double.valueOf(distField.getText());    
                        output.writeDouble(distTemp);
                    } catch (NumberFormatException nfe)
                    {
                        System.err.println("Distance from Star must be entered as a double");
                    }

                    try
                    {
                        numMoonsTemp = Integer.parseInt(numMoonsField.getText());
                        output.writeInt(numMoonsTemp);
                    } catch (NumberFormatException nfe)
                    {
                        System.err.println("Number of moons must be entered as an integer");
                    }

                    try
                    {
                        waterTemp = Boolean.parseBoolean(hasWaterField.getText());
                        output.writeBoolean(waterTemp);
                    } catch (IllegalArgumentException iae)
                    {
                        System.err.println("Must be entered as true or false");
                    }
                    
                    try
                    {
                        lifeTemp = Boolean.parseBoolean(hasLifeField.getText());
                        output.writeBoolean(lifeTemp);
                    } catch (IllegalArgumentException iae)
                    {
                        System.err.println("Must be entered as true or false");
                    }

                    try
                    {
                        atmosTemp = Boolean.parseBoolean(atmosphereField.getText());
                        output.writeBoolean(atmosTemp);
                    } catch (IllegalArgumentException iae)
                    {
                        System.err.println("Must be entered as true or false");
                    }
                }

                sysNumField.setText("");
                nameField.setText("");
                planetTypeField.setText("");
                distField.setText("");
                numMoonsField.setText("");
                hasWaterField.setText("");
                hasLifeField.setText("");
                atmosphereField.setText("");

            } catch(NumberFormatException nfe)
            {
                System.err.println("You must enter an integer number");
            } catch (IOException io)
            {
                System.err.println("Error during write file operation\n" + io.toString());
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) 
    {
        new MakePlanet();    
    }
}
