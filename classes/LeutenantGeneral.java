package classes;

import java.util.ArrayList;
import java.util.List;

import interfaces.PrivateListable;

public class LeutenantGeneral extends Private implements PrivateListable {
	private List<Private> privates;
	
	public LeutenantGeneral(double salary, int ID, String firstName
			, String lastName, List<Private> privates) {
		super(salary,ID,firstName,lastName);
		this.privates = new ArrayList<>();
		this.privates = privates;
	}
	
	public List<Private> getPrivates() {
		return this.privates;
	}
	
	@Override
	public String listPrivates() {
		return this.castCollectionToString(this.getPrivates());
	}
	
	@Override
	public String toString() {
		return String.format("%s\nPrivates:%s", super.toString()
				, this.listPrivates());
	}
}
