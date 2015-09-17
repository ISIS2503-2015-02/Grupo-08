package logic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class test {

	public static void main(String[] args) throws UnirestException 
	{
		HttpResponse<String> jsonResponse = Unirest.put("http://exp1.diegorbaquero.com/estacion/1/pedirLlenado")
				  .header("Content-Type", "application/json")


				  .asString();
		
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatusText());

	}

}
