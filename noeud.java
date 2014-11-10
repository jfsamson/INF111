/**
 * Conserve chacun des éléments de la liste chaînée
 * 
 * @author Benjamin Fournier
 * @version  2014-11-09
 */
public class Noeud {
    private InfoBloc info;
    private Noeud suivant;
    private Noeud liste;
    private int taille;
    
    public Noeud(){
    }
    
    public Noeud (InfoBloc info){
        this.info = info;
    }

    public Noeud (InfoBloc info, Noeud suivant){
        this.info = info;
        this.suivant = suivant;
    }
    
    public InfoBloc getValeur(){
        return info;
    }
    
    public Noeud getSuivant(){
        return suivant;
    }
    
    public void setValeur(InfoBloc info){
        this.info = info;
    }
    
    public void setSuivant(Noeud suivante){
        this.suivant = suivante;
    }

    public void ajouter(InfoBloc valeur) {
        Noeud nouveuNoeud = new Noeud(valeur, null);
        
        if (liste == null){
            liste = nouveuNoeud;
        }
        else{
            Noeud dernier = liste;
            while(dernier.getSuivant() != null){
                dernier = dernier.getSuivant();
            }
            
            dernier.setSuivant(nouveuNoeud);
        }
        
        taille ++;
    }

    public InfoBloc getValeur(int indice) {
        verifierLimite(indice);
        
        Noeud courant = liste;
        for (int i = 0; i < indice; i++)
        {
            courant = courant.getSuivant();
        }
        
        return courant.getValeur();
    }

    public void supprimer(int indice) {
        verifierLimite(indice);
        
        Noeud noeudAEnlever;
        
        if (indice == 0){
            noeudAEnlever = liste;
            liste = noeudAEnlever.getSuivant();
        }
        else{
            Noeud courrant = liste;
            for(int i = 0; i < indice - 1; i++)
            {
                courrant = courrant.getSuivant();
            }
            noeudAEnlever = courrant.getSuivant();
            
            courrant.setSuivant (noeudAEnlever.getSuivant());
        }
        noeudAEnlever.setSuivant (null);
            
        taille --;
    }
    
    public void verifierLimite(int indice){
        if (indice < 0 || indice >= taille){
            throw new IndexOutOfBoundsException("L'indice " + indice + " est hors limite!"); 
        }
    }
}

