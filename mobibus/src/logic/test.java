package logic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class test {

	public static void main(String[] args) throws UnirestException 
	{
		HttpResponse<String> jsonResponse = Unirest.get("https://www.google.com.co/#safe=off&q=david")
				  .header("accept", "application/json")
				  .queryString("apiKey", "123")
				  .asString();
		
		System.out.println(jsonResponse.getStatus());

	}

}
