import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal(){
        Scanner s = new Scanner(System.in);
        int eleccion=0;
        while (eleccion<1 || eleccion>3){
            System.out.println("1.-Jugar");
            System.out.println("2.-Salir");
            eleccion = s.nextInt();
        }
        if (eleccion==1){
            jugar();
        }if (eleccion==2){
            System.out.println("Adios");
        }
    }

    public static void jugar() {
        Scanner t = new Scanner(System.in);
        String[][] matrizCartas=crearMatrizCartas();
        matrizCartas=inicializarCartas();
        String[][] jugador1= new String[3][2];
        String[][] jugador2= new String[3][2];
        int acumulador1=0;
        int acumulador2=0;
        String aux = "0";
        int ganador=0;

        for (int i = 0; i <3 ; i++) {
            if (ganador==0){
                System.out.println("-----------------Jugador 1-------------------");
                System.out.println("Puntaje:"+acumulador1);
                System.out.println(" ingrese algun caracter para coger una carta");
                aux = t.nextLine();
                jugador1[i]=cogerCarta(matrizCartas);
                acumulador1+=Integer.parseInt(jugador1[i][1]);
                if (acumulador1>20){
                    System.out.println("has perdido");
                    ganador=2;
                    System.out.println("el ganador es el jugador2");
                    break;
                }
                System.out.println("-----------------Jugador 2-------------------");
                System.out.println("Puntaje:"+acumulador2);
                System.out.println(" ingrese algun caracter para coger una carta");
                aux = t.nextLine();
                jugador2[i]=cogerCarta(matrizCartas);
                acumulador2+=Integer.parseInt(jugador2[i][1]);
                System.out.println("");
                if (acumulador2>20){
                    System.out.println("has perdido");
                    ganador=2;
                    System.out.println("el ganador es el jugador 1");
                    break;
                }
                System.out.println("---------------------------------------------");
            }
        }
        if ((ganador==0)){
            decisionGanador(acumulador1,acumulador2);
        }
        jugardenuevo();




    }

    private static void jugardenuevo() {
        Scanner t = new Scanner(System.in);
        int jugarDenuevo=0;
        while(jugarDenuevo>2 || jugarDenuevo<1){
            System.out.println("Quieres jugar denuevo?");
            System.out.println("1.-si");
            System.out.println("2.-no");
            jugarDenuevo=t.nextInt();
        }
        if (jugarDenuevo==1){
            jugar();
        }else{
            System.out.println("adios");
        }
    }

    private static void decisionGanador(int acumulador1, int acumulador2){
        if(20-acumulador1>20-acumulador2){
            System.out.println("ha ganado el jugador 2 con"+acumulador2+"pts");
        }else {
            System.out.println("ha ganado el jugador 1 con"+acumulador1+"pts");
        }
    }


    private static String[] cogerCarta(String[][] matrizCartas) {
        int indiceAleatorio=(int) (Math.random()*11);
        System.out.println("La carta es:"+matrizCartas[indiceAleatorio][0]);
        System.out.println(("el puntaje es:"+matrizCartas[indiceAleatorio][1]));
        return matrizCartas[indiceAleatorio];

    }

    private static String[][] inicializarCartas() {
        String[][] matrizCartas = new String[12][2];
        matrizCartas[0]= agregarCarta("As",11);
        matrizCartas[1]= agregarCarta("dos",2);
        matrizCartas[2]= agregarCarta("tres",3);
        matrizCartas[3]= agregarCarta("cuatro",4);
        matrizCartas[4]= agregarCarta("cinco",5);
        matrizCartas[5]= agregarCarta("seis",6);
        matrizCartas[6]= agregarCarta("siete",7);
        matrizCartas[7]= agregarCarta("ocho",8);
        matrizCartas[8]= agregarCarta("nuve",9);
        matrizCartas[9]= agregarCarta("jota",10);
        matrizCartas[10]= agregarCarta("queen",10);
        matrizCartas[11]= agregarCarta("king",10);
        return matrizCartas;
    }

    public static  String[][] crearMatrizCartas(){
        String[][] matrizCartas = new String[12][2];
        return matrizCartas;
    }

    private static String[] agregarCarta(String nombreC, int puntaje) {
        String[] carta = {nombreC,Integer.toString(puntaje)};
        return carta;
    }


}