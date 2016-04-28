
package dechoudens.projetmaven;

import dechoudens.projetmaven.metier.Fichier;
import static org.testng.Assert.fail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Meckanik
 */
public class FichierTest {
  private Fichier fichier;
  
  @DataProvider(name = "dataFalse")
  public Object[][] dataFalse() {
    Object[][] dataFalse = new Object[3][1];
    dataFalse[0] = new Object[]{"DUPONT;Jean;M;32.1"};
    dataFalse[1] = new Object[]{"FAVRE;Martine;F;30.2"};
    dataFalse[2] = new Object[]{"TERRIEUR;Alex;M;26.2"};
    return dataFalse;
  }
  
  @DataProvider(name = "dataTrue")
  public Object[][] dataTrue() {
    Object[][] dataTrue = new Object[3][1];
    dataTrue[0] = new Object[]{"Heineken;2"};
    dataTrue[1] = new Object[]{"Feldschlosschen;3"};
    dataTrue[2] = new Object[]{"Guiness;3"};
    return dataTrue;
  }
  
  @Test(dataProvider = "dataFalse")
  public void isLigneEquipeFalseTest(String ligne){
    fichier = new Fichier(ligne);
    if (fichier.isLigneEquipe()) {
      fail("it should not be true");
    }
  }
  
  @Test(dataProvider = "dataTrue")
  public void isLigneEquipeTrueTest(String ligne){
    fichier = new Fichier(ligne);
    if (!fichier.isLigneEquipe()) {
      fail("it should not be false");
    }
  }
}
