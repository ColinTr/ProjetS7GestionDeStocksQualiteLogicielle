package controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Magasin;
import modele.MagasinTableClass;
import modele.Rayon;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class controleurFenetrePrincipale implements Initializable {

    //La table et les colonnes
    @FXML private TableView<MagasinTableClass> itemTbl;
    @FXML private TableColumn colonneNom;
    @FXML private TableColumn colonneChefDeRayon;
    @FXML private TableColumn colonneNbArticles;

    //Les données de la table
    private ObservableList<MagasinTableClass> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colonneNom.setCellValueFactory( new PropertyValueFactory<MagasinTableClass, Long>("nom") );
        colonneChefDeRayon.setCellValueFactory( new PropertyValueFactory<MagasinTableClass,String>("chef") );
        colonneNbArticles.setCellValueFactory( new PropertyValueFactory<MagasinTableClass,Integer>("nombre") );

        data = FXCollections.observableArrayList();
        itemTbl.setItems(data);

        MagasinTableClass item = new MagasinTableClass("Pêche","Colin Troisemaine",42);
        data.add(item);
    }

    public void setContenuTable(Magasin magasin){
        List<Rayon> rayons = MagasinDAO.tousLesRayons(magasin);

        for(Rayon r : rayons){
            data.add(new MagasinTableClass(r.getNomRayon(), r.getChefDeRayon().toString(), r.getNbProduits()));
        }
    }
}