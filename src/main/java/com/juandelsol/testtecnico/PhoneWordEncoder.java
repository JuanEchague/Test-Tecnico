package com.juandelsol.testtecnico;

import java.util.Locale;
import java.util.Scanner;

public class PhoneWordEncoder {
     ////////////////////////Atributes///////////////////////////////////////
     private String original;
     private String[] replacements = {"2 ", "22 ", "222 ", "3 ", "33 ", "333 ", "4 ", "44 ", "444 ", "5 ", "55 ", "555 ", "6 ", "66 ", "666 ", "7 ", "77 ", "777 ", "7777 ", "8 ", "88 ", "888 ", "9 ", "99 ", "999 ", "9999 ","0 "};
     private char[] chars;
     //////////////////////////Constructors////////////////////////////////////
 
     public PhoneWordEncoder(String original, String[] replacements, char[] chars) {
         this.original = original;
         this.replacements = replacements;
         this.chars = chars;
     }
     
     public PhoneWordEncoder() {
     }
 
     ////////////////////////////Getters and Setters/////////////////////////////
 
     public String getOriginal() {
         return original;
     }
 
     public void setOriginal(String original) {
         this.original = original;
     }
 
     public String[] getReplacements() {
         return replacements;
     }
 
     public void setReplacements(String[] replacements) {
         this.replacements = replacements;
     }
 
     public char[] getChars() {
         return chars;
     }
 
     public void setChars(char[] chars) {
         this.chars = chars;
     }
 
     ///////////////////////////////Methods/////////////////////////////////////
     public void createString() {
         try (Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US)) {
             System.out.println("Ingrese una frase a codificar: ");
             this.chars = read.next().toLowerCase().toCharArray();
         }
         this.original = "abcdefghijklmnopqrstuvwxyz ";
         System.out.println("El resultado de la codificacion es: "+ encodeText(this.chars, this.original, this.replacements));
         
     }
 
     public String encodeText(char[] chars, String original, String[] replacements) {
         StringBuilder sb = new StringBuilder(chars.length);
         for (char c : chars) {
             int index = original.indexOf(c);
             if (index >= 0) {
                 sb.append(replacements[index]);
             } else {
                 sb.append(c);
             }
         }
         return sb.toString();
     }
     
}
