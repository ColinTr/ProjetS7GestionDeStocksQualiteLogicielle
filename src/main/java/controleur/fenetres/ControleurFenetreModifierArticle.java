package controleur.fenetres;

import controleur.Connexion;
import controleur.ProduitDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Produit;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class ControleurFenetreModifierArticle implements Initializable {

    private static int idArticle;

    private static Produit articleAModifier;

    @FXML private TextField fieldNom;
    @FXML private TextField fieldPrix;
    @FXML private TextField fieldDescription;
    @FXML private TextField fieldReference;

    @FXML private Button boutonModifier;
    @FXML private Button boutonAnnuler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Pré-remplissage des données :
        articleAModifier = ProduitDAO.trouverProduit(idArticle);

        EntityManager em = Connexion.getEntityManager();
        articleAModifier = em.merge(articleAModifier);
        em.close();

        fieldNom.setText(articleAModifier.getNomProduit());
        fieldPrix.setText(String.valueOf(articleAModifier.getPrix()));
        fieldDescription.setText(articleAModifier.getDescription());
        fieldReference.setText(articleAModifier.getReference());

        boutonModifier.setOnAction(event -> {
            try{
                String nouveauNom = fieldNom.getText();
                float nouveauPrix = Float.parseFloat(fieldPrix.getText());
                String nouvelleDescription = fieldDescription.getText();
                String nouvelleReference = fieldReference.getText();

                if(nouveauPrix < 0){
                    throw new NumberFormatException();
                }

                EntityManager em1 = Connexion.getEntityManager();

                em1.getTransaction().begin();

                articleAModifier = em1.find(articleAModifier.getClass(), articleAModifier.getIdProduit());

                articleAModifier.setNomProduit(nouveauNom);
                articleAModifier.setPrix(nouveauPrix);
                articleAModifier.setDescription(nouvelleDescription);
                articleAModifier.setReference(nouvelleReference);

                em1.getTransaction().commit();

                em1.close();

                ControleurFenetrePrincipale.miseAJourDesTables();

                Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                stage.close();
                event.consume();
            } catch(NumberFormatException a){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de modifier l'article, prix incorrect.", ButtonType.OK);
                alert.show();
            }
        });

        boutonAnnuler.setOnAction(event -> {
            Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
            stage.close();
            event.consume();
        });
    }

    public static void setIdArticle(int id){
        idArticle = id;
    }
}