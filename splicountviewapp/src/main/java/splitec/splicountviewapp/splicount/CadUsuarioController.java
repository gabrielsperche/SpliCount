package splitec.splicountviewapp.splicount;

import entities.MessageResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import splitec.service.UsuarioService;

public class CadUsuarioController {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSenha;

    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        try {
            MessageResponse response = UsuarioService.createUser(txtEmail.getText(), txtSenha.getText(), txtNome.getText());
            if (response.isSucess()) {
                HelloApplication.changeScreen("main");
            }
        } catch (Exception e) {

        }
    }
}
