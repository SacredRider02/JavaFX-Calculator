package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class Controller {

    @FXML
    private Label show;
    private int number1;
    private String operator = "";
    private boolean start = true;
    private Source source = new Source();


    public void processNumbers(ActionEvent event) {
        if (start){
            show.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        show.setText(show.getText()+value);
    }

    public void processOperators(ActionEvent event) {
        if (start){
            show.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        if (value.charAt(0) != "=".charAt(0)){
            if (value.equals("C")){
                operator = "";
                number1 = 0;
                show.setText("");
                start = true;
            }
            else if (operator.isEmpty()){
                number1 = Integer.parseInt(show.getText());
                operator = value;
                show.setText("");
            }

        }
        else {
            if (operator.isEmpty()){
                if (number1 == 0){
                    show.setText("");
                    return;
                }
                else{
                    number1 = Integer.parseInt(show.getText());
                    show.setText(String.valueOf(number1));
                }
            }
            else{
                int number2 = Integer.parseInt(show.getText());
                String result = String.valueOf(source.calculate(number1, number2, operator));
                show.setText(result);
                operator = "";
                number1= Integer.parseInt(result);
            }
        }
    }

    public void sqrt(ActionEvent event) {
        number1 = Integer.parseInt(show.getText());
        show.setText(String.valueOf(Math.sqrt((double) number1)));
    }
}
