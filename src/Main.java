import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Para leer por teclado
    private static Scanner sc = new Scanner(System.in);

    // Guardar el DNI del usuario
    private static String dniUsuario;

    // Guarda el nombre del usuario
    private static String nombreUsuario;

    // Guarda la edad del usuario
    private static int edadUsuario = 0;
    private static String edadUsu;

    // Objetos para usuario y cuenta
    private static Usuario nuevoUsuario;
    private static Cuenta nuevaCuenta;

    // Para el menu
    private static int opcionSeleccionada;

    // Indicar el importe
    private static double importe;

    // Poder escribir el concepto del movimiento
    private static String descripcionMovimiento;


    // Pregunta por los datos del usuario
    private static boolean crearUsuario() {
        nuevoUsuario = new Usuario();

        do {
            System.out.println("Introduce tu nombre: ");
            nombreUsuario = sc.nextLine();
        } while (nombreUsuario.isEmpty());
        nuevoUsuario.setNombre(nombreUsuario);

        // Te pide la edad y valida que son números pasandolo a Int.
        do {
            System.out.println("Introduce tu edad:");
            edadUsu = sc.nextLine();

            try {
                edadUsuario = Integer.parseInt(edadUsu);
                nuevoUsuario.setEdad(edadUsuario);
            } catch (Exception e) {
                System.out.println("Edad inválida");
            }

        } while (edadUsuario <= 0);

        // Te pide que pongas el DNI
        do {
            System.out.println("Introduce tu DNI:");
            dniUsuario = sc.nextLine();

            if (!nuevoUsuario.setDNI(dniUsuario)) {
                System.out.println("DNI inválido");
            }

        } while (!nuevoUsuario.setDNI(dniUsuario));

        System.out.println("Usuario "+nuevoUsuario.getNombre()+" creado correctamente");
        return true;
    }

    // El menu para seleccionar operacion
    private static void seleccionarOperacion() {
        System.out.println("Realiza una nueva acción:");
        System.out.println("1. Introducir un nuevo gasto");
        System.out.println("2. Introducir un nuevo ingreso");
        System.out.println("3. Mostrar gastos");
        System.out.println("4. Mostrar ingresos");
        System.out.println("5. Mostrar saldo.");
        System.out.println("0. Salir");

        // Confirma que la selección entra dentro de los parametros
        do {
            opcionSeleccionada = sc.nextInt();
            if (opcionSeleccionada > 5){
                System.out.println("Debes de seleccionar una opción correcta");
            }
        } while (opcionSeleccionada < 0 || opcionSeleccionada > 5);
        sc.nextLine();
    }

    // Pide que ponga el motivo y la cantida del gasto
    private static boolean añadirDatosDeGasto() {
        do {

            System.out.println("Introduce el concepto del gasto:");
            descripcionMovimiento = sc.nextLine();
        } while (descripcionMovimiento.isEmpty());

        do {

            System.out.println("Introduce el importe del gasto:");
            importe = sc.nextDouble();

        } while (importe < 0);

        return true;
    }

    // Crea la lista de gastos
    private static List<Gasto>listaGastos = new ArrayList<Gasto>();

    // Agrega el gasto a la lista
    private static void agregarGasto() {
        Gasto nuevoGasto = new Gasto(importe, descripcionMovimiento);
        nuevoGasto.setDescription(descripcionMovimiento);
        nuevoGasto.setDinero(importe);
        listaGastos.add(nuevoGasto);
    }

    // Pide que pongas el motivo y la cantidad del ingreso
    private static boolean añadirDatosIngresos() {

        do {
            System.out.println("Introduce el concepto del ingreso:");
            descripcionMovimiento = sc.nextLine();
        } while (descripcionMovimiento.isEmpty());

        do {
            System.out.println("Introduce el importe del ingreso:");
            importe = sc.nextDouble();
        } while (importe <= 0);

        return true;
    }

    // Crea la lista de ingresos
    private static List<Ingreso> listaIngresos = new ArrayList<Ingreso>();

    // Agrega el ingreso a la lista
    private static void agregarIngreso() {

        Ingreso nuevoIngreso = new Ingreso(importe, descripcionMovimiento);
        nuevoIngreso.setDescription(descripcionMovimiento);
        nuevoIngreso.setDinero(importe);
        listaIngresos.add(nuevoIngreso);
    }

    public static void main(String[] args) throws GastoException {

        // El switch del menu
        if (crearUsuario()) {
            nuevaCuenta = new Cuenta(nuevoUsuario);
            seleccionarOperacion();

            //Entra en el switch dependiendo de la opción seleccionada
            do {
                switch (opcionSeleccionada) {
                    // El caso para añadir un nuevo gasto. Si tienes saldo suficiente le resta el gasto a tu saldo
                    // En caso contrario te da el error de Exception
                    case 1:
                        if (añadirDatosDeGasto()) {
                            if (importe > nuevaCuenta.getSaldo()) {
                                System.out.println(new GastoException());
                            } else {
                                agregarGasto();
                                nuevaCuenta.addGastos(descripcionMovimiento, importe);
                                nuevaCuenta.setGastos(listaGastos);
                                System.out.println("Gasto añadido correctamente");
                            }
                        }
                        seleccionarOperacion();
                        break;

                        // El caso para añadir ingresos
                    case 2:
                        if (añadirDatosIngresos()) {
                            agregarIngreso();
                            nuevaCuenta.addIngresos(descripcionMovimiento, importe);
                            nuevaCuenta.setIngresos(listaIngresos);
                            System.out.println("Ingreso añadadido correctamente");
                        }
                        seleccionarOperacion();
                        break;

                        // Caso para mostrar todos los gastos
                    case 3:
                        // Comprueba si tienes o no movimientos de gastos y te lo indica.
                        if (nuevaCuenta.getGastos() ==null) {
                            System.out.println("No existen movimientos de gastos");
                        } else {
                            for (int i = 0; i <= nuevaCuenta.getGastos().size() -1; i++) {
                                System.out.println(nuevaCuenta.getGastos().get(i).toString());
                            }
                        } seleccionarOperacion();
                        break;

                        // Caso para mostrar todos los ingresos
                    case 4:
                        // Comprueba si tienes o no movimientos de ingresos y te lo indica
                        if(nuevaCuenta.getIngresos() == null) {
                            System.out.println("No existen movimientos de ingresos");
                        } else {
                            for (int i = 0; i <= nuevaCuenta.getIngresos().size() -1; i++) {
                                System.out.println(nuevaCuenta.getIngresos().get(i).toString());
                            }
                        } seleccionarOperacion();
                        break;

                        // El caso que te dice tu saldo actual
                    case 5:
                        System.out.println(nuevaCuenta.toString());
                        seleccionarOperacion();
                        break;

                        // El caso pasa salir del programa
                    case 0:

                }

            } while (opcionSeleccionada != 0 || opcionSeleccionada > 5);
            sc.close();
        }
        System.out.println("Fin del programa");
        System.out.println("Gracias por utilizar la aplicación");
    }
}
