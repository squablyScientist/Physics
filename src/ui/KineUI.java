package ui;

import formulae.Kinematics;
import units.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 5-10-2016
 */
class KineUI extends CalcUI {
    private JPanel oneD = new JPanel(), twoD = new JPanel();
    private JButton close = new JButton("Close"), solv = new JButton("Solve");
    private JTextField accel = new JTextField(), finVel = new JTextField(),
            disp = new JTextField(), initVel = new JTextField(), time = new JTextField();

    KineUI() {
        super("Kinematics");
        String[] strs = new String[]{"One Dimension", "Two Dimension"};
        JPanel[] panes = new JPanel[]{oneD, twoD};
        makeTabs(strs, panes);
        build();
    }

    /**
     * Essentially this just builds the window, didn't want to have everything in the constructor
     */
    void build() {
        JPanel fields = new JPanel(), ans = new JPanel();
        fields.setLayout(new GridLayout(5, 2));


        //build the label/fields pane
        addMult(fields, new JLabel("Acceleration(m/s^2)"), accel, new JLabel("Final Velocity(m/s)"),
                finVel, new JLabel("Displacement(m)"), disp, new JLabel("Initial Velocity(m/s)"), initVel,
                new JLabel("Time(s)"), time);
        ans.add(new JLabel("Result:"));
        close.addActionListener(this);
        solv.addActionListener(this);
        JPanel buttons = new JPanel();
        buttons.add(solv);
        buttons.add(close);
        oneD.add(fields);
        oneD.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(close)) {
            dispose();
        }

        if (e.getSource().equals(solv)) {
            solve();
        }
    }

    /**
     * Checks to see if the text fields are empty and if they aren't then will assign doubles for easy
     * usage
     */

    private void solve() {
        if (!areEmpty(accel)) {
            double accD = Double.parseDouble(accel.getText());
        }

        try {
            //Parses all variables into doubles
            double timeD = Double.parseDouble(time.getText()), dispD = Double.parseDouble(disp.getText()),
                    accD = Double.parseDouble(accel.getText());

            if (!areEmpty(disp, time) && !finVel.hasFocus()) {
                finVel.setText("" + Kinematics.vel(new Meter(dispD), new Second(timeD)).getValue());
            } else if (!areEmpty(accel, time) && !finVel.hasFocus()) {
                finVel.setText("" + Kinematics.vel(new MetersPerSecSquared(accD), new Second(timeD)).getValue());
            }

        } catch (NumberFormatException n) {
            new Error("That is not a pure number, please only use number characters and '.' ");
        }

    }

}
