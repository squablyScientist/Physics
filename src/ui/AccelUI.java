package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Collin Tod
 * @version 0.1
 *
 */
public class AccelUI extends CalcUI{

	private JTextField dVel = new JTextField(), time = new JTextField();
	private JLabel accel = new JLabel();
	public AccelUI(){
		super("Acceleration", false);
		build();
	}


	@Override
	void build() {
		addMult(pane, fields, buttons);
		fields.setLayout(new GridLayout(3,2));
		addMult(fields, new JLabel("Change in Velocity(m/s)"),
				dVel, new JLabel("Time Elapsed(s)"), time, new JLabel("Acceleration(m/s^2)"), accel);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		super.actionPerformed(actionEvent);
	}

	@Override
	void solve() {
		if (areNumeric(dVel.getText(), time.getText())) {
			accel.setText("" + parse(dVel.getText()) / parse(time.getText()) + "m/s^2");
		}
	}
}
