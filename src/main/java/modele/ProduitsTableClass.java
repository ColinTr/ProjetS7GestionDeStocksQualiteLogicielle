package modele;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProduitsTableClass {

    private SimpleStringProperty nom;
    private SimpleFloatProperty prix;
    private SimpleIntegerProperty stock;
    private SimpleIntegerProperty reservations;
    private SimpleStringProperty description;
    private SimpleStringProperty reference;
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

    public String getDescription() { return description.get(); }

    public String getReference() { return reference.get(); }

    public int getIdArticle(){ return idArticle; }


    public ProduitsTableClass(String nom, float prix, int stock, int reservations, int idArticle, String description, String reference) {
        this.nom = new SimpleStringProperty(nom);
        this.prix = new SimpleFloatProperty(prix);
        this.stock = new SimpleIntegerProperty(stock);
        this.reservations = new SimpleIntegerProperty(reservations);
        this.description = new SimpleStringProperty(description);
        this.reference = new SimpleStringProperty(reference);
        this.idArticle = idArticle;

    }
}