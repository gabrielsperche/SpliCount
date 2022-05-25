package splitec.splicountviewapp.splicount;

import entities.Departamento;
import entities.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import splitec.service.EmpresaService;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoEmpresaController implements Initializable {

    @FXML
    private Text txtNomeEmpresa;
    @FXML
    private Text txtPatrimonio;
    @FXML
    private ListView listDeparts;
    @FXML
    private Button btnDepartScreen;
    @FXML
    private Button btnUserScreen;
    @FXML
    private Button btnDashScreen;


    @FXML
    protected void onCadastrarClick(ActionEvent event) {
        try {

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

    @FXML
    protected void logoutApp(ActionEvent event) {
        try {
            HelloApplication.changeScreen("main");
        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Empresa empresa = EmpresaService.infosEmpresa("kljdflkjdsl");
        
        txtNomeEmpresa.setText(empresa.getNome());
        txtPatrimonio.setText(empresa.getPatrimonio());

        for (Departamento dept: empresa.getDepartamentos()) {
            listDeparts.getItems().add(dept.getNome());
        }
    }
}
