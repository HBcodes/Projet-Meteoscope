/**
 * Classe principale de l'application 
 * elle lance 2 threads
 * l'IHM
 * le thread de surveillance des boutons
 * le message apparait dans un des 2 labels lorsque l'on clique sur le bouton afficher le message
 * On quitte le programme lorsque l'on appui sur le bouton quitter
 * @param 
 * @author BAL Hugo
 * @version v03
 */

package MonProgramme;

import java.awt.EventQueue;
import MonIHM.FenetrePrincipale;

public class MonProgrammePrincipal {
	private static ThreadSurveillanceBouton monThreadSurveillanceBouton=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// création de l'IHM 
					FenetrePrincipale maFenetrePrincipale = new FenetrePrincipale();
										
					System.out.println("Debut du main");
					//création du Thread de surveillance des boutons
					monThreadSurveillanceBouton = new ThreadSurveillanceBouton(maFenetrePrincipale);
					//Lancement du Thread de surveillance des boutons
					monThreadSurveillanceBouton.start();
					//Affichage d'un msg d'info dans la console
					System.out.println("Fin du main et demarrage du thread  < surveillance des boutons >");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
