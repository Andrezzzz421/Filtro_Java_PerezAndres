package View;
import Model.Mision;
import Model.Ninja;
import java.util.List;

public class MisionView {
    public void displayMisionesDetails(Mision mision) {
        System.out.println(mision);
    }

    public void displayAllMisiones(List<Mision> misions) {
        for (Mision mision : misions) {
            displayAllMisiones(misions);
        }
    }

    public void displayNinjaMisiones() {
        System.out.println("Mision creado exitosamente.");
    }

    public void displayMisionesNotFound() {
        System.out.println("Mision no encontrado.");
    }
}
