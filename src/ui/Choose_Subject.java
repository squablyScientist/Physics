package ui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Collin
 * @version 0.1
 * @since 2-4-2016
 */
class Choose_Subject extends JFrame implements TreeSelectionListener, ActionListener {
    //declare tree elements
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Physics");
    private JTree tree = new JTree(root);

    //other declarations
    private JLabel current = new JLabel();
    private JFrame next;

    Choose_Subject() {
        //local Declarations
        DefaultMutableTreeNode kine = new DefaultMutableTreeNode("Kinematics"),
                force = new DefaultMutableTreeNode("Forces"),
                circuits = new DefaultMutableTreeNode("Circuits"),
                oneD = new DefaultMutableTreeNode("One Dimensional"),
                twoD = new DefaultMutableTreeNode("Two Dimensional");
        JPanel pane = new JPanel();
        JLabel title = new JLabel();
        JButton okBut = new JButton("Accept");

        //Set frame properties
        setSize(350, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose your field of physics");
        setLayout(new BorderLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

        //Set the pane properties
        pane.setLayout(new BorderLayout());
        pane.add(title, BorderLayout.NORTH);
        pane.add(current, BorderLayout.CENTER);
        title.setText("Please select your field");

        //Add an actionListener to okBut
        okBut.addActionListener(this);

        //set Tree properties
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);

        //Add Elements
        add(pane, BorderLayout.NORTH);
        add(okBut, BorderLayout.SOUTH);

        //Create and fill the Tree
        growTree(root, kine, force, circuits);
        growTree(kine, oneD, twoD);
        add(tree, BorderLayout.CENTER);
    }

    /**
     * Takes a root and leaves, adds all leaves to the root
     *
     * @param root   Node to add all leaves to
     * @param leaves Variable amount of nodes that will all be added to the root
     */
    private void growTree(DefaultMutableTreeNode root, DefaultMutableTreeNode... leaves) {
        for (DefaultMutableTreeNode leaf : leaves) {
            root.add(leaf);
        }
    }


    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();
        if (!node.isLeaf()) {
            current.setText("Please Select a more specific field");
        } else {
            current.setText(node.toString());
        }
    }

    @Override
    /**
     * Listens for an action from a button, when action is heard depending on the currently selected tree node
     * method will open a new window with the calculations for that node
     */
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (!node.isLeaf()) {
            next = new Error("This is not a subject, please choose a subject further down the tree.");
        }

        switch (node.toString()) {
            case "One Dimensional":
            case "Two Dimensional":
               new KineUI();
                break;
        }
    }
}
