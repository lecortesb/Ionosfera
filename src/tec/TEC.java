/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec;
import java.io.*;

/**
 *
 * @author THE MONGREL
 */
public class TEC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena,sub;
        int datos[][],posEs,i,j;
        double lat=87.5;
        datos=new int[71][73];
        int año,mes,dia,hr,min,seg;
        año=2014;
        mes=2;
        dia=14;
        hr=0;
        min=0;
        seg=0;
        try{
            BufferedReader lector=new BufferedReader(new FileReader("E:\\datos\\045\\jplg0450.14i\\datos.14i"));
            do{
                cadena=lector.readLine();
                //System.out.println(""+cadena);
            }while(cadena != null && cadena.contains("START OF TEC MAP") == false);
            cadena=lector.readLine();
            if(cadena !=null){
                //System.out.println(""+cadena);
            }
            //Ya se quito el renglón de la fecha
            cadena=lector.readLine();
            if(cadena !=null){
                //System.out.println(""+cadena);
            }
            //Ya se quito el primer renglon de la latitud y la longitud
            i=0;
            j=0;
            do{
                System.out.println(""+cadena);
                cadena=lector.readLine();//Primera linea de datos
                i=0;
                while(cadena!=null&&cadena.contains("LAT")==false&&cadena.contains("END")==false){//Ya se quito el renglon de la latitud y la longitud
                    //cadena=lector.readLine();//datos
                    if(cadena !=null){
                        //System.out.println(""+cadena);
                        //i=0;
                        posEs=0;
                        while(cadena.charAt(0)==' '){//Quita los espacios del principio
                            cadena=cadena.substring(1);
                        }
                        while(cadena.indexOf(" ", 0)!=-1){
                            //for(i=0;i<15;i++){
                            posEs=cadena.indexOf(" ",0);
                            //System.out.println(""+posEs);
                            sub=cadena.substring(0,posEs);
                            datos[j][i]=Integer.parseInt(sub);
                            System.out.print(";"+datos[j][i]);
                            cadena=cadena.substring(posEs, cadena.length());
                            while(cadena.charAt(0)==' '){//Quita los espacios del principio de la siguiente iteracion
                                cadena=cadena.substring(1);
                            }
                         i++;
                        }
                         /*while(cadena.charAt(0)==' '){
                            cadena=cadena.substring(1);
                        }*/
                        datos[j][i]=Integer.parseInt(cadena);
                        System.out.print(";"+datos[j][i]);
                        i++;
                    }
                    cadena=lector.readLine();
                }
                lat=lat-2.5;
                j++;
                System.out.println("*j="+(j-1)+"i="+i);
            }while(cadena!=null&&cadena.contains("END")==false&&j<71);
            lector.close();
            System.out.println("latitud final:"+lat);
            
            System.out.println("Inicio del arreglo");
            for(j=0;j<71;j++){
                System.out.println("");
                for(i=0;i<73;i++){
                    System.out.print(","+datos[j][i]);
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }
        catch(IOException ee){
            System.out.println("Algo raro pasó al leer el archivo");
        }
    }
    
}
