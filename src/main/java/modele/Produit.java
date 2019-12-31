package modele;

import javax.persistence.*;

@Entity
public class Produit {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduit;

    private String nomProduit;
    private int stock;
    private int reservations;
    private float prix;
    private String description;
    private String reference;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rayon")
    private Rayon rayon;

    //============================= Constructeurs =============================

    public Produit(String nomProduit, int stock, int reservations, float prix, Rayon rayon, String description, String reference) {
        this.nomProduit = nomProduit;
        this.stock = stock;
        this.reservations = reservations;
        this.prix = prix;
        this.rayon = rayon;
        this.description = description;
        this.reference = reference;
    }

    public Produit() {
        nomProduit = "";
        stock = 0;
        reservations = 0;
        prix = 0;
        rayon = null;
        description = "";
        reference = "";
    }

    //============================= Méthodes ============================

    public boolean reservation(int quantite){
        if( stock - reservations - quantite >= 0 ){
            reservations += quantite;
            return true;
        }
        return false;
    }

    public boolean ajout(int quantite){
        if( stock - reservations + quantite >= 0 ){
            stock+= quantite;
            return true;
        }
        return false;
    }

    public boolean suppression(int quantite){
        if( stock - reservations - quantite >= 0 ){
            stock -= quantite;
            return true;
        }
        return false;
    }

    //============================= Getters et Setters =============================

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getReference() { return reference; }

    public void setReference(String reference) { this.reference = reference; }
}