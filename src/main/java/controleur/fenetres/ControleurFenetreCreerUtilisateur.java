package controleur.fenetres;

import controleur.Connexion;
import controleur.MagasinDAO;
import controleur.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import modele.Magasin;
import modele.Rayon;
import modele.TypeDeCompte;
import modele.Utilisateur;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurFenetreCreerUtilisateur implements Initializable {

    //L'utilisateur actuellement connecté
    private static Utilisateur utilisateurConnecte;

    @FXML ComboBox<Magasin> boxMagasins;
    private ObservableList<Magasin> magasins= FXCollections.observableArrayList();

    @FXML ComboBox<Rayon> boxRayons;
    private ObservableList<Rayon> rayons= FXCollections.observableArrayList();

    @FXML ComboBox<TypeDeCompte> boxTypeCompte;
    private ObservableList<TypeDeCompte> typeComptes = FXCollections.observableArrayList();

    @FXML private TextField fieldNomCompte;
    @FXML private PasswordField fieldMotDePasse;
    @FXML private TextField fieldNom;
    @FXML private TextField fieldPrenom;

    @FXML private Button boutonModifier;
    @FXML private Button boutonAnnuler;

    @FXML private CheckBox checkBoxRestreint;
    @FXML private CheckBox boxDirigeMagasin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if(utilisateurConnecte.getTypeDeCompte().equals(TypeDeCompte.SUPER_ADMINISTRATEUR)){
            typeComptes = FXCollections.observableArrayList(TypeDeCompte.UTILISATEUR, TypeDeCompte.ADMINISTRATEUR);
        }
        else{
            typeComptes = FXCollections.observableArrayList(TypeDeCompte.UTILISATEUR);
        }
        boxTypeCompte.setItems(typeComptes);
        boxTypeCompte.getSelectionModel().select(0);

        magasins = FXCollections.observableArrayList(MagasinDAO.tousLesMagasins());
        boxMagasins.setItems(magasins);
        boxMagasins.getSelectionModel().select(0);

        rayons = FXCollections.observableArrayList(MagasinDAO.tousLesRayons(magasins.get(0).getIdMagasin()));
        boxRayons.setItems(rayons);
        boxRayons.getSelectionModel().select(0);

        boxMagasins.setOnAction(event -> {
            rayons = FXCollections.observableArrayList(MagasinDAO.tousLesRayons(boxMagasins.getValue().getIdMagasin()));
            boxRayons.setItems(rayons);
            boxRayons.getSelectionModel().select(0);
        });

        boutonModifier.setOnAction(event -> {
            String nomCompte = fieldNomCompte.getText();
            String motDePasse = fieldMotDePasse.getText();
            String nom = fieldNom.getText();
            String prenom = fieldPrenom.getText();


            if(nomCompte.isEmpty() || nom.isEmpty() || motDePasse.isEmpty() || prenom.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez renseigner tous les champs pour créer un utilisateur.", ButtonType.OK);
                alert.show();
            }
            else{
                if(UtilisateurDAO.testerNomDeCompte(nomCompte) != null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Un utilisateur avec le même nom de compte existe déjà dans la base de données.", ButtonType.OK);
                    alert.show();
                }
                else{
                    Utilisateur nouvelUtilisateur = new Utilisateur(nomCompte, nom, prenom, UtilisateurDAO.SHA512(motDePasse), boxTypeCompte.getValue(), checkBoxRestreint.isSelected(), null, null, boxMagasins.getValue());

                    UtilisateurDAO.creerUtilisateur(nouvelUtilisateur);

                    UtilisateurDAO.definirChefRayon(nouvelUtilisateur.getIdUtilisateur(), boxRayons.getValue().getIdRayon());

                    if(boxDirigeMagasin.isSelected()){
                        UtilisateurDAO.definirChefMagasin(nouvelUtilisateur.getIdUtilisateur(), boxMagasins.getValue().getIdMagasin());
                    }

                    ControleurFenetreGestionUtilisateurs.miseAJourTable();

                    Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                    stage.close();
                    event.consume();
                }

            }
        });

        boutonAnnuler.setOnAction(event -> {
            Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
            stage.close();
            event.consume();
        });

    }

    /**
     * Cette fonction statique et publique permet de définir l'utilisateur connecté à l'application depuis la fenêtre principale.
     * @param utilisateur : l'utilisateur connecté.
     */
    public static void setUtilisateurConnecte(Utilisateur utilisateur){
        utilisateurConnecte = utilisateur;
    }
}
