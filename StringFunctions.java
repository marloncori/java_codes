import java.io.*;
import java.util.*;

public class StringFunctions 
{
     static String str1 = "       Jesus is  my Lord!       ";
     static String str2 = "      Learning Java is needed!      ";
     final static int val = 77;
    
     static String str3 = "       C++ and Python are both import proglangs.       ";
     static String str4 = "       C++ and Python are both import proglangs.       ";
     final static int num = 33;
    
     public static void main(String args[])
     {
       StringAnaliser(str1, str2, val);
       StringAnaliser(str3, str4, num);
     
     }

static public void StringAnaliser(String word1, String word2, int num)
{
   String line = "\033[1;32m=================================================\033[0m";
   String line2 = "\033[1;34m=================================================\033[0m";
   
    System.out.println("\n" + line2);
    System.out.println("\n The length of WORD1 = " + word1.length());
    System.out.println("\n The length of WORD1 = " + word2.length());
    System.out.println(line2);
    
   if(word1.equals(word2))
   { 
    System.out.println("\n" + line);
    System.out.println("\033[1;33m>> The var \'word1\' is equal to var \'word2\'! <<\033[0m");
    System.out.println("  And their contents is: " + word1);
    System.out.println(line);
   } else {
    System.out.println(line2);
    System.out.println("\033[1;33m>> The var \'word1\' is NOT equal to var \'word2\'! <<\033[0m");
    System.out.println(."  ---> word1 = " + word1 + "\n and --> word2 = " + word2);
    System.out.println(line2);
   }
   
   
   if(word1.contains("Jesus"))
   { 
    System.out.println("\n" + line);
    System.out.println("\033[1;30m>> And the Lord is coming back soon, so be ready for his arrival! <<\033[0m");
    System.out.println(line);
   } else if(word1.contains("C++")){
    System.out.println(line2);
    System.out.println("\033[1;30m>> Actually, C++ syntanx reminds of Java a little bit. They may be then related <<\033[0m");
    System.out.println("  ---> word1 = " + word1 + "\n and --> word2 = " + word2);
    System.out.println(line2);
   } else {
     System.out.println(line);
     System.out.println(line2);
   }
   
    String word0 = word1.toUpperCase();
    if(word2.equalsIgnoreCase(word2))
   {
    System.out.println(line2);
    System.out.println("\033[1;35m>> The var \'word1\' is equal to var \'word2\'! <<\033[0m");
    System.out.println("  And their contents is: " + word1);
    System.out.println(line2);
   }  else {
    System.out.println(line);
    System.out.println("\033[1;35m>> Now the var \'word1\' is NOT equal to var \'word2\'! <<\033[0m");
    System.out.println("  ---> word1 = " + word1 + "\n and --> word2 = " + word2);
    System.out.println(line);
   }
   
    String word = word0.toLowerCase();
    System.out.println("\n" + line2);
    System.out.println("\033[1;34m>> This was \'word1\' in upper case: " + word0 + ".\033[0m");
    System.out.println("\033[1;31m>> And this is \'word1\' back to lower case: " + word + ".\033[0m");
    System.out.println(line2);
    
    String word3 = word1.trim();
    System.out.println("\n" + line);
    System.out.println("\033[1;36m>> This is \'word1\' after trimming: " + word3 + ".\033[0m");
    System.out.println(line);
    
    String word4 = word2.stripLeading();
    System.out.println("\n" + line2);
    System.out.println("\033[1;31m>> This is \'word2\' after stripLeading: " + word4 + ".\033[0m");
    System.out.println(line2);
    
    String word5 = word1.stripTrailing();
    System.out.println("\n" + line);
    System.out.println("\033[1;33m>> This is \'word1\' after stripTrailing: " + word5 + ".\033[0m");
    System.out.println(line);
    
    String word8 = word2.strip();
    System.out.println("\n" + line);
    System.out.println("\033[1;33m>> This is \'word2\' after stripping: " + word5 + ".\033[0m");
    System.out.println(line);
    
    char char1 = word2.charAt(4);
    char char2 = word1.charAt(5);
    
    System.out.println("\n" + line2);
    System.out.println("\033[1;34m>> This is char at word1\'s index 5: " + char2 + ".\033[0m");
    System.out.println(line2);
    
    System.out.println("\n" + line);
    System.out.println("\033[1;35m>> And this is char at word2\'s index 4: " + char1 + ".\033[0m");
    System.out.println(line);
    
    int index = word1.indexOf("a");
    System.out.println("\n" + line2);
    System.out.println("\033[1;30m>> And this is index of \'a\' in word1 variable: " + index + ".\033[0m");
    System.out.println(line2);
    
    String number = Integer.toString(num);
    System.out.println("\n" + line);
    System.out.println("\033[1;33m>> This is the int converted to String: " + number + ".\033[0m");
    System.out.println(line);
    
    String word7 = word5.concat(number);
    System.out.println("\n" + line2);
    System.out.println("\033[1;34m>> This is the var \1word5 concatenated with number:\n " + word7 + ".\033[0m");
    System.out.println(line2);
  }
}
