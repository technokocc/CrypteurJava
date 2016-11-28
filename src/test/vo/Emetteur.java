package test.vo;

import crypto.vo.Encrypteur;

public final class Emetteur {

	public static void main(String[] args) {
		new Encrypteur("poeme.txt", "poemecrypt.txt").encrypte();
		new Encrypteur("time.mp4",  "timecrypt.mp4") .encrypte();
	}

}

/*
 
1/3 - Chargement de poeme.txt... ok.
2/3 - Encryptage et sauvegarde dans poemecrypt.txt... ok.
3/3 - Sauvegarde du crypteur dans poemecrypt.txt.crypteur... ok.
1/3 - Chargement de time.mp4... ok.
2/3 - Encryptage et sauvegarde dans timecrypt.mp4... ok.
3/3 - Sauvegarde du crypteur dans timecrypt.mp4.crypteur... ok.
 
 */
