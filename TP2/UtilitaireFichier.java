import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * Cette classe est un utilitaire possédent les méthodes nécessaires
 * au bon fonctionnement du programme dont récupérer un fichier avec une
 * extension .dsn
 */

/**
 *
 * @author Jean-Frédéric Samson
 */
public class UtilitaireFichier {

    //attributs nécessaires à la récupération d'un fichier
    private static int valeurRetournee;
    private static JFileChooser jChoose;
    private static FileNameExtensionFilter filtre;
    private static JOptionPane jPane;
    private static FileInputStream fileInput;
    private static File fichier;
    private static ObjectInputStream objectInput;

    //méthode permettent de récupérer un fichier
    static Object recupererFichier() throws
            IOException, ClassNotFoundException {

        jChoose = new JFileChooser();
        //filtre disponible dans la fenêtre de sélection permettant de trier
        //les fichiers affichés
        filtre = new FileNameExtensionFilter("Fichiers DSN", "dsn");
        jChoose.addChoosableFileFilter(filtre);
        jPane = new JOptionPane();

        boolean choisirFichier = true;

        //tant qu'on a pas fait cancel ou sélectionné un fichier valide
        //on continue d'afficher la fenêtre de sélection
        while (choisirFichier) {

            //Ouvre une fenêtre de sélection de fichier
            valeurRetournee = jChoose.showOpenDialog(null);
            //Prend le nom du fichier
            String nomFichier = jChoose.getSelectedFile().getName();
            //Soustrait du nom les caractères en partant de la dernière position
            //d'un . jusqu'à la fin
            String extension = nomFichier.substring(
                    nomFichier.lastIndexOf("."), nomFichier.length());

            //Si l'utilisateur click sur OK
            if (valeurRetournee == JFileChooser.APPROVE_OPTION) {
                //Vérifie si l'extension trouvée plus haut correspond avec
                //celle voulu - si oui on sort de la boucle et on sélectionne 
                //le fichier
                if (extension.equals(".dsn")) {
                    fichier = jChoose.getSelectedFile();
                    choisirFichier = false;
                } else {
                    //Affiche un message si le fichier n'est pas valide
                    jPane.showMessageDialog(
                            null, "Le fichier sélectionné n'est pas valide");
                }
            } //On quitte l'appplication si l'utilisateur click sur cancel
            else if (valeurRetournee == JFileChooser.CANCEL_OPTION) {
                System.exit(0);
            }
        }

        //Créer une connection au fichier approuvé plus haut 
        fileInput = new FileInputStream(fichier);
        //Extrait les données et les converties pour qu'elles soient lues
        objectInput = new ObjectInputStream(fileInput);

        //on lit l'objet contenu dans l'objectinput et on le place
        //dans un objet (Il serait aussi possible de le mettre directement
        //dans un objet de GrilleDessin, mais je laisse le choix de cette
        //décision dans le main).
        Object dessin = objectInput.readObject();
        //fermeture du flux
        objectInput.close();

        return dessin;
    }
}
