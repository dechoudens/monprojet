
package dechoudens.projetmaven;

import dechoudens.projetmaven.domaine.Equipe;
import dechoudens.projetmaven.domaine.Coureur;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Meckanik
 */
public class EquipeTest {
  private static final int NB_COUREUR = 10;
  private Equipe equipe;

  @BeforeMethod
  public void setUp() throws Exception {
    equipe = new Equipe("Equipe de test", NB_COUREUR);
  }

  @Test
  public void testAddCoureur() {

    Coureur c = new Coureur("UNIT", "Test", 'M', 0);

    int initialSize = equipe.getSizeListeCoureurs();
    equipe.addCoureur(c);
    int finalSize = equipe.getSizeListeCoureurs();

    assertTrue(finalSize == initialSize + 1);
  }

  @Test
  public void testMultipleAddCoureur() {

    Coureur c = new Coureur("UNIT", "Test", 'M', 0);

    int initialSize = equipe.getSizeListeCoureurs();
    ArrayList<Coureur> coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'M', 0));
    }
    equipe.setCoureurs(coureurs);
    
    int finalSize = equipe.getSizeListeCoureurs();

    assertTrue(finalSize == initialSize + NB_COUREUR);
  }

  @Test
  public void testMeilleur() {

    ArrayList coureurs = new ArrayList();
    double temps = 0;
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'M', temps + 1));
    }
    equipe.setCoureurs(coureurs);

    Coureur result = equipe.meilleurCoureur();
    assertEquals(result.getTemps(), 1.0);
  }

  @Test
  public void testMajoriteMasculine() {

    ArrayList<Coureur> coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'M', 0));
    }
    equipe.setCoureurs(coureurs);
   

    String expResult = "masculine";
    String result = equipe.composition();
    assertEquals(result, expResult);
  }

  @Test
  public void testMajoriteFeminine() {
    ArrayList coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'F', 0));
    }
    equipe.setCoureurs(coureurs);

    String expResult = "feminine";
    String result = equipe.composition();
    assertEquals(result, expResult);
  } 

  @Test
  public void testMajoriteMixte() {
    ArrayList coureurs = new ArrayList();
    
    boolean change = true;
    for (int i = 0; i < NB_COUREUR; i++) {
      if (change) {
        coureurs.add(new Coureur("UNIT", "Test", 'F', 0));
      }
      else{
        coureurs.add(new Coureur("UNIT", "Test", 'M', 0));
      }
      change = !change;
    }
    equipe.setCoureurs(coureurs);

    String expResult = "mixte";
    String result = equipe.composition();
    assertEquals(result, expResult);
  }

}