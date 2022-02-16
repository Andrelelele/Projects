public class Zauberstab {
	public static void main (String[] args) {
		Staff myStaff = new Staff("Dumbledore's Staff" , " Green " , 5);
		System.out.println(myStaff.getStaffName() + " " + myStaff.getStrength() + " strength points ");
		Staff myStaff1 = new Staff("Gandalf's Staff" , " Blue " , 8);
		System.out.println("Are both staffs equal? ");
		System.out.println(myStaff == myStaff1);
		if (myStaff.equals(myStaff1))
			System.out.println("they are equal");
		else
			System.out.println("they are not equal");
		
		while(5<8) {
			System.out.println(myStaff.getStaffName());
			break;
		}
	}
}
public class Staff {
	private String staffName; 			// Name of the staff
	private String staffColor; 			// Color of the staff
	private int strength; 				// Strength points
	public Staff(String staffName, String staffColor, int strength) {
		this.staffName = staffName;
		this.staffColor = staffColor;
		this.strength = strength;
	}
	public String getStaffName(){
		return staffName;
	}
	public String getStaffColor(){
		return staffColor;
	}
	public int getStrength(){
		return strength;
	}
}
