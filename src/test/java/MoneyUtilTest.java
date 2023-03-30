import org.junit.Assert;
import org.junit.Test;

public class MoneyUtilTest {
    @Test
    public void testDecimal(){
        String money = MoneyUtil.format(1000);
        Assert.assertEquals("$1000.00",money);
    }
    @Test
    public void negativeDecimal(){
        String money = MoneyUtil.format(-1000);
        Assert.assertEquals("-$1000.00",money);
    }

    @Test
    public void addEuroDecimal(){
        String money = MoneyUtil.format(-1000, "€");
        Assert.assertEquals("-€1000.00",money);
    }
    @Test(expected = IllegalArgumentException.class)
    public void notNullExceptionDecimal(){
      MoneyUtil.format(-1000, null);

    }
}
