package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Collin Tod on 3/7/2016.
 */
public class Start extends JFrame implements ActionListener {
	//Make components
	private JLabel wel = new JLabel("Welcome to Tali's Physics!");
	private JButton ent = new JButton("Enter");

	public Start() {
		//Set properties of the frame
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(wel, BorderLayout.CENTER);
		getContentPane().add(ent, BorderLayout.SOUTH);

		//add actionlistener to enter button
		ent.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
