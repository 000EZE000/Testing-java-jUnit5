import java.math.BigDecimal;

public class MoneyUtil {

    public static String format(double dinner){
      return  format(dinner, "$");
    }

    public static String format(double dinner ,String symbol){
        if(symbol == null) throw new IllegalArgumentException();
        if(dinner < 0){
            symbol = "-" + symbol;
            dinner = dinner * (-1);
        }
        BigDecimal dinnerAddDecimal = BigDecimal.valueOf(dinner).setScale(2, BigDecimal.ROUND_HALF_UP);
        return  symbol + dinnerAddDecimal;
    }

}
