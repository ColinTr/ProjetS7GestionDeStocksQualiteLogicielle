package modele.tables;

import javafx.beans.property.SimpleStringProperty;

public class UtilisateursTableClass {
    private final SimpleStringProperty nomCompte;
    private final SimpleStringProperty nom;
    private final SimpleStringProperty prenom;
    private final SimpleStringProperty typeCompte;
    private final SimpleStringProperty acces;
    private final SimpleStringProperty rayonDirige;
    private final SimpleStringProperty magasin;
    private final int idUtilisateur;

    public String getNomCompte() {
        return nomCompte.get();
    }

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public String getTypeCompte() {
        return typeCompte.get();
    }

    public String getAcces() {
        return acces.get();
    }

    public String getRayonDirige() {
        return rayonDirige.get();
    }

    public String getMagasin() {
        return magasin.get();
    }

    public int getIdUtilisateur(){ return idUtilisateur; }

    public UtilisateursTableClass(String nc, String n, String p, String t, String a, String r, String m, int i) {
        this.nomCompte = new SimpleStringProperty(nc);
        this.nom = new SimpleStringProperty(n);
        this.prenom = new SimpleStringProperty(p);
        this.typeCompte = new SimpleStringProperty(t);
        this.acces = new SimpleStringProperty(a);
        this.rayonDirige = new SimpleStringProperty(r);
        this.magasin = new SimpleStringProperty(m);
        this.idUtilisateur = i;
    }
}
