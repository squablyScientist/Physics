package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 3-10-2016
 */
 class Error extends JFrame implements ActionListener {

    private JLabel error = new JLabel();


    private Error() {
        //local declaration
        JButton but = new JButton("OK");
        setTitle("Error");
        setSize(300, 100);
        setVisible(true);
        setLayout(new BorderLayout());
        add(error, BorderLayout.CENTER);
        add(but, BorderLayout.SOUTH);
        but.addActionListener(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        this.setVisible(true);
    }

     Error(String mess) {
        this();
        //html to wrap text
        error.setText("<html><div style='text-align: center;'>" + mess + "</html>");
    }

    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
