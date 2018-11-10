/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplevalidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
	public static String readString()throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		return(br.readLine());
	}
	public static int readInteger()throws IOException{
		return(Integer.parseInt(readString()));
	}
	public static void printMessage(String label){
		System.out.print(label);
	}
	public static void printMessage(String label, int num){
		System.out.print(label+ " : "+num);
	}
	public static void newLine(){
		System.out.println();
	}
}