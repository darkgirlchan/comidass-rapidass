package application;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        String[] productos = {"Hamburguesas","Perros Calientes","Papas Fritas"};
        String[] turnos = {"Almuerzo","Tarde", "Noche", "madrugada"};
        double[][] ventas = new double[3][4];
        registrarVentas(ventas,productos,turnos);
        double[] sumasTurno =sumaPorTurno(ventas,turnos);
        mostrarSumaTurno(sumasTurno,turnos);
        double[] sumasProductos =sumaPorProductos(ventas,productos);
        mostrarSumaProductos(sumasProductos,productos);
        System.out.println("Total Recaudado: $" + totalRecaudado(ventas));
        mostrarMayorYMenorTurno(sumasTurno,turnos);
        mostrarMayorYMenorProducto(sumasProductos,productos);

    }
    public static void registrarVentas(double[][] ventas, String[] productos, String[] turnos){
        for (int i = 0; i < productos.length; i++){
            for (int j = 0; j < turnos.length; j++
            ){
                System.out.println("Ingrese el valor de la venta de " + productos[i] +" en el turno de " + turnos[j]+":");
                ventas[i][j] = validarDato();
            }
        }
    }
    public static double validarDato(){
        double dato = 0;
        while (true) {
            if (!sc.hasNextDouble()){
                System.out.println("Error: Ingrese un valor válido.");
                sc.next();
                continue;
            }
            dato = sc.nextDouble();
            if (dato<=0){
                System.out.println("Error: Ingrese un valor mayor o igual a 0.");
                continue;
            }
            break;
        }
        return dato;
    }
    public static double[] sumaPorTurno(double[][] ventas, String[] turnos) {
        double[] sumas = new double[turnos.length];
        for (int j=0; j< turnos.length; j++){
            for (int i=0; i< ventas.length;i++){
                sumas[j] += ventas[i][j];
            }
        }
        return sumas;
    }
    public static void mostrarSumaTurno(double[] sumas, String[] turnos){
        System.out.println("Total de ventas por turno");
        for (int j = 0; j< turnos.length; j++){
            System.out.println(turnos[j] + ": " + sumas[j]);
        }
    }
    public static double[] sumaPorProductos(double[][] ventas, String[] productos) {
        double[] sumas = new double[productos.length];
        for (int i=0; i< productos.length; i++){
            for (int j=0; j< productos.length;j++){
                sumas[i] += ventas[i][j];
            }
        }
        return sumas;
    }
    public static void mostrarSumaProductos(double[] sumas, String[] productos){
        System.out.println("Total de ventas por producto");
        for (int i = 0; i< productos.length; i++){
            System.out.println(productos[i] + ": " + sumas[i]);
        }
    }
    public static double totalRecaudado(double[][] ventas){
        double total=0;
        for (int i= 0;i<ventas.length;i++){
            for (int j= 0; j<ventas[i].length;j++) {
                total += ventas[i][j];
            }
        }
        return total;
    }
    public static int[] mayorYMenorTurno(double[] sumasTurno){
        int mayor = 0;
        int menor = 0;
        for (int j = 1; j < sumasTurno.length; j++){
            if (sumasTurno[j] > sumasTurno[mayor]){
                mayor = j;
            }
            if (sumasTurno[j] < sumasTurno[menor]){
                menor = j;
            }
        }
        return new int[]{mayor, menor};
    }

    public static void mostrarMayorYMenorTurno(double[] sumasTurno, String[] turnos){
        int[] indices = mayorYMenorTurno(sumasTurno);
        System.out.println("Turno con mayores ventas: " + turnos[indices[0]] + " con: " + sumasTurno[indices[0]] + " ventas");
        System.out.println("Turno con menores ventas: " + turnos[indices[1]] + " con: " + sumasTurno[indices[1]] + " ventas");
    }
    public static int[] mayorYMenorProducto(double[] sumasProductos){
        int mayor = 0;
        int menor = 0;
        for (int i = 1; i < sumasProductos.length; i++){
            if (sumasProductos[i] > sumasProductos[mayor]){
                mayor = i;
            }
            if (sumasProductos[i] < sumasProductos[menor]){
                menor = i;
            }
        }
        return new int[]{mayor, menor};
    }

    public static void mostrarMayorYMenorProducto(double[] sumasProductos, String[] productos){
        int[] indices = mayorYMenorProducto(sumasProductos);
        System.out.println("Producto con mayores ventas: " + productos[indices[0]] + " con: " + sumasProductos[indices[0]] + " ventas");
        System.out.println("Producto con menores ventas: " + productos[indices[1]] + " con" + sumasProductos[indices[1]] + " ventas");
    }
}
