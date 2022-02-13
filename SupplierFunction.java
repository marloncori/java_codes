import java.util.*;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;

public class SupplierFunction {
  static String line1 = "\033[1;31m--------------------------------------------------------------\033[0m";  
  static String line2 = "\033[1;30m==============================================================\033[0m";
    
  public static void main(String[] args) throws IOException {
    supplier(line1);
    optionalSupplier(line2);
  }
}

public int generateRandom() {
  int intRand = ThreadLocalRandom.current().nextInt(min, max + 1);
  return intRand;
}

public long generateLong() {
   long leftLimit = 1L;
   long rightLimit = 10L;
   long randLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
  return randLong;
}

@Test
public void supplier(String ln) {
  Supplier<Double> doubleSupplierOne = () -> Math.random();
  DoubbleSupplier doubleSupplerTwo = Math::random;
  IntSupplier integerSupplier = generateRandom();
 
  try {
    System.out.println("\n" + ln);
    System.out.println("\033[1;33m >>> doubleSupplierOne.get() = " + doubleSupplierOne.get() + ".\033[0m");
    Thread.sleep(1000);
    System.out.println("\033[1;34m >>> doubleSupplierTwo.getAsDouble() = " + doubleSupplierOne.getAsDouble() + ".\033[0m");
    Thread.sleep(1000);
    System.out.println("\033[1;35m >>> integerSupplier.getAsInt() = " + doubleSupplierOne.getAsInt() + ".\033[0m");
    Thread.sleep(1000);
    System.out.println(ln);
  }catch(InterruptedException e){
    e.printStackTrace();
  }
}

@Test
public void optionalSupplier(String ln) {
  Supplier<Long> longNumSupplier = () -> generateLong();
  Optional<Long> optionalNumber = Optionnal.empty();
  
   try{
     System.out.println("\n" + ln);
     System.out.println("\033[1;32m optionalNumber.orElseGet(longNumSupplier) = " + optionalNumber.orElseGet(longNumSupplier));
     System.out.println(ln);
     Thread.sleep(1000);
   }catch(InterruptedException e){
    e.printStackTrace();
  }
}
