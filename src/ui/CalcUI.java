package ui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Collin Tod
 * @version 0.3
 * @since 5-10-2016
 */
abstract class CalcUI extends JFrame implements ActionListener {
    private JTabbedPane tabbed = new JTabbedPane();

    CalcUI(String title) {

        JButton close = new JButton("Go back to selection");
        setTitle(title);
        setSize(400, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        setLayout(new CardLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(tabbed);
        add(close);
        setVisible(true);
    }

    /**
     * This method creates the tabs and title of said tabs on
     *
     * @param titles array of strings that will be applied to the tabs of the frame
     * @param panels Panes that will become the tabs
     */
    void makeTabs(String[] titles, JPanel[] panels) {
        if (titles.length != panels.length) {
            throw new IllegalArgumentException("Titles and Panels mus tbe the same length");
        }
        for (int i = 0; i < titles.length; i++) {
            tabbed.add(titles[i], panels[i]);
        }
    }

    void addMult(Component... comp) {
        for (Component c : comp) {
            add(c);
        }
    }

    void addMult(Container cont, Component... comp) {
        for (Component c : comp) {
            cont.add(c);
        }
    }

    double parse(String s){
        return Double.parseDouble(s);
    }
    /**
     * Checks to see if any textFields re empty in a group
     *
     * @param field Array of fields that are to be tested for being empty or not
     * @return true if any of field are empty, false if all are filled
     */
    boolean areEmpty(JTextComponent... field) {
        for (JTextComponent f : field) {
            if (f.getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    abstract void build();
}
