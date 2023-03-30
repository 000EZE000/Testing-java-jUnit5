import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final String BUZZ = "buzz";
    public static final String FIZZ = "fizz";

    public List<String> run (){
   List<String> listNumberUpTo100 = new ArrayList<>();
   for (int i = 1 ; i < 101 ; i++){
       listNumberUpTo100.add(
               (i % 3) == 0 && (i % 5) == 0 ?  FIZZ + BUZZ:
                       (i % 3) == 0 ?  FIZZ  :
                               (i % 5) == 0 ? BUZZ
                                       : (i +"") ) ;

  }

   return listNumberUpTo100;
    }
}
