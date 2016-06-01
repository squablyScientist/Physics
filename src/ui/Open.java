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
	private Choose_Subject choose;

	public Open() {
		//Set properties of the frame
		setSize(300, 100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Physics Program");
		setLayout(new BorderLayout());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

		//Add the components to the frame
		JLabel wel = new JLabel("Welcome to Physics!");
		getContentPane().add(wel, BorderLayout.CENTER);
		JButton ent = new JButton("Enter");
		getContentPane().add(ent, BorderLayout.SOUTH);

		//add action listener to enter button
		ent.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		choose = new Choose_Subject();
	}
}
