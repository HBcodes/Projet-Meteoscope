/**
 * Fenetre principale de l'application, affiche 2 boutons et 2 labels 
 * le message apparait dans un des 2 labels lorsque l'on clique sur le bouton afficher le message
 * On quitte le programme lorsque l'on appui sur le bouton quitter
 * @param 
 * @author Wilfrid Grassi
 * @since 30/11/2014
 * @version v03
 */
package MonIHM;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FenetrePrincipale {

	private JFrame frame;
	private static JLabel lblLeMessageAffiche = new JLabel("");
	private static JLabel Villerech = new JLabel("");
	private static JLabel Meteorech = new JLabel("");
	private static JLabel Humidrech = new JLabel("");
	private static JLabel Presrech = new JLabel("");
	private static JLabel Temprech = new JLabel("");
	private boolean EtatBoutonAfficherLeMessage=false;
	private boolean EtatBoutonQuitter=false;
	private boolean EtatBoutonAM=false;
	public JTextField txtVille;

	/**
	 * Creation de la fenetre graphique de l'application.
	 */
	public FenetrePrincipale() {
		initialize();
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon(getClass().getResource("/Soleil1.png")).getImage());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(new Color(0, 102, 153));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 991, 688);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*-----------------------------------------------------------------------------*/
		/*cr�ation du bouton d'affichage */
		JButton btnBoutonAfficherLeMessage = new JButton("Aide");
		btnBoutonAfficherLeMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				* On passe dans cette m�thode lorsque l'on clique sur le bouton
				* C'est ici que l'on peut placer le code � executer lors du clique sur ce bouton
				*/
				if(getEtatBoutonAfficherLeMessage()==false)
					setEtatBoutonAfficherLeMessage(true);
				else
					setEtatBoutonAfficherLeMessage(false);
			}
		});
		btnBoutonAfficherLeMessage.setBounds(409, 582, 149, 23);
		frame.getContentPane().add(btnBoutonAfficherLeMessage);
		/*------------------------------------------------------------------------------*/

		/*------------------------------------------------------------------------------*/
		/*cr�ation du label o� sera affich� le message"*/
		lblLeMessageAffiche.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeMessageAffiche.setForeground(Color.BLACK);
		lblLeMessageAffiche.setBackground(Color.GRAY);
		lblLeMessageAffiche.setBounds(248, 558, 475, 14);
		frame.getContentPane().add(lblLeMessageAffiche);
		/*------------------------------------------------------------------------------*/
		
		/*------------------------------------------------------------------------------*/
		/*cr�ation du bouton quitter"*/
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EtatBoutonQuitter=true;
			}
		});
		btnQuitter.setBounds(876, 616, 89, 23);
		frame.getContentPane().add(btnQuitter);
		
		JButton btnAjoutMeteoscope = new JButton("Ajout Meteoscope");
		btnAjoutMeteoscope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				* On passe dans cette m�thode lorsque l'on clique sur le bouton
				* C'est ici que l'on peut placer le code � executer lors du clique sur ce bouton
				*/
				if(getEtatBoutonAM()==false)
					setEtatBoutonAM(true);
				else
					setEtatBoutonAM(false);
			}
		});
		btnAjoutMeteoscope.setBounds(51, 93, 137, 23);
		frame.getContentPane().add(btnAjoutMeteoscope);
		
		txtVille = new JTextField();
		txtVille.setBounds(75, 50, 86, 20);
		frame.getContentPane().add(txtVille);
		txtVille.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville:");
		lblVille.setForeground(Color.WHITE);
		lblVille.setBounds(105, 25, 31, 14);
		frame.getContentPane().add(lblVille);
		
		JLabel lblVille_1 = new JLabel("Ville:");
		lblVille_1.setBounds(263, 53, 89, 14);
		frame.getContentPane().add(lblVille_1);
		
		JLabel lblMeteo = new JLabel("Meteo:");
		lblMeteo.setBounds(263, 78, 89, 14);
		frame.getContentPane().add(lblMeteo);
		
		JLabel lblTemperature = new JLabel("Temperature:");
		lblTemperature.setBounds(263, 102, 89, 14);
		frame.getContentPane().add(lblTemperature);
		
		JLabel lblPression = new JLabel("Pression:");
		lblPression.setBounds(263, 127, 89, 14);
		frame.getContentPane().add(lblPression);
		
		JLabel lblHumidite = new JLabel("Humidite:");
		lblHumidite.setBounds(263, 152, 89, 14);
		frame.getContentPane().add(lblHumidite);
		
		
		Villerech.setBounds(353, 50, 110, 14);
		frame.getContentPane().add(Villerech);
		
		
		Meteorech.setBounds(353, 78, 110, 14);
		frame.getContentPane().add(Meteorech);
		
		
		Temprech.setBounds(353, 102, 110, 14);
		frame.getContentPane().add(Temprech);
		
		
		Presrech.setBounds(353, 127, 110, 14);
		frame.getContentPane().add(Presrech);
		
		
		Humidrech.setBounds(353, 152, 110, 14);
		frame.getContentPane().add(Humidrech);
		
				
		/*------------------------------------------------------------------------------*/
	}
	
	//----------------  textPaneReponseClient --------------------------//
		public void setText_lblLeMessageAffiche(String chaine){
			lblLeMessageAffiche.setText(chaine);
		}
		
		public void setEtatBoutonAfficherLeMessage(boolean booleanEtatBouton){
			EtatBoutonAfficherLeMessage = booleanEtatBouton;
		}
		
		public boolean getEtatBoutonAfficherLeMessage(){
			boolean booleanEtatBouton;
			
			//System.out.println("getEtatBoutonAfficherLeMessage");
			booleanEtatBouton = EtatBoutonAfficherLeMessage;
			return(booleanEtatBouton);
		}
		
		public void setEtatBoutonAM(boolean booleanEtatBoutonAM){
			EtatBoutonAM = booleanEtatBoutonAM;
		}
		
		public boolean getEtatBoutonAM(){
			boolean booleanEtatBoutonAM;
			
			//System.out.println("getEtatBoutonAfficherLeMessage");
			booleanEtatBoutonAM = EtatBoutonAM;
			return(booleanEtatBoutonAM);
		}
		
		public boolean getEtatBoutonQuitter(){
			boolean booleanEtatQuitter;
			
			booleanEtatQuitter = EtatBoutonQuitter;
			//System.out.print("");
			
			return(booleanEtatQuitter);
		}
		
		public void FermerIHM(){
			frame.dispose();
		}

		public void setText_Villerech(String string) {
			// TODO Auto-generated method stub
			Villerech.setText(string);
		}

		public void setText_Meteorech(String string) {
			// TODO Auto-generated method stub
			Meteorech.setText(string);
		}

		public void setText_Humidrech(String string) {
			// TODO Auto-generated method stub
			Humidrech.setText(string);
		}

		public void setText_Presrech(String string) {
			// TODO Auto-generated method stub
			Presrech.setText(string);
		}

		public void setText_Temprech(String string) {
			// TODO Auto-generated method stub
			Temprech.setText(string);
		}

}