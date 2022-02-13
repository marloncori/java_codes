import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class FunctionInterface {
  static List<String> myNames = Arrays.asList("Marlon", "Lazaro", "Laura", "Teresa Cristina", "Maria Claro", "Mateus", "Geysa", "Beniamin", "Miguel");

  public static void main(String[] args) throws InterruptedException {
    Analyser checker = new Analyser(myNames);
    Thread.sleep(3000);
    checker.showList();
    checker.showResult();
  }
}

public class Analyser {
   String ln = "\033[1;31m+++++++++++++++++++++++++++++++++++++\033[0m";
   
   List<Integer> lengths;
  
   List<String> names = new ArrayList<>();
  
   Function<String, Integer> nameMappingByLength = String::length;
  
   Consumer<List<String>> displayNames; 
  
   Consumer<List<Integer>> displayNumbers;
  
    Analyser(List<String> names){
     this.names = names;
     System.out.println("\n Starting the application in 3 seconds..."); 
    }
  
     public List<Integer> getNameLengths()
       lengths = List.of(names.stream().map(nameMappingByLength).collection(Collectors.toList()));
       return lengths;
     }

     public showList() throws InterruptedException {
       displayNames = l -> l.stream().forEach(n -> System.out.println("\n" + ln + "\033[1;34m The list name is: " + n +".\033[0m\n" + ln));
       displayNames.accept(names);
       Thread.sleep(1000);
     }
    
     public showResult() throws InterruptedException {
       displayNumbers = m -> m.stream().forEach(i -> System.out.println("\n" + ln + "\033[1;36m The list number is: " + i +".\033[0m\n" + ln));
       displayNumbers.accept(getNameLengths);
       Threads.sleep(1000);
     }
}
