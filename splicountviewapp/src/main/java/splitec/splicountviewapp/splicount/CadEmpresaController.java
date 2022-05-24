package splitec.splicountviewapp.splicount;

import entities.Empresa;
import entities.MessageResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import splitec.service.EmpresaService;

import java.net.URL;
import java.util.ResourceBundle;

public class CadEmpresaController {

    @FXML
    private TextField txtNomeEmpresa;
    @FXML
    private TextField txtCnpj;
    @FXML
    private Button btnDepartScreen;
    @FXML
    private Button btnUserScreen;
    @FXML
    private Button btnDashScreen;


    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        try {
            String nome = txtNomeEmpresa.getText();
            String cnpj = txtCnpj.getText();

            MessageResponse response = EmpresaService.createEmpresa(nome, cnpj);

        } catch (Exception e) {
            throw e;
        }
    }


    @FXML
    protected void onDepartScreenClick(ActionEvent event) {
        try {
            HelloApplication.changeScreen("departamento");
        } catch (Exception e) {

        }
    }

    @FXML
    protected void onDashScreenClick(ActionEvent event) {
        try {
            HelloApplication.changeScreen("dashboard");
        } catch (Exception e) {

        }
    }

    @FXML
    protected void onUserScreenClick(ActionEvent event) {
        try {
            HelloApplication.changeScreen("cadastrarUsuario");
        } catch (Exception e) {

        }
    }
}
