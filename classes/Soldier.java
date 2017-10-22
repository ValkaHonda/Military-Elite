package classes;

import java.util.List;

import interfaces.SoldierDateGetable;

public abstract class Soldier implements SoldierDateGetable { 
	private int ID;
	private String firstName;
	private String lastName;
	
	public Soldier(int ID,String firstName,String lastName) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int getID() {
		return this.ID;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}
	
	protected <T>String castCollectionToString(List<T> list) { // update it, after test!!!
		StringBuilder sb = new StringBuilder(System.lineSeparator());
		for(T myObject:list) {
			sb.append("\t");
			sb.append(myObject);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	public String toString() {
		return String.format("Name: %s %s Id: %d", this.getFirstName()
				, this.getLastName(), this.getID());
	}
}
