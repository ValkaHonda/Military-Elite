package classes;

import java.util.ArrayList;
import java.util.List;

import interfaces.MissionListable;

public class Commando extends SpecialisedSoldier implements MissionListable{
	private List<Mission> missions;
	
	public Commando(String corps, double salary, int ID, String firstName
			, String lastName, List<Mission> missions) {
		super(corps,salary,ID,firstName,lastName);
		this.missions = new ArrayList<>();
		this.missions = missions;
	}

	public List<Mission> getMissions(){
		return this.missions;
	}
	
	@Override
	public String listMissions() {
		return this.castCollectionToString(this.getMissions());
	}
	
	@Override
	public String toString() {
		return String.format("%s \nMissions: %s",super.toString()
				, this.listMissions());
	}
}
