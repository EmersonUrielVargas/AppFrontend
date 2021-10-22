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

	public static ArrayList<Users> getJSON() throws IOException, ParseException {
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

	public static int postJSON(Users usuario) throws IOException {
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

	public static int putJSON(Users usuario) throws IOException {
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

	public static int deleteJSON(Long userId) throws IOException {
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

}
