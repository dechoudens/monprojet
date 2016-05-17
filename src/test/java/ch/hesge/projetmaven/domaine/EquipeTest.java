package ch.hesge.projetmaven.domaine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Meckanik
 */
public class EquipeTest {

  private Equipe equipe;
  List mockedList;

  @BeforeMethod
  public void setUp() throws Exception {
    equipe = new Equipe("Equipe de test", 4);
    mockedList = mock(ArrayList.class);
  }

  @Test
  public void meilleurCoureur_should_be_the_first() {
    Coureur mockCoureur1 = mock(Coureur.class);
    when(mockCoureur1.getTemps()).thenReturn(1.0);
    
    Coureur mockCoureur2 = mock(Coureur.class);
    when(mockCoureur2.getTemps()).thenReturn(1.0);
    
    Coureur mockCoureur3 = mock(Coureur.class);
    when(mockCoureur3.getTemps()).thenReturn(1.0);
    
    Coureur mockCoureur4 = mock(Coureur.class);
    when(mockCoureur4.getTemps()).thenReturn(1.0);
    
    List coureurs = Arrays.asList(mockCoureur1, mockCoureur2, mockCoureur3, mockCoureur4);

    equipe.addCoureurs(coureurs);
    Coureur result = equipe.meilleurCoureur();

    assertEquals(result.getTemps(), mockCoureur1.getTemps());
  }
  
  @Test
  public void meilleurCoureur_should_be_the_last() {
    Coureur mockCoureur1 = mock(Coureur.class);
    when(mockCoureur1.getTemps()).thenReturn(2.0);
    
    Coureur mockCoureur2 = mock(Coureur.class);
    when(mockCoureur2.getTemps()).thenReturn(2.0);
    
    Coureur mockCoureur3 = mock(Coureur.class);
    when(mockCoureur3.getTemps()).thenReturn(2.0);
    
    Coureur mockCoureur4 = mock(Coureur.class);
    when(mockCoureur4.getTemps()).thenReturn(1.0);
    
    List coureurs = Arrays.asList(mockCoureur1, mockCoureur2, mockCoureur3, mockCoureur4);

    equipe.addCoureurs(coureurs);
    Coureur result = equipe.meilleurCoureur();

    assertEquals(result.getTemps(), mockCoureur4.getTemps());
  }
  
  @Test
  public void meilleurCoureur_should_be_the_second() {
    Coureur mockCoureur1 = mock(Coureur.class);
    when(mockCoureur1.getTemps()).thenReturn(2.0);
    
    Coureur mockCoureur2 = mock(Coureur.class);
    when(mockCoureur2.getTemps()).thenReturn(1.0);
    
    Coureur mockCoureur3 = mock(Coureur.class);
    when(mockCoureur3.getTemps()).thenReturn(2.0);
    
    Coureur mockCoureur4 = mock(Coureur.class);
    when(mockCoureur4.getTemps()).thenReturn(2.0);
    
    List coureurs = Arrays.asList(mockCoureur1, mockCoureur2, mockCoureur3, mockCoureur4);

    equipe.addCoureurs(coureurs);
    Coureur result = equipe.meilleurCoureur();

    assertEquals(result.getTemps(), mockCoureur2.getTemps());
  }
  

  @Test
  public void Composition_should_return_Masculine() {
    Coureur mockCoureur1 = mock(Coureur.class);
    when(mockCoureur1.getSexe()).thenReturn(true);
    
    Coureur mockCoureur2 = mock(Coureur.class);
    when(mockCoureur2.getSexe()).thenReturn(true);
    
    Coureur mockCoureur3 = mock(Coureur.class);
    when(mockCoureur3.getSexe()).thenReturn(true);
    
    Coureur mockCoureur4 = mock(Coureur.class);
    when(mockCoureur4.getSexe()).thenReturn(true);
    
    List coureurs = Arrays.asList(mockCoureur1, mockCoureur2, mockCoureur3, mockCoureur4);


    equipe.addCoureurs(coureurs);
    String expResult = "masculine";
    String result = equipe.composition();
    assertEquals(result, expResult);
  }

  @Test
  public void Composition_should_return_Feminine() {
    Coureur mockCoureur1 = mock(Coureur.class);
    when(mockCoureur1.getSexe()).thenReturn(false);
    
    Coureur mockCoureur2 = mock(Coureur.class);
    when(mockCoureur2.getSexe()).thenReturn(false);
    
    Coureur mockCoureur3 = mock(Coureur.class);
    when(mockCoureur3.getSexe()).thenReturn(false);
    
    Coureur mockCoureur4 = mock(Coureur.class);
    when(mockCoureur4.getSexe()).thenReturn(false);
    
    List coureurs = Arrays.asList(mockCoureur1, mockCoureur2, mockCoureur3, mockCoureur4);


    equipe.addCoureurs(coureurs);
    String expResult = "feminine";
    String result = equipe.composition();
    assertEquals(result, expResult);
  }

  @Test
  public void Composition_should_return_Mixte() {
    Coureur mockCoureur1 = mock(Coureur.class);
    when(mockCoureur1.getSexe()).thenReturn(true);
    
    Coureur mockCoureur2 = mock(Coureur.class);
    when(mockCoureur2.getSexe()).thenReturn(false);
    
    Coureur mockCoureur3 = mock(Coureur.class);
    when(mockCoureur3.getSexe()).thenReturn(true);
    
    Coureur mockCoureur4 = mock(Coureur.class);
    when(mockCoureur4.getSexe()).thenReturn(true);
    
    List coureurs = Arrays.asList(mockCoureur1, mockCoureur2, mockCoureur3, mockCoureur4);


    equipe.addCoureurs(coureurs);
    String expResult = "mixte";
    String result = equipe.composition();
    assertEquals(result, expResult);
  }

  @Test
  public void addCoureur_adds_a_list_of_4_Coureur() {
    when(mockedList.size()).thenReturn(4);
    
    equipe.addCoureurs(mockedList);
    int finalSize = equipe.getSizeListeCoureurs();

    assertEquals(finalSize, 4);
  }
  
  @Test
  public void addCoureur_adds_an_empty_list() {
    equipe.addCoureurs(mockedList);
    int finalSize = equipe.getSizeListeCoureurs();

    assertEquals(finalSize, 0);
  }

  @Test
  public void equals_should_return_True() {
    Equipe equipeTest = new Equipe("Equipe de test");
    assertTrue(equipe.equals(equipeTest));
  }

  @Test
  public void equals_should_return_False() {
    Equipe equipeTest = new Equipe("FalseName");
    assertFalse(equipe.equals(equipeTest));
  }

  @Test
  public void toStringTestMasculin() {
    List coureur = new ArrayList();
    coureur.add(new Coureur("UNIT", "Test", 'M', 0, "equipe"));
    equipe.addCoureurs(coureur);

    String toStringVoulu = "Equipe: mixte \"Equipe de test\", " + 4 + " coureurs, " + coureur.get(0).toString();
    String toStringObtenu = equipe.toString();

    assertEquals(toStringVoulu, toStringObtenu);
  }

  @Test
  public void toStringTestFeminin() {
    List coureur = new ArrayList();
    coureur.add(new Coureur("UNIT", "Test", 'F', 0, "equipe"));
    equipe.addCoureurs(coureur);

    String toStringVoulu = "Equipe: feminine \"Equipe de test\", " + 4 + " coureurs, " + coureur.get(0).toString();
    String toStringObtenu = equipe.toString();

    assertEquals(toStringVoulu, toStringObtenu);
  }

}
