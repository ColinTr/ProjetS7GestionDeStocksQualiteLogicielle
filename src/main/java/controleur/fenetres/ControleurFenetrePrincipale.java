package controleur.fenetres;

import controleur.Connexion;
import controleur.MagasinDAO;
import controleur.ProduitDAO;
import controleur.RayonDAO;
import javafx.scene.image.Image;
import modele.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.tables.ProduitsTableClass;
import modele.tables.RayonsTableClass;
import org.apache.log4j.Logger;
import vue.FenetrePrincipale;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Cette classe définit le contenu des tables de l'application et toutes les actions liées aux boutons et sélections de lignes.
 */
public class ControleurFenetrePrincipale implements Initializable {

    final static Logger logger = Logger.getLogger(ControleurFenetrePrincipale.class);

    private final static String icon = "/icon.png";

    //L'utilisateur actuellement connecté
    private static Utilisateur utilisateurConnecte;

    //L'id du rayon actuellement affiché
    private static int idRayon;

    //Table et colonnes de la table des rayons d'un magasin :
    @FXML private BorderPane paneRayons;
    @FXML private TableView<RayonsTableClass> rayonsTable;
    @FXML private TableColumn<RayonsTableClass, String> colonneNom;
    @FXML private TableColumn<RayonsTableClass, String> colonneChefDeRayon;
    @FXML private TableColumn<RayonsTableClass, Integer> colonneNbArticles;
    private static ObservableList<RayonsTableClass> dataTableRayons;

    //Table et colonnes de la table des produits d'un rayon :
    @FXML private BorderPane paneProduits;
    @FXML private TableView<ProduitsTableClass> produitsTable;
    @FXML private TableColumn<ProduitsTableClass, String> colonneNomp;
    @FXML private TableColumn<ProduitsTableClass, Float> colonnePrix;
    @FXML private TableColumn<ProduitsTableClass, String> colonneDescription;
    @FXML private TableColumn<ProduitsTableClass, String> colonneReference;
    @FXML private TableColumn<ProduitsTableClass, Integer> colonneStock;
    @FXML private TableColumn<ProduitsTableClass, Integer> colonneReservations;
    private static ObservableList<ProduitsTableClass> dataTableProduits;

    @FXML private Text labelChemin;
    @FXML private Text labelUtilisateur;

    //Définition des boutons
    @FXML private Button homeButton;
    @FXML private Button boutonCreerArticle;
    @FXML private Button boutonModifierArticle;
    @FXML private Button boutonModifierStock;
    @FXML private Button boutonSupprimerArticle;
    @FXML private Button boutonTransfererArticles;
    @FXML private Button buttonGestionUtilisateurs;

    @FXML private BorderPane paneArticles;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        EntityManager em = Connexion.getEntityManager();

        utilisateurConnecte = em.find(utilisateurConnecte.getClass(), utilisateurConnecte.getIdUtilisateur());

        labelChemin.setText(utilisateurConnecte.getMagasin().getNomMagasin());

        em.close();

        //================================ Définition des actions des boutons ================================

        //Bouton qui permet de revenir à la liste des rayons
        homeButton.setOnAction(event -> {
            paneRayons.toFront();
            labelChemin.setText(utilisateurConnecte.getMagasin().getNomMagasin());
            event.consume();
        });

        boutonCreerArticle.setOnAction(event -> {
            //On vérifie d'abord si l'utilisateur a le droit de créer un article dans ce rayon :
            if(utilisateurConnecte.getTypeDeCompte() == TypeDeCompte.UTILISATEUR && utilisateurConnecte.getRayonDirige().getIdRayon() != idRayon){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de créer un article dans un rayon que vous ne dirigez pas.", ButtonType.OK);
                alert.show();
            }
            else{
                ControleurFenetreCreerArticle.setIdRayon(idRayon);
                creerFenetre("/fenetreCreerArticle.fxml", "Créer article", 350, 450);
            }
            event.consume();
        });

        boutonModifierArticle.setOnAction(event -> {
            //On vérifie que l'utilisateur a sélectionné un ligne du tableau :
            ProduitsTableClass articleSelectionne = produitsTable.getSelectionModel().getSelectedItem();
            if(articleSelectionne != null){
                //Puis on vérifie si l'utilisateur a le droit de créer un article dans ce rayon :
                if(utilisateurConnecte.getTypeDeCompte() == TypeDeCompte.UTILISATEUR && utilisateurConnecte.getRayonDirige().getIdRayon() != idRayon){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de modifier les informations d'un article d'un rayon que vous ne dirigez pas.", ButtonType.OK);
                    alert.show();
                }
                else{
                    ControleurFenetreModifierArticle.setIdArticle(articleSelectionne.getIdArticle());
                    creerFenetre("/fenetreModifierArticle.fxml", "Modifier article", 350, 350);
                }
            }
            event.consume();
        });

        boutonModifierStock.setOnAction(event -> {
            //On vérifie que l'utilisateur a sélectionné un ligne du tableau :
            ProduitsTableClass articleSelectionne = produitsTable.getSelectionModel().getSelectedItem();
            if(articleSelectionne != null){
                //Puis on vérifie si l'utilisateur a le droit de modifier un article dans ce rayon :
                if(utilisateurConnecte.getTypeDeCompte() == TypeDeCompte.UTILISATEUR && utilisateurConnecte.getRayonDirige().getIdRayon() != idRayon){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de modifier le stock d'un article d'un rayon que vous ne dirigez pas.", ButtonType.OK);
                    alert.show();
                }
                else{
                    ControleurFenetreModifierStock.setIdArticle(articleSelectionne.getIdArticle());
                    creerFenetre("/fenetreModifierStock.fxml", "Modifier stock", 250, 250);
                }
            }
            event.consume();
        });

        boutonSupprimerArticle.setOnAction(event -> {
            //On vérifie que l'utilisateur a sélectionné un ligne du tableau :
            ProduitsTableClass articleSelectionne = produitsTable.getSelectionModel().getSelectedItem();
            if(articleSelectionne != null){
                //On vérifie d'abord si l'utilisateur a le droit de supprimer un article dans ce rayon :
                if(utilisateurConnecte.getTypeDeCompte() == TypeDeCompte.UTILISATEUR && utilisateurConnecte.getRayonDirige().getIdRayon() != idRayon){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Impossible de supprimer un article d'un rayon que vous ne dirigez pas.", ButtonType.OK);
                    alert.show();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Êtes-vous sûr de vouloir supprimer " + articleSelectionne.getNom() + " ?");
                    Optional<ButtonType> choose = alert.showAndWait();
                    if(choose.get() == ButtonType.OK){
                        ProduitDAO.supprimerUnProduit(articleSelectionne.getIdArticle());
                        miseAJourDesTables();
                    }
                }
            }
            event.consume();
        });

        boutonTransfererArticles.setOnAction(event -> {
            creerFenetre("/fenetreTransfererArticles.fxml", "Transférer articles", 250, 250);
            event.consume();
        });

        buttonGestionUtilisateurs.setOnAction(event -> {
            //On vérifie d'abord si l'utilisateur a le droit de supprimer un article dans ce rayon :
            if(utilisateurConnecte.getTypeDeCompte() == TypeDeCompte.UTILISATEUR){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Vous ne disposez pas des droits suffisants.", ButtonType.OK);
                alert.show();
            }
            else{
                ControleurFenetreGestionUtilisateurs.setUtilisateurConnecte(utilisateurConnecte);
                creerFenetre("/fenetreGestionUtilisateurs.fxml", "Gestion des utilisateurs", 1080, 720);
            }

            event.consume();
        });

        //================================ Initialisation des tables ================================

        //Permet de détecter un double click sur une ligne de la table des rayons et d'afficher la liste des articles de celui-ci
        rayonsTable.setRowFactory(tv -> {
            final TableRow<RayonsTableClass> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    RayonsTableClass rowData = row.getItem();
                    idRayon = rowData.getIdRayon();
                    miseAJourDesTables();
                    paneArticles.toFront();
                    labelChemin.setText(utilisateurConnecte.getMagasin().getNomMagasin() + " > " + RayonDAO.trouverRayon(idRayon).getNomRayon());
                }
            });
            return row;
        });

        //On définit le nom de l'utilisateur affiché
        labelUtilisateur.setText(utilisateurConnecte.toString());

        //On fait le lien entre les lignes déclarées ici et celles du fichier .fxml et les éléments du modèle TableClass :
        colonneNom.setCellValueFactory( new PropertyValueFactory<>("nom") );
        colonneChefDeRayon.setCellValueFactory( new PropertyValueFactory<>("chef") );
        colonneNbArticles.setCellValueFactory( new PropertyValueFactory<>("nombre") );

        dataTableRayons = FXCollections.observableArrayList();
        rayonsTable.setItems(dataTableRayons);

        colonneNomp.setCellValueFactory( new PropertyValueFactory<>("nom") );
        colonnePrix.setCellValueFactory( new PropertyValueFactory<>("prix") );
        colonneDescription.setCellValueFactory( new PropertyValueFactory<>("description") );
        colonneReference.setCellValueFactory( new PropertyValueFactory<>("reference") );
        colonneStock.setCellValueFactory( new PropertyValueFactory<>("stock") );
        colonneReservations.setCellValueFactory( new PropertyValueFactory<>("reservations") );

        dataTableProduits = FXCollections.observableArrayList();
        produitsTable.setItems(dataTableProduits);

        //On affiche la table des rayons au lancement de l'application
        paneRayons.toFront();
    }

    /**
     * Méthode permettant de créer une nouvelle fenetre à partir d'un fichier FXML
     * @param fichierFXML le fichier FXML de la fenetre
     * @param titre le titre de la fenetre
     * @param largeur la largeur de la fenetre
     * @param hauteur la hauteur de la fenetre
     */
    private static void creerFenetre(String fichierFXML, String titre, int largeur, int hauteur){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(ControleurFenetrePrincipale.class.getResource(fichierFXML));
            root = loader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(FenetrePrincipale.class.getResourceAsStream(ControleurFenetrePrincipale.icon)));
            stage.setTitle(titre);
            stage.setScene(new Scene(root, largeur, hauteur));
            stage.show();
        }
        catch (IOException e) {
            logger.fatal(e);
        }
    }

    /**
     * Permet d'afficher la liste des rayons d'un magasin donné.
     * @param idM : le magasin dont on veut afficher les rayons.
     */
    public static void setContenuTableRayons(int idM){
        List<Rayon> rayons = MagasinDAO.tousLesRayons(idM);

        dataTableRayons.clear();

        EntityManager em = Connexion.getEntityManager();

        for(Rayon r : rayons){
            r = em.merge(r);

            //On récupère le nom du chef de rayon s'il n'est pas null grâce à la surcharge de toString de Utilisateur
            Utilisateur chefR = r.getChefDeRayon();
            String nomCR = "Ø";
            if(chefR != null){ nomCR = chefR.toString(); }

            dataTableRayons.add( new RayonsTableClass(r.getNomRayon(), nomCR, r.getNbProduits(), r.getIdRayon()) );
        }

        em.close();
    }

    /**
     * Permet d'afficher la liste des produits d'un rayon donné.
     * @param idR : le rayon dont on veut afficher les produits.
     */
    public static void setContenuTableProduits(int idR){
        List<Produit> produits = RayonDAO.tousLesProduits(idR);
        idRayon = idR;

        dataTableProduits.clear();

        EntityManager em = Connexion.getEntityManager();

        for(Produit p : produits){
            p = em.find(Produit.class, p.getIdProduit());

            dataTableProduits.add( new ProduitsTableClass(p.getNomProduit(), p.getPrix(), p.getStock(), p.getReservations(), p.getIdProduit(), p.getDescription(), p.getReference()) );
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

    /**
     * Cette fonction met à jour toutes les tables avec les dernières données de la BDD.
     */
    public static void miseAJourDesTables(){
        setContenuTableRayons(utilisateurConnecte.getMagasin().getIdMagasin());
        setContenuTableProduits(idRayon);
    }
}