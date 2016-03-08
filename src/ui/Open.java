package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Collin Tod
 * @version 0.3
 * @since 3-7-2016
 */
public class Open extends JFrame implements ActionListener {
	//Make components
	private JLabel wel = new JLabel("Welcome to Physics!");
	private JButton ent = new JButton("Enter");
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public Open() {
		//Set properties of the frame
		setSize(300, 100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Physics Program");
		setLayout(new BorderLayout());
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

		//Add the components to the frame
		getContentPane().add(wel, BorderLayout.CENTER);
		getContentPane().add(ent, BorderLayout.SOUTH);

		//add actionlistener to enter button
		ent.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
