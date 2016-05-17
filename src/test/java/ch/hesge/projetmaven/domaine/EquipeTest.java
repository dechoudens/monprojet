package ch.hesge.projetmaven.domaine;

import java.util.ArrayList;
import java.util.Arrays;
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
    Coureur coureur1 = new Coureur("test1", "test1", 'M', 1.0, "test1");
    Coureur coureur2 = new Coureur("test2", "test2", 'M', 1.0, "test2");
    Coureur coureur3 = new Coureur("test3", "test3", 'M', 1.0, "test3");
    Coureur coureur4 = new Coureur("test4", "test4", 'M', 1.0, "test4");
    
    List coureurs = Arrays.asList(coureur1, coureur2, coureur3, coureur4);

    equipe.addCoureurs(coureurs);
    Coureur result = equipe.meilleurCoureur();

    assertEquals(result, coureur1);
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
    Equipe equipeTest = new Equipe("Equipe de test", 4);
    assertTrue(equipe.equals(equipeTest));
  }

  @Test
  public void equals_wrong_name_should_return_false() {
    Equipe equipeTest = new Equipe("FalseName");
    assertFalse(equipe.equals(equipeTest));
  }
  
  @Test
  public void equals_different_coureurList_should_return_false(){
    Coureur coureur1 = new Coureur("test1", "test1", 'M', 1.0, "test1");
    Coureur coureur2 = new Coureur("test2", "test2", 'M', 1.0, "test2");
    Coureur coureur3 = new Coureur("test3", "test3", 'M', 1.0, "test3");
    Coureur coureur4 = new Coureur("test4", "test4", 'M', 1.0, "test4");
    
    List coureurs1 = Arrays.asList(coureur1, coureur2, coureur3, coureur4);

    equipe.addCoureurs(coureurs1);
    
    Equipe equipeTest = new Equipe("Equipe de test", 4);
    
    Coureur coureur5 = new Coureur("test1", "test1", 'M', 1.0, "test1");
    Coureur coureur6 = new Coureur("test2", "test2", 'M', 1.0, "test2");
    Coureur coureur7 = new Coureur("test3", "test3", 'F', 1.0, "test3");
    Coureur coureur8 = new Coureur("test4", "test4", 'F', 1.0, "test4");
    
    List coureurs2 = Arrays.asList(coureur5, coureur6, coureur7, coureur8);
    
    equipeTest.addCoureurs(coureurs2); 
    
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
