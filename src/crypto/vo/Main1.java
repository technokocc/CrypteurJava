package crypto.vo;

import java.util.HashSet;
import java.util.Set;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> pal = new HashSet<Integer>() ;
		pal.add(5) ;
		pal.add(8) ;
		pal.add(0) ;
		pal.add(7) ;
		pal.add(2) ;
		pal.add(3) ;
		pal.add(5) ;
		
		Crypteur cr = new Crypteur(pal) ;			
		
		System.out.println("\n");
		cr.description();
		
	}

}
