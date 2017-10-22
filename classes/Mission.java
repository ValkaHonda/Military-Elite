package classes;

import interfaces.MissionCompleateable;
import interfaces.MissionInformable;

public class Mission implements MissionCompleateable, MissionInformable{
	private String codeName;
	private String state;
	
	public Mission(String codeName,String state) {
		this.codeName = codeName;
		this.state = state;
	}
	
	private void setState(String newState) {
		this.state = newState;
	}
	
	public void compliedMission() {
		this.setState("finished");
	}

	@Override
	public String getCodeName() {
		return this.codeName;
	}

	@Override
	public String getState() {
		return this.state;
	}
	
	@Override
	public String toString() {
		return String.format("Code Name: %s Hours State: %s",this.getCodeName()
				, this.getState()); 
	}
}
