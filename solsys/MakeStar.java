package solsys;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MakeStar extends Frame implements ActionListener
{
     private TextField nameField, distField, spectralField, colorField, sysNameField, numOfPlanetsField;
     private Button enter, done;
     private DataOutputStream output;

     public MakeStar()
     {
        super("Star File - Write");

        try {
             output = new DataOutputStream(new FileOutputStream("star.dat"));
        } catch (IOException e) {
             System.err.println("File not opened correctly\n" + e.toString());
             System.exit(1);
        }

        setSize(400,400); // sets the frame size
        setLayout(new GridLayout(7,2));

        add(new Label("Name"));
        nameField = new TextField();
        add(nameField);

        add(new Label("Distance From Sol"));
        distField = new TextField();
        add(distField);

        add(new Label("Spectral Class"));
        spectralField = new TextField();
        add(spectralField);

        add(new Label("Color"));
        colorField = new TextField();
        add(colorField);

        add(new Label("System Name"));
        sysNameField = new TextField();
        add(sysNameField);

        add(new Label("Number of Planets"));
        numOfPlanetsField = new TextField();
        add(numOfPlanetsField);

        enter = new Button("Enter");
        enter.addActionListener(this);
        add(enter);

        done = new Button("Done");
        done.addActionListener(this);
        add(done);

        setVisible(true); //sets the visibility of the frame
        nameField.requestFocus();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == enter)
        {
            addStar();
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

    public void addStar()
    {
        // define temp variables
        double distTemp;
        char specTemp;
        int numPlanetsTemp;

        if(!distField.getText().equals("")) //checks if distance from sol is empty or not
        {
            try 
            {
                distTemp = Double.parseDouble(distField.getText());

                if (distTemp > 0)
                {
                    output.writeDouble(distTemp);
                    output.writeUTF(nameField.getText());

                    try
                    {
                        specTemp = spectralField.getText().charAt(0);
                        output.writeChar(specTemp);
                    } catch(IndexOutOfBoundsException ibe)
                    {
                        System.err.println("Spectral Class must be entered as one character");
                    }

                    try
                    {
                        numPlanetsTemp = Integer.parseInt(numOfPlanetsField.getText());
                        output.writeInt(numPlanetsTemp);
                    } catch(NumberFormatException nfe)
                    {
                        System.err.println("Must be entered as an integer number");
                    }
                }

                nameField.setText("");
                distField.setText("");
                spectralField.setText("");
                colorField.setText("");
                sysNameField.setText("");
                numOfPlanetsField.setText("");

            } catch(IOException io)
            {
                System.err.println("Error during write file operation\n" + io.toString());
                System.exit(1);
            }
        }
  
    }

    public static void main(String[] args) 
    {
        new MakeStar();
    }
}

