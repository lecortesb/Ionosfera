/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author THE MONGREL
 */
public class TEC {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int año,d,i;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Escriba el año que desea guardar");
        año=entrada.nextInt();
        if(año%4==0){
            d=366;
        }
        else{
            d=365;
        }
        for(i=1;i<=d;i++){
            proceso(año,i);
        }
        
    }
    
    public static void proceso(int a,int d){
        String cadena,sub;
        int datos[][][],posEs,i,j,k;
        double lat=87.5;
        datos=new int[13][71][73];
        int año,mes,dia,hr,min,seg,feb;
        boolean ban=false,bisiesto=false,nuevoarchivo;
        año=a;
        if(año%4==0){
            bisiesto=true;
            feb=29;
        }
        else{
            feb=28;
        }
        if(d<=31){
            dia=d;
            mes=1;
        }
        else{
                if(31<d&&d<=31+feb){
                    mes=2;
                    dia=d-31;
                }
                else{
                    if(31+feb<d&&d<=31+feb+31){
                        mes=3;
                        dia=d-(31+feb);
                    }
                    else{
                        if(31+feb+31<d&&d<=31+feb+31+30){
                            mes=4;
                            dia=d-(31+feb+31);
                        }
                        else{
                            if(31+feb+31+30<d&&d<=31+feb+31+30+31){
                                mes=5;
                                dia=d-(31+feb+31+30);
                            }
                            else{
                                if(31+feb+31+30+31<d&&d<=31+feb+31+30+31+30){
                                    mes=6;
                                    dia=d-(31+feb+31+30+31);
                                }
                                else{
                                    if(31+feb+31+30+31+30<d&&d<=31+feb+31+30+31+30+31){
                                        mes=7;
                                        dia=d-(31+feb+31+30+31+30);
                                    }
                                    else{
                                        if(31+feb+31+30+31+30+31<d&&d<=31+feb+31+30+31+30+31+31){
                                            mes=8;
                                            dia=d-(31+feb+31+30+31+30+31);
                                        }
                                        else{
                                            if(31+feb+31+30+31+30+31+31<d&&d<=31+feb+31+30+31+30+31+31+30){
                                                mes=9;
                                                dia=d-(31+feb+31+30+31+30+31+31);
                                            }
                                            else{
                                                if(31+feb+31+30+31+30+31+31+30<d&&d<=31+feb+31+30+31+30+31+31+30+31){
                                                    mes=10;
                                                    dia=d-(31+feb+31+30+31+30+31+31+30);
                                                }
                                                else{
                                                    if(31+feb+31+30+31+30+31+31+30+31<d&&d<=31+feb+31+30+31+30+31+31+30+31+30){
                                                        mes=11;
                                                        dia=d-(31+feb+31+30+31+30+31+31+30+31);
                                                    }
                                                    else{
                                                        mes=12;
                                                        dia=d-(31+feb+31+30+31+30+31+31+30+31+30);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        }
        hr=0;
        min=0;
        seg=0;
        try{
            String dd="";
            if(d<10){
                dd=dd+"0";
            }
            if(d<100){
                dd=dd+"0";
            }
            System.out.println("Archivo a buscar:D:\\"+año+"\\jplg"+dd+d+"0."+año%100+"i\\jplg"+dd+d+"0."+año%100+"i");
            BufferedReader lector=new BufferedReader(new FileReader("D:\\"+año+"\\jplg"+dd+d+"0."+año%100+"i\\jplg"+dd+d+"0."+año%100+"i"));
            k=0;
            do{
                //System.out.println("K="+k);///////////////////////////////////
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
                //System.out.println(""+cadena);/////////////////////////////////////////////////////////////////////
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
                            datos[k][j][i]=Integer.parseInt(sub);
                            //System.out.print(";"+datos[k][j][i]);////////////////////////////////////////////////////
                            cadena=cadena.substring(posEs, cadena.length());
                            while(cadena.charAt(0)==' '){//Quita los espacios del principio de la siguiente iteracion
                                cadena=cadena.substring(1);
                            }
                         i++;
                        }
                         /*while(cadena.charAt(0)==' '){
                            cadena=cadena.substring(1);
                        }*/
                        datos[k][j][i]=Integer.parseInt(cadena);
                        //System.out.print(";"+datos[k][j][i]);///////////////////////////////////////////////////////////
                        i++;
                    }
                    cadena=lector.readLine();
                }
                lat=lat-2.5;
                j++;
                //System.out.println("*j="+(j-1)+"i="+i);///////////////////////////////////////////////////////////////////
            }while(cadena!=null&&cadena.contains("END")==false&&j<71);
            k++;
            }while(cadena!=null);
            lector.close();
            //System.out.println("latitud final:"+lat);
            
            //System.out.println("Inicio del arreglo");////////////////////////////////////////////////////////////////////
            for(k=0;k<13;k++,hr=hr+2){
                //System.out.println("Hora="+hr+" min="+min+" seg="+seg);////////////////////////////////////////////////
                for(j=0;j<71;j++){
                    //System.out.println("Latitud="+(87.5-(2.5*j)));///////////////////////////////////////////////////
                    for(i=0;i<73;i++){
                        //System.out.print(","+datos[k][j][i]);///////////////////////////////////////////
                    }
                    //System.out.println("");//////////////////////////////////////////////////////
                }
            }
            //El último renglón es el primer renglón del siguiente día
        }
        catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
            ban=true;
        }
        catch(IOException ee){
            System.out.println("Algo raro pasó al leer el archivo");
            ban=true;
        }
        
        if (ban==false){
            nuevoarchivo=false;
            BufferedReader lector2;
            try{
                lector2=new BufferedReader(new FileReader("D:\\datos\\BBDD"+año+".csv"));
                lector2.close();
            }
            catch(FileNotFoundException e){
                nuevoarchivo=true;
            }
            catch(IOException eee){
            }
            try{
                BufferedWriter escritor;
                if(nuevoarchivo){
                    escritor=new BufferedWriter(new FileWriter("D:\\datos\\BBDD"+año+".csv"));
                    escritor.write("year,month,day,hr,min,seg,lat,lon,TEC");
                }
                else{
                    escritor=new BufferedWriter(new FileWriter("D:\\datos\\BBDD"+año+".csv",true));
                }
                
                for(k=0;k<12;k++){
                    for(j=0;j<71;j++){
                        for(i=0;i<73;i++){
                            escritor.newLine();
                            escritor.write(año+","+mes+","+dia+","+(0+(k*2))+","+min+","+seg+","+(87.5-(2.5*j))+","+(-180+(5*i))+","+datos[k][j][i]);
                        }
                    }
                }
                escritor.close();
            }
            catch(FileNotFoundException e){
                System.out.println("\nError no esperado");
            }
            catch(IOException ee){
                System.out.println("\nNo se pudo crear el archivo");
            }
        }
    }
    
}
