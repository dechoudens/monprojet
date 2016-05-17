package ch.hesge.projetmaven.base;

import ch.hesge.projetmaven.base.Fichier;
import static org.testng.Assert.*;
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

  @DataProvider(name = "size")
  public Object[][] size() {
    Object[][] size = new Object[3][2];
    size[0] = new Object[]{"FAVRE;Martine;F;30.2", 1};
    size[1] = new Object[]{"DUPONT;Jean;M;32.1\n\rFAVRE;Martine;F;30.2", 2};
    size[2] = new Object[]{"DUPONT;Jean;M;32.1\n\rFAVRE;Martine;F;30.2\n\rTERRIEUR;Alex;M;26.2", 3};
    return size;
  }

  @Test(dataProvider = "dataFalse")
  public void isLigneEquipeFalseTest(String ligne) {
    fichier = new Fichier(ligne);
    if (fichier.isLigneEquipe()) {
      fail("it should not be true");
    }
  }

  @Test(dataProvider = "dataTrue")
  public void isLigneEquipeTrueTest(String ligne) {
    fichier = new Fichier(ligne);
    if (!fichier.isLigneEquipe()) {
      fail("it should not be false");
    }
  }

  @Test
  public void ligneCouranteTest() {
    String ligne1 = "DUPONT;Jean;M;32.1";
    String ligne2 = "FAVRE;Martine;F;30.2";
    fichier = new Fichier(ligne1 + "\n\r" + ligne2);

    assertEquals(fichier.getLigneCourante(), ligne1);

    fichier.nextLigne();
    
    assertEquals(fichier.getLigneCourante(), ligne2);
  }

  @Test
  public void isNullTest() {
    String lignes = "DUPONT;Jean;M;32.1\n\rFAVRE;Martine;F;30.2";
    fichier = new Fichier(lignes);

    fichier.nextLigne();
    assertFalse(fichier.isEOF());

    fichier.nextLigne();
    assertTrue(fichier.isEOF());
  }

  @Test(dataProvider = "size")
  public void sizeTest(String lignes, int size) {
    fichier = new Fichier(lignes);

    assertTrue(fichier.size() == size);
  }
}
