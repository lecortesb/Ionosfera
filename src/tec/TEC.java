/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec;
import java.io.*;

/**
 *
 * @author LASALLE
 */
public class TEC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena,sub;
        int datos[],posEs,i;
        datos=new int[73];
        try{
            BufferedReader lector=new BufferedReader(new FileReader("E:\\datos\\045\\jplg0450.14i\\datos.14i"));
            do{
                do{
                    cadena=lector.readLine();
                    //System.out.println(""+cadena);
                }while(cadena != null && cadena.contains("START OF TEC MAP") == false);
                cadena=lector.readLine();
                if(cadena !=null){
                    System.out.println(""+cadena);
                }
                cadena=lector.readLine();
                if(cadena !=null){
                    System.out.println(""+cadena);
                }
                cadena=lector.readLine();//datos
                if(cadena !=null){
                    for(i=0;i<15;i++){
                        while(cadena.charAt(0)==' '){
                            cadena=cadena.substring(1);
                        }
                        posEs=cadena.indexOf(" ",0);
                        //System.out.println(""+posEs);
                        sub=cadena.substring(0,posEs);
                        datos[i]=Integer.parseInt(sub);
                        System.out.println(""+datos[i]);
                        cadena=cadena.substring(posEs, cadena.length());
                    }
                    while(cadena.charAt(0)==' '){
                        cadena=cadena.substring(1);
                    }
                    datos[i]=Integer.parseInt(cadena);
                    System.out.println(""+datos[i]);
                }
            }while(cadena!=null);
            lector.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }
        catch(IOException ee){
            System.out.println("Algo raro pasó al leer el archivo");
        }
    }
    
}
