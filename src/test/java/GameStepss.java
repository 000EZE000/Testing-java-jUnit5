import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

public class GameStepss {


    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    public static final int NUMBER_RANDOM = 3;

    @InjectMocks
    private Game game;
    @Mock
    @InjectMocks
    Scanner scanner;
    @Mock
    Random random;

    private ByteArrayOutputStream out;
    @Before
    public void config(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Given("The user will choose {string}")
    public void theUserWillChoose(String inputs) {
        when(scanner.nextLine()).thenReturn("Scissors").thenReturn("Quit");
    }

    @Given("the computer will choose {string}")
    public void theComputerWillChoose(String arg0) {
        when(random.nextInt(NUMBER_RANDOM)).thenReturn(OPTION_PAPER);
    }

    @When("they play")
    public void theyPlay() {
        game.play();
    }

    @Then("the user wins")
    public void theUserWins() {
        Assert.assertTrue(out.toString().contains("you win!"));
        Assert.assertTrue(out.toString().contains("wins:1"));
    }


}
