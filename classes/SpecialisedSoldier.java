package classes;

import interfaces.CorpsIndentificatiteable;

public abstract class SpecialisedSoldier extends Private implements CorpsIndentificatiteable{
	private String corps;
	
	public SpecialisedSoldier(String corps,double salary, int ID
			, String firstName, String lastName) {
		super(salary,ID,firstName,lastName);
		this.corps = corps;
	}

	@Override
	public String getCorps() {
		return this.corps;
	}
	
	@Override
	public String toString() {
		return String.format("%s Corps: %s",super.toString(),this.getCorps());
	}
}
