/**
 * @author bal
**/
package BaseDonnees;

import java.sql.*;

public class RecupInfoDB extends Thread
{
	
	String url = "jdbc:mysql://172.29.1.27:3308/base_de_donnee_projet?zeroDatetimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	String login = "root";
	String password = "";
	Connection con = null;
	Statement smt = null;
	ResultSet rs = null;
		
		public void Connexion()
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, login, password);
				System.out.println("Connect�");
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		
		public String getVilleMeteoscope(String VilleDB)
		{
			
			
			return VilleDB;
		}
		
		public String getTempMeteoscope(String MeteoDB)
		{
			
				
			return MeteoDB;
		}
	
		public void EnvoiDataBase(String VilleOWM, double TemperatureOWM, String MeteoOWM, double HumiditeOWM, double PressionOWM) throws SQLException
		{
			smt = con.createStatement();
			String sql = "INSERT INTO `use_meteoscope` (`nom_ville`, `meteo_ville`, `temp_ville`, `humidite_ville`, `pression_ville`) VALUES ('"+ VilleOWM +"', '"+ MeteoOWM +"', '"+ TemperatureOWM +"', '"+ HumiditeOWM +"', '"+ PressionOWM +"')";
			smt.executeUpdate(sql);
		}
	
}
