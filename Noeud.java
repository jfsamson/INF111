/**
 * Conserve chacun des éléments de la liste chaînée
 * 
 * @author Benjamin Fournier
 * @version  2014-11-09
 */
public class Noeud {
    private InfoBloc valeur;
    private Noeud suivant;
    
    public Noeud(){
    }
    
    public Noeud (InfoBloc valeur){
        this.valeur = valeur;
    }

    public Noeud (InfoBloc valeur, Noeud suivant){
        this.valeur = valeur;
        this.suivant = suivant;
    }
    
    public InfoBloc getValeur(){
        return valeur;
    }
    
    public Noeud getSuivant(){
        return suivant;
    }
    
    public void setValeur(InfoBloc valeur){
        this.valeur = valeur;
    }
    
    public void setSuivant(Noeud suivante){
        this.suivant = suivante;
    }
}
