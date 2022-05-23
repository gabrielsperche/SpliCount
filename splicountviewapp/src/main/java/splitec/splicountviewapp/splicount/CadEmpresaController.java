package splitec.splicountviewapp.splicount;

import entities.Empresa;
import entities.MessageResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import splitec.service.EmpresaService;

import java.net.URL;
import java.util.ResourceBundle;

public class CadEmpresaController implements Initializable {
    @FXML
    private Stage stage = new Stage();
    @FXML
    private TextField txtNomeEmpresa;
    @FXML
    private TextField txtCnpj;

    @FXML
    private TableColumn<Empresa, String> nameColumn;
    @FXML
    private TableColumn<Empresa, String> cnpjColumn;
    @FXML
    private TableView<Empresa> listEmpresas;

    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        try {
            String nome = txtNomeEmpresa.getText();
            String cnpj = txtCnpj.getText();

            MessageResponse response = EmpresaService.createEmpresa(nome, cnpj);
            if (response.isSucess()) {
                listEmpresas.getItems().add(new Empresa(nome, cnpj));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cnpjColumn.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
    }
}
