package ch.hesge.projetmaven.domaine;

import java.util.ArrayList;
import java.util.List;
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
  public void testMultipleAddCoureur() {

    Coureur c = new Coureur("UNIT", "Test", 'M', 0, "equipe");

    int initialSize = equipe.getSizeListeCoureurs();
    ArrayList<Coureur> coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
    }
    equipe.setCoureurs(coureurs);

    int finalSize = equipe.getSizeListeCoureurs();

    assertTrue(finalSize == initialSize + NB_COUREUR);
  }

  @Test
  public void testMeilleurPremier() {

    List<Coureur> coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'M', i, "equipe"));
    }
    equipe.setCoureurs(coureurs);

    Coureur result = equipe.meilleurCoureur();
    assertTrue(result.getTemps() == coureurs.get(0).getTemps());
  }
  
  @Test
  public void testMeilleurDeuxième() {

    List<Coureur> coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      if (i == 2) {
        coureurs.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
      }
      coureurs.add(new Coureur("UNIT", "Test", 'M', i+10, "equipe"));
    }
    equipe.setCoureurs(coureurs);

    Coureur result = equipe.meilleurCoureur();
    assertTrue(result.getTemps() == coureurs.get(2).getTemps());
  }

  @Test
  public void testMajoriteMasculine() {
    ArrayList<Coureur> coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
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
      coureurs.add(new Coureur("UNIT", "Test", 'F', 0, "equipe"));
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
        coureurs.add(new Coureur("UNIT", "Test", 'F', 0, "equipe"));
      } else {
        coureurs.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
      }
      change = !change;
    }
    equipe.setCoureurs(coureurs);

    String expResult = "mixte";
    String result = equipe.composition();
    assertEquals(result, expResult);
  }

  @Test
  public void addCoureurTest() {
    ArrayList coureurs = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureurs.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
    }

    equipe.addCoureurs(coureurs);
    int finalSize = equipe.getSizeListeCoureurs();

    assertTrue(NB_COUREUR == finalSize);
  }

  @Test
  public void equalsTestTrue() {
    Equipe equipeTest = new Equipe("Equipe de test");
    assertTrue(equipe.equals(equipeTest));
  }

  @Test
  public void equalsTestFalse() {
    Equipe equipeTest = new Equipe("FalseName");
    assertFalse(equipe.equals(equipeTest));
  }

  @Test
  public void getCoureurTest() {
    List coureursVoulu = new ArrayList();
    for (int i = 0; i < NB_COUREUR; i++) {
      coureursVoulu.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
    }
    equipe.addCoureurs(coureursVoulu);

    List coureursObtenu = equipe.getCoureurs();
    assertEquals(coureursObtenu, coureursVoulu);
  }

  @Test
  public void toStringTestMasculin() {
    List coureur = new ArrayList();
    coureur.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
    equipe.addCoureurs(coureur);

    String toStringVoulu = "Equipe: mixte \"Equipe de test\", " + NB_COUREUR + " coureurs, " + coureur.get(0).toString();
    String toStringObtenu = equipe.toString();
    
    assertEquals(toStringVoulu, toStringObtenu);
  }
  
  @Test
  public void toStringTestFeminin() {
    List coureur = new ArrayList();
    coureur.add(new Coureur("UNIT", "Test", 'F', 0, "equipe"));
    equipe.addCoureurs(coureur);

    String toStringVoulu = "Equipe: feminine \"Equipe de test\", " + NB_COUREUR + " coureurs, " + coureur.get(0).toString();
    String toStringObtenu = equipe.toString();
    
    assertEquals(toStringVoulu, toStringObtenu);
  }

}
