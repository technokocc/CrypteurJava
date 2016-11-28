package test.vo;

import crypto.vo.Decrypteur;

public final class Recepteur {

	public static void main(String[] args) {
		new Decrypteur("poemecrypt.txt", "poemecrypt.txt.crypteur", "poemedecrypt.txt").decrypte();
		new Decrypteur("timecrypt.mp4",  "timecrypt.mp4.crypteur",  "timedecrypt.mp4") .decrypte();
	}

}

/*

1/2 - Chargement de poemecrypt.txt.crypteur... ok.
2/2 - Chargement, décryptage et sauvegarde dans poemedecrypt.txt... ok.
1/2 - Chargement de timecrypt.mp4.crypteur... ok.
2/2 - Chargement, décryptage et sauvegarde dans timedecrypt.mp4... ok.

*/
