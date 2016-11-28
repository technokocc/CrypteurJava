package crypto.vo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused") // à supprimer quand le code est complèté
public class Encrypteur {

	private String source, cible;

	public Encrypteur(String source1, String cible1) {
		this.source = source1;
		this.cible = cible1;		
	}

	public void encrypte() {

		Set<Integer> liste = lireFichier();
		Crypteur cr = new Crypteur(liste);
		cr.description();
		saveFichier(cr);
		saveFileCrypted(cr);
	}
	private void saveFileCrypted(Crypteur cr){
		Integer octet = 0 ;
		FileOutputStream vers  ;
		FileInputStream depuis ;
	
		try {
			depuis = new FileInputStream(this.source) ;
			vers = new FileOutputStream(this.cible);
			
			while (octet != -1){
				octet = depuis.read() ;				
				Integer octetCode = cr.code(octet);				
				vers.write(octetCode);
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
	private Set<Integer> lireFichier(){

		Set<Integer> val = new HashSet<Integer>();
		Integer octet = 0 ;
		FileInputStream fichier  ;

		try {
			fichier = new FileInputStream(this.source);

			while (octet != -1){
				octet = fichier.read() ;
				val.add(octet) ;
			}
			fichier.close();
		} catch (FileNotFoundException e) {				
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e = (IOError)e ;
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return val ;
	}

	private void saveFichier(Crypteur cr){

		FileOutputStream fos ;
		ObjectOutputStream oos ;
		
		try{
			fos = new FileOutputStream(this.cible+".crypteur");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(cr);
			oos.close();
			fos.close();			
		}
		catch(IOException e){
			e = (IOError) e ;
			System.out.println(e.getMessage());
		}
	}
}
