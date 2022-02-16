public class ZaehlenMitHindernissen {
	public static void main (String[] args) {
		int j = 1;
		while(j<=100){
			if((j%3==0) && (j%4==0)){
				j = j+7;
			}
			if(j%3==0){
				j = j+4;
			}
			if(j%4 == 0){
				j = j+3;
			}
			System.out.println(j);
			j = j+1;
		}
	}
}
