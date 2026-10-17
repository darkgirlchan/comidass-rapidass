package application;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        String[] productos = {"Hamburguesas","Perros Calientes","Papas Fritas"};
        String[] turnos = {"Almuerzo","Tarde", "Noche", "madrugada"};
        double[][] ventas = new double[3][4];
        registrarVentas(ventas,productos,turnos);
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
}
