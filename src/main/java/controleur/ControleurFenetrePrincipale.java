package controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import modele.*;
import vue.FenetreDeParametres;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Cette classe définit le contenu des tables de l'application et toutes les actions liées aux boutons et sélections de lignes.
 */
public class ControleurFenetrePrincipale implements Initializable {

    private static Utilisateur utilisateurConnecte;

    //L'id du rayon actuellement affiché
    private static int idRayon;

    //Table et colonnes de la table des rayons d'un magasin :
    @FXML private BorderPane pane_rayons;
    @FXML private TableView<RayonsTableClass> rayonsTable;
    @FXML private TableColumn colonneNom;
    @FXML private TableColumn colonneChefDeRayon;
    @FXML private TableColumn colonneNbArticles;

    //Table et colonnes de la table des produits d'un rayon :
    @FXML private BorderPane pane_produits;
    @FXML private TableView<ProduitsTableClass> produitsTable;
    @FXML private TableColumn colonneNomp;
    @FXML private TableColumn colonnePrix;
    @FXML private TableColumn colonneStock;
    @FXML private TableColumn colonneReservations;

    @FXML private Text label_chemin;
    @FXML private Text label_utilisateur;

    //Définition des boutons
    @FXML private Button home_button;
    @FXML private Button settings_button;
    @FXML private Button bouton_creerArticle;
    @FXML private Button bouton_modifierArticle;
    @FXML private Button bouton_modifierStock;
    @FXML private Button bouton_supprimerArticle;
    @FXML private Button bouton_transfererArticles;

    @FXML private BorderPane pane_articles;

    //Les données de la table
    private static ObservableList<RayonsTableClass> dataTableRayons;
    private static ObservableList<ProduitsTableClass> dataTableProduits;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //================================ Définition des actions des boutons ================================

        //Bouton qui permet de revenir à la liste des rayons
        home_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane_rayons.toFront();
                event.consume();
            }
        });

        //Bouton pour ouvrir la fenêtre des paramètres (À REFAIRE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!)
        settings_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FenetreDeParametres.main(null);
                event.consume();
            }
        });

        bouton_creerArticle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControleurFenetreCreerArticle.setIdRayon(idRayon);
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fenetreCreerArticle.fxml"));
                    root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Créer article");
                    stage.setScene(new Scene(root, 350, 450));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                event.consume();
            }
        });

        bouton_modifierArticle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProduitsTableClass articleSelectionne = produitsTable.getSelectionModel().getSelectedItem();
                if(articleSelectionne != null){
                    ControleurFenetreModifierArticle.setIdArticle(articleSelectionne.getIdArticle());
                    Parent root;
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fenetreModifierArticle.fxml"));
                        root = loader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Modifier article");
                        stage.setScene(new Scene(root, 350, 350));
                        stage.show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    event.consume();
                }
            }
        });

        bouton_modifierStock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fenetreModifierStock.fxml"));
                    root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Modifier stock");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                event.consume();
            }
        });

        bouton_supprimerArticle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fenetreSupprimerArticle.fxml"));
                    root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Supprimer article");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                event.consume();
            }
        });

        bouton_transfererArticles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fenetreTransfererArticles.fxml"));
                    root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Transférer articles");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                event.consume();
            }
        });

        //================================ Définition des tables ================================

        //Permet de détecter un double click sur une ligne de la table des rayons et d'afficher la liste des articles de celui-ci
        rayonsTable.setRowFactory(new Callback<TableView<RayonsTableClass>, TableRow<RayonsTableClass>>() {
            @Override
            public TableRow<RayonsTableClass> call(TableView<RayonsTableClass> tv) {
                final TableRow<RayonsTableClass> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2 && (!row.isEmpty())) {
                            RayonsTableClass rowData = row.getItem();
                            setContenuTableProduits(rowData.getIdRayon());
                            pane_articles.toFront();
                            label_chemin.setText("azer");
                        }
                    }
                });
                return row;
            }
        });

        //On définit le nom de l'utilisateur affiché
        if(utilisateurConnecte != null){
            label_utilisateur.setText(utilisateurConnecte.toString());
        }

        //On fait le lien entre les lignes déclarées ici et celles du fichier .fxml et les éléments du modèle TableClass :
        colonneNom.setCellValueFactory( new PropertyValueFactory<RayonsTableClass, String>("nom") );
        colonneChefDeRayon.setCellValueFactory( new PropertyValueFactory<RayonsTableClass,String>("chef") );
        colonneNbArticles.setCellValueFactory( new PropertyValueFactory<RayonsTableClass,Integer>("nombre") );

        dataTableRayons = FXCollections.observableArrayList();
        rayonsTable.setItems(dataTableRayons);

        colonneNomp.setCellValueFactory( new PropertyValueFactory<ProduitsTableClass, String>("nom") );
        colonnePrix.setCellValueFactory( new PropertyValueFactory<ProduitsTableClass, Float>("prix") );
        colonneStock.setCellValueFactory( new PropertyValueFactory<ProduitsTableClass, Integer>("stock") );
        colonneReservations.setCellValueFactory( new PropertyValueFactory<ProduitsTableClass, Integer>("reservations") );

        dataTableProduits = FXCollections.observableArrayList();
        produitsTable.setItems(dataTableProduits);

        //On affiche la table des rayons au lancement de l'application
        pane_rayons.toFront();
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
            p = em.merge(p);

            dataTableProduits.add( new ProduitsTableClass(p.getNomProduit(), p.getPrix(), p.getStock(), p.getReservations(), p.getIdProduit()) );
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