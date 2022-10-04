
/**
 *
 * Clase Cuenta, se encargar de todos los movimientos tantos gastos como ingresos
 *
 */

import java.util.List;

public class Cuenta {

    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    public Cuenta(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = 0;
    }

    // Devuelve el saldo
    public double getSaldo() {
        return saldo;
    }

    // Establece el saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Devuelve el usuario
    public Usuario getUsuario() {
        return usuario;
    }

    // Establece el usuario
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Añade el ingreso
    public double addIngresos(String descripcion, double cantidad){
        this.saldo = this.saldo + cantidad;
        return saldo;
    }

    // Crea una lista de ingresos
    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    // Devuelve la lista de ingresos
    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    // Añade el gasto
    public double addGastos(String descripcion, double cantidad){
        this.saldo = this.saldo - cantidad;
        return saldo;
    }

    // Crea una lista de gastos
    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    // Devuelve la lista de gastos
    public List<Gasto> getGastos() {
        return gastos;
    }

    // Devuelve el saldo de la cuenta
    public String toString(){
        return "El saldo actual de la cuenta es: " + this.saldo +"€";
    }
}
