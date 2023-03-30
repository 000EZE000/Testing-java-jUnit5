import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzTest {

    List<String> list;
    public static final String BUZZ = "buzz";
    public static final String FIZZ = "fizz";
    @Before
    public void before(){
        list = new FizzBuzz().run();
    }

    @Test
    public void returnOfNumberOne(){
        List<String> listTest = new ArrayList<>();
        listTest.add("1");
        Assert.assertEquals(listTest.get(0), list.get(0));
    }
    @Test
    public void lengthOfList(){
        Assert.assertEquals(100,list.size());
    }

    @Test
    public void numbersPeers(){

        Assert.assertEquals("2",list.get(1));
        Assert.assertEquals("4",list.get(3));
        Assert.assertEquals("74",list.get(73));
        Assert.assertEquals("56",list.get(55));

    }
    @Test
    public void fizzShouldAppear(){

        Assert.assertEquals(FIZZ,list.get(2));
    }
    @Test
    public void testingTheNumber99(){

        Assert.assertEquals(FIZZ,list.get(98));
    }

    @Test
    public void buzzShouldAppear(){

        Assert.assertEquals(BUZZ,list.get(4));
    }

    @Test
    public void testingTheNumber64(){

        Assert.assertEquals(BUZZ,list.get(64));
    }
    @Test
    public void fizzBuzzShouldAppear(){

        Assert.assertEquals(FIZZ + BUZZ,list.get(14));
    }

    @Test
    public void testingTheNumber30(){

        Assert.assertEquals(FIZZ + BUZZ,list.get(29));
    }
}
