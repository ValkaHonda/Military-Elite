package classes;

import java.util.ArrayList;
import java.util.List;

import interfaces.RepairListable;

public class Engineer extends SpecialisedSoldier implements RepairListable {
	private List<Repair> repairs;
	
	public Engineer(double salary, int ID, String firstName, String lastName
			, String corps, List<Repair> repairs) {
		super(corps,salary,ID,firstName,lastName);
		this.repairs = new ArrayList<>();
		this.repairs = repairs;
	}
	
	public List<Repair> getRepairs(){
		return this.repairs;
	}
	
	@Override
	public String listRepair() {
		return this.castCollectionToString(this.getRepairs());
	}
	
	@Override
	public String toString() {
		return String.format("%s \nRepairs: %s",super.toString()
				, this.listRepair());
	}
}
