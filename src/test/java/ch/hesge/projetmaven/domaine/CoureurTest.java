package ch.hesge.projetmaven.domaine;

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
  public void toStringTest(){
    
  }
}
