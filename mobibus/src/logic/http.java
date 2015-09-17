package logic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class http 
{
	private String root = "http://exp1.diegorbaquero.com/";
	
	//
	//Usuario
	//
	public void usuarioVerEstado(String usuarioId, String id) throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse = Unirest.get(root+"usuario/{usuarioId}/verEstado/{id}")
				  .header("accept", "application/json")
				  .routeParam("usuarioId", usuarioId)
				  .routeParam("id", id)
				  .asJson();
	}
	
	public void usuarioSolicitarMobibus(String usuarioId, String lat, String lon) throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse = Unirest.post(root+"usuario/{usuarioId}/solicitarMobibus/{lat}/{lon}")
				  .header("accept", "application/json")
				  .routeParam("usuarioId", usuarioId)
				  .routeParam("lat", lat)
				  .routeParam("lon", lon)
				  .asJson();
	}
	//
	//-----------------------------------------------------------------------------------------------------
	//

	//
	//Estación Vcubs
	//
	public String prestarVcub(String VcubId, String estacionId) throws UnirestException
	{
		System.out.println("prestar vcub");
		HttpResponse<String> jsonResponse = Unirest.put(root+"estacion/{EstacionId}/prestarVcub/{VcubId}")
				  .header("accept", "application/json")
				  .routeParam("VcubId", VcubId)
				  .routeParam("EstacionId", estacionId)
				  .asString();
		
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatusText());
		return jsonResponse.getBody();
	}

	public String recibirVcub(String VcubId, String estacionId) throws UnirestException
	{
		System.out.println("recibir vcub");
		
		HttpResponse<String> jsonResponse = Unirest.put(root+"estacion/{EstacionId}/recibirVcub/{VcubId}")
				  .header("accept", "application/json")
				  .routeParam("VcubId", VcubId)
				  .routeParam("EstacionId", estacionId)
				  .asString();
		
		System.out.println(jsonResponse.getBody());
		
		return jsonResponse.getBody();
		
	}
	
	public String pedirLlenado(String estacionId) throws UnirestException
	{
		System.out.println("pedir llenado");
		
		HttpResponse<String> jsonResponse = Unirest.put(root+"estacion/{EstacionId}/pedirLlenado")
				  .header("accept", "application/json")
				  .routeParam("EstacionId", estacionId)
				  .asString();
		
		System.out.println(jsonResponse.getBody());
		
		return jsonResponse.getBody();
	}
	
	public String registrarVcubs(String estacionId) throws UnirestException
	{
		System.out.println("registrar vcubs");
		
		HttpResponse<String> jsonResponse = Unirest.put(root+"estacion/{EstacionId}/registrarVcubs")
				  .header("accept", "application/json")
				  .routeParam("EstacionId", estacionId)
				  .asString();
		
		System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody();
	}
	//
	//-----------------------------------------------------------------------------------------------------
	//
	
	
	//
	//Tranvia
	//
	public String tranviaInfo(String id) throws UnirestException
	{
		return Unirest.get(root+"tranvia/{id}")
				  .header("accept", "application/json")
				  .routeParam("id", id)
				  .asString().getBody();
		
		
	}

	public String tranviaReportarEmergencia(String id) throws UnirestException
	{
		return Unirest.put(root+"tranvia/{id}/emergencia")
				  .header("accept", "application/json")
				  .routeParam("id", id)
				  .field("lat", "4.601586")
				  .field("long", "-74.065274")
				  
				  
				  .asString().getBody();
	}
	
	public String tranviaReportarPosicion(String id) throws UnirestException
	{
		return Unirest.put(root+"tranvia/{id}/reportarPosicion")
				  .header("accept", "application/json")
				  .routeParam("id", id)
				  .field("lat", "4.601586")
				  .field("long", "-74.065274")
				  .asString().getBody();
	}
	
	//
	//-----------------------------------------------------------------------------------------------------
	//
	
	//
	//Mobibus
	//
	public void mobibusInfo(String id) throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse = Unirest.get(root+"mobibus/{id}")
				  .header("accept", "application/json")
				  .routeParam("id", id)
				  .asJson();
	}

	public String mobibusreportarOcupacion(String id) throws UnirestException
	{
		HttpResponse<String> jsonResponse = Unirest.put(root+"mobibus/{id}/ocupacion")
				  .header("accept", "application/json")
				  .routeParam("id", id)
				  .asString();
		
		return jsonResponse.getBody();
	}
	
	public String mobibusReportarPosicion(String id) throws UnirestException
	{
		HttpResponse<String> jsonResponse = Unirest.put(root+"mobibus/{id}/reportarPosicion")
				  .header("accept", "application/json")
				  .routeParam("id", id)
				  .asString();
		
		return jsonResponse.getBody();
	}
	
	//
	//-----------------------------------------------------------------------------------------------------
	//
	
}
