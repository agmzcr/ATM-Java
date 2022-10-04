
/**
 *
 * Clase que recibe de la clase Dinero.
 *
 */

public class Ingreso extends Dinero {

    /**
     *
     * @param ingreso
     * @param description
     */

    public Ingreso (double ingreso, String description){
        this.dinero = ingreso;
        this.description = description;

    }
    // Devuelve el motivo del ingreso
    public String toString(){
        return "Ingreso: " + this.getDescription() + ", cantidad: " + this.dinero +"€" + "\n";
    }
}
