package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by turgon on 9/30/16.
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
		fields.setLayout(new GridLayout(3,2));
		addMult(fields, new JLabel("Change in Velocity(m/s)"), dVel, new JLabel("Time Elapsed(s)"), time,
				new JLabel("Acceleration(m/s^2)"), accel);
//		addMult(fields, dVel, time);

//		add(fields);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		super.actionPerformed(actionEvent);
	}
}
