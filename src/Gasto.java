
/**
 *
 * Clase que recibe de la clase Dinero
 *
 */

public class Gasto extends Dinero {

    /**
     *
     * @param gasto
     * @param description
     */

    public Gasto (double gasto, String description) {
        this.dinero = gasto;
        this.description = description;
    }

    // Devuelve el motivo del gasto
    public String toString() {
        return "Gasto: " + this.getDescription() + ", cantidad: " + this.dinero + "€" + "\n";

    }
}
