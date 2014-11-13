/**
 *
 * @author Jean-Frédéric Samson
 */
public class GrilleJeu {
    
    //ATTRIBUTS
    //Les tableaux d’indices du jeu
    private ListeChainee [] tabBlocLignes;
    private ListeChainee [] tabBlocColonnes;

    private GrilleDessin dessin_orig;
    private GrilleDessin dessin_cache;
    private int nbVies;

    //Évite pls appels à l'accesseur
    private int taille;
    
    public GrilleJeu(GrilleDessin dessin) {
        dessin_orig = dessin;
        this.taille = dessin.getTaille();
        tabBlocLignes = new ListeChainee[taille];
        tabBlocColonnes = new ListeChainee[taille];
        setNombreVie();
        initialiserJeu();
    }

    /**
     * Retourne un tableau de tous les blocs sur une ligne
     *
     * @param ligne La ligne voulue
     * @return Un tableau des tous les blocs sur une ligne
     */
    public InfoBloc[] getInfoBlocLigne(int ligne) {
        int nbNoeud = tabBlocLignes[ligne-1].getNbNoeuds();
        InfoBloc[] ib = new InfoBloc[nbNoeud];
        tabBlocLignes[ligne-1].setPositionDebut();
        for (int i = 0; i < nbNoeud; i++) {
            ib[i] = tabBlocLignes[ligne-1].getNoeud();
            tabBlocLignes[ligne-1].nextPositionCourante();
        }
        return ib;
    }

    /**
     * Retourne un tableau de tous les blocs sur une colonne
     *
     * @param colonne La colonne voulue
     * @return Un tableau des tous les blocs sur une colonne
     */
    public InfoBloc[] getInfoBlocColonne(int colonne) {
         int nbNoeud = tabBlocColonnes[colonne-1].getNbNoeuds();
        InfoBloc[] ib = new InfoBloc[nbNoeud];
        tabBlocColonnes[colonne-1].setPositionDebut();
        for (int i = 0; i < nbNoeud; i++) {
            ib[i] = tabBlocColonnes[colonne-1].getNoeud();
            tabBlocColonnes[colonne-1].nextPositionCourante();
        }
        return ib;
    }

    public void setNombreVie() {
        switch (taille) {
            case 5:
                nbVies = 1;
                break;
            case 10:
                nbVies = 3;
                break;
            case 15:
                nbVies = 5;
                break;
        }
    }

    public void initialiserJeu() {
        
        ListeChainee liste = new ListeChainee();
        boolean nouveauBloc = true;
        int colonneDebut = 0;
        int compteur = 0;
        int ligneDebut = 0;
        
        //boucle qui créé des infobloc avec les infos de chaque ligne
        for (int i = 0; i < tabBlocLignes.length; i++) {
            if(compteur != 0){
                InfoBloc ib = new InfoBloc(colonneDebut, compteur, compteur);
                liste.ajouterFin(ib);
                tabBlocLignes[i-1] = liste;
                
                nouveauBloc = true;
                compteur = 0;
            }
               
            liste  = new ListeChainee();
            
            compteur = 0;
            for (int j = 0; j < tabBlocColonnes.length; j++) {
                
                if (dessin_orig.estColorie(i, j) && nouveauBloc) {
                    colonneDebut = j;
                    nouveauBloc = false;
                    compteur++;
                } else if (dessin_orig.estColorie(i, j)) {
                    compteur++;
                } else if (compteur != 0){
                    InfoBloc ib = new InfoBloc(colonneDebut, compteur, compteur);
                    
                    liste.ajouterFin(ib);
                    
                    nouveauBloc = true;
                    compteur = 0;
                }
            }
            tabBlocLignes[i] = liste;
        }
        if(compteur != 0){
            InfoBloc ib = new InfoBloc(colonneDebut, compteur, compteur);
            liste.ajouterFin(ib);
            tabBlocLignes[tabBlocColonnes.length-1] = liste;
        }
        compteur = 0;
        nouveauBloc = true;
        
        //boucle qui créé des infobloc avec les infos de chaque ligne
        for (int i = 0; i < tabBlocColonnes.length; i++) {
            if(compteur != 0){
                InfoBloc ib = new InfoBloc(ligneDebut, compteur, compteur);
                liste.ajouterFin(ib);
                tabBlocColonnes[i-1] = liste;
                
                nouveauBloc = true;
                compteur = 0;
            }
               
            liste  = new ListeChainee();
            
            compteur = 0;
            for (int j = 0; j < tabBlocLignes.length; j++) {
                
                if (dessin_orig.estColorie(j, i) && nouveauBloc) {
                    ligneDebut = j;
                    nouveauBloc = false;
                    compteur++;
                } else if (dessin_orig.estColorie(j, i)) {
                    compteur++;
                } else if (compteur != 0){
                    InfoBloc ib = new InfoBloc(ligneDebut, compteur, compteur);
                    
                    liste.ajouterFin(ib);
                    
                    nouveauBloc = true;
                    compteur = 0;
                }
            }
            tabBlocColonnes[i] = liste;
        }
        if(compteur != 0){
            InfoBloc ib = new InfoBloc(ligneDebut, compteur, compteur);
            liste.ajouterFin(ib);
            tabBlocColonnes[tabBlocLignes.length-1] = liste;
        }
        afficherLigne(15);
        afficherColonne(2);
        System.out.println(validateNbCases());
    }
    
    public boolean jeuEstSolutionne(){
        boolean jeuSolutionne = false;
        int compteur = 0;
        boolean solutionne = false;
        for(int i=0; i<tabBlocColonnes.length;i++){
            if(tabBlocColonnes[i].getNbNoeuds() == 0 && tabBlocLignes[i].getNbNoeuds() ==0){
                compteur++;
            }
        }
        if(compteur == tabBlocColonnes.length-1){
            solutionne = true;
        }
        
        if(solutionne || validateNbCases()){
            jeuSolutionne = true;
        }

        return jeuSolutionne;
    }
    
    public boolean validateNbCases() {
        int value = 0;
        
        boolean valideLignes = true;
        boolean valideColonnes = true;
        boolean valide = false;
        for (int i = 0; i < tabBlocLignes.length; i++) {
            if(!valideLignes){
                break;
            }
            tabBlocLignes[i].setPositionDebut();
            while (value < tabBlocLignes[i].getNbNoeuds()) {
                if (tabBlocLignes[i].getNoeud().getNbCasesRestantes() == 0) {
                    tabBlocLignes[i].nextPositionCourante();
                } else {
                    valideLignes = false;
                    break;
                }
            }
        }
        for (int i = 0; i < tabBlocColonnes.length; i++) {
            if(!valideColonnes){
                break;
            }
            tabBlocColonnes[i].setPositionDebut();
            while (value < tabBlocColonnes[i].getNbNoeuds()) {
                if (tabBlocColonnes[i].getNoeud().getNbCasesRestantes() == 0) {
                    tabBlocColonnes[i].nextPositionCourante();
                } else {
                    valideColonnes = false;
                    break;
                }
            }
        }
        
        if(valideLignes && valideColonnes){
            valide = true;
        }

        return valide;
    }
    
    public void ajusterJeu(int i, int j){

    }
    
    public void afficherLigne(int ligne){
        InfoBloc [] infoBloc = getInfoBlocLigne(ligne);
        for(int i=0; i<infoBloc.length; i++){
            int result = i + 1;
            System.out.println("Ligne :" + ligne + "\t Bloc: " + result + " : " + infoBloc[i].toString());           
        }
    }
    
    public void afficherColonne(int colonne){
        InfoBloc [] infoBloc = getInfoBlocColonne(colonne);
        for(int i=0; i<infoBloc.length; i++){
            int result = i + 1;
            System.out.println("Colonne :" + colonne + "\t Bloc: " + result + " : " + infoBloc[i].toString());           
        }
    }

}
