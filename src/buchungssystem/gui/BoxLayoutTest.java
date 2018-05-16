package buchungssystem.gui;

import java.awt.*;
import javax.swing.*;

class BoxLayoutTest extends JFrame
{
    public BoxLayoutTest()
    {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        for(int k=0; k<12; k++) {
            getContentPane().add(new JButton(""+k));
        }

        setBounds(100,100,400,300);
    }

    public static void main(String[] args)
    {
        BoxLayoutTest flt = new BoxLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }
}