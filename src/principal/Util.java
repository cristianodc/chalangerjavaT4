package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

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
			
		default:
			break;
		}
		return moeda;
		
	}
	
	

	public static Moeda getMoedaJson(String codigo)
	{
		String URL = "https://economia.awesomeapi.com.br/json/last/";
		 String urlParaChamada = URL+codigo;
		 
		try {
			
			URL url = new URL(urlParaChamada);
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br= new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			String retornUrl = "";
			StringBuilder jsonMoeda = new StringBuilder();
			
			while((retornUrl = br.readLine())!= null) 
				{
					jsonMoeda.append(retornUrl);
				}
		//	System.out.println(jsonMoeda.toString());
			Moeda moeda = new Gson().fromJson(jsonMoeda.toString(), Moeda.class);
			
			System.out.println(moeda);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
}
