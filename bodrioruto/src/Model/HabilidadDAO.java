/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Database.ConectionDB;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class HabilidadDAO {
    private Connection con;
    
    public HabilidadDAO(){
        this.con = ConectionDB.getConnection();
    }
    
    public void addHabilidad(Habilidad habilidad) throws SQLException {
        String query = "INSERT INTO Habilidad (id_ninja , nombre, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, habilidad.getIdNinja());
            stmt.setString(2, habilidad.getNombre());
            stmt.setString(3, habilidad.getDescripcion());
            stmt.executeUpdate();
        }
    }
    public List<Habilidad> listarHabilidades() throws SQLException {
        String query = "SELECT * FROM Habilidad";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Usamos Stream para transformar el ResultSet en una lista de eventos
            return Stream.generate(() -> {
                try {
                    if (rs.next()) {
                        return new Habilidad(
                            rs.getInt("id del ninja"),
                            rs.getString("nombre de la habilidad"),
                            rs.getString("descripcion de la habilidad")
                        );
                    } else {
                        return null; // Fin de los datos
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            })
            .takeWhile(habilidad -> habilidad != null) // Tomar eventos hasta llegar al final
            .collect(Collectors.toList());
        }
    }

}