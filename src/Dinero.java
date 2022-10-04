
/**
 * Clase Dinero que es abstracta y envia a Gasto y Ingreso
 */

public abstract class Dinero {

    protected double dinero;
    protected String description;

    // Devuelve el dinero
    public double getDinero() {
        return dinero;
    }

    // Establece el dinero
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    // Devuelve la descripcion
    public String getDescription() {
        return description;
    }

    // Establece la descripcion
    public void setDescription(String descripcion) {
        this.description = description;
    }
}
