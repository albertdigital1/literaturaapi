package com.literaturaapi.repositories;

import com.literaturaapi.database.DatabaseConnection;
import com.literaturaapi.models.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository {
    public void guardarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, idioma, numero_descargas) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getIdioma());
            stmt.setInt(4, libro.getNumeroDescargas());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                libros.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("idioma"),
                        rs.getInt("numero_descargas")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
}
