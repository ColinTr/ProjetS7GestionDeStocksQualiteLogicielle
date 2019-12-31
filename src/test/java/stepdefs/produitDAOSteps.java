package stepdefs;

import controleur.Connexion;
import controleur.ProduitDAO;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modele.Produit;
import modele.Rayon;
import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.PersistentObjectException;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.CoreMatchers.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@DisplayName("ProduitDAOTestClass")
public class produitDAOSteps {

    List<Produit> listProduit = new ArrayList<Produit>();
    List<Produit> listProduitBDD = new ArrayList<Produit>();

    boolean resultat = true;

    @Before("@bdd")
    public void connectionBDD() {
        Connexion.init("modeCreate");
        System.out.println("TEST BEFORE");
    }

    @After("@bdd")
    public void closeConnectionBDD() {
        Connexion.close();
    }


    /*Méthodes tests recupération BDD*/
    @Given("^(\\d+) produits dans la bdd$")
    public void setNbProduitsDansBdd(int arg0) {
        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < arg0; i++) {
            Produit p = new Produit(RandomStringUtils.randomAlphanumeric(10), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1),null,"","");
            em.persist(p);
        }
        em.getTransaction().commit();
        em.close();
    }

    @When("^Quand on récupère la bdd et on stock la liste$")
    @Then("^Alors on récupère la bdd et on stock la liste$")
    @And("^Et on récupère la bdd et on stock la liste$")
    public void recupProduitsBDD() {
        listProduitBDD = ProduitDAO.tousLesProduits();
    }

    @Then("^Alors notre liste BDD contient (\\d+) produits$")
    @And("^Et notre liste BDD contient (\\d+) produits$")
    public void checkNbBDD(int arg0) {
        assertEquals(arg0, listProduitBDD.size());
    }


    @When("^On insère (\\d+) produits à la BDD et on les stocks dans une liste$")
    public void onInsereNumberProduitsALaBDDEtOnLesStocksDansUneListe(int arg0) {
        EntityManager em = Connexion.getEntityManager();
        for (int i = 0; i < arg0; i++) {
            Produit p = new Produit(RandomStringUtils.randomAlphanumeric(10), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1),null,"","");
            if (resultat) { resultat = ProduitDAO.ajouterUnProduit(p); }
            listProduit.add(p);
        }
        em.close();
    }

    @And("^La liste BDD contient les produits de la liste locale$")
    public void coherenceProduitInsereEtBDD() {
        for (Produit pInsere : listProduit) {
            assertThat(listProduitBDD, hasItem(pInsere));
        }
    }

    @When("^Quand on supprime (\\d+) produits et qu'on les stocks$")
    public void quandOnSupprimeNumProduitsEtQuOnLesStocks(int arg0) {
        EntityManager em = Connexion.getEntityManager();
        for (int i = 0; i < arg0; i++) {
            listProduit.add(listProduitBDD.get(i));
            if (resultat) { resultat = ProduitDAO.supprimerUnProduit(listProduitBDD.get(i)); }
        }
        em.close();
    }

    @And("^La liste BDD ne contient pas les produits de la liste locale$")
    public void laListeBDDNeContientPasLesProduitsDeLaListeLocale() {
        for (Produit pInsere : listProduit) {
            assertThat(listProduitBDD, not(hasItem(pInsere)));
        }
    }


    @And("^On remplie la liste BDD avec (\\d+) produits qui ne sont pas sur la BDD$")
    public void onRemplieLaListeBDDAvecProduitsQuiNeSontPasSurLaBDD(int arg0) {
        for (int i = 0; i < arg0; i++) {
            listProduitBDD.add(new Produit(RandomStringUtils.randomAlphanumeric(10), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1), null, "", ""));
        }
    }

    @When("^On reinsere les produits de la liste bdd dans la bdd$")
    public void onReinsereLesProduitsDeLaListeBddDansLaBdd() {
        EntityManager em = Connexion.getEntityManager();
        for (Produit produit : listProduitBDD) {
            if (resultat) { resultat = ProduitDAO.ajouterUnProduit(produit) ;}
        }
        em.close();
    }


    @Then("^Cela fonctionne$")
    public void celaFonctionne() {
        assert (resultat);
    }

    @Then("^Cela ne fonctionne pas$")
    public void celaNeFonctionnePas() {
        assert (!resultat);
    }
}