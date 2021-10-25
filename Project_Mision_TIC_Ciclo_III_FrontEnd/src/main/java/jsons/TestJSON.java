package jsons;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class TestJSON {

	private static URL url;
	private static String sitio = "http://localhost:5000/";


	//CRUD Clients
	
	public static int addClient(Clients client) throws IOException {
		int respuesta = 0;
		if (verifyClient(client.getClient_id())) {
			respuesta = 300;
		} else {

			url = new URL(sitio + "clients/saveClient");
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http;
			http = (HttpURLConnection) url.openConnection();
			try {
				http.setRequestMethod("POST");
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
			http.setDoOutput(true);
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			http.setRequestProperty("Content-Type", "application/json");
			String data = "{" + "\"client_id\":\"" + client.getClient_id() + "\",\"client_address\": \""
					+ client.getClient_address() + "\",\"client_email\": \"" + client.getClient_email() + "\",\"client_name\":\""
					+ client.getClient_name()+ "\",\"client_phone\":\"" + client.getClient_phone() + "\"}";
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			OutputStream stream = http.getOutputStream();
			stream.write(out);
			respuesta = http.getResponseCode();
			http.disconnect();
		}
		return respuesta;
	}

	public static int updateClient(Clients client) throws IOException {
		int respuesta=0;
		url = new URL(sitio + "clients/updateClient");
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic "+authStr);
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{" + "\"client_id\":\"" + client.getClient_id() + "\",\"client_address\": \""
				+ client.getClient_address() + "\",\"client_email\": \"" + client.getClient_email() + "\",\"client_name\":\""
				+ client.getClient_name()+ "\",\"client_phone\":\"" + client.getClient_phone() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteClient(Long userId) throws IOException {
		url = new URL(sitio + "users/deleteUser/" + userId);
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic "+authStr);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static Clients askClient(Long userId) {
		Clients client = new Clients();
		try {
			url = new URL(sitio + "clients/showClient/" + userId);
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject innerObj = (JSONObject) jsonParser.parse(json);
			client.setClient_id(Long.parseLong(innerObj.get("client_id").toString()));
			client.setClient_address(innerObj.get("client_address").toString());
			client.setClient_email(innerObj.get("client_email").toString());
			client.setClient_name(innerObj.get("client_name").toString());
			client.setClient_name(innerObj.get("client_phone").toString());

			http.disconnect();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return client;
	}
	
	

	//CRUD Users
	
	public static int addUser(Users usuario) throws IOException {
		int respuesta = 0;
		if (verifyUser(usuario.getUser_id())) {
			respuesta = 300;
		} else {

			url = new URL(sitio + "users/saveUser");
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http;
			http = (HttpURLConnection) url.openConnection();
			try {
				http.setRequestMethod("POST");
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
			http.setDoOutput(true);
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			http.setRequestProperty("Content-Type", "application/json");
			String data = "{" + "\"user_id\":\"" + usuario.getUser_id() + "\",\"user_email\": \""
					+ usuario.getUser_email() + "\",\"user_name\": \"" + usuario.getUser_name() + "\",\"password\":\""
					+ usuario.getPassword() + "\",\"user\":\"" + usuario.getUser() + "\"}";
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			OutputStream stream = http.getOutputStream();
			stream.write(out);
			respuesta = http.getResponseCode();
			http.disconnect();
		}
		return respuesta;
	}

	public static int updateUser(Users usuario) throws IOException {
		url = new URL(sitio + "users/updateUser");
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic "+authStr);
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{" + "\"user_id\":\"" + usuario.getUser_id() + "\",\"user_email\": \"" + usuario.getUser_email()
				+ "\",\"user_name\": \"" + usuario.getUser_name() + "\",\"password\":\"" + usuario.getPassword()
				+ "\",\"user\":\"" + usuario.getUser() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteUser(Long userId) throws IOException {
		url = new URL(sitio + "clients/deleteClient/" + userId);
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic "+authStr);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static Users askUser(Long userId) {
		Users user = new Users();
		try {
			url = new URL(sitio + "users/showUser/" + userId);
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject innerObj = (JSONObject) jsonParser.parse(json);
			user.setUser_id(Long.parseLong(innerObj.get("user_id").toString()));
			user.setUser_email(innerObj.get("user_email").toString());
			user.setUser_name(innerObj.get("user_name").toString());
			user.setPassword(innerObj.get("password").toString());
			user.setUser(innerObj.get("user").toString());

			http.disconnect();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
	//CRUD Users
	
	public static int addVendor(Vendors vendor) throws IOException {
		int respuesta = 0;
		if (verifyVendor(vendor.getVendor_nit())) {
			respuesta = 300;
		} else {

			url = new URL(sitio + "vendors/saveVendor");
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http;
			http = (HttpURLConnection) url.openConnection();
			try {
				http.setRequestMethod("POST");
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
			http.setDoOutput(true);
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			http.setRequestProperty("Content-Type", "application/json");
			String data = "{" + "\"vendor_nit\":\"" + vendor.getVendor_nit() + "\",\"vendor_city\": \""
					+ vendor.getVendor_city() + "\",\"vendor_address\": \"" + vendor.getVendor_address() + "\",\"vendor_name\":\""
					+ vendor.getVendor_name() + "\",\"vendor_phone\":\"" + vendor.getVendor_phone() + "\"}";
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			OutputStream stream = http.getOutputStream();
			stream.write(out);
			respuesta = http.getResponseCode();
			http.disconnect();
		}
		return respuesta;
	}

	public static int updateVendor(Vendors vendor) throws IOException {
		int respuesta = 0;
		if (verifyVendor(vendor.getVendor_nit())==false) {
			respuesta = 300;
		} else {

			url = new URL(sitio + "vendors/updateVendor");
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http;
			http = (HttpURLConnection) url.openConnection();
			try {
				http.setRequestMethod("PUT");
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
			http.setDoOutput(true);
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			http.setRequestProperty("Content-Type", "application/json");
			String data = "{" + "\"vendor_nit\":\"" + vendor.getVendor_nit() + "\",\"vendor_city\": \""
					+ vendor.getVendor_city() + "\",\"vendor_address\": \"" + vendor.getVendor_address() + "\",\"vendor_name\":\""
					+ vendor.getVendor_name() + "\",\"vendor_phone\":\"" + vendor.getVendor_phone() + "\"}";
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			OutputStream stream = http.getOutputStream();
			stream.write(out);
			respuesta = http.getResponseCode();
			http.disconnect();
		}
		return respuesta;
	}

	public static int deleteVendor(Long userId) throws IOException {
		url = new URL(sitio + "vendors/deleteVendor/" + userId);
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic "+authStr);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static Vendors askVendor(Long userId) {
		Vendors vendor = new Vendors();
		try {
			url = new URL(sitio + "vendors/showVendor/" + userId);
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject innerObj = (JSONObject) jsonParser.parse(json);
			vendor.setVendor_nit(Long.parseLong(innerObj.get("vendor_nit").toString()));
			vendor.setVendor_city(innerObj.get("vendor_city").toString());
			vendor.setVendor_address(innerObj.get("vendor_address").toString());
			vendor.setVendor_name(innerObj.get("vendor_name").toString());
			vendor.setVendor_phone(innerObj.get("vendor_phone").toString());

			http.disconnect();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return vendor;
	}
	
	
	
	//Verify Clients , Vendors , Users

	public static boolean verifyUser(Long userId) {
		boolean result = false;
		try {
			url = new URL(sitio + "users/verifyUser/" + userId);
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			result = (boolean) jsonParser.parse(json);
			http.disconnect();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return result;

	}

	public static boolean verifyClient(Long clientId) {
		boolean result = false;
		try {
			url = new URL(sitio + "clients/verifyClient/" + clientId);
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			result = (boolean) jsonParser.parse(json);
			http.disconnect();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public static boolean verifyVendor(Long vendorNit) {
		boolean result = false;
		try {
			url = new URL(sitio + "vendors/verifyVendor/" + vendorNit);
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+authStr);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			result = (boolean) jsonParser.parse(json);
			http.disconnect();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public static Users verifyAdmin() {
		Users user = new Users();
		try {
			url = new URL(sitio + "users/checkAdmin/");
			String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
			HttpURLConnection http = (HttpURLConnection) (url).openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Authorization", "Basic "+ authStr);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject innerObj = (JSONObject) jsonParser.parse(json);
			user.setUser_id(Long.parseLong(innerObj.get("user_id").toString()));
			user.setUser_email(innerObj.get("user_email").toString());
			user.setUser_name(innerObj.get("user_name").toString());
			user.setPassword(innerObj.get("password").toString());
			user.setUser(innerObj.get("user").toString());

			http.disconnect();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return user;
	}


	//Reports

	public static ArrayList<Users> listUsers() throws IOException, ParseException {
		url = new URL(sitio + "users/listUsers");
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic "+authStr);
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Users> lista = new ArrayList<Users>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
	}

	public static ArrayList<Users> parsingUsuarios(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Users> list = new ArrayList<Users>();
		JSONArray users = (JSONArray) jsonParser.parse(json);
		Iterator<?> i = users.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Users user = new Users();
			user.setUser_id(Long.parseLong(innerObj.get("user_id").toString()));
			user.setUser_email(innerObj.get("user_email").toString());
			user.setUser_name(innerObj.get("user_name").toString());
			user.setPassword(innerObj.get("password").toString());
			user.setUser(innerObj.get("user").toString());
			list.add(user);
		}
		return list;
	}
	
	public static ArrayList<Clients> listClients() throws IOException, ParseException {
		url = new URL(sitio + "clients/listClients");
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic "+authStr);
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Clients> lista = new ArrayList<Clients>();
		lista = parsingClients(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Clients> parsingClients(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Clients> list = new ArrayList<Clients>();
		JSONArray clients = (JSONArray) jsonParser.parse(json);
		Iterator<?> i = clients.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Clients client = new Clients();
			client.setClient_id(Long.parseLong(innerObj.get("client_id").toString()));
			client.setClient_name(innerObj.get("client_name").toString());
			client.setClient_email(innerObj.get("client_email").toString());
			client.setClient_address(innerObj.get("client_adress").toString());
			client.setClient_phone(innerObj.get("client_telephone").toString());
			list.add(client);
		}
		return list;
	}
	
	
	
	


}
