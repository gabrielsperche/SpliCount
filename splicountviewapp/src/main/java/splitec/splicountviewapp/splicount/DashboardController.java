package splitec.splicountviewapp.splicount;

import entities.Departamento;
import entities.Empresa;
import entities.Nota;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import splitec.service.DepartamentoService;
import splitec.service.EmpresaService;
import splitec.service.NotasService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController {

    public void setDashboard() {
        List<Nota> notas = DepartamentoService.getNotas();
        pieChartData = FXCollections.observableArrayList();
        pieChartDataSaidas = FXCollections.observableArrayList();

        for (Nota nota: notas) {
            pieChartData.add(new PieChart.Data(nota.getNome(), nota.getValorEntrada()));
            pieChartDataSaidas.add(new PieChart.Data(nota.getNome(), nota.getValorSaida()));
        }

        pieChart.setData(pieChartData);
        pieChartSaidas.setData(pieChartDataSaidas);

        pieChart.setTitle("Entradas");
        pieChartSaidas.setTitle("Saídas");
    }
    @FXML
    private Button btnDepartScreen;
    @FXML
    private PieChart pieChart;
    private ObservableList<PieChart.Data> pieChartData;
    @FXML
    private PieChart pieChartSaidas;
    private ObservableList<PieChart.Data> pieChartDataSaidas;

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
            HelloApplication.changeScreen("empresa");
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
}
