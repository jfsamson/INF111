import java.io.Serializable;

/**
 * Une grille représentant un dessin caché à l'aide de case colorié ou non.
 *
 * Si une case est coloriée, elle fait partie du dessin.
 *
 * Cette grille est carrée
 *
 * @author pbelisle
 * @version A14
 *
 */
public class GrilleDessin implements Serializable {

    private boolean[][] grille;
    private String nom;

    /**
     * Accessur du nom du dessin
     *
     * @return Le nom du dessin
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mutateur du nom du dessin
     *
     * @param nom Le nouveau nom du dessin
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Création d'une grille carrée représentant le dessin. SI une intersection
     * est mise à true, c'est que la case est coloriée.
     *
     * @param taille La taille de la grille
     */
    public GrilleDessin(int taille, String nom) {

        //On crée simplement la grille
        grille = new boolean[taille][taille];
        this.nom = nom;
    }
    
    /**
     * La position (i,j) sera retournée
     *
     * @param i La position en ligne
     * @param j La position en colonne
     * @return Si la case es colorié ou non
     */
    boolean estColorie(int i, int j) {
        return grille[i][j];
    }

    /**
     * Met la case de la grille à la position (i,j) dans l'état demandé
     *
     * @param i La position en ligne
     * @param j La position en colonne
     * @param etat L'état de la case après l'appel
     */
    void colorieCase(int i, int j, boolean etat) {
        grille[i][j] = etat;
    }

    /**
     * Accesseur de la taille au moment de la création
     *
     * @return La taille de la grille carrée
     */
    int getTaille() {
        return grille.length;
    }

    /**
     * Retourne si le dessin est validie
     *
     * Le dessin est valide si aucune ligne ou colonne n'est vide à l'exception
     * des contours.
     *
     * @return Si le dessin respecte les règles de validité
     */
    public boolean estValide() {

        //VARIABLES
        //les quatres bordurent permettant de délimité la contour du dessin
        int bordureHaut = 0;
        int bordureGauche = 0;
        int bordureBas = 0;
        int bordureDroit = 0;
        //booleans servant à savoir si le dessin est alide, si une ligne est
        //vide et si une colonne est vide
        boolean ligneVide = true;
        boolean valide = true;
        boolean colonneVide = true;

        //Permet de déterminé le point le plus à droite et le plus en bas d'un
        //dessin
        for (int i = 0; i < getTaille(); i++) {
            for (int j = 0; j < grille[0].length; j++) {
                if (estColorie(i, j)) {
                    bordureBas = i;
                }
                if (estColorie(j, i)) {
                    bordureDroit = i;
                }
            }
        }

        //Permet de déterminé le point le plus à gauche et le plus en haut d'un
        //dessin 
        for (int i = getTaille() - 1; i >= 0; i--) {
            for (int j = grille[0].length - 1; j >= 0; j--) {
                if (estColorie(i, j)) {
                    bordureHaut = i;
                }
                if (estColorie(j, i)) {
                    bordureGauche = i;
                }
            }
        }

        //Permet de déterminer si les rangées sont valides une à une.
        //Si une rangée est invalide le dessin devient automatiquement invalide
        for (int i = bordureHaut; i <= bordureBas; i++) {
            for (int j = bordureGauche; j <= bordureDroit; j++) {
                if (!estColorie(i, j)) {
                    ligneVide = true;
                } else {
                    ligneVide = false;
                    break;
                }
            }
            if (ligneVide) {
                valide = false;
            }
        }

        //Permet de déterminer si les colonnes sont valides une à une.
        //Si une colonne est invalide le dessin devient automatiquement invalide
        for (int j = bordureGauche; j <= bordureDroit; j++) {
            for (int i = bordureHaut; i <= bordureBas; i++) {
                if (!estColorie(i, j)) {
                    colonneVide = true;
                } else {
                    colonneVide = false;
                    break;
                }
            }
            if (colonneVide) {
                valide = false;
            }
        }

        return valide;
    }
}
