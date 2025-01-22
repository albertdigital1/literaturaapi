package com.literaturaapi.services;

import com.literaturaapi.models.Libro;
import com.literaturaapi.repositories.LibroRepository;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GutendexAPIService {
    private static final String API_URL = "https://gutendex.com/books";

    public void buscarLibroPorTitulo(String titulo) {
        try {
            URL url = new URL(API_URL + "?search=" + titulo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();

                JSONObject json = new JSONObject(inline.toString());
                JSONArray results = json.getJSONArray("results");

                for (int i = 0; i < results.length(); i++) {
                    JSONObject book = results.getJSONObject(i);
                    String tituloLibro = book.getString("title");
                    String autor = book.getJSONArray("authors").getJSONObject(0).getString("name");
                    String idioma = book.getJSONArray("languages").getString(0);
                    int descargas = book.getInt("download_count");

                    Libro libro = new Libro(0, tituloLibro, autor, idioma, descargas);
                    new LibroRepository().guardarLibro(libro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
