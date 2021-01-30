package com.skilldisstillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
	}

	public void loadCargo() {
		System.out.println(this.getModel() + " is loading it's cargo");
		System.out.println("Yumm");
	}
}
