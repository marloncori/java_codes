import java.util.*;
import java.util.function.*;

public class OptionalisPresent {
  static String[] words = {"Robotics", "Programming", "Electronics", "Music", "Bible", "Faith", "Love", "Peace", "Health"};

  static String ln = "======================================================\n";
    
  static Function<String, String> showException = y -> y.toUpperCase();
  
  static Consumer<String> display = w -> System.out.println("\n" + ln + "\033[1;36m >>> This is result to be displayed: \n\033[0m \033[1;35m" + w + "\033[0m\n" + ln);
  
  static String errMsg = "\033[1;31m there is no value inside the variable words[2]!!!\033[0m";
  
  static String errMsg2 = "\033[1;30m there is no value inside the variable words[9]!!!\033[0m";
  
  public static void main(String[] args) throws InterruptedException {
    Optional<String> chekNull = Optional.ofNullable(words[2]);
    checkNull.ifPresent().map(x -> x.toUpperCase()).orElseGet(() -> showErrMsg());
    Thread.sleep(1000);
   
    Optional<String> chekNull2 = Optional.ofNullable(words[9]);
    checkNull2.ifPresent().map(x -> x.toUpperCase()).orElseGet(() -> showErrMsg());
    Thread.sleep(1000);
  
    if(checkNull.isPresent(){
      String word = words[2].toUpperCase();
      display.accept(word);
      Thread.sleep(1000);
    } else {
      display.accept(showException.apply(errMsg));
      Thread.sleep(1000);
    }
       
    if(checkNull2.isPresent(){
      String word2 = words[9].toUpperCase();
      display.accept(word2);
      Thread.sleep(1000);
    } else {
      display.accept(showException.apply(errMsg2));
      Thread.sleep(1000);
    }
  }
  
  public static String showErrMsg(){
    String errMsg = "\033[1;32m [ NULL ERROR ] There is no value in the variable words[9]\033[0m";
    return errMsg;
  }
}
