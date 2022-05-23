package splitec.splicountviewapp.splicount;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene cadastroUsuarioScene;
    private static Scene dashboardScene;
    private static Scene departamentoScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        Parent fxmlMain= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        mainScene = new Scene(fxmlMain, 1200, 720);

        Parent fxmlCadastroUsuario= FXMLLoader.load(getClass().getResource("CadUsuario.fxml"));
        cadastroUsuarioScene = new Scene(fxmlCadastroUsuario, 1200, 720);

        Parent fxmlDashboard= FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        dashboardScene = new Scene(fxmlDashboard, 1200, 720);

        Parent fxmlDepartamento= FXMLLoader.load(getClass().getResource("CadDepartamento.fxml"));
        departamentoScene = new Scene(fxmlDepartamento, 1200, 720);

        primaryStage.setTitle("Hello!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScreen(String scr){
        switch (scr){
            case "main":
                stage.setScene(mainScene);
                break;
            case "cadastrarUsuario":
                stage.setScene(cadastroUsuarioScene);
                break;
            case "dashboard":
                stage.setScene(dashboardScene);
                break;
            case "departamento":
                stage.setScene(departamentoScene);
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}