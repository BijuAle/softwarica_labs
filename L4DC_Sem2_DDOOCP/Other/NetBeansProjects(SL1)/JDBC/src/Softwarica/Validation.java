/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Softwarica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pawan
 */
public class Validation {
    String patternvalidation;
    Pattern pattern;
    Matcher matcher;
    
    public boolean isNameValid(String name){
        patternvalidation="[A-Z][a-z]+";
        pattern=Pattern.compile(patternvalidation);
        matcher=pattern.matcher(name);
        
        return matcher.matches();
    } 
    
    public boolean isLastNameValid(String lname){
        patternvalidation="[a-z]+";
        pattern=Pattern.compile(patternvalidation);
        matcher=pattern.matcher(lname);
        
        return matcher.matches();
    }
    
    public boolean isPhoneNumberValid(String pnumber){
        patternvalidation="\\d{10}";
        pattern=Pattern.compile(patternvalidation);
        matcher=pattern.matcher(pnumber);
        
        return matcher.matches();
    }
    
    public boolean isEmailValid(String email){
        patternvalidation="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(patternvalidation);
        matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
}
