/**
 * Conserve chacun des éléments de la liste chaînée
 * 
 * @author Jean-Frédéric Samson
 * @version  2014-11-09
 */
public class ListeChainee {

    //attributs
    private Noeud debut;
    private Noeud fin;
    private Noeud positionCourante;
    private int nbNoeuds;
    
    //Cette classe permet de lier les objets de la liste chaînée
    public class Noeud {

        public Object element;
        public Noeud suivant;

        public Noeud(Object element, Noeud lien) {
            this.element = element;
            suivant = lien;
        }
    }
    
    //constructeur par défaut
    public ListeChainee(){
    }
    
    //méthode qui détermine si la liste est vide
    public boolean estVide(){
        return nbNoeuds == 0;
    }
   
    //méthode permettant d'ajouter un élément après la positionCourante
    public void ajouterPositionCourante(InfoBloc info) {
        Noeud noeudTempo;
        if (estVide()) {
            debut = new Noeud(info, null);
            fin = positionCourante = debut;
        }else{
            noeudTempo = new Noeud(info, positionCourante.suivant);    
            positionCourante.suivant = noeudTempo;
            positionCourante = noeudTempo;
        }
        nbNoeuds++;
        
    }
    
    //méthode permettant d'ajouter un élément à la fin de la liste chaînée
    public void ajouterFin(InfoBloc info) {
        
        if (estVide()) {
            debut = new Noeud(info, null);
            fin = positionCourante = debut;
        }else{
             fin.suivant = new Noeud(info, null);
             fin = fin.suivant;
             positionCourante = fin;
        }
        nbNoeuds++;
    }
    
    //méthode permettant d'ajouter un élément au début de la liste chaînée
    public void ajouterDebut(InfoBloc info) {
        
        if (estVide()) {
            debut = new Noeud(info, null);
            fin = positionCourante = debut;
        }else{
            Noeud noeudTemporaire = new Noeud(info, debut);
            debut = noeudTemporaire;
            positionCourante = debut;
        }
        nbNoeuds++;
    }

    //méthode qui retourne l'infobloc à la position courante.
    public InfoBloc getNoeud() {
        return (InfoBloc)positionCourante.element;
    }

    //méthode permettant de supprimer un élément à la positionCourante
    public String supprimer() {
        
        String message = "";
        Noeud courant = debut;
        Noeud precedent = debut;
        //Si la liste chaînée est vide
        if(estVide()){
            message = "Impossible de supprimer, la liste est vide !";
        //Si la positionCourante se trouve au début
        }else if(positionCourante == debut){
            debut = debut.suivant;
            positionCourante = debut;
            message = "Élément supprimé avec succès !";
        }
        //Ailleurs qu'au début
        else{
            //Noeud noeudTemporaire = positionCourante.suivant;
            while (!precedent.suivant.equals(positionCourante)){
                precedent = courant;
                courant = courant.suivant;
            }
             //Si la positionCourante  se trouve à la fin
            if(positionCourante == fin){
                precedent.suivant = null;
                fin = positionCourante = precedent;
            //ailleurs qu'au début et la fin
            }else{
                precedent.suivant = positionCourante.suivant;
                positionCourante = positionCourante.suivant;
            }
            message = "Élément supprimé avec succès !";
        }
        nbNoeuds--;
        return message;
    }
    
    //méthode qui avance la positionCourante au noeud suivant
    public void nextPositionCourante(){
        if(positionCourante == fin){
            positionCourante = debut;
        }else{
            positionCourante = positionCourante.suivant;
        }
    }
    
    //méthode qui place la positionCourante au début
    public void setPositionDebut(){
        positionCourante = debut;
    }
    
    //méthode qui place la positionCourante à la fin
    public void setPositionFin(){
        positionCourante = fin;
    }
    
    //méthode qui retourne le nombre de noeuds
    public int getNbNoeuds(){
        return nbNoeuds;
    }
    
}

