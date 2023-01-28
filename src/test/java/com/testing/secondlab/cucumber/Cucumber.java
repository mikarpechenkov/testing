package com.testing.secondlab.cucumber;

import com.testing.secondlab.CalculatorApplication;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

public class Cucumber extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        stage.show();
        sleep(1000);
    }

    @Before
    public void before() throws Exception {
        ApplicationTest.launch(CalculatorApplication.class);
    }

    @Given("that {string} exists")
    public void that_exists(String fxElementID) {
        try {
            Assertions.assertNotNull(lookup("#" + fxElementID).query());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @When("expression is {double} {string} {double}")
    public void expressionIs(Double firstArgument, String operator, Double secondArgument) {
        inputNumber(firstArgument);
        inputOperator(operator);
        inputNumber(secondArgument);
    }

    @When("click {string} button")
    public void clickOnButton(String fxElementID) {
        try {
            clickOn("#" + fxElementID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("answer is {double}")
    public void answerIs(Double answer) {
        try {
            Assertions.assertEquals(String.valueOf(answer), lookup("#outputField").queryAs(TextField.class).getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("answer is {string}")
    public void answerIs(String answer) {
        try {
            Assertions.assertEquals(answer, lookup("#outputField").queryAs(TextField.class).getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("information message is {string}")
    public void infoMessageIs(String infoMessage) {
        try {
            Assertions.assertEquals(infoMessage, lookup("#infoLabel").queryAs(Label.class).getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void inputNumber(double number) {
        try {
            for (char partOfNumber : String.valueOf(number).toCharArray())
                if (Character.isDigit(partOfNumber))
                    clickOn("#number" + partOfNumber);
                else
                    clickOn("#dotButton");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void inputOperator(String operator) {
        try {
            switch (operator) {
                case "plus" -> clickOn("#plusButton");
                case "minus" -> clickOn("#minusButton");
                case "divide" -> clickOn("#divideButton");
                case "multiply" -> clickOn("#multiplyButton");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
