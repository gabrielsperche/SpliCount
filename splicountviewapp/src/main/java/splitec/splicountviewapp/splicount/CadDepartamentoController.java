package splitec.splicountviewapp.splicount;

import entities.Departamento;
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
import splitec.service.DepartamentoService;

import java.net.URL;
import java.util.ResourceBundle;

public class CadDepartamentoController implements Initializable {
    @FXML
    private Stage stage = new Stage();
    @FXML
    private TextField txtNomeDepart;
    @FXML
    private TextField txtOrcamento;
    @FXML
    private Button btnEmpresaScreen;
    @FXML
    private Button btnUserScreen;
    @FXML
    private Button btnDashScreen;

    @FXML
    private TableColumn<Departamento, String> nameColumn;
    @FXML
    private TableColumn<Departamento, Double> orcamentoColumn;
    @FXML
    private TableView<Departamento> listDepartamentos;

    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        try {
            String nome = txtNomeDepart.getText();
            Double orcamento = Double.parseDouble(txtOrcamento.getText());

            MessageResponse response = DepartamentoService.createDepartamento(nome, orcamento);
            if (response.isSucess()) {
                listDepartamentos.getItems().add(new Departamento(nome, orcamento));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        orcamentoColumn.setCellValueFactory(new PropertyValueFactory<>("orcamento"));
    }

    @FXML
    protected void onEmpresaScreenClick(ActionEvent event) {
        try {
            HelloApplication.changeScreen("cadastrarEmpresa");
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
