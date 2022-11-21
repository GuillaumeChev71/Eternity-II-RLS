public class Eternity {

    public static int[][][] creationPlateau(){

        int n = 3;
        int kc = 4;
        int[][][] plateau = new int[n][n][kc];
        int[] a = new int[]{65,66,67,68};
        int[] b = new int[]{65,66,67,68};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<kc;k++){
                    plateau[i][j][k] = 65+k;
                }
            }
        }
        return plateau;
    }

    public static void affichagePlateau(int[][][] plateau){


        int taille = plateau.length;
        //affichage des indices de colonnes
        System.out.print("   ");

        for(int indiceCol=0;indiceCol<taille;indiceCol++){

            System.out.print(" "+indiceCol+"  ");       

        }

        System.out.println("");
        System.out.println("");

        //affichage des pieces du puzzle

        for(int h=0;h<taille;h++){
            System.out.print("   ");
            for(int i=0;i<taille;i++){
                //lettre du haut de la pièce
                System.out.print(" "+(char)plateau[h][i][0]+"  ");
            }
            System.out.println("");
            //affichage indice de ligne
            System.out.print(h+"  ");
            for(int j=0;j<taille;j++){
                //affichage lettre de gauche et de droite de la piece
                System.out.print((char)plateau[h][j][3]+"#"+(char)plateau[h][j][1]+" ");
            }
            System.out.println("");
            System.out.print("   ");
            for(int k=0;k<taille;k++){
                //affichage lettre du bas de la piece
                System.out.print(" "+(char)plateau[h][k][2]+"  ");
            }
            System.out.println("");
        }
        System.out.println("");System.out.println("");System.out.println("");
    }

    public static int getNbConflits(int [][][] p,int dim){
        int nb =0;
 
        for(int i=0;i<dim;i++){

            if(p[0][i][0] != p[dim-1][i][2]){ //entre côté haut de la première ligne et côté bas de la dernière ligne
                nb= nb+1;
            }
                               
            if(p[i][0][3] != p[i][dim-1][1]){ //lettre a gauche en debut de ligne et lettre a droite en fin de ligne
                nb=nb+1;
            }

        }

        for(int i=0;i<dim-1;i++){
            for(int j=0;j<dim;j++){
                if((p[i][j][2] != p[i+1][j][0]) && (i != dim-1)){
                    nb=nb+1;
                }

            }
        }

        for(int i=0;i<dim;i++){
            for (int j=0; j<dim-1;j++){
                if(p[i][j][1] != p[i][j+1][3]){
                    nb=nb+1;
                }
            }
        }

    return nb;

    }

 

    public static int[][][] solutionAleatoire(){

        int n = 3;
        int kc = 4;
        int[][][] p = new int[n][n][kc];
        int dim = p.length;

        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(i==0 && j==0){ // aucune contrainte
                    for(int k=0;k<4;k++){
                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));
                    }
                }

                if(i==0 && j!=0 && j!=dim-1){
                    for(int k=0;k<4;k++){
                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));
                    }
                    p[i][j][3]=p[i][j-1][1];
                }

                if(i==0 && j==dim-1){
                    for(int k=0;k<4;k++){
                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));
                    }
                    p[i][j][1]=p[i][0][3];
                    p[i][j][3]=p[i][j-1][1];
                }

                if(i!=dim-1 && i!=0 && j==0){
                    for(int k=0;k<4;k++){
                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));
                    }
                    p[i][j][0]=p[i-1][j][2];
                }

                if(i!=0 && j!=0 && i!=dim-1 && j!=dim-1){
                    for(int k=0;k<4;k++){
                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));
                    }
                    p[i][j][0]=p[i-1][j][2];
                    p[i][j][3]=p[i][j-1][1];
                }

                if(i!=0 && j!=0 && j==dim-1){
                    for(int k=0;k<4;k++){
                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));
                    }
                    p[i][j][0]=p[i-1][j][2];
                    p[i][j][1]=p[i][0][3];
                    p[i][j][3]=p[i][j-1][1];
                }

                if(i==dim-1 && j==0){
                    for(int k=0;k<4;k++){
                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));
                    }
                    p[i][j][0]=p[i-1][j][2];
                    p[i][j][2]=p[0][j][0];
                }
                
                if(i==dim-1 && j!=dim-1 && j!=0){

                    for(int k=0;k<4;k++){

                        p[i][j][k]=65 + (int)(Math.random() * ((68 - 65) + 1));

                    }
                    p[i][j][0]=p[i-1][j][2];
                    p[i][j][2]=p[0][j][0];
                    p[i][j][3]=p[i][j-1][1];
                }
                
                if(i==dim-1 && j==dim-1){
                    p[i][j][0]=p[i-1][j][2];
                    p[i][j][1]=p[i][0][3];
                    p[i][j][2]=p[0][j][0];
                    p[i][j][3]=p[i][j-1][1];
                }
            }
        }
        return p;
    }

    public static void rotationPiece(int[][][] p,int a,int b){

        int e = p[a][b][0];
        int f = p[a][b][1];
        int g = p[a][b][2];
        int h = p[a][b][3];
 
        p[a][b][0]=h;
        p[a][b][1]=e;
        p[a][b][2]=f;
        p[a][b][3]=g;
    }

 

    public static void echangePiece(int[][][] p,int a, int b,int c,int d){
        int[] echange = p[a][b]; //on echange les pieces d'indices a et b
        p[a][b]=p[c][d];
        p[c][d]=echange;
    }


    public static void melangePlateau(int[][][] p){

 
    }

 
    public static void main(String args[]) {

        int[][][] plateau = solutionAleatoire();
        affichagePlateau(plateau);
        int nbConflits = getNbConflits(plateau,plateau.length);
        System.out.println("Nombre de conflits dans le plateau : "+nbConflits);
        //int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));
        echangePiece(plateau,0,0,0,1);
        affichagePlateau(plateau);
        nbConflits = getNbConflits(plateau,plateau.length);
        System.out.println("Nombre de conflits dans le plateau : "+nbConflits);
    }

 

}