package dechoudens.projetmaven;


/**
 *
 * @author meckanik
 */
public class Main {
    private static Resultats resultats;
    
    public static void main(String[] args) {
        String fileName = "Resultats.txt";
        System.out.println("Traitement des résultats connu contenus dans \"" + fileName + "\" :");
        resultats = new Resultats();
        resultats.traiterFichier(fileName);
        resultats.afficheResultats();
    } 
}
