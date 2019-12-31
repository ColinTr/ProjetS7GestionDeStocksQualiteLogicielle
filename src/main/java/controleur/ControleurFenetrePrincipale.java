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
import javafx.util.Callback;
import modele.Magasin;
import modele.RayonsTableClass;
import modele.Rayon;
import modele.Utilisateur;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleurFenetrePrincipale implements Initializable {

    @FXML private Button home_button;

    //La table et les colonnes
    @FXML private BorderPane pane_rayons;
    @FXML private TableView<RayonsTableClass> rayonsTable;
    @FXML private TableColumn colonneNom;
    @FXML private TableColumn colonneChefDeRayon;
    @FXML private TableColumn colonneNbArticles;


    @FXML private BorderPane pane_articles;

    //Les données de la table
    private ObservableList<RayonsTableClass> data;

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
                            pane_articles.toFront();
                        }
                    }
                });
                return row;
            }
        });

        colonneNom.setCellValueFactory( new PropertyValueFactory<RayonsTableClass, Long>("nom") );
        colonneChefDeRayon.setCellValueFactory( new PropertyValueFactory<RayonsTableClass,String>("chef") );
        colonneNbArticles.setCellValueFactory( new PropertyValueFactory<RayonsTableClass,Integer>("nombre") );

        data = FXCollections.observableArrayList();
        rayonsTable.setItems(data);

        //On affiche d'abord la table des rayons
        pane_rayons.toFront();
    }

    /**
     * Permet d'afficher la liste des rayons d'un magasin donné.
     * @param magasin : le magasin dont on veut afficher les rayons.
     */
    public void setContenuTable(Magasin magasin){
        List<Rayon> rayons = MagasinDAO.tousLesRayons(magasin);

        System.out.println(rayons.size());

        data.clear();

        EntityManager em = Connexion.getEntityManager();

        for(Rayon r : rayons){
            r = em.merge(r);

            //On récupère le nom du chef de rayon s'il n'est pas null grâce à la surcharge de toString de Utilisateur
            Utilisateur chefR = r.getChefDeRayon();
            String nomCR = "Ø";
            if(chefR != null){ nomCR = chefR.toString(); }

            data.add(new RayonsTableClass(r.getNomRayon(), nomCR, r.getNbProduits()));
        }

        em.close();
    }
}