package controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.*;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleurFenetreGestionUtilisateurs implements Initializable {

    //Défintion des boutons
    @FXML Button boutonCreer;
    @FXML Button boutonModifier;
    @FXML Button boutonSupprimer;
    @FXML Button boutonRestreindre;
    @FXML Button boutonTransformer;

    //L'utilisateur actuellement connecté
    private static Utilisateur utilisateurConnecte;

    //Table et colonnes de la table des rayons d'un magasin :
    @FXML private TableView<UtilisateursTableClass> utilisateursTable;
    @FXML private TableColumn<UtilisateursTableClass, String> colonneNomCompte;
    @FXML private TableColumn<UtilisateursTableClass, String> colonneNom;
    @FXML private TableColumn<UtilisateursTableClass, String> colonnePrenom;
    @FXML private TableColumn<UtilisateursTableClass, String> colonneTypeCompte;
    @FXML private TableColumn<UtilisateursTableClass, String> colonneAcces;
    @FXML private TableColumn<UtilisateursTableClass, String> colonneRayonDirige;
    @FXML private TableColumn<UtilisateursTableClass, String> colonneMagasin;
    private static ObservableList<UtilisateursTableClass> dataTableUtilisateurs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //================================ Définition des actions des boutons ================================

        boutonCreer.setOnAction( event -> {

        });

        boutonModifier.setOnAction( event -> {

        });

        boutonSupprimer.setOnAction( event -> {

        });

        boutonRestreindre.setOnAction( event -> {

        });

        boutonTransformer.setOnAction( event -> {

        });

        //================================ Initialisation des tables ================================

        //On fait le lien entre les lignes déclarées ici et celles du fichier .fxml et les éléments du modèle TableClass :
        colonneNomCompte.setCellValueFactory( new PropertyValueFactory<>("nomCompte") );
        colonneNom.setCellValueFactory( new PropertyValueFactory<>("nom") );
        colonnePrenom.setCellValueFactory( new PropertyValueFactory<>("prenom") );
        colonneTypeCompte.setCellValueFactory( new PropertyValueFactory<>("typeCompte") );
        colonneAcces.setCellValueFactory( new PropertyValueFactory<>("acces") );
        colonneRayonDirige.setCellValueFactory( new PropertyValueFactory<>("rayonDirige") );
        colonneMagasin.setCellValueFactory( new PropertyValueFactory<>("magasin") );

        dataTableUtilisateurs = FXCollections.observableArrayList();
        utilisateursTable.setItems(dataTableUtilisateurs);

        miseAJourTable();
    }

    /**
     * Cette fonction met à jour la table avec les dernières données de la BDD.
     */
    private static void miseAJourTable(){
        List<Utilisateur> utilisateurs = UtilisateurDAO.tousLesUtilisateurs();

        dataTableUtilisateurs.clear();

        EntityManager em = Connexion.getEntityManager();

        for(Utilisateur u : utilisateurs){
            u = em.find(Utilisateur.class, u.getIdUtilisateur());

            boolean ajouterUtilisateur = false;
            if(u.getTypeDeCompte().equals(TypeDeCompte.ADMINISTRATEUR)){
                if(utilisateurConnecte.getTypeDeCompte().equals(TypeDeCompte.SUPER_ADMINISTRATEUR)){
                    ajouterUtilisateur = true;
                }
            }
            if(u.getTypeDeCompte().equals(TypeDeCompte.UTILISATEUR)){
                ajouterUtilisateur = true;
            }

            if(ajouterUtilisateur){
                String typeCompte;
                switch(u.getTypeDeCompte()){
                    case UTILISATEUR:
                        typeCompte = "Utilisateur";
                        break;
                    case ADMINISTRATEUR:
                        typeCompte = "Administrateur";
                        break;
                    case SUPER_ADMINISTRATEUR:
                        typeCompte = "Super-administrateur";
                        break;
                    default:
                        typeCompte = "non défini";
                        break;
                }

                String restreint;
                if(u.isRestreint()){
                    restreint = "Restreint";
                }
                else{
                    restreint = "Normal";
                }

                dataTableUtilisateurs.add( new UtilisateursTableClass(u.getNomDeCompte(), u.getNom(), u.getPrenom(), typeCompte, restreint, u.getRayonDirige().getNomRayon(), u.getMagasin().getNomMagasin(), u.getIdUtilisateur()) );
            }
        }

        em.close();
    }

    /**
     * Cette fonction statique et publique permet de définir l'utilisateur connecté à l'application depuis la fenêtre de connexion.
     * @param utilisateur : l'utilisateur connecté.
     */
    public static void setUtilisateurConnecte(Utilisateur utilisateur){
        utilisateurConnecte = utilisateur;
    }

}
