/**
 * Cette classe conserve les informations sur un bloc du jeu de dessin caché
 *
 * @author Benjamin Fournier
 * @version 2014-11-09
 */
public class InfoBloc {
    private int debut;
    private int nbCases;
    private int nbCasesRestantes;

    public InfoBloc(){
    }
    
    public InfoBloc(int debut, int nbCases, int nbCasesRestantes) {
        this.debut = debut;
        this.nbCases = nbCases;
        this.nbCasesRestantes = nbCasesRestantes;
    }
    
    public InfoBloc(InfoBloc infoBloc){
        this.debut = infoBloc.getDebut();
        this.nbCases = infoBloc.getNbCases();
        this.nbCasesRestantes = infoBloc.getNbCasesRestantes();
    }

    public int getDebut() {
        return debut;
    }

    public int getNbCases() {
        return nbCases;
    }

    public int getNbCasesRestantes() {
        return nbCasesRestantes;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public void setNbCases(int nbCases) {
        this.nbCases = nbCases;
    }

    public void setNbCasesRestantes(int nbCasesRestantes) {
        this.nbCasesRestantes = nbCasesRestantes;
    }
}
