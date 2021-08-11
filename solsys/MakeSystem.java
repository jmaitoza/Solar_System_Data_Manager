package solsys;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MakeSystem extends Frame implements ActionListener 
{
    private TextField sysNumField, sysNameField, numOfPlanetsField;
    private Button enter, done;
    private DataOutputStream output;

    public MakeSystem()
    {
        super("Solar System -Write");

        try {
            output = new DataOutputStream(new FileOutputStream("solsystem.dat"));
        } catch (IOException e) {
            System.err.println("File not opened correctly\n" + e.toString());
            System.exit(1);
        }

        setSize(400,400); // sets the frame size
        setLayout(new GridLayout(4,2));

        add(new Label("System Number"));
        sysNumField = new TextField();
        add(sysNumField);

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

        setVisible(true); // sets the visibility of the frame
        sysNumField.requestFocus();
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == enter)
        {
            addSystem();
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

    public void addSystem()
    {
        int sysNumber = 0;
        int numPlanetsTemp = 0;

        if (!sysNumField.getText().equals(""))
        {
            try
            {
                sysNumber = Integer.parseInt(sysNumField.getText());

                if (sysNumber > 0)
                {
                    output.writeInt(sysNumber);
                    output.writeUTF(sysNameField.getText());

                    try
                    {
                        numPlanetsTemp = Integer.parseInt(numOfPlanetsField.getText());
                        output.writeInt(numPlanetsTemp);
                    } catch (NumberFormatException nfe)
                    {
                        System.err.println("Number must be entered as an integer");
                    }
                }

                sysNumField.setText("");
                sysNameField.setText("");
                numOfPlanetsField.setText("");
            } catch (NumberFormatException nfe)
            {
                System.err.println("Must enter an integer number");
            } catch (IOException io)
            {
                System.err.println("Error during write file operation\n" + io.toString());
                System.exit(1);
            }
        }
    }
    
    public static void main(String[] args) 
    {
        new MakeSystem();       
    }
}

