package it.stepdefs;

import controleur.Connexion;
import controleur.UtilisateurDAO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import modele.Magasin;
import modele.Rayon;
import modele.TypeDeCompte;
import modele.Utilisateur;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class utilisateurDAOSteps {

    Utilisateur utilisateur;

    @Given("J'ai un utilisateur sur la base de donnée")
    public void jAiUnUtilisateurSurLaBaseDeDonnée() {
        utilisateur = new Utilisateur("JD","Doe","John",UtilisateurDAO.SHA512("1234"), TypeDeCompte.ADMINISTRATEUR,false,null,null,null);

        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();

        em.persist(utilisateur);

        em.getTransaction().commit();
    }

    @When("Je supprime l'utilisateur")
    public void jeSupprimeLUtilisateur() {
        UtilisateurDAO.supprimerUtilisateur(utilisateur.getIdUtilisateur());
    }

    @Then("Il n'est plus sur la base de donnée")
    public void ilNEstPlusSurLaBaseDeDonnée() {
        EntityManager em = Connexion.getEntityManager();
        Utilisateur u = em.find(Utilisateur.class, utilisateur.getIdUtilisateur());
        assertNull(u);
    }


    Rayon rayon;

    @And("J'ai un rayon sur la base de donnée")
    public void jAiUnRayonSurLaBaseDeDonnée() {
        rayon = new Rayon();

        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();

        em.persist(rayon);

        em.getTransaction().commit();
    }

    @When("Je définie que l'utilisateur est le chef du rayon")
    public void jeDéfinieQueLUtilisateurEstLeChefDuRayon() {
        UtilisateurDAO.definirChefRayon(utilisateur.getIdUtilisateur(), rayon.getIdRayon());
    }

    @Then("Lorsqu'on recupere le rayon, le chef est bien l'utilisateur")
    public void lorsquOnRecupereLeRayonLeChefEstBienLUtilisateur() {
        EntityManager em = Connexion.getEntityManager();
        Rayon rayonRecup = em.find(Rayon.class, rayon.getIdRayon());

        assertEquals(rayonRecup.getChefDeRayon().getIdUtilisateur(), utilisateur.getIdUtilisateur());
    }


    Magasin magasin;

    @And("J'ai un magasin sur la base de donnée")
    public void jAiUnMagasinSurLaBaseDeDonnée() {
        magasin = new Magasin();

        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();

        em.persist(magasin);

        em.getTransaction().commit();
    }

    @When("Je définie que l'utilisateur est le chef du magasin")
    public void jeDéfinieQueLUtilisateurEstLeChefDuMagasin() {
        UtilisateurDAO.definirChefMagasin(utilisateur.getIdUtilisateur(), magasin.getIdMagasin());
    }

    @Then("Lorsqu'on recupere le magasin, le chef est bien l'utilisateur")
    public void lorsquOnRecupereLeMagasinLeChefEstBienLUtilisateur() {
        EntityManager em = Connexion.getEntityManager();
        Magasin magasinRecup = em.find(Magasin.class, magasin.getIdMagasin());

        assertEquals(magasinRecup.getChefDeMagasin().getIdUtilisateur(), utilisateur.getIdUtilisateur());
    }


    @When("Je teste l'authentification de cet utilisateur avec le bon mot de passe")
    public void jeTesteLAuthentificationDeCetUtilisateurAvecLeBonMotDePasse() {
        assertNotNull(UtilisateurDAO.testerAuthentification("JD", "1234"));
    }

    @When("Je teste l'authentification de cet utilisateur avec un mauvais mot de passe")
    public void jeTesteLAuthentificationDeCetUtilisateurAvecUnMauvaisMotDePasse() {
        assertNull(UtilisateurDAO.testerAuthentification("JD", "wrongPassword"));
    }

    @When("Je teste un bon nom de compte")
    public void jeTesteUnNomDeCompte() {
        assertNotNull(UtilisateurDAO.testerNomDeCompte("JD"));
    }

    @When("Je teste un mauvais nom de compte")
    public void jeTesteUnMauvaisNomDeCompte() {
        assertNull(UtilisateurDAO.testerNomDeCompte("usEr"));
    }

    @Given("J'ai un utilisateur")
    public void jAiUnUtilisateur() {
        utilisateur = new Utilisateur("JD","Doe","John",UtilisateurDAO.SHA512("1234"), TypeDeCompte.ADMINISTRATEUR,false,null,null,null);
    }

    @When("Je l'ajoute sur la base de donnée")
    public void jeLAjouteSurLaBaseDeDonnée() {
        UtilisateurDAO.creerUtilisateur(utilisateur);
    }

    @Then("Il est sur la base de donnée")
    public void ilEstSurLaBaseDeDonnée() {
        EntityManager em = Connexion.getEntityManager();
        Utilisateur utilisateurRecup = em.find(Utilisateur.class, utilisateur.getIdUtilisateur());
        assertNotNull(utilisateurRecup);
        assertEquals(utilisateurRecup.getIdUtilisateur(), utilisateur.getIdUtilisateur());
    }

    List<Utilisateur> utilisateurList;

    @Given("J'ai trois utilisateurs sur la base de donnée")
    public void jAiTroisUtilisateursSurLaBaseDeDonnée() {

        utilisateurList = new ArrayList<>();

        utilisateurList.add(new Utilisateur());
        utilisateurList.add(new Utilisateur());
        utilisateurList.add(new Utilisateur());

        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();

        for (Utilisateur u:utilisateurList) {
            em.persist(u);
        }

        em.getTransaction().commit();
    }

    List<Utilisateur> utilisateursRecup;

    @When("Je recupere les utilisateurs de la base de donnée")
    public void jeRecupereLesUtilisateursDeLaBaseDeDonnée() {
        utilisateursRecup = UtilisateurDAO.tousLesUtilisateurs();
    }

    @Then("La liste d'utilisateurs recupérés sont les mêmes que ceux insérés")
    public void laListeDUtilisateursRecupérésSontLesMêmesQueCeuxInsérés() {
        for (Utilisateur u: utilisateurList) {
            boolean present = false;
            for (Utilisateur uBdd:utilisateursRecup) {
                if (u.getIdUtilisateur() == uBdd.getIdUtilisateur()){
                    present = true;
                    break;
                }
            }
            assertTrue(present);
        }
    }

    Utilisateur utilisateurRecup;

    @When("Je recupere un utilisateur")
    public void jeRecupereUnUtilisateur() {
        utilisateurRecup = UtilisateurDAO.getUtilisateur(utilisateurList.get(0).getIdUtilisateur());
    }

    @Then("L'utilisateur que je recupere est bien le bon")
    public void lUtilisateurQueJeRecupereEstBienLeBon() {
        assertNotNull(utilisateurRecup);
        assertEquals(utilisateurRecup.getIdUtilisateur(), utilisateurList.get(0).getIdUtilisateur());
    }
}
