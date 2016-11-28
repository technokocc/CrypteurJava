package crypto.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused") // à supprimer quand le code est complèté
public class Crypteur implements Serializable {
	private static final long serialVersionUID = -5014568058113026043L; // identifiant de sérialisation
	private Map<Integer, Integer> code;
	private Map<Integer, Integer> decode;

	public Crypteur(Set<Integer> s) {		
		code = new HashMap<Integer,Integer>();	
		decode = new HashMap<Integer,Integer>();
		setCode(s) ;
		setDecode();
		
	}

	public Integer code(Integer c) {

		if(this.code.containsKey(c))
			return code.get(c) ;
		System.out.println("Code : Inconnue "+c);
		return c; 
	}
		
	private void setDecode(){	
//		
//		for(Map.Entry<Integer, Integer> entry : code.entrySet()){
//		    decode.put(entry.getValue(), entry.getKey());
//		}
		
		Set<Integer> cles = code.keySet();
		Iterator<Integer> it = cles.iterator();
		
		while(it.hasNext()){
			Integer cle = it.next();
			Integer valeur = code.get(cle);
			decode.put(valeur,cle);
		}
	}

	private void setCode(Set<Integer> s){
		
		ArrayList<Integer> liste = new ArrayList<Integer>(s) ;
		ArrayList<Integer> base = new ArrayList<Integer>(liste) ;			
		Collections.shuffle(liste);			
		int i = 0 ;
		
		while(i < base.size()){
			code.put(base.get(i), liste.get(i++)) ;
		}
				
	}

	public Integer decode(Integer cc) {
		
		if(decode.containsKey(cc))
			return decode.get(cc); 
		System.out.println("Decode : Inconnue "+cc);
		return cc; 
	}
	
	public void description(){
		System.out.println(code.toString());
		System.out.println("\n");
		System.out.println(decode.toString());
	}
}
