package com.diana;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        try {
            //preguntamos a Cristina cuantos alumnos juegan
            System.out.println("Cuantos alumnos juegan?");
            int N = leer.nextInt();//ALUMNOS

            //preguntamos a Cristina cuantos bombones
            System.out.println("Cuantos bombones maximo tendra cada alumno?");
            int M = leer.nextInt();//BOMBONES

            //creamos el HashMap
            HashMap<String, Integer> hashMapAlumnosBombones = new HashMap<String, Integer>();

            //generamos numeros aleatorios
            Random randomObject = new Random();
            int upperbound = M + 1;
            //generate random values from 0-M
            int numeroAleatorio = randomObject.nextInt(upperbound);

            //el archivo que queremos leer
            String pwd = System.getProperty("user.dir");//ruta directorio actual de trabajo
            File archivoParticipantes = new File(pwd + File.separator + "participants.csv");//esta es la ruta relativa que funciona en linux y en Windows

            //leemos el fichero CSV
            Scanner sc = new Scanner(new File(archivoParticipantes.getAbsolutePath()));
            sc.useDelimiter(",");   //ponemos , como delimitador
            for (int i = 0; i < N; i++) {
                hashMapAlumnosBombones.put(sc.nextLine(), numeroAleatorio);//Anadimos los nombres y un numero aleatorio al HashMap
            }
            sc.close();  //cerramos scanner
            String limpiarScanner = leer.nextLine();//limpiamos el Scanner XD
            //System.out.println(hashMapAlumnosBombones); para ver que contiene el HashMap

            System.out.println("Cristina, dime el nombre de un alumno");
            String nombreAlumno = leer.nextLine();

            if (hashMapAlumnosBombones.containsKey(nombreAlumno)) {//si el HashMap contiene esta clave(nombreAlumno)
                hashMapAlumnosBombones.get(nombreAlumno);//me devuelve cuantos bombones le corresponden
            } else
                throw new NoHayBombonesParaTi("Sorry! No hay bombones para esta persona.");//si no hay este alumno en el HashMap me sale este error


        } catch (Exception ex) {//manejamos excepciones predefinidas
            ex.printStackTrace();
        } finally {
            leer.close(); //cerramos el primer scanner
        }
    }
}
