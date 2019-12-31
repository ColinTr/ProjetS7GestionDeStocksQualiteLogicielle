package controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import modele.*;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Cette classe définit le contenu des tables de l'application et toutes les actions liées aux boutons et sélections de lignes.
 */
public class ControleurFenetrePrincipale implements Initializable {

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

    @FXML private Button home_button;
    @FXML private Button settings_button;

    @FXML private BorderPane pane_articles;

    //Les données de la table
    private ObservableList<RayonsTableClass> dataTableRayons;
    private ObservableList<ProduitsTableClass> dataTableProduits;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Bouton qui permet de revenir à la liste des rayons
        home_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane_rayons.toFront();
                event.consume();
            }
        });

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

        //On affiche d'abord la table des rayons
        pane_rayons.toFront();
    }

    /**
     * Permet d'afficher la liste des rayons d'un magasin donné.
     * @param magasin : le magasin dont on veut afficher les rayons.
     */
    public void setContenuTableRayons(Magasin magasin){
        List<Rayon> rayons = MagasinDAO.tousLesRayons(magasin);

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
     * @param idRayon : le rayon dont on veut afficher les produits.
     */
    public void setContenuTableProduits(int idRayon){
        List<Produit> produits = RayonDAO.tousLesProduits(idRayon);

        dataTableProduits.clear();

        EntityManager em = Connexion.getEntityManager();

        for(Produit p : produits){
            p = em.merge(p);

            dataTableProduits.add( new ProduitsTableClass(p.getNomProduit(), p.getPrix(), p.getStock(), p.getReservations()) );
        }

        em.close();
    }
}