package splitec.splicountviewapp.splicount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboardController {
    @FXML
    private Button btnDepartScreen;

    @FXML
    protected void onDepartScreenClick(ActionEvent event) {
        try {
            HelloApplication.changeScreen("departamento");
        } catch (Exception e) {

        }
    }

    @FXML
    protected void onEmpresaScreenClick(ActionEvent event) {
        try {
            HelloApplication.changeScreen("cadastrarEmpresa");
        } catch (Exception e) {

        }
    }
}
