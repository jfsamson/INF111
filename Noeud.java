/**
 * Conserve chacun des éléments de la liste chaînée
 * 
 * @author Benjamin Fournier
 * @version  2014-11-09
 */
public class Noeud {
    private int valeur;
    private Noeud suivant;
    
    public Noeud(){
    }
    
    public Noeud (int valeur){
        this.valeur = valeur;
    }

    public Noeud (int valeur, Noeud suivant){
        this.valeur = valeur;
        this.suivant = suivant;
    }
    
    public int getValeur(){
        return valeur;
    }
    
    public Noeud getSuivant(){
        return suivant;
    }
    
    public void setValeur(int valeur){
        this.valeur = valeur;
    }
    
    public void setSuivant(Noeud suivante){
        this.suivant = suivante;
    }
}
