package splitec.splicountviewapp.splicount;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene cadastroUsuarioScene;
    private static Scene empresaScene;
    private static Scene dashboardScene;
    private static Scene departamentoScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        mainScene = new Scene(fxmlMain, 1200, 720);

        Parent fxmlCadastroUsuario = FXMLLoader.load(getClass().getResource("CadUsuario.fxml"));
        cadastroUsuarioScene = new Scene(fxmlCadastroUsuario, 1200, 720);

        Parent fxmlEmpresa = FXMLLoader.load(getClass().getResource("InfoEmpresa.fxml"));
        empresaScene = new Scene(fxmlEmpresa, 1200, 720);

        Parent fxmlDashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        dashboardScene = new Scene(fxmlDashboard, 1200, 720);

        Parent fxmlDepartamento = FXMLLoader.load(getClass().getResource("CadDepartamento.fxml"));
        departamentoScene = new Scene(fxmlDepartamento, 1200, 720);

        primaryStage.setTitle("Splicount");
        primaryStage.setScene(mainScene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Images/icon.png")));
        primaryStage.show();
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "main":
                stage.setScene(mainScene);
                break;
            case "cadastrarUsuario":
                stage.setScene(cadastroUsuarioScene);
                break;
            case "empresa":
                stage.setScene(new Scene(empresaScreen(), 1200, 720));
                break;
            case "dashboard":
                stage.setScene(new Scene(dashboardScreen(), 1200, 720));
                break;
            case "departamento":
                stage.setScene(new Scene(departsScreen(), 1200, 720));
                break;
        }
    }

    public static Parent empresaScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("InfoEmpresa.fxml"));
            Parent root = loader.load();
            InfoEmpresaController infoEmpresaController = loader.getController();
            infoEmpresaController.setEmpresa();
            return root;

        } catch (Exception e) {
            return null;
        }
    }

    public static Parent departsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("CadDepartamento.fxml"));
            Parent root = loader.load();
            CadDepartamentoController cadDepartamentoController = loader.getController();
            cadDepartamentoController.setDepartamento();
            return root;

        } catch (Exception e) {
            return null;
        }
    }

    public static Parent dashboardScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
            Parent root = loader.load();
            DashboardController dashboardController = loader.getController();
            dashboardController.setDashboard();
            return root;

        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}