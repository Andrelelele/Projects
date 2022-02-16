public class Code {
	int digit;
	Code subcode;

	public Code(int input) {
		if(Integer.toString(input) != "") {
		this.digit = Integer.parseInt(Integer.toString(input).substring(0, 1));
			subcode = new Code(Integer.parseInt(Integer.toString(input).substring(1)));
		}
	}
	
	// Copy
	/*
	public Code(int digit, int input) {
		this(Integer.parseInt(Integer.toString(input).substring(1)));
		this.digit = digit;
	}
	*/
	
	public String toString() {
		while(subcode != null){
			subcode = subcode.subcode;
			return String.valueOf(this.digit);
		}
		return "";
		/*
		String output = "";
		Code code = subcode.subcode;
		while(subcode != null) {
			
		}
		if(this.digit != 0) {
			return String.valueOf(this.digit); 
			}
			else {
				return "";
				}
		*/
	}
}


