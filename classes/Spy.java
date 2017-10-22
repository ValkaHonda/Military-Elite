package classes;

import interfaces.CodeNumberIdentifiable;

public class Spy extends Soldier implements CodeNumberIdentifiable{ 
	private int codeNumber;
	
	public Spy(int codeNumber, int ID, String firstName, String lastName) {
		super(ID,firstName,lastName);
		this.codeNumber = codeNumber;
	}

	@Override
	public int getCodeNumber() {
		return this.codeNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d",super.toString(),this.getCodeNumber());
	}
}
