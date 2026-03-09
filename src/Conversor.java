import java.util.Scanner;

public class Conversor {

    public static void menu(){

        Scanner lectura = new Scanner(System.in);

        int opcion = 0;

        while(opcion != 7){

            System.out.println("***********************************");
            System.out.println("Sea bienvenido al Conversor de Moneda");
            System.out.println("1) USD a ARS");
            System.out.println("2) ARS a USD");
            System.out.println("3) USD a BRL");
            System.out.println("4) BRL a USD");
            System.out.println("5) USD a COP");
            System.out.println("6) COP a USD");
            System.out.println("7) Salir");
            System.out.println("Seleccione una opción:");
            System.out.println("***********************************");

            opcion = lectura.nextInt();

            if(opcion == 7){
                System.out.println("Programa finalizado");
                break;
            }

            System.out.println("Ingrese el valor a convertir:");

            double valor = lectura.nextDouble();

            ConsultaAPI consulta = new ConsultaAPI();

            double resultado = consulta.convertir(opcion, valor);

            System.out.println("Resultado: " + resultado);

        }

    }

}