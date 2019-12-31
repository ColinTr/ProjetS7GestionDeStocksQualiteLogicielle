package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Produit;
import modele.Rayon;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleurFenetreCreerArticle implements Initializable {

    private static int idRayon;

    @FXML private TextField fieldNom;
    @FXML private TextField fieldPrix;
    @FXML private TextField fieldDescription;
    @FXML private TextField fieldReference;
    @FXML private TextField fieldStocks;
    @FXML private TextField fieldReservations;

    @FXML private Button boutonModifier;
    @FXML private Button boutonAnnuler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        boutonModifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    String nom = fieldNom.getText();
                    float prix = Float.parseFloat(fieldPrix.getText());
                    String description = fieldDescription.getText();
                    String reference = fieldReference.getText();
                    int stock = Integer.parseInt(fieldStocks.getText());
                    int reservations = Integer.parseInt(fieldReservations.getText());

                    if(prix < 0 || stock < 0 || reservations < 0){
                        throw new NumberFormatException();
                    }

                    Rayon rayon = RayonDAO.trouverRayon(idRayon);

                    if(!ProduitDAO.ajouterUnProduit(new Produit(nom, stock, reservations, prix, rayon, description, reference))){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Connexion impossible. Vérifiez votre connexion internet ou l’adresse de la base.", ButtonType.OK);
                        alert.show();
                    }
                    else{
                        Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                        stage.close();
                        event.consume();
                        ControleurFenetrePrincipale.miseAJourDesTables();
                    }
                } catch(java.lang.NumberFormatException a){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de créer l'article, valeurs incorrectes.", ButtonType.OK);
                    alert.show();
                }
            }
        });

        boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                stage.close();
                event.consume();
            }
        });
    }

    public static void setIdRayon(int idR){
        idRayon = idR;
    }
}
