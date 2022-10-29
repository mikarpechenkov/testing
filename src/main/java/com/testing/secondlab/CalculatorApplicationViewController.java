package com.testing.secondlab;

import com.testing.secondlab.interfaces.CalculatorPresenter;
import com.testing.secondlab.interfaces.CalculatorView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorApplicationViewController implements CalculatorPresenter, CalculatorView {
    @FXML
    private TextField outputField;

    @FXML
    private Label infoLabel;

    private String expression = "";

    private CalculatorApplicationModel model = new CalculatorApplicationModel();

    private boolean checkInformEmptyField() {
        boolean result = expression.isEmpty();
        if (result)
            displayError("Выражение не корректно");
        return result;
    }

    private boolean checkInformOperatorPresence() {
        boolean result = Pattern.compile("[\\+\\-\\*\\/]").matcher(expression).find();
        if (result)
            displayError("Допустим только один оператор");
        return result;
    }

    private void changeInfoMessage() {
        String standardMessage = "Все супер!";
        if (!getInfoLabelText().equals(standardMessage))
            displayError(standardMessage);
    }

    @Override
    public void onPlusClicked() {
        changeInfoMessage();
        if (!checkInformOperatorPresence() && !checkInformEmptyField()) {
            expression += "+";
            printResult(expression);
        }
    }

    @Override
    public void onMinusClicked() {
        changeInfoMessage();
        if (!checkInformOperatorPresence() && !checkInformEmptyField()) {
            expression += "-";
            printResult(expression);
        }
    }

    @Override
    public void onDivideClicked() {
        changeInfoMessage();
        if (!checkInformOperatorPresence() && !checkInformEmptyField()) {
            expression += "/";
            printResult(expression);
        }
    }

    @Override
    public void onMultiplyClicked() {
        changeInfoMessage();
        if (!checkInformOperatorPresence() && !checkInformEmptyField()) {
            expression += "*";
            printResult(expression);
        }
    }

    public void onEqualsClicked() {
        changeInfoMessage();
        Matcher matcher = Pattern.compile("[\\+\\-\\*\\/]").matcher(expression);
        String operator = "";
        if (matcher.find())
            operator = matcher.group();
        if (!operator.isEmpty()) {
            double result = 0.0;
            try {
                double firstArgument = Double.parseDouble(getFirstArgumentAsString()),
                secondArgument = Double.parseDouble(getSecondArgumentAsString());
                switch (operator) {
                    case "+" -> result = model.sum(firstArgument, secondArgument);
                    case "-" -> result = model.subtract(firstArgument, secondArgument);
                    case "/" -> result = model.divide(firstArgument, secondArgument);
                    case "*" -> result = model.multiply(firstArgument, secondArgument);
                }
                expression = String.valueOf(result);
                printResult(result);
            } catch (NumberFormatException ex){
                displayError("Неверный формат числа");
            }
            catch (Exception ex) {
                displayError(ex.getMessage());
            }
        }
    }

    public void onDeleteClicked() {
        changeInfoMessage();
        if (!expression.isEmpty()) {
            expression = expression.substring(0, expression.length() - 1);
            printResult(expression);
        }
    }

    public void onClearClicked() {
        changeInfoMessage();
        expression = "";
        printResult(expression);
    }

    public void onDotClicked() {
        String argument = Pattern.compile("[\\+\\-\\*\\/]").matcher(expression).find() ? getSecondArgumentAsString() : getFirstArgumentAsString();
        if (!Pattern.compile("\\.").matcher(argument).find()) {
            expression += ".";
            printResult(expression);
        } else
            displayError("Дробная часть уже определена");
    }

    @FXML
    public void onNumbersClicked(@NotNull MouseEvent event) {
        changeInfoMessage();
        expression += ((Node) event.getSource()).getUserData().toString();
        printResult(expression);
    }

    @Override
    public void printResult(double result) {
        outputField.setText(String.valueOf(result));
    }

    public void printResult(String expression) {
        outputField.setText(expression);
    }

    @Override
    public void displayError(String message) {
        infoLabel.setText(message);
    }

    public String getInfoLabelText() {
        return infoLabel.getText();
    }

    @Override
    public String getFirstArgumentAsString() {
        return outputField.getText().split("[\\+\\-\\*\\/]")[0];
    }

    @Override
    public String getSecondArgumentAsString() {
        String[] expression = outputField.getText().split("[\\+\\-\\*\\/]");
        if (expression.length == 2)
            return expression[1];
        else
            return "";
    }
}