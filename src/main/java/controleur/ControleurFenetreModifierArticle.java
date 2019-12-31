package controleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modele.Utilisateur;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class ControleurFenetreModifierArticle implements Initializable {

    private static int idArticle;

    @FXML private TextField fieldNom;
    @FXML private TextField fieldPrix;
    @FXML private TextField fieldDescription;
    @FXML private TextField fieldReference;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public static void setIdArticle(int id){
        idArticle = id;
    }
}