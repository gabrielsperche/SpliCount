package splitec.splicountviewapp.splicount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import splitec.service.Service;

import java.io.IOException;

public class HelloController {

    @FXML
    private Stage stage = new Stage();
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSenha;

    @FXML
    protected void onAcessarClick(ActionEvent event) {

        try {
            Service.auth(txtEmail.getText(), txtSenha.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DashBoard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}