package main;

import formulae.Direction;
import formulae.Force;
import units.Newton;

import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

		ArrayList<Newton> list = new ArrayList<>();

		Newton force1 = new Newton(50, Direction.RIGHT), force2 = new Newton(60, Direction.LEFT), force3 = new Newton(50, Direction.DOWN);

		list.add(force1);
		list.add(force2);
		list.add(force3);
		System.out.println(Force.netForce(new ArrayList<Newton>(list)));
	}
}
