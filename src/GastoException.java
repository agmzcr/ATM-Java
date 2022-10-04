
/**
 *
 * Clase del excepcion propio.
 *
 */

public class GastoException extends  Exception {

    // Método donde guardamos el mensaje del error
    private String mensajeError;

    // El constructor
    public GastoException() {
        this.mensajeError = "No se puede añadir el movimiento porque "
                +"el importe del gasto es superior al saldo "
                +"o el saldo es de 0€";
    }

    // Devuelve el mensaje
    public String getMessage() {
        return mensajeError;
    }
}
