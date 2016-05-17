package ch.hesge.projetmaven.domaine;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Meckanik
 */
public class CoureurTest {
  private Coureur coureur;
  
  @BeforeMethod
  public void setUp() throws Exception {
    coureur = new Coureur("Wilson", "Wilson", 'M', 12, "equipe");
  }
  
  @Test
  public void estMonEquipeTestTrue(){
    Equipe e = new Equipe("equipe");
    
    assertTrue(coureur.estMonEquipe(e));
  }
  
  @Test
  public void estMonEquipeTestFalse(){
    Equipe e = new Equipe("mauvaise equipe");
    
    assertFalse(coureur.estMonEquipe(e));
  }
  
  @Test
  public void equalsTrueTest(){
    Coureur coureurTest = new Coureur("Wilson", "Wilson", 'M', 12, "equipe");
    assertTrue(coureur.equals(coureurTest));
  }
  @Test
  public void equals_Nom_False(){
    Coureur coureurTest = new Coureur("Wilsonn", "Wilson", 'M', 12, "equipe");
    assertFalse(coureur.equals(coureurTest));
  }
  
  @Test
  public void equals_Prenom_False(){
    Coureur coureurTest = new Coureur("Wilson", "Wilsonn", 'M', 12, "equipe");
    assertFalse(coureur.equals(coureurTest));
  }
  
  @Test
  public void equals_Sexe_False(){
    Coureur coureurTest = new Coureur("Wilson", "Wilson", 'F', 12, "equipe");
    assertFalse(coureur.equals(coureurTest));
  }
  
  @Test
  public void equals_Temps_False(){
    Coureur coureurTest = new Coureur("Wilson", "Wilson", 'M', 11, "equipe");
    assertFalse(coureur.equals(coureurTest));
  }
  
  @Test
  public void equals_Equipe_False(){
    Coureur coureurTest = new Coureur("Wilson", "Wilson", 'M', 12, "equipes");
    assertFalse(coureur.equals(coureurTest));
  }
}
