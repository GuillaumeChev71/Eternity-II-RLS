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
        for(int indiceCol=1;indiceCol<taille+1;indiceCol++){
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


    public static void main(String args[]) {

      int[][][] plateau = creationPlateau();
      affichagePlateau(plateau);

    }

}