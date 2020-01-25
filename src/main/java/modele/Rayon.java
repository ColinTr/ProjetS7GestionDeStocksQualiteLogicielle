package modele;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rayon {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRayon;

    private String nomRayon;

    @OneToOne(mappedBy = "rayonDirige", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Utilisateur chefDeRayon;

    @OneToMany(mappedBy = "rayon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produit> listeProduits;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "magasin")
    private Magasin magasin;

    //============================= Méthodes =============================

    /**
     * Méthode qui renvoie le nombre de produits différents dans le rayon.
     * @return le nombre de produits.
     */
    public int getNbProduits(){
        return listeProduits.size();
    }

    /**
     * Méthode permettant d'ajouter un nouveau produit au rayon.
     * @param p : un produit.
     */
    public void ajouterProduit(Produit p){
        if(listeProduits == null){
            listeProduits = new ArrayList<>();
        }
        listeProduits.add(p);
    }

    //============================= Constructeurs =============================

    public Rayon(String nomRayon, Utilisateur chefDeRayon, List<Produit> listeProduits, Magasin magasin) {
        this.nomRayon = nomRayon;
        this.chefDeRayon = chefDeRayon;
        this.listeProduits = listeProduits;
        this.magasin = magasin;
    }

    public Rayon(){

    }

    @Override
    public String toString(){
        return nomRayon;
    }

    //============================= Getters et Setters =============================

    public int getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(int idRayon) {
        this.idRayon = idRayon;
    }

    public String getNomRayon() {
        return nomRayon;
    }

    public void setNomRayon(String nomRayon) {
        this.nomRayon = nomRayon;
    }

    public Utilisateur getChefDeRayon() {
        return chefDeRayon;
    }

    public void setChefDeRayon(Utilisateur chefDeRayon) {
        this.chefDeRayon = chefDeRayon;
    }

    public List<Produit> getListeProduits() {
        return listeProduits;
    }

    public void setListeProduits(List<Produit> listeProduits) {
        this.listeProduits = listeProduits;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
}