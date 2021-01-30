package com.skilldisstillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
	}
	public void fight() {
		System.out.println(this.getModel() + " is Fighting. Brrrrrrrrrrrt!");
	}
}
