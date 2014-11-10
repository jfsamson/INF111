/**
 * Interface qui représente une liste dynamique d'entiers de type int
 * 
 * @author Benjamin Fournier
 * @version 2014-11-09
 */
public interface InterfaceListeChainee {
    /**
    * Ajoute un entier à la liste
    *
    * @param valeur L'entier valeur sera ajouté à la fin
    * de la liste
    */
    public void ajouter (int valeur);
 
    /**
     * Récupère un entier dans la liste
     *
     * @param indice L'indice de l'entier voulu dans la liste
     * @return L'entier à l'indice reçu est renvoyé
     */
    public int getValeur (int indice);
    
     /**
     * Supprime un élément de la liste
     *
     * @param indice L'indice de la liste de l'entier à
     * supprimer     
     */
    public void supprimer (int indice);
}
