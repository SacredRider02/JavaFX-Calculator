package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label show;
    private int number1;
    private String operator = "";
    private boolean start = true;
    private Source source = new Source();

    public void processNumbers(ActionEvent event) {
        if (start == true){
            show.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        show.setText(show.getText()+value);
    }

    public void processOperators(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        operator = value;
        if (!value.equals("=")){
            if (value.isEmpty()){
                return;
            }

            number1 = Integer.parseInt(show.getText());
            show.setText("");
        }
        else {
            if (value.isEmpty()){
                return;
            }
            int number2 = Integer.parseInt(show.getText());
            int result = source.calculate(number1, number2, operator);
            show.setText(String.valueOf(result));
            operator = "";
            number1=0;
            number2=0;
            start=true;
        }
    }
}
