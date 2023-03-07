package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class ConversorCoin {

	
	public  String getMoeda(int index) 
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
	
	public  Moeda getMoeda_Json(String codigo) throws Exception 
	{

		
		int codigoSucesso = 200;
		 String urlParaChamada = "https://economia.awesomeapi.com.br/json/"+codigo;
		 URL url = new URL(urlParaChamada);
         URLConnection conexao =  url.openConnection();
	      Moeda moeda = new Moeda();
	   

	        try {
	            

	            if (((HttpURLConnection) conexao).getResponseCode() != codigoSucesso)
	                throw new RuntimeException("HTTP error code : " + ((HttpURLConnection) conexao).getResponseCode());

	            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
	            String jsonEmString = Util.converteJsonEmString(resposta);
                String moedaJ = jsonEmString.toString().replaceAll("[\\[\\]]","");
                
	            Gson gson = new Gson();
	            moeda = gson.fromJson(moedaJ, Moeda.class);
	            
	            conexao.getInputStream().close();
	          //  conexao.connect();
	            return moeda;
	        } catch (Exception e) {
	            throw new Exception("ERRO: " + e);
	        }
	   
	}
	
	 public  String converteJsonEmString(BufferedReader buffereReader) throws IOException {
	        String resposta, jsonEmString = "";
	        while ((resposta = buffereReader.readLine()) != null) {
	            jsonEmString += resposta;
	        }
	        return jsonEmString;
	    }
	
}
