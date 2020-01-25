package controleur.fenetres;

import controleur.Connexion;
import controleur.MagasinDAO;
import controleur.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Rayon;
import modele.TypeDeCompte;
import modele.Utilisateur;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControleurFenetreTransformerUtilisateur implements Initializable {

    private static Utilisateur utilisateurATransformer;

    @FXML private Button boutonConfirmer;
    @FXML private Button boutonAnnuler;

    @FXML private Text fieldText;

    @FXML private ComboBox<TypeDeCompte> boxType;
    private ObservableList<TypeDeCompte> types = FXCollections.observableArrayList();

    @FXML private ComboBox<Rayon> boxRayon;
    private ObservableList<Rayon> rayons = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldText.setText("Transformer " + utilisateurATransformer.getNomDeCompte() + " :");

        boxType.setOnAction(event -> {
            if(boxType.getValue().equals(TypeDeCompte.UTILISATEUR)){
                rayons = FXCollections.observableArrayList(MagasinDAO.tousLesRayons(utilisateurATransformer.getMagasin().getIdMagasin()));
                boxRayon.setItems(rayons);
                boxRayon.getSelectionModel().select(0);
            }
            if(boxType.getValue().equals(TypeDeCompte.ADMINISTRATEUR)){
                rayons = FXCollections.observableArrayList();
                boxRayon.setItems(rayons);
                boxRayon.getSelectionModel().select(0);
            }
        });

        boutonConfirmer.setOnAction(event -> {
            String message = "";
            EntityManager em = Connexion.getEntityManager();

            utilisateurATransformer = em.find(utilisateurATransformer.getClass(), utilisateurATransformer.getIdUtilisateur());

            if(boxType.getValue().equals(TypeDeCompte.UTILISATEUR)){
                message = utilisateurATransformer.getNomDeCompte() + "va devenir le nouveau chef de rayon de \"" +boxRayon.getValue().getNomRayon() + "\". Confirmer ?";
            }
            if(boxType.getValue().equals(TypeDeCompte.ADMINISTRATEUR)){
                message = utilisateurATransformer.getNomDeCompte() + "va devenir le nouveau chef magasin de \"" + utilisateurATransformer.getMagasin().getNomMagasin() + "\". Confirmer ?";
            }

            em.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message);
            Optional<ButtonType> choose = alert.showAndWait();

            if(choose.get() == ButtonType.OK){

                if(boxType.getValue().equals(TypeDeCompte.UTILISATEUR)){
                    em = Connexion.getEntityManager();

                    em.getTransaction().begin();

                    utilisateurATransformer = em.find(utilisateurATransformer.getClass(), utilisateurATransformer.getIdUtilisateur());

                    utilisateurATransformer.setTypeDeCompte(TypeDeCompte.UTILISATEUR);

                    utilisateurATransformer.setMagasinDirige(null);

                    em.getTransaction().commit();

                    em.close();

                    UtilisateurDAO.definirChefRayon(utilisateurATransformer.getIdUtilisateur(), boxRayon.getValue().getIdRayon());
                }
                if(boxType.getValue().equals(TypeDeCompte.ADMINISTRATEUR)){
                    em = Connexion.getEntityManager();

                    em.getTransaction().begin();

                    utilisateurATransformer = em.find(utilisateurATransformer.getClass(), utilisateurATransformer.getIdUtilisateur());

                    utilisateurATransformer.setTypeDeCompte(TypeDeCompte.ADMINISTRATEUR);

                    utilisateurATransformer.setRayonDirige(null);

                    em.getTransaction().commit();

                    em.close();

                    UtilisateurDAO.definirChefMagasin(utilisateurATransformer.getIdUtilisateur(), utilisateurATransformer.getMagasin().getIdMagasin());
                }

                ControleurFenetreGestionUtilisateurs.miseAJourTable();

                Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                stage.close();
            }

            event.consume();
        });

        boutonAnnuler.setOnAction(event -> {
            Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
            stage.close();
            event.consume();
        });

        types = FXCollections.observableArrayList(TypeDeCompte.UTILISATEUR, TypeDeCompte.ADMINISTRATEUR);
        boxType.setItems(types);
        boxType.getSelectionModel().select(utilisateurATransformer.getTypeDeCompte());
        if(utilisateurATransformer.getTypeDeCompte().equals(TypeDeCompte.UTILISATEUR)){
            rayons = FXCollections.observableArrayList(MagasinDAO.tousLesRayons(utilisateurATransformer.getMagasin().getIdMagasin()));
            boxRayon.setItems(rayons);
            boxRayon.getSelectionModel().select(0);
        }
    }

    public static void setUtilisateurATransformer(Utilisateur utilisateur) { utilisateurATransformer = utilisateur; }
}
