/**
 * Implémente une collection de type liste avec chaînage dynamique
 * 
 * @author Benjamin Fournier
 * @version 2014-11-09
 */

public class ListeChainee implements InterfaceListeChainee{

    private Noeud liste;
    private int taille;
    
    public ListeChainee(){
        liste = null;
        taille = 0;
    }
     
    public int getTaille(){
        return taille;
    }
    
    @Override
    public void ajouter(int valeur) {
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

    @Override
    public int getValeur(int indice) {
        verifierLimite(indice);
        
        Noeud courant = liste;
        for (int i = 0; i < indice; i++)
        {
            courant = courant.getSuivant();
        }
        
        return courant.getValeur();
    }

    @Override
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
        if (indice < 0 || indice >= getTaille()){
            throw new IndexOutOfBoundsException("L'indice " + indice + " est hors limite!"); 
        }
    }
}
