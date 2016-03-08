package main;

import formulae.Direction;
import formulae.*;
import ui.Start;
import units.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Main {

	public static void main(String[] args) {

		Start frame = new Start();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		ArrayList<Newton> list = new ArrayList<>();

		Newton force1 = new Newton(-50, Direction.RIGHT), force2 = new Newton(60, Direction.LEFT), force3 = new Newton(50, Direction.DOWN), force4 = new Newton(100, Direction.UP);

		list.add(force1);
		list.add(force2);
		list.add(force3);
		list.add(force4);


		List<Newton> list2 = Force.getDirectionalAngularForceDegrees(new Newton(50.0), 135);

		list2.add(new Newton(50, Direction.RIGHT));
		System.out.println(Force.netForce(list2));


	}
}
