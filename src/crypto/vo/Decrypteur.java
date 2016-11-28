package crypto.vo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

@SuppressWarnings("unused") // à supprimer quand le code est complèté
public class Decrypteur {

	private String source,  cible, sourcecrypteur;

	public Decrypteur(String source1, String sourcecrypteur1, String cible1) {
		this.source = source1;
		this.sourcecrypteur = sourcecrypteur1;
		this.cible = cible1;
	}

	public void decrypte() {		
		Crypteur cr = loadCrypteur() ;
		System.out.println("\n");
		cr.description();
		decrypteAndSave(cr);
	}
	
	private void decrypteAndSave(Crypteur cr){
		Integer octet = 0 ;
		FileOutputStream vers  ;
		FileInputStream depuis ;
	
		try {
			depuis = new FileInputStream(this.source) ;
			vers = new FileOutputStream(this.cible);
			
			while (octet != -1){
				octet = depuis.read() ;				
				Integer octetDecode = cr.decode(octet);				
				vers.write(octetDecode);
			}
			depuis.close();
			vers.close();
		} catch (FileNotFoundException e) {				
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e = (IOError)e ;
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}		

	}

	private Crypteur loadCrypteur(){
		FileInputStream fis ;
		ObjectInputStream ois ;
		Crypteur cr = null;
		
		try
	      {
	         fis = new FileInputStream(this.sourcecrypteur);
	         ois = new ObjectInputStream(fis);
	         cr = (Crypteur) ois.readObject();
	         ois.close();
	         fis.close();
	      }catch(IOException e)
	      {
	    	  e = (IOError) e ;
	         System.out.println(e.getMessage());	         
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println(c.getMessage());	         
	      }
		return cr ;
	}
}
