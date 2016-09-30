package ui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Collin Tod
 * @version 0.3
 * @since 5-10-2016
 */
abstract class CalcUI extends JFrame implements ActionListener {
    private JTabbedPane tabbed = new JTabbedPane();

    //Common fields and panes
	JButton solve = new JButton("Solve"), close = new JButton("Close");
	JPanel buttons = new JPanel(), labels = new JPanel(), fields = new JPanel(), pane = new JPanel();

    CalcUI(String title, boolean tab) {

		addMultListeners(close, solve);
        setTitle(title);
        setSize(400, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		if(tab) {
			setLayout(new CardLayout());
			add(tabbed);
		}

		//Sets up a borderLayout window in the case that it is not tabbed
		else{
			add(pane);
		}

		addMult(buttons, solve, close);
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

    void addMultListeners(JButton... b){
		for(JButton B : b){
			B.addActionListener(this);
		}
	}

	//TODO
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



	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getSource().equals(close)){
			dispose();
		}
		else if(actionEvent.getSource().equals(solve)){
			solve();
		}
	}

	/**
	 *  Tests to see if a String is numeric or not
	 * @param str String to be tested
	 * @return Whether or str is numeric
	 */
	boolean isNumeric(String str)
	{
		try
		{
			double d = Double.parseDouble(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}

	boolean areNumeric(String... strs){
		for(String s : strs){
			if(!isNumeric(s)){
				return false;
			}
		}
		return true;
	}

	//Will be implemented as the method that sets up everything in the window
	abstract void build();

	//Finds the answer to whatever each window needs to find
	abstract void solve();
}
