package splitec.splicountviewapp.splicount;

import entities.MessageResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import splitec.service.UsuarioService;

public class HelloController {
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSenha;

    @FXML
    private Text txtAlert;

    @FXML
    protected void onAcessarClick(ActionEvent event) {
        try {
            if(txtEmail.getText() == "" || txtSenha.getText() == ""){
                txtAlert.setText("Informe o Usuário e senha");
                txtAlert.setVisible(true);
                return;
            }

            MessageResponse response = UsuarioService.auth(txtEmail.getText(), txtSenha.getText());
            if (response.isSucess()) {
               HelloApplication.changeScreen("dashboard");
           }
            else{
                txtAlert.setText(response.getMensagem());
                txtAlert.setVisible(true);
            }
        } catch (Exception e) {
            txtAlert.setText(e.getMessage());
            txtAlert.setVisible(true);
        }
    }

    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        HelloApplication.changeScreen("cadastrarUsuario");
    }
}