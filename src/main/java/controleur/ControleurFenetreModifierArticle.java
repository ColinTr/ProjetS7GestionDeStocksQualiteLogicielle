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
import java.util.*;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class ControleurFenetreModifierArticle implements Initializable {

    private static int idArticle;

    private static Produit articleAModifier;

    @FXML
    private TextField fieldNom;
    @FXML private TextField fieldPrix;
    @FXML private TextField fieldDescription;
    @FXML private TextField fieldReference;

    @FXML private Button boutonModifier;
    @FXML private Button boutonAnnuler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        articleAModifier = ProduitDAO.trouverProduit(idArticle);

        EntityManager em = Connexion.getEntityManager();
        articleAModifier = em.merge(articleAModifier);
        em.close();

        fieldNom.setText(articleAModifier.getNomProduit());
        fieldPrix.setText(String.valueOf(articleAModifier.getPrix()));
        fieldDescription.setText(articleAModifier.getDescription());
        fieldReference.setText(articleAModifier.getReference());

        boutonModifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nouveauNom = null;
                float nouveauPrix = -1;
                String nouvelleDescription = null;
                String nouvelleReference = null;

                try{
                    nouveauNom = fieldNom.getText();
                    nouveauPrix = Float.parseFloat(fieldPrix.getText());
                    nouvelleDescription = fieldDescription.getText();
                    nouvelleReference = fieldReference.getText();

                    EntityManager em = Connexion.getEntityManager();

                    em.getTransaction().begin();

                    if(nouveauPrix < 0){
                        throw new NumberFormatException();
                    }

                    articleAModifier = em.find(articleAModifier.getClass(), articleAModifier.getIdProduit());

                    articleAModifier.setNomProduit(nouveauNom);
                    articleAModifier.setPrix(nouveauPrix);
                    articleAModifier.setDescription(nouvelleDescription);
                    articleAModifier.setReference(nouvelleReference);

                    em.getTransaction().commit();

                    em.close();

                    Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                    stage.close();
                    event.consume();
                    ControleurFenetrePrincipale.miseAJourDesTables();
                } catch(java.lang.NumberFormatException a){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de modifier l'article, prix incorrect.", ButtonType.OK);
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

    public static void setIdArticle(int id){
        idArticle = id;
    }
}