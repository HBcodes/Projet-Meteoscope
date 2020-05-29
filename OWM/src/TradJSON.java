import org.json.*;


public class TradJSON 
{

	public double getTemp(String Data) throws JSONException {
		
		JSONObject RecupDonnee = new JSONObject(Data);		
		JSONObject Temp = RecupDonnee.getJSONObject("main");	
		
		return Temp.getDouble("temp");
	}
	
	public String getMeteo(String Data) throws JSONException {
		
		JSONObject RecupDonnee = new JSONObject(Data);
		JSONArray array = RecupDonnee.getJSONArray("weather");		
		String Meteo = array.getJSONObject(0).get("main").toString();
		
		return Meteo;
	}
	
	public double getPres(String Data) throws JSONException {
		
		JSONObject RecupDonnee = new JSONObject(Data);		
		JSONObject Pres = RecupDonnee.getJSONObject("main");	
		
		return Pres.getDouble("pressure");
	}
	
	public double getHumid(String Data) throws JSONException {
		
		JSONObject RecupDonnee = new JSONObject(Data);
		JSONObject Humid = RecupDonnee.getJSONObject("main");	
		
		return Humid.getDouble("humidity");
	}
}