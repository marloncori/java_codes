import java.util.*;
import java.util.function.*;

public class PredicateInterface {
  static String line = \033[1;36m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\033[0m";
  
  static List<String> langs = Arrays.asList("AIML", "C++", "C", "C#", "Python", "HTML, 
   "CSS", "SQL", "Javascript", "ChatScript", "Prolog", "Rust", "Perl", "Lisp", "Java", 
   "Lua", "Ruby", "Go", "Haskell");
  
  public static void main(String[] args) throws IOException {
    predicateToFilterMethond(langs, line);
    composedPredicateToFilter(langs, line);
  }
}

@Test
public void predicateToFilterMethod(List<String> list, String ln) throws InterruptedException { 
                       //or List.of(...)
   Predicate<String> doesItStartWithL = l -> l.startsWith("L");
   Predicate<String> doesItEndtWithL = m -> m.endsWith("l");
   Predicate<String> doesItContainC = n -> n.contains("C");
   Predicate<String> isItFiveLettersLong = w -> w.length() == 5;
   Consumer<List<String>> displayResult = list -> 
     list.stream().forEach(x -> System.out.println("\n" + ln + "\033[1;32m The filtered programming language\n name was =\033[0m \033[1;34m\'" + x + "\'.\033[0m\n" + ln)); 
     
   displayResult.accept(langs.stream().filter(doesItStartWithL).collect(Collectors.toList()));
   Thread.sleep(1000);
   displayResult.accept(langs.stream().filter(doesItEndWithL).collect(Collectors.toList()));
   Thread.sleep(1000); 
   displayResult.accept(langs.stream().filter(doesItContainC).collect(Collectors.toList()));
   Thread.sleep(1000); 
   displayResult.accept(langs.stream().filter(isItFiveLettersLong).collect(Collectors.toList()));
   Thread.sleep(1000);
}
                                                                                                 
@Test
public void composedPredicateToFilter(List<String> list, String ln) throws InterruptedException {
  
  Predicate<String> doesItEqualIgnoreCaseGo = y -> y.equalsIgnoreCase("Go");
  Predicate<String> doesItEqualPython = z -> z.equals("Python"); 
  Predicate<String> isItLongerThanFour = x -> x.length() > 4;
  Predicate<String> doesItHaveYpsilon = w -> w.contains("y");
  
  String error = "No programming language with the demanded parameters has been found in the list.";
  
  Consumer<String> displayResult = result -> System.out.println("\n" + ln + "\033[1;34m This is the result:" + result + "\033[0m\n" + ln);
  Consumer<String> showMsg = msg -> System.out.println("\n" + ln + "\033[1;36m" + msg + "\033[0m\n" + ln);
  
  displayResult.accept(list.stream()
                       .filter(doesItEqualIgnoreCaseGo.or(doesItEqualPython))
                        .collect(Collectors.toList()));
  Thread.sleep(1000);
  
  List<String> proglangs = Optional.of(list.stream()
                                        .filter(isItLongerThanFour.and(doesItHaveYpsilon))
                                         .collect(Collectors.toList())).orElseGet(() -> showMsg.accept(error));
  displayResult.accept(proglangs);
  Thread.sleep(1000);
}
