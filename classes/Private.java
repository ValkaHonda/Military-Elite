package classes;
import interfaces.SalaryReceiveable;

public class Private extends Soldier implements SalaryReceiveable{
	private double salary;
	
	public Private(double salary, int ID, String firstName, String lastName) {
		super(ID,firstName,lastName);
		this.salary = salary;
	}

	@Override
	public double getSalary() {
		return this.salary;
	}
	
	@Override
	public String toString() {
		return String.format("%s Salary: %.2f", super.toString() ,this.getSalary());
	}
	

}
