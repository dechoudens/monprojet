
package ch.hesge.projetmaven;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

/**
 * @author Meckanik
 */
public class ResultatsTest {
  public Resultats resultat;
  public String[] argsTest;

  public ResultatsTest() throws Exception {
    this.resultat = new Resultats();
  }
  
  @Test
  public void traiterResultatsTest(){
    try {
      resultat.traiterResultats(new String[] {"src/test/resources/Equipes.txt"});
      fail("Should have triggered the exeption");
    } catch (Exception e) {
      
    }
  }
  
  @Test
  public void checkArgs_returns_true(){ 
    argsTest = new String[] {"args1", "args2"};
    
    assertTrue(resultat.checkArgs(argsTest));
  }
  
  @Test
  public void checkArgs_too_much_args(){
    argsTest = new String[] {"args1", "args2", "args3"};
    
    assertFalse(resultat.checkArgs(argsTest));
  }
  @Test
  public void checkArgs_not_enough_args(){
    argsTest = new String[] {"args1"};
    
    assertFalse(resultat.checkArgs(argsTest));
  }
  
}
