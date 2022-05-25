package splitec.splicountviewapp.splicount;

import entities.Conta;
import entities.Departamento;
import entities.Empresa;
import entities.MessageResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import splitec.service.DepartamentoService;
import splitec.service.EmpresaService;
import splitec.service.NotasService;

import java.net.URL;
import java.util.ResourceBundle;

public class CadDepartamentoController implements Initializable {
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
    private ListView listDeparts;

    @FXML
    private ComboBox comboBox;

    @FXML
    private TextField txtNomeDepEntradaSaida;

    @FXML
    private TextField txtValorEntradaSaida;
    @FXML
    private Text txtAlert;

    public void setDepartamento() {
        Empresa empresa = EmpresaService.getInfoEmpresa();

        for (Departamento dept : empresa.getDepartamentos()) {
            listDeparts.getItems().add(dept.getNome());
        }
    }

    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        try {
            String nome = txtNomeDepart.getText();
            Double orcamento = Double.parseDouble(txtOrcamento.getText());

            MessageResponse response = DepartamentoService.createDepartamento(nome, orcamento);
            if (response.isSucess()) {
                listDeparts.getItems().add(nome);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    protected void onRegistrarEntradaSaidaClick(ActionEvent event) {
        try {
            String nome = listDeparts.getSelectionModel().getSelectedItem().toString();
            String tipo = comboBox.getSelectionModel().getSelectedItem().toString();
            Double valor = Double.parseDouble(txtValorEntradaSaida.getText());

            MessageResponse response = NotasService.createNota(nome, tipo, valor);
            if (response.isSucess()) {
                txtAlert.setText("Nota cadastrada");
                txtAlert.setVisible(true);
            }

        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    protected void onEmpresaScreenClick(ActionEvent event) {
        try {
            HelloApplication.changeScreen("empresa");
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

    @FXML
    protected void logoutApp(ActionEvent event) {
        try {
            HelloApplication.changeScreen("main");
        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll(
                "Entrada",
                "Saída"
        );
    }
}
