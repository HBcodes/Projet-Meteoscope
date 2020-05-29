/**
 * Thread de surveillance des boutons l'application 
 * surveille l'état des boutons <quitter> et <afficher le message> 
 * @param 
 * @author Wilfrid Grassi
 * @since 30/11/2014
 * @version v03
 */
package MonProgramme;

import MonIHM.FenetrePrincipale;

//import java.sql.SQLException;

import org.json.JSONException;
import JSON.TradJSON;
import JSON.WeatherHttpClient;
//import BaseDonnees.RecupInfoDB;

public class ThreadSurveillanceBouton extends Thread{
	private static FenetrePrincipale monIHM;
	
	private boolean flagStopThreadSurveillanceBouton = false;
	
	//Lorsque l'on crée le thread on lui passe un pointeur sur l'interface graphique pour y accéder
	public ThreadSurveillanceBouton(FenetrePrincipale monIHMPrincipale)
	{
		monIHM = monIHMPrincipale;
	}

	// corps du code traité par le thread
	public void run()
	{	
		WeatherHttpClient monclient = new WeatherHttpClient();
		TradJSON maTradJSON = new TradJSON();
		//RecupInfoDB maBDD = new RecupInfoDB();
		boolean booleanAfficheEfface = true;
		
		System.out.println("Debut du thread < Surveillance boutons >");
		while(flagStopThreadSurveillanceBouton==false)
		{
			
			//On a cliqué sur le bouton de demande d'affichage du message
			if(monIHM.getEtatBoutonAfficherLeMessage()==true)
			{
				System.out.println("Clique sur < Bouton : afficher le message >");
				if(booleanAfficheEfface == true){
					monIHM.setText_lblLeMessageAffiche("Ecrivez nomdeville,codepays sans espace puis valider en cliquant sur ajout");
					monIHM.setEtatBoutonAfficherLeMessage(false);
					booleanAfficheEfface = false;
				}
				else{ //On efface le message au click suivant
					monIHM.setText_lblLeMessageAffiche("");
					monIHM.setEtatBoutonAfficherLeMessage(false);
					booleanAfficheEfface = true;
				}
			}
			
			//Test bouton ajout
			if(monIHM.getEtatBoutonAM()==true)
			{
				monIHM.setText_lblLeMessageAffiche("");
				double Temp = 0;
				String Meteo = "";
				double Pres = 0;
				double Humid = 0;
				System.out.println("Clique sur < Bouton : Ajout Meteoscope >");
				String Ville = monIHM.txtVille.getText();
				System.out.println("" + Ville);
				String Data = monclient.getWeatherData("" + Ville);				
				System.out.print("Data: " + Data);
				try {
					Temp = maTradJSON.getTemp("" + Data);
					System.out.println("" + Temp);
					Meteo = maTradJSON.getMeteo("" + Data);
					System.out.println("" + Meteo);
					Pres = maTradJSON.getPres("" + Data);
					System.out.println("" + Pres);
					Humid = maTradJSON.getHumid("" + Data);
					System.out.println("" + Humid);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				monIHM.setText_Villerech(Ville);
				monIHM.setText_Meteorech(Meteo);
				monIHM.setText_Humidrech("" + Humid + " %");
				monIHM.setText_Presrech("" + Pres + " hPa");
				monIHM.setText_Temprech("" + Temp + " °C");
				
				/*maBDD.Connexion();
				try {
					maBDD.EnvoiDataBase(Ville, Temp, Meteo, Humid, Pres);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				if(booleanAfficheEfface == true){
					monIHM.setEtatBoutonAM(false);
					booleanAfficheEfface = false;
				}
				else{ 
					
					monIHM.setEtatBoutonAM(false);
				}
			}
			
			/*On a cliqué sur le bouton quitter*/
			if(monIHM.getEtatBoutonQuitter()==true){
				System.out.println("Clique sur < Bouton : Quitter >");
				flagStopThreadSurveillanceBouton=true;
			}
			
			try {
				// !!!!! obligatoire permet une temporisation pour la prise en compte des événements de l'IHM, delai de 1ms
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin du thread < Surveillance boutons >");
		monIHM.FermerIHM();
	}
	
	//Methode pour detruire la boucle infinie du thread, fermeture propre du thread
	public void stopThreadSurveillanceBouton()
	{
		//On positionne la variable flagStopThreadSurveillanceBouton pour arrêter la boucle du thread de surveillance 
		flagStopThreadSurveillanceBouton = true;
	}
}