package main;

import formulae.*;
import units.*;
import ui.Open;

import java.util.ArrayList;
import java.util.Arrays;

class Main {

	public static void main(String[] args) {

		Open frame = new Open();

		frame.setVisible(true);

		ArrayList<Newton> list = new ArrayList<>();

		Newton force1 = new Newton(-50, Direction.RIGHT), force2 = new Newton(60, Direction.LEFT), force3 = new Newton(50, Direction.DOWN), force4 = new Newton(100, Direction.UP);

		list.add(force1);
		list.add(force2);
		list.add(force3);
		list.add(force4);


		Newton[] list2 = Force.forceComponents(new Newton(50.0), new Degree(5.0));
		System.out.println(Arrays.toString(list2));
		ArrayList<Newton> list3 = new ArrayList<>();
		list3.addAll(Arrays.asList(list2));
		list3.add(new Newton(50, Direction.RIGHT));
		System.out.println(Arrays.toString(Force.netForce(list3)));

		//fuck everything

	}
}
