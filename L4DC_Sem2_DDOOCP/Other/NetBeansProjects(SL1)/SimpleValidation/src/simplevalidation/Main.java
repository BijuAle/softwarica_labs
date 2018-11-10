/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplevalidation;

/**
 *
 * @author NCC
 */
public class Main {
    public static void main(String[] args)throws Exception {
        String full_name;
        IO.printMessage("Enter Full Name : ");
        full_name=IO.readString();
        if(isFullName(full_name)==true){
            IO.printMessage("---------------------------------");
            IO.newLine();
            IO.printMessage("Full Name : "+full_name);
            IO.newLine();  
            IO.printMessage("---------------------------------");
            IO.newLine();
        }
        else{
            IO.printMessage("Error: invalide full name");
            IO.newLine();
        }
    }
    public static boolean isFullName(String full_name){
        full_name=full_name.toUpperCase();//RAJESH
        IO.printMessage("1."+full_name);
        IO.newLine();
        int MAX=full_name.length();
        IO.printMessage("2."+MAX);        
        IO.newLine();
        char chs[]=new char[MAX];
        full_name.getChars(0, MAX, chs, 0);
        IO.printMessage("3."+chs.length);
        IO.newLine();
        for(int i=0; i<MAX; i++){
            IO.printMessage(""+chs[i]+" -> "+ (int)chs[i]+" ");
            IO.newLine();
        }       
        for(int i=0; i<MAX; i++){
            if(((int)chs[i]<65) && ((int)chs[i]>90))
                return(false)
        }
        return(res);
    }
}
