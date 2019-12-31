package modele;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProduitsTableClass {

    private SimpleStringProperty nom;
    private SimpleFloatProperty prix;
    private SimpleIntegerProperty stock;
    private SimpleIntegerProperty reservations;
    private int idArticle;

    public String getNom() {
        return nom.get();
    }

    public float getPrix() {
        return prix.get();
    }

    public int getStock() {
        return stock.get();
    }

    public int getReservations() {
        return reservations.get();
    }

    public int getIdArticle(){ return idArticle; }

    public ProduitsTableClass(String nom, float prix, int stock, int reservations, int idArticle) {
        this.nom = new SimpleStringProperty(nom);
        this.prix = new SimpleFloatProperty(prix);
        this.stock = new SimpleIntegerProperty(stock);
        this.reservations = new SimpleIntegerProperty(reservations);
        this.idArticle = idArticle;
    }
}