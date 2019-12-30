package controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import modele.Magasin;
import modele.MagasinTableClass;
import modele.Rayon;

import javax.persistence.EntityManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleurFenetrePrincipale implements Initializable {

    //La table et les colonnes
    @FXML private TableView<MagasinTableClass> itemTbl;
    @FXML private TableColumn colonneNom;
    @FXML private TableColumn colonneChefDeRayon;
    @FXML private TableColumn colonneNbArticles;

    //Les données de la table
    private ObservableList<MagasinTableClass> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemTbl.setRowFactory(new Callback<TableView<MagasinTableClass>, TableRow<MagasinTableClass>>() {
            @Override
            public TableRow<MagasinTableClass> call(TableView<MagasinTableClass> tv) {
                final TableRow<MagasinTableClass> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2 && (!row.isEmpty())) {
                            MagasinTableClass rowData = row.getItem();
                            System.out.println("Double click on: " + rowData.getNom());
                        }
                    }
                });
                return row;
            }
        });

        colonneNom.setCellValueFactory( new PropertyValueFactory<MagasinTableClass, Long>("nom") );
        colonneChefDeRayon.setCellValueFactory( new PropertyValueFactory<MagasinTableClass,String>("chef") );
        colonneNbArticles.setCellValueFactory( new PropertyValueFactory<MagasinTableClass,Integer>("nombre") );

        data = FXCollections.observableArrayList();
        itemTbl.setItems(data);
    }

    public void setContenuTable(Magasin magasin){
        List<Rayon> rayons = MagasinDAO.tousLesRayons(magasin);

        data.clear();

        EntityManager em = Connexion.getEntityManager();

        for(Rayon r : rayons){
            r = em.merge(r);
            data.add(new MagasinTableClass(r.getNomRayon(), r.getChefDeRayon().toString(), r.getNbProduits()));
        }

        em.close();
    }
}