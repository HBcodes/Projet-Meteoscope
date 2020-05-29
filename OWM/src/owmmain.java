import clavier.In;
import org.json.*;
public class owmmain {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		while(true){
			WeatherHttpClient monclient = new WeatherHttpClient();
			String VilleChoisis;
			System.out.println("Entrez vôtre ville,pays: (Ex: Valence,fr)");
			VilleChoisis = In.readString();
			String Data = monclient.getWeatherData("" + VilleChoisis);
			System.out.print("Data: " + Data);
			TradJSON matrad = new TradJSON();
			double Temp = matrad.getTemp(Data);
			System.out.println("" + Temp);
			String Meteo = matrad.getMeteo(Data);
			System.out.println("" + Meteo);
			double Pres = matrad.getPres(Data);
			System.out.println("" + Pres);//hpa
			double Humid = matrad.getHumid(Data);
			System.out.println("" + Humid);//Pourcentage
		}
	}
}