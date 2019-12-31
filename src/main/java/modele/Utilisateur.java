package modele;

import javax.persistence.*;

@Entity
public class Utilisateur {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUtilisateur;

    private String nomDeCompte;
    private String nom;
    private String prenom;
    private String motDePasse;
    private TypeDeCompte typeDeCompte;
    private boolean restreint;

    //Utilisé pour magasin.chefDeMagasin
    @JoinColumn(name = "magasinDirige")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Magasin magasinDirige;

    //Utilisé pour rayon.chefDeRayon
    @JoinColumn(name = "rayonDirige")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rayon rayonDirige;

    //Utilisé pour magasin.listeEmployes
    @JoinColumn(name = "magasin")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Magasin magasin;

    //============================= Constructeurs =============================

    public Utilisateur(String nomDeCompte, String nom, String prenom, String motDePasse, TypeDeCompte typeDeCompte, boolean restreint, Magasin magasinDirige, Rayon rayonDirige, Magasin magasin) {
        this.nomDeCompte = nomDeCompte;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.typeDeCompte = typeDeCompte;
        this.restreint = restreint;
        this.magasinDirige = magasinDirige;
        this.rayonDirige = rayonDirige;
        this.magasin = magasin;
    }

    public Utilisateur(){
        restreint = false;
    }

    //============================= Méthodes =============================

    /**
     * Cette fonction détermine si un String correspond aux restrictions imposées sur les noms de compte.
     * Un nom de compte est acceptable si il contient au moins 4 caracteres et aucun caractère espace.
     * @param ndcompte : Un String
     * @return vrai si il est acceptable, faux sinon.
     */
    public static boolean estCeUnNomDeCompteAcceptable(String ndcompte){
        return !(ndcompte.contains(" ") || ndcompte.length()<4);
    }

    /**
     * Cette fonction détermine si un String correspond aux restrictions imposées sur les mots de passe.
     * Un mot de passe est acceptable si il contient au moins 8 caracteres.
     * @param mdpasse : Un String
     * @return vrai si il est acceptable, faux sinon.
     */
    public static boolean estCeUnMotDePasseAcceptable(String mdpasse){
        return (mdpasse.length()>=8);
    }

    /**
     * On override cette méthode pour afficher correctement le prenom et le nom de la personne lorsque l'on print(Utilisateur) par exemple.
     * Notamment utilisé dans les tables.
     * @return le prenom suivi du nom de l'utilisateur.
     */
    @Override
    public String toString() {
        return prenom + " " + nom;
    }

    //============================= Getters et Setters =============================

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomDeCompte() {
        return nomDeCompte;
    }

    public void setNomDeCompte(String nomDeCompte) {
        this.nomDeCompte = nomDeCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public TypeDeCompte getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(TypeDeCompte typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
    }

    public boolean isRestreint() {
        return restreint;
    }

    public void setRestreint(boolean restreint) {
        this.restreint = restreint;
    }

    public Magasin getMagasinDirige() {
        return magasinDirige;
    }

    public void setMagasinDirige(Magasin magasinDirige) {
        this.magasinDirige = magasinDirige;
    }

    public Rayon getRayonDirige() {
        return rayonDirige;
    }

    public void setRayonDirige(Rayon rayonDirige) {
        this.rayonDirige = rayonDirige;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
}