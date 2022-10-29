package com.testing.secondlab;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

public class CalculatorApplicationViewControllerTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("calculator.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @After
    public void tearDown()throws Exception{
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testNumber0(){
        clickOn("#number0");
        Assertions.assertEquals("0",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testNumber1(){
        clickOn("#number1");
        Assertions.assertEquals("1",lookup("#outputField").queryAs(TextField.class).getText());
    }


    @Test
    public void testNumber2(){
        clickOn("#number2");
        Assertions.assertEquals("2",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testNumber3(){
        clickOn("#number3");
        Assertions.assertEquals("3",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testNumber4(){
        clickOn("#number4");
        Assertions.assertEquals("4",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testNumber5(){
        clickOn("#number5");
        Assertions.assertEquals("5",lookup("#outputField").queryAs(TextField.class).getText());
    }


    @Test
    public void testNumber6(){
        clickOn("#number6");
        Assertions.assertEquals("6",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testNumber7(){
        clickOn("#number7");
        Assertions.assertEquals("7",lookup("#outputField").queryAs(TextField.class).getText());
    }


    @Test
    public void testNumber8(){
        clickOn("#number8");
        Assertions.assertEquals("8",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testNumber9(){
        clickOn("#number9");
        Assertions.assertEquals("9",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testDelete(){
        clickOn("#number1");
        clickOn("#number2");
        clickOn("#deleteButton");
        Assertions.assertEquals("1",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testClear(){
        clickOn("#number1");
        clickOn("#number2");
        clickOn("#number3");
        clickOn("#clear");
        Assertions.assertEquals("",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testDot(){
        clickOn("#number1");
        clickOn("#dotButton");
        Assertions.assertEquals("1.",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testMultiply(){
        clickOn("#number4");
        clickOn("#multiplyButton");
        clickOn("#number2");
        Assertions.assertEquals("4*2",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testDivide(){
        clickOn("#number4");
        clickOn("#divideButton");
        clickOn("#number2");
        Assertions.assertEquals("4/2",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testPlus(){
        clickOn("#number4");
        clickOn("#plusButton");
        clickOn("#number2");
        Assertions.assertEquals("4+2",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testMinus(){
        clickOn("#number8");
        clickOn("#minusButton");
        clickOn("#number2");
        Assertions.assertEquals("8-2",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testEquals(){
        clickOn("#number4");
        clickOn("#multiplyButton");
        clickOn("#number2");
        clickOn("#equalsButton");
        Assertions.assertEquals("8.0",lookup("#outputField").queryAs(TextField.class).getText());
    }

    @Test
    public void testInfoLabel(){
        clickOn("#number1");
        clickOn("#divideButton");
        clickOn("#number0");
        clickOn("#equalsButton");
        Assertions.assertEquals("Делить должен быть больше",lookup("#infoLabel").queryAs(Label.class).getText());
    }
}