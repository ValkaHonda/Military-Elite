package classes;

import interfaces.Repairable;

public class Repair implements Repairable {
	private String partName;
	private int hoursWorked;
	
	public Repair(String partName,int hoursWorked) {
		this.partName = partName;
		this.hoursWorked = hoursWorked;
	}
	
	public Repair() {
		this(null, 0);
	}

	@Override
	public int getHoursWorked() {
		return this.hoursWorked;
	}

	@Override
	public String getPartName() {
		return this.partName;
	}
	
	@Override
	public String toString() {
		return String.format("Part Name: %s Hours Worked: %d",this.getPartName()
				, this.getHoursWorked()); 
	}
}
