package com.skilldisstillery.jets;

import java.util.Scanner;

public class JetApp {
	private AirField airField = new AirField();
	private Scanner kb = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		JetApp user = new JetApp();
		
		user.launch();
	}
	
	
	private void launch() {
		airField.readNamesFromFile("names.txt");
		displayUserMenu();
	}
	protected void displayUserMenu() {
		System.out.println("Welcome to the Jet App");
		System.out.println("----------------------");
		System.out.println("1) List the fleet of jets");
		System.out.println("2) Fly all Jets");
		System.out.println("3) View the fastest jet ");
		System.out.println("4) View the jet with the longest range ");
		System.out.println("5) Load all the cargo jets ");
		System.out.println("6) Make all the fighter jets fight ");
		System.out.println("7) Add a jet to the fleet");
		System.out.println("8) Remove a jet from the fleet");
		System.out.println("9) Quit");
		menuSwitch();
	}
	private void menuSwitch() {
		int choose = kb.nextInt();
		
		switch(choose) {
		case 1:
			airField.displayAllJets();
			displayUserMenu();
			break;
		case 2:
				airField.flyAllJets();
				displayUserMenu();
				break;
		case 3:
				airField.fastestJet();
				displayUserMenu();
				break;
		case 4:
				airField.longestRange();
				displayUserMenu();
				break;
		case 5:
				airField.loadCargo();
				displayUserMenu();
				break;
		case 6:
				airField.dogFight();
				displayUserMenu();
				break;
		}
		
	}
	public	JetApp(){}
}
