package stepdefs;

import controleur.Connexion;
import controleur.ProduitDAO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modele.Produit;
import modele.Rayon;
import org.apache.commons.lang.RandomStringUtils;
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
    List<Produit> listProduitInsere = new ArrayList<Produit>();
    List<Produit> listProduitBDD = new ArrayList<Produit>();

    @Given("^j'ai (\\d+) produits en local$")
    public void jAiProduitsEnLocal(int arg0){
        for (int i = 0; i < arg0; i++){
            Produit p = new Produit(RandomStringUtils.randomAlphanumeric(10),new Random().nextInt(101 + 1), new Random().nextInt(101 + 1),new Random().nextInt(101 + 1),null);
            listProduit.add(p);
        }
    }

    @Given("^on est connecté à la bdd$")
    public void connectionBDD(){ Connexion.init("modeCreate"); }

    @Given("^(\\d+) dans la bdd$")
    public void setNbProduitsDansBdd(int arg0){
        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < arg0; i++){
            Produit p = new Produit(RandomStringUtils.randomAlphanumeric(10),new Random().nextInt(101 + 1), new Random().nextInt(101 + 1),new Random().nextInt(101 + 1),new Rayon());
            em.persist(p);
        }
        em.getTransaction().commit();
        em.close();
    }

    @When("^j'essaie d'en ajouter (\\d+) a la bdd$")
    public void EssaieAjoutBDD(int arg0){
        EntityManager em = Connexion.getEntityManager();
        for (int i = 0; i < arg0; i++){
            ProduitDAO.ajouterUnProduit(listProduit.get(i));
        }
        em.close();
    }

    @Then("^on récupere la liste bdd$")
    public void recupProduitsBDD(){
        EntityManager em = Connexion.getEntityManager();
        listProduitBDD = ProduitDAO.tousLesProduits();
        em.close();
    }

    @And("^il en y a (\\d+) dans la liste bdd$")
    public void checkNbBDD(int arg0){
        assertEquals(arg0, listProduitBDD.size());
    }

    @And("^on retrouve les produits inséré dans la liste bdd$")
    public void coherenceProduitInsereEtBDD(){
        for (Produit pInsere: listProduitInsere) {
            assertThat(listProduitBDD, hasItem(pInsere));
        }
    }


    @And("^la bdd est fermée$")
    public void closeConnectionBDD(){ Connexion.close(); }

}
