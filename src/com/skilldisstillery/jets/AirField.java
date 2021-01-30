package com.skilldisstillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AirField {
	ArrayList<Jet> jetList = new ArrayList<>();

	protected void dogFight() {
		for (int i = 0; i < jetList.size(); i++) {
			if (jetList.get(i) instanceof CombatReady) {
				if (jetList.get(i) instanceof FighterJet) {
					((FighterJet) jetList.get(i)).fight();
				}
			}
		}
	}
	
	protected void loadCargo() {
		for (int i = 0; i < jetList.size(); i++) {
			if (jetList.get(i) instanceof CargoCarrier) {
				if (jetList.get(i) instanceof CargoPlane) {
					((CargoPlane) jetList.get(i)).loadCargo();
				}
			}
		}
	}

	protected void displayAllJets() {
		Iterator<Jet> it = jetList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	protected void flyAllJets() {
		// take all of the jets in jetList and call their fly method

		Iterator<Jet> it = jetList.iterator();
		while (it.hasNext()) {
			for (Jet jet : jetList) {
				jet.fly();
			}
			break;
		}

	}

	protected void longestRange() {
		Iterator<Jet> it = jetList.iterator();
		while (it.hasNext()) {
			double max = 0;
			String name = " ";
			for (Jet jet : jetList) {
				if (jet.getRange() > max) {
					max = jet.getRange();
					name = jet.getModel();
				}
			}
			System.out.println(name + " has the longest range which is " + max + " miles");
			break;
		}
	}

	protected void fastestJet() {
		Iterator<Jet> it = jetList.iterator();
		while (it.hasNext()) {
			double max = 0;
			String name = " ";
			for (Jet jet : jetList) {
				if (jet.getSpeed() > max) {
					max = jet.getSpeed();
					name = jet.getModel();
				}
			}
			System.out.println(name + " is the fastest jet with a speed of " + max + " miles per hour");
			break;
		}
	}

	protected void readNamesFromFile(String fileName) {
		BufferedReader reader = null;
		// we want to put the names into a list which is
		// is of type collection. "is collection" because
		// when we call we will have the option to asaign it to
		// any kind of list after

		try {
			reader = new BufferedReader(new FileReader("Jets.txt")); // here we are adding the file we want to read
			String line;
			while ((line = reader.readLine()) != null) {
				// split data
				String[] splitLine = line.split(",");
				// use data to construct the jet
				if (splitLine[4].equals("Fighter")) {
					FighterJet fj = new FighterJet(splitLine[0], Integer.parseInt(splitLine[1]),
							Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), splitLine[4]);
					jetList.add(fj);
				} else if (splitLine[4].equals("Cargo")) {
					CargoPlane cg = new CargoPlane(splitLine[0], Integer.parseInt(splitLine[1]),
							Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), splitLine[4]);
					jetList.add(cg);
				} else if (splitLine[4].equals("Passenger")) {
					PassengerJet pj = new PassengerJet(splitLine[0], Integer.parseInt(splitLine[1]),
							Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), splitLine[4]);
					jetList.add(pj);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public AirField() {
		super();
	}

}
