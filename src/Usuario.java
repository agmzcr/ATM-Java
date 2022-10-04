/**
 *
 * Clase Usuario, que gestiona al usuario.
 *
 */

public class Usuario {

    String nombre, dni;
    int edad;

    public void Usuario() {
    }

    // Devuelve el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    // Establece el nombre del usuario
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve la edad del usuario
    public int getEdad() {
        return edad;
    }

    // Establece la edad del usuario
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Devuelve el DNI del usuario
    public String getDNI() {
        return dni;
    }

    // Comprobación de que el DNI sea correcto
    public boolean setDNI(String dniUsuario) {
        String numeros;
        String letra;

        dniUsuario = dniUsuario.toUpperCase();
        dniUsuario = dniUsuario.replaceAll("-", "");

        letra = dniUsuario.substring(dniUsuario.length() -1);
        numeros = dniUsuario.substring(0, dniUsuario.length() -1);

        if (dniUsuario.length() == 9 && numeros.matches("[0-9]+") && letra.matches("[a-zA-Z]")) {
            this.dni = dniUsuario;
            return true;
        } else {
            return false;
        }
    }

    // Devuelve los datos del usuario
    public String toString() {
            return "Nombre: " +nombre +"\n" +"Edad: " +edad +"\n" +"DNI: " +dni;
        }
}
