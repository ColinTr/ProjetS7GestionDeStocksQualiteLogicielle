package controleur.fenetres;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleurFenetreTransfererArticles  implements Initializable {

    @FXML private Button boutonAnnuler;
    @FXML private Button boutonConfirmer;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boutonConfirmer.setOnAction(event -> {
            Stage stage = (Stage) boutonConfirmer.getScene().getWindow();
            stage.close();
            event.consume();
        });
        boutonAnnuler.setOnAction(event -> {
            Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
            stage.close();
            event.consume();
        });
    }
}
