package application;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        String[] productos = {"Hamburguesas","Perros Calientes","Papas Fritas"};
        String[] turnos = {"Almuerzo","Tarde", "Noche", "madrugada"};
        double[][] ventas = new double[3][4];
        registrarVentas(ventas,productos,turnos);
        double[] sumas =sumaPorTurno(ventas,turnos);
        mostrarSumaTurno(sumas,turnos);
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
}
