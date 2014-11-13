/**
 * Cette classe conserve les informations sur un bloc du jeu de dessin caché
 *
 * @author Jean-Frédéric Samson
 * @version 2014-11-09
 */
public class InfoBloc {
    
    //attributs
    private int debut;
    private int nbCases;
    private int nbCasesRestantes;

    //constructeur par défaut
    public InfoBloc(){
    }
    
    //constructeur par copie d'attributs
    public InfoBloc(int debut, int nbCases, int nbCasesRestantes) {
        this.debut = debut;
        this.nbCases = nbCases;
        this.nbCasesRestantes = nbCasesRestantes;
    }
    
    //constructeur par copie d'objets
    public InfoBloc(InfoBloc infoBloc){
        this.debut = infoBloc.getDebut();
        this.nbCases = infoBloc.getNbCases();
        this.nbCasesRestantes = infoBloc.getNbCasesRestantes();
    }

    //accesseurs
    public int getDebut() {
        return debut;
    }

    public int getNbCases() {
        return nbCases;
    }

    public int getNbCasesRestantes() {
        return nbCasesRestantes;
    }

    //mutateurs
    public void setDebut(int debut) {
        this.debut = debut;
    }

    public void setNbCases(int nbCases) {
        this.nbCases = nbCases;
    }

    public void setNbCasesRestantes(int nbCasesRestantes) {
        this.nbCasesRestantes = nbCasesRestantes;
    }
    
    //méthode pour affichage
    public String toString(){
        return "Les valeurs sont les suivantes : " + this.getDebut() +  ", " + this.getNbCases() + ", " + this.getNbCasesRestantes();
    }
}

