package transport;

public class Employee {
	private String _fname;
	private String _lname;
	private String _department;
	private int _phone;
	
	public Employee(String fname, String lname, String department, int phone){
		_fname = fname;
		_lname = lname;
		_department = department;
		_phone = phone;
	}
	
	public void setFname(String firstname){
		_fname = firstname;
	}
	
	public void setLname(String lastname){
		_lname = lastname;
	}
	
	public void setDepartment(String department){
		_department = department;
	}
	
	public void setPhone(int phone){
		_phone = phone;
	}
	
	@Override
	public String toString() {
		return _lname + ", " + _fname + " " + _phone + " " + _department;
	}
}
