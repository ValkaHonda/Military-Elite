package tester;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import classes.Commando;
import classes.Engineer;
import classes.LeutenantGeneral;
import classes.Mission;
import classes.Private;
import classes.Repair;
import classes.Soldier;
import classes.Spy;
import exceptions.InvalidCorps;
import exceptions.InvalidState;

public class Main {
	private static Soldier createPrivate(String[] strArr) {
		return new Private(Double.parseDouble(strArr[4]),Integer.parseInt(strArr[1])
				,strArr[2], strArr[3]);
	}
	
	private static Soldier createSpy(String[] strArr) {
		return new Spy(Integer.parseInt(strArr[4]),Integer.parseInt(strArr[1])
				, strArr[2], strArr[3]);
	}
	
	private static boolean doesContainsSpecificID(Soldier soldier, int ID) {
		if(soldier.getID() == ID) {
			return true;
		} 
		return false;
	}
	
	private static List<Private> createPrivatesList(String[] strArr
			, List<Soldier> soldiers){
		List<Private> privatesList = new ArrayList<>();
		for(int i = 5; i < strArr.length; i++) {
			int idTester = Integer.parseInt(strArr[i]);
			for(Soldier mySoldier:soldiers) {
				if(mySoldier instanceof Private 
						&& doesContainsSpecificID(mySoldier,idTester)) {
					privatesList.add((Private)mySoldier);
				}
			}
		} 
		return privatesList;
	}
	
	private static Soldier createLeutenantGeneral(String[] strArr
			, List<Soldier> soldiers) {
		return new LeutenantGeneral(Double.parseDouble(strArr[4])
				, Integer.parseInt(strArr[1]), strArr[2], strArr[3]
						, createPrivatesList(strArr,soldiers));
	}
	
	private static Soldier createCommando(String[] strArr)  throws InvalidCorps{
		if(!strArr[5].equals("Airforces") && !strArr[5].equals("Marines")) {
			throw new InvalidCorps("Invalid corps");
		}
		return new Commando(strArr[5],Double.parseDouble(strArr[4])
				, Integer.parseInt(strArr[1]), strArr[2], strArr[3]
						, createMissions(strArr));
	}
	
	private static Mission createMission(String codeName
			, String state) throws InvalidState{
		if(!"inProgress".equals(state) && !"Finished".equals(state)) {
			throw new InvalidState("Invalid mission state");
		}
		
		return new Mission(codeName, state);
	}
	
	private static List<Mission> createMissions(String[] strArr) {
		List<Mission> missions = new ArrayList<>();
		for(int i = 6; i < strArr.length; i+=2) {
			try {
				missions.add(createMission(strArr[i],strArr[i+1]));
			} catch (InvalidState e) {}
		}
		return missions;
	}
	
	private static Engineer createEngineer(String[] strArr) throws InvalidCorps{
		if(!strArr[5].equals("Airforces") && !strArr[5].equals("Marines")) {
			throw new InvalidCorps("Invalid corps");
		}
		return new Engineer(Double.parseDouble(strArr[4]), Integer.parseInt(strArr[1])
				, strArr[2], strArr[3], strArr[5], createRepairs(strArr));
	}
	
	private static List<Repair> createRepairs(String[] strArr){
		List<Repair> repairs = new ArrayList<>();
		for(int i = 6; i < strArr.length; i+=2) {
			repairs.add(new Repair(strArr[i],Integer.parseInt(strArr[i+1])));
		}
		return repairs;
	}
	
	private static Soldier createSoldier(String inputLine
			, List<Soldier> soldiers) throws InvalidCorps{
		String[] strArr = inputLine.split("[ ]+");
		switch(strArr[0]) {
			case "Private":
				return createPrivate(strArr);
			case "Commando":
				return createCommando(strArr);
			case "LeutenantGeneral":
				return createLeutenantGeneral(strArr,soldiers);
			case "Engineer":
				return createEngineer(strArr);
			case "Spy":
				return createSpy(strArr);	
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Military Elite");
		System.out.println("Enter your input:");
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in))){
			List<Soldier> soldiers = new ArrayList<>();	
			String inputLine = reader.readLine();
			while(!"End".equals(inputLine)) {
				try {
					soldiers.add(createSoldier(inputLine,soldiers));
				} catch(InvalidCorps e) {}
				inputLine = reader.readLine();
			}
			for(Soldier soldier : soldiers) {
				System.out.println(soldier);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}

}
