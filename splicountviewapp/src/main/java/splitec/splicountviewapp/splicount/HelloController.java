package splitec.splicountviewapp.splicount;

import entities.MessageResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import splitec.service.UsuarioService;

public class HelloController {
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSenha;

    @FXML
    protected void onAcessarClick(ActionEvent event) {
        try {
            MessageResponse response = UsuarioService.auth(txtEmail.getText(), txtSenha.getText());
            if (response.isSucess()) {
                HelloApplication.changeScreen("dashboard");
            }
        } catch (Exception e) {

        }
    }
}