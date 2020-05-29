package JSON;
import org.json.*;
import clavier.In;
public class owmmain extends Thread 
{

	public void run(String[] args) throws JSONException {
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
		}
	}
}