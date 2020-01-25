package it.stepdefs;

import controleur.Connexion;
import controleur.ProduitDAO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Produit;
import modele.Rayon;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Transaction;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class produitDAOSteps {

    List<Produit> listProduit = new ArrayList<Produit>();
    List<Produit> listProduitBDD = new ArrayList<Produit>();




















    // -----------------------------------------------------------------------

    /* === Récupération de la Base de donnée === */


    @Before("@bdd")
    public void connectionBDD() {
        Connexion.init("testUnit");
    }

    @After("@bdd")
    public void closeConnectionBDD() {
        Connexion.close();
    }


    @Given("^On met (\\d+) produits dans la bdd et on stock dans la liste locale$")
    public void onMetXProduitsDansLaBddEtOnStockDansLaListeLocal(int arg0){
        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();
        Rayon r = new Rayon();
        for (int i = 0; i < arg0; i++) {
            Produit p = new Produit(RandomStringUtils.randomAlphanumeric(10), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1), new Random().nextInt(101 + 1),r,"","");
            em.persist(p);
            listProduit.add(p);
        }
        em.getTransaction().commit();
        em.close();
    }

    @When("^On récupère la bdd et on la stock dans la liste bdd$")
    @Then("^Alors on récupère la bdd et on la stock dans la liste bdd$")
    public void onRecupereLaBddEtOnLaStockDansLaListeBdd(){
        listProduitBDD = ProduitDAO.tousLesProduits();
    }

    @Then("^La liste bdd fait la taille (\\d+)$")
    public void laListeBddFaitLaTailleX(int arg0){
        assertEquals(arg0, listProduitBDD.size());
    }

    @Then("^La liste bdd contient les produits de la liste locale$")
    public void laListeBddContientLesProduitsDeLaListeLocale(){
        for (Produit p : listProduit) {
            assertThat(listProduitBDD, hasItem(p));
        }
    }

    /* === Récupération de la Base de donnée avec id === */

    //Given : On met (\d+) produits dans la bdd et on stock dans la liste locale

    @When("^On récupère la bdd et on la stock dans la liste bdd avec l'id$")
    public void onRecupereLaBddEtOnLaStockDansLaListeBddAvecLId(){
        for (Produit p : listProduit) {
            listProduitBDD.add(ProduitDAO.trouverProduit(p.getIdProduit()));
        }
    }

    //Then : La liste bdd fait la taille (\d+)
    //Then : La liste bdd contient les produits de la liste locale

    /* === Ajout produit BDD valide === */

    //Given : On met (\d+) produits dans la bdd et on stock dans la liste locale

    @Given("^On génère (\\d+) produits dans la liste locale$")
    public void onGenereXProduitsDansLaListeLocale(int arg0){
        listProduit.clear();
        for (int i = 0; i < arg0; i++){
            listProduit.add(new Produit());
        }
    }

    @When("^On insère les produits de la liste locale dans la bdd VALIDE$")
    public void onInsereLesProduitsDeLaListeLocaleDansLaBddValide() {
        for (Produit p : listProduit){
            assert (ProduitDAO.ajouterUnProduit(p));
        }
    }

    //Then : On récupère la bdd et on la stock dans la liste bdd
    //Then : La liste bdd fait la taille (\d+)
    //Then : La liste bdd contient les produits de la liste locale


    /* === Ajout produit BDD non valide === */

    //Given : On met (\d+) produits dans la bdd et on stock dans la liste locale


    @When("^On insère les produits de la liste locale dans la bdd NON VALIDE$")
    public void onInsereLesProduitsDeLaListeLocaleDansLaBddNonValide() {
        for (Produit p : listProduit){
            assert (!ProduitDAO.ajouterUnProduit(p));
        }
    }
    //Then : On récupère la bdd et on la stock dans la liste bdd
    //Then : La liste bdd fait la taille (\d+)
    //Then : La liste bdd contient les produits de la liste locale


    /* === Suppression produit BDD valide === */

    //Given : On met (\d+) produits dans la bdd et on stock dans la liste locale

    @When("^On supprime dans la bdd les produits de la liste locale VALIDE$")
    public void onSupprimeDansLaBddLesProduitsDeLaListeLocaleValide(){
        for (Produit p : listProduit){
            assert(ProduitDAO.supprimerUnProduit(p));
        }
    }

    @When("^On supprime par id dans la bdd les produits de la liste locale VALIDE$")
    public void onSupprimeParIdDansLaBddLesProduitsDeLaListeLocaleValide(){
        for (Produit p : listProduit){
            assert(ProduitDAO.supprimerUnProduit(p.getIdProduit()));
        }
    }

    //Then : On récupère la bdd et on la stock dans la liste bdd
    //Then : La liste bdd fait la taille (\d+)

    @Then("^La liste bdd ne contient pas les produits de la liste locale$")
    public void laListeBddNeContientPasLesProduitsDeLaListeLocale(){
        for (Produit p : listProduit) {
            assertThat(listProduitBDD, not(hasItem(p)));
        }
    }

    /* === Suppression produit BDD non valide === */

    //Given : On met (\d+) produits dans la bdd et on stock dans la liste locale
    //Given : On génère (\d+) produits dans la liste locale

    @When("^On supprime dans la bdd les produits de la liste locale NON VALIDE$")
    public void onSupprimeDansLaBddLesProduitsDeLaListeLocaleNonValide(){
        for (Produit p : listProduit){
            assert(!ProduitDAO.supprimerUnProduit(p));
        }
    }

    @When("^On supprime par id dans la bdd les produits de la liste locale NON VALIDE$")
    public void onSupprimeParIdDansLaBddLesProduitsDeLaListeLocaleNonValide(){
        for (Produit p : listProduit){
            assert(!ProduitDAO.supprimerUnProduit(p.getIdProduit()));
        }
    }


    //Then : On récupère la bdd et on la stock dans la liste bdd
    //Then : La liste bdd fait la taille (\d+)
    //Then : La liste bdd ne contient pas les produits de la liste locale

    /* === Suppression de stock d'un produit de la BDD valide === */

    //Given : On génère (\d+) produits dans la liste locale

    @Given("^On met le stock des produits aléatoirement avec comme minimum (\\d+)$")
    public void onMetLeStockDesProduitsAleaAvecCommeMinX(int arg0){
        for (Produit p : listProduit) {
            p.setStock(new Random().nextInt(1000 + 1) + arg0);
        }
    }

    //Given : On insère les produits de la liste locale dans la bdd VALIDE

    @When("^On supprime (\\d+) au stock de tout les produits de la liste locale sur la bdd VALIDE$")
    public void onSupprimeXAuStockDeToutLesProduitsDeLaListeLocaleSurLaBddValide(int arg0){
        for (Produit p : listProduit) {
            assert (ProduitDAO.suppressionStockProduit(p, arg0));
        }
    }

    //Then : On récupère la bdd et on la stock dans la liste bdd

    @Then("^Tous les produits ont leurs stock initial moins (\\d+)$")
    public void tousLesProduitsOntLeursStockInitialMoinsX(int arg0){
        for (int i = 0; i < listProduitBDD.size(); i++) {
            assertEquals(listProduitBDD.get(i).getStock(), listProduit.get(i).getStock()-arg0);
        }
    }

    /* === Suppression de stock d'un produit de la BDD non valide === */

    //Given : On génère (\d+) produits dans la liste locale

    @Given("^On met le stock des produits aléatoirement avec comme maximum (\\d+)$")
    public void onMetLeStockDesProduitsAleatoirementAvecCommeMaximumMax(int arg0) {
        for (Produit p : listProduit) {
            p.setStock(new Random().nextInt(arg0));
        }
    }

    //Given : On insère les produits de la liste locale dans la bdd VALIDE

    @When("^On supprime (\\d+) au stock de tout les produits de la liste locale sur la bdd NON VALIDE$")
    public void onSupprimeXAuStockDeToutLesProduitsDeLaListeLocaleSurLaBddNonValide(int arg0){
        for (Produit p : listProduit) {
            assert (!ProduitDAO.suppressionStockProduit(p, arg0));
        }
    }

    //Then : On récupère la bdd et on la stock dans la liste bdd

    @Then("^Tous les produits ont leurs stock initial$")
    public void tousLesProduitsOntLeursStockInitial(){
        for (int i = 0; i < listProduitBDD.size(); i++) {
            assertEquals(listProduitBDD.get(i).getStock(), listProduit.get(i).getStock());
        }
    }

    /* === Ajout de stock d'un produit de la BDD === */

    //Given : On génère (\d+) produits dans la liste locale
    //Given : On met le stock des produits aléatoirement avec comme minimum (\d+)
    //Given : On insère les produits de la liste locale dans la bdd VALIDE

    @When("^On ajoute (\\d+) au stock de tout les produits de la liste locale sur la bdd$")
    public void onAjouteXAuStockDeToutLesProduitsDeLaListeLocaleSurLaBdd(int arg0) {
        for (Produit p : listProduit) {
            assert (ProduitDAO.ajoutStockProduit(p, arg0));
        }
    }

    //Then : On récupère la bdd et on la stock dans la liste bdd

    @Then("^Tous les produits ont leurs stock initial plus (\\d+)$")
    public void tousLesProduitsOntLeursStockInitialPlusX(int arg0) {
        for (int i = 0; i < listProduitBDD.size(); i++) {
            assertEquals(listProduitBDD.get(i).getStock(), listProduit.get(i).getStock()+arg0);
        }
    }









    private List<Object> listBDD = new ArrayList<Object>();
    private List<Produit> produitsRecup = new ArrayList<Produit>();

    @Before("DAO")
    public void mockBDD(){
        PowerMockito.mockStatic(Connexion.class);

        EntityManager em = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        Transaction transaction = Mockito.mock(Transaction.class);

        Mockito.when(em.createQuery("SELECT u FROM Produit u")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(listBDD);

        BDDMockito.given(Connexion.getEntityManager()).willReturn(em);
    }



    @Given("Une liste de produits sur la bdd")
    public void uneListeDeProduitsSurLaBdd() {
        listBDD.add(Mockito.mock(Produit.class));
    }

    @When("On récupère cette liste de produits")
    public void onRécupèreCetteListeDeProduits() {
        produitsRecup = ProduitDAO.tousLesProduits();
    }

    @Then("La liste récupérée correspond avec la liste de la bdd")
    public void laListeRécupéréeCorrespondAvecLaListeDeLaBdd() {
        for (Produit p : produitsRecup) {
            assertThat(listBDD, hasItem(p));
        }
    }








    @Given("Je me connecte à la bdd")
    public void jeMeConnecteÀLaBdd() {
        //Connexion.init("testUnit");
    }

    @Then("Je me deconnecte de la bdd")
    public void jeMeDeconnecteDeLaBdd() {
        //Connexion.close();
    }


    Produit produit;
    Produit produitRecupere;

    @Given("J'ai un produit")
    public void jAiUnProduit() {
        produit = new Produit();
    }

    @And("J'ajoute le produit à la bdd")
    public void jeLAjouteÀLaBdd() {
        assertTrue(ProduitDAO.ajouterUnProduit(produit));
    }

    @When("Je récupère le produit sur la base de donnée")
    public void jeRécupèreLeProduitSurLaBaseDeDonnée() {
        produitRecupere = ProduitDAO.trouverProduit(produit.getIdProduit());
    }

    @Then("Le produit récupéré est le même que celui ajouté")
    public void leProduitRécupéréEstLeMêmeQueCeluiAjouté() {
        assertEquals(produit, produitRecupere);
    }

    boolean res1;
    boolean res2;

    @When("J'ajoute le produit deux fois à la bdd")
    public void jeLAjouteDeuxFoisÀLaBdd() {
        res1 = ProduitDAO.ajouterUnProduit(produit);
        res2 = ProduitDAO.ajouterUnProduit(produit);
    }

    @Then("Le premier fonctionne mais pas le deuxième")
    public void lePremierFonctionneMaisPasLeDeuxième() {
        assertTrue(res1);
        assertFalse(res2);
    }

    @When("Je supprime le produit de la bdd")
    public void jeSupprimeLeProduitDeLaBdd() {
        assertTrue(ProduitDAO.supprimerUnProduit(produit.getIdProduit()));
    }

    @Then("Je ne trouve pas le produit sur la bdd")
    public void jeNeTrouvePasLeProduitSurLaBdd() {
        assertNull(ProduitDAO.trouverProduit(produit.getIdProduit()));
    }

    List<Produit> produits = new ArrayList<Produit>();

    @Given("J'ai trois produits")
    public void jAiTroisProduits() {
        listProduit.add(new Produit());
        listProduit.add(new Produit());
        listProduit.add(new Produit());
    }

    @And("J'ajoute les trois produits à la base de donnée")
    public void jAjouteLesTroisProduitsÀLaBaseDeDonnée() {
        ProduitDAO.ajouterUnProduit(listProduit.get(0));
        ProduitDAO.ajouterUnProduit(listProduit.get(1));
        ProduitDAO.ajouterUnProduit(listProduit.get(2));
    }

    List<Produit> produitsBDD = new ArrayList<Produit>();

    @When("Je recupere tous les produits de la base de donnée")
    public void jeRecupereTousLesProduitsDeLaBaseDeDonnée() {
        produitsBDD = ProduitDAO.tousLesProduits();
    }

    @Then("La liste de produit récupéré est composé des trois produits insérée au départ")
    public void laListeDeProduitRécupéréEstComposéDesTroisProduitsInséréeAuDépart() {
        for (Produit p : produits) {
            assertThat(produitsBDD, hasItem(p));
        }
    }
}