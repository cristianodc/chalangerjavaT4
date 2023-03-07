package principal;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Util {

	public static String getMoeda(int index) 
	{
		String moeda = null;
		
		switch (index) {
		case 0:
			moeda = "USD-BRL";
			return moeda;
		case 1:
			moeda = "EUR-BRL";
			return moeda;
		case 2:
			moeda = "GBP-BRL";
			return moeda;
		case 3:
			moeda = "ARS-BRL";
			return moeda;
		case 4:
			moeda = "BRL-USD";
			return moeda;
		case 5:
			moeda = "BRL-EUR";
			return moeda;
		case 6:
			moeda = "BRL-GBP";
			return moeda;
		case 7:
			moeda = "BRL-ARS";
			return moeda;
			
		default:
			break;
		}
		return moeda;
		
	}
	
	

	public static Moeda getMoedaJson(String codigo) throws IOException 
	{
		
		 List<Moeda> moedas = new ArrayList<>();
		  String urlParaChamada = "https://economia.awesomeapi.com.br/json/"+codigo;
		 
		 URL  url = new URL(urlParaChamada);
		 javax.net.ssl.HttpsURLConnection connection =  (HttpsURLConnection) url.openConnection();
		try {
			
				
			   	 Moeda moeda = new Moeda();
			   	InputStream is = connection.getInputStream();
				
				BufferedReader br= new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				String retornUrl = "";
				String joinMoeda = "";
				
				while((retornUrl = br.readLine())!= null) 
					{
					
					   joinMoeda += retornUrl;
					
					}
				
				   String moedaJson = joinMoeda.toString().replaceAll("[\\[\\]]","");
				
				  
			       moeda = new Gson().fromJson(moedaJson, Moeda.class);
			     return moeda;
				
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("MENSAGEM DE ERRO" +e.getMessage());
		}
		return null;
		
	}
		
	 public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
	        String resposta, jsonEmString = "";
	        while ((resposta = buffereReader.readLine()) != null) {
	            jsonEmString += resposta;
	        }
	        return jsonEmString;
	    }
	 
	 public static double calcConversao(double valor , Moeda moeda) {
		
		 double resultado = 0;
		
		 		 resultado = valor  / moeda.getBid();
		
		 
		 return resultado = (double) Math.round(resultado * 100d) / 100;
		 
	 }
	 
	
}
