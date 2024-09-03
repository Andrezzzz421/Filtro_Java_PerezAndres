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

public class NinjaDAO {
    private Connection con;
    
    public NinjaDAO(){
        this.con = ConectionDB.getConnection();
    }
    
   public void addNinja(Ninja ninja) throws SQLException {
        String query = "INSERT INTO Ninja (nombre, rango, aldea) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, ninja.getNombre());
            stmt.setString(2, ninja.getRango());
            stmt.setString(3, ninja.getAldea());
            stmt.executeUpdate();
        }
    }

    public List<Ninja> listarNinjas() throws SQLException {
        String query = "SELECT * FROM Ninja";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Usamos Stream para transformar el ResultSet en una lista de eventos
            return Stream.generate(() -> {
                try {
                    if (rs.next()) {
                        return new Ninja(
                            rs.getString("nombre"),
                            rs.getString("rango"),
                            rs.getString("aldea")
                        );
                    } else {
                        return null; // Fin de los datos
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            })
            .takeWhile(ninja -> ninja != null) // Tomar eventos hasta llegar al final
            .collect(Collectors.toList());
        }
    }

}
