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

public class ControleurFenetreModifierStock implements Initializable {

    private static int idArticle;

    private static Produit articleAModifier;

    @FXML private TextField fieldStock;
    @FXML private TextField fieldReservations;

    @FXML private Button boutonConfirmer;
    @FXML private Button boutonAnnuler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Pré-remplissage des données :
        articleAModifier = ProduitDAO.trouverProduit(idArticle);

        EntityManager em = Connexion.getEntityManager();
        articleAModifier = em.merge(articleAModifier);
        em.close();

        fieldStock.setText(String.valueOf(articleAModifier.getStock()));
        fieldReservations.setText(String.valueOf(articleAModifier.getReservations()));

        boutonConfirmer.setOnAction(event -> {

            try{
                int nouveauStock = Integer.parseInt(fieldStock.getText());
                int nouvellesReservations = Integer.parseInt(fieldReservations.getText());

                if(nouveauStock < nouvellesReservations || nouveauStock < 0 || nouvellesReservations < 0){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de modifier l'article, stock ou réservations incohérents.", ButtonType.OK);
                    alert.show();
                }
                else{
                    EntityManager em1 = Connexion.getEntityManager();

                    em1.getTransaction().begin();

                    articleAModifier = em1.find(articleAModifier.getClass(), articleAModifier.getIdProduit());

                    articleAModifier.setStockEtReservations(nouveauStock, nouvellesReservations);

                    em1.getTransaction().commit();

                    em1.close();

                    ControleurFenetrePrincipale.miseAJourDesTables();

                    Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                    stage.close();
                    event.consume();
                }

            } catch(NumberFormatException a){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Seul les entiers sont acceptés dans les champs ci-dessus.", ButtonType.OK);
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
