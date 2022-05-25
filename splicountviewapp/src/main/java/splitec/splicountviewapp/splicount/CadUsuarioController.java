package splitec.splicountviewapp.splicount;

import entities.MessageResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import splitec.service.UsuarioService;

public class CadUsuarioController {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextField txtEmpresa;
    @FXML
    private Text txtAlert;

    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        try {
            if(txtNome.getText() == "" || txtEmail.getText() == "" || txtSenha.getText() == "" || txtEmpresa.getText() == ""){
                txtAlert.setText("Preencha todos os dados para realizar o cadastro!");
                txtAlert.setVisible(true);
                return;
            }

            MessageResponse response = UsuarioService.createUser(txtEmail.getText(), txtSenha.getText(), txtNome.getText(), txtEmpresa.getText());
            if (response.isSucess()) {
                HelloApplication.changeScreen("main");
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
    protected void backToLogin(ActionEvent event) {
        try {
            HelloApplication.changeScreen("main");
        } catch (Exception e) {
            txtAlert.setText(e.getMessage());
            txtAlert.setVisible(true);
        }
    }
}
