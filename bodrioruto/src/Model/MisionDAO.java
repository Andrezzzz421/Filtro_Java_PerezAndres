
package Model;
import Database.ConectionDB;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class MisionDAO {
    private Connection con;
    
    public MisionDAO(){
        this.con = ConectionDB.getConnection();
    }
    
    public void addMision(Mision misiones) throws SQLException {
        String query = "INSERT INTO Mision (descripcion, rango, recompensa) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, misiones.getDescripcion());
            stmt.setString(2, misiones.getRango());
            stmt.setString(3, misiones.getRecompensa());
            stmt.executeUpdate();
        }
    }
 public List<Mision> listarMision() throws SQLException {
        String query = "SELECT * FROM Mision";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Usamos Stream para transformar el ResultSet en una lista de eventos
            return Stream.generate(() -> {
                try {
                    if (rs.next()) {
                        return new Mision(
                            rs.getString("descripcion"),
                            rs.getString("rango"),
                            rs.getString("recompensa")
                        );
                    } else {
                        return null; // Fin de los datos
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            })
            .takeWhile(mision -> mision != null) // Tomar eventos hasta llegar al final
            .collect(Collectors.toList());
        }
    }

}