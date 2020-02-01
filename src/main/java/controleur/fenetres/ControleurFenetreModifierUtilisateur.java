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

public class ControleurFenetreModifierUtilisateur implements Initializable {

    //L'utilisateur actuellement connecté
    private static Utilisateur utilisateurConnecte;
    private static Utilisateur utilisateurAModifier;

    @FXML
    private ComboBox<Magasin> boxMagasins;
    private ObservableList<Magasin> magasins= FXCollections.observableArrayList();

    @FXML private ComboBox<Rayon> boxRayons;
    private ObservableList<Rayon> rayons= FXCollections.observableArrayList();

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

        //Définition des listes déroulantes
        magasins = FXCollections.observableArrayList(MagasinDAO.tousLesMagasins());

        //Un administrateur ne peut pas gérer les autres magasins, donc on les enlève
        if(!utilisateurConnecte.getTypeDeCompte().equals(TypeDeCompte.SUPER_ADMINISTRATEUR)){
            magasins.removeIf(m -> m.getIdMagasin() != utilisateurConnecte.getMagasin().getIdMagasin());
        }

        boxMagasins.setItems(magasins);

        rayons = FXCollections.observableArrayList(MagasinDAO.tousLesRayons(utilisateurAModifier.getMagasin().getIdMagasin()));
        boxRayons.setItems(rayons);

        boxMagasins.getSelectionModel().select(0);
        boxRayons.getSelectionModel().select(0);

        //=================================== Pré-remplissage des champs ===================================

        EntityManager em = Connexion.getEntityManager();

        utilisateurAModifier = em.find(utilisateurAModifier.getClass(), utilisateurAModifier.getIdUtilisateur());
        utilisateurConnecte = em.find(utilisateurConnecte.getClass(), utilisateurConnecte.getIdUtilisateur());

        if(utilisateurAModifier.getRayonDirige() != null){
            int indice = 0;
            int indiceRayon = 0;
            for(Rayon r : rayons){
                if(r.getIdRayon() == utilisateurAModifier.getRayonDirige().getIdRayon()){
                    indiceRayon = indice;
                }
                indice++;
            }
            boxRayons.getSelectionModel().select(indiceRayon);
        }

        if(utilisateurAModifier.getMagasin() != null){
            int indice = 0;
            int indiceMagasin = 0;
            for(Magasin m : magasins){
                if(m.getIdMagasin() == utilisateurAModifier.getMagasin().getIdMagasin()){
                    indiceMagasin = indice;
                }
                indice++;
            }
            boxMagasins.getSelectionModel().select(indiceMagasin);
        }

        fieldNomCompte.setText(utilisateurAModifier.getNomDeCompte());
        fieldMotDePasse.setText(utilisateurAModifier.getMotDePasse());

        fieldNom.setText(utilisateurAModifier.getNom());
        fieldPrenom.setText(utilisateurAModifier.getPrenom());

        if(utilisateurAModifier.isRestreint()){
            checkBoxRestreint.setSelected(true);
        }

        if(utilisateurAModifier.getTypeDeCompte().equals(TypeDeCompte.ADMINISTRATEUR)){
            boxDirigeMagasin.setSelected(true);
            boxRayons.setItems(null);
        }

        em.close();

        //=================================== Fin du pré-remplissage ===================================

        boxDirigeMagasin.setOnAction(event -> {
            if(boxDirigeMagasin.isSelected()){
                boxRayons.setItems(null);
            }
            else{
                boxRayons.setItems(rayons);
                boxRayons.getSelectionModel().select(0);
            }
        });

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
            else if(!nomCompte.equals(utilisateurAModifier.getNomDeCompte()) && UtilisateurDAO.testerNomDeCompte(nomCompte) != null){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Un utilisateur avec le même nom de compte existe déjà dans la base de données.", ButtonType.OK);
                alert.show();
            }
            else if(!Utilisateur.estCeUnNomDeCompteAcceptable(nomCompte)){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Le nom de compte ne respecte pas les contraintes.", ButtonType.OK);
                alert.show();
            }
            else if(!Utilisateur.estCeUnMotDePasseAcceptable(motDePasse)){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Le mot de passe ne respecte pas les contraintes.", ButtonType.OK);
                alert.show();
            }
            else if(boxDirigeMagasin.isSelected() && !utilisateurConnecte.getTypeDeCompte().equals(TypeDeCompte.SUPER_ADMINISTRATEUR)){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Vous ne disposez pas des droits suffisants pour créer un chef de magasin.", ButtonType.OK);
                alert.show();
            }
            else{
                TypeDeCompte type;
                if(boxDirigeMagasin.isSelected()){
                    type = TypeDeCompte.ADMINISTRATEUR;
                }
                else{
                    type = TypeDeCompte.UTILISATEUR;
                }

                UtilisateurDAO.supprimerUtilisateur(utilisateurAModifier.getIdUtilisateur());

                Utilisateur nouvelUtilisateur = new Utilisateur(nomCompte, nom, prenom, UtilisateurDAO.SHA512(motDePasse), type, checkBoxRestreint.isSelected(), null, null, boxMagasins.getValue());

                UtilisateurDAO.creerUtilisateur(nouvelUtilisateur);

                //Soit il dirige le magasin, soit il dirige le rayon :
                if(boxDirigeMagasin.isSelected()){
                    UtilisateurDAO.definirChefMagasin(nouvelUtilisateur.getIdUtilisateur(), boxMagasins.getValue().getIdMagasin());
                }
                else{
                    UtilisateurDAO.definirChefRayon(nouvelUtilisateur.getIdUtilisateur(), boxRayons.getValue().getIdRayon());
                }

                ControleurFenetreGestionUtilisateurs.miseAJourTable();

                Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
                stage.close();
                event.consume();
            }
            event.consume();
        });

        boutonAnnuler.setOnAction(event -> {
            Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
            stage.close();
            event.consume();
        });

    }

    /**
     * Cette fonction statique et publique permet de définir l'utilisateur connecté et à modifer depuis la fenêtre principale.
     * @param utilisateurC : l'utilisateur connecté.
     * @param utilisateurAM : l'utilisateur à modifier.
     */
    public static void setUtilisateurConnecteEtAModifier(Utilisateur utilisateurC, Utilisateur utilisateurAM){
        utilisateurConnecte = utilisateurC;
        utilisateurAModifier = utilisateurAM;
    }
}