import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tamanho da matriz: ");
        int n = sc.nextInt();

        double aux, pivor;
        double matrizA [][] = new double[n][n];
        double matrizIndent[][] = new double[n][n] ;



        System.out.println("Insira os valores:");


        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                int ii = i+1;
                int jj = j+1;
                System.out.println("Digite os valores de a" + ii + jj + ":");
                matrizA[i][j] = sc.nextInt();
                matrizIndent[i][j] = 0;

                if(i==j){
                    matrizIndent[i][j] = 1;
                }
            }
        }

        System.out.println ("Matriz A  = ");
        for(int i=0;i< matrizA.length;i++){
            for(int j=0;j< matrizA.length;j++){
                System.out.print ("|"+ matrizA[i][j] +"|");
            }
            System.out.println ();
        }

        System.out.println("\nO determinante da matriz é : " + determinante.determinanteDaMatriz(matrizA, n));

        double oDeterminante = determinante.determinanteDaMatriz(matrizA,n);

        if(oDeterminante != 0){
            for(int i=0; i<n; i++){
                pivor = matrizA[i][i];

                //converte o pivor para 1 e zera os outros elementos da coluna
                for(int k = 0; k<n; k++){
                    matrizA[i][k] = matrizA[i][k]/pivor;
                    matrizIndent[i][k] = matrizIndent[i][k]/pivor;
                }

                //
                for(int j =0; j<n; j++){
                    if(i!=j){   // se essa condição é verdadeira então não está na diagonal e deve zerar os elementos
                        aux = matrizA[j][i];

                        for(int k = 0; k<n; k++){
                            matrizA[j][k] = matrizA[j][k] - aux * matrizA[i][k];
                            matrizIndent[j][k] = matrizIndent[j][k] - aux * matrizIndent[i][k];
                        }
                    }
                }

            }

            //imprimir valores
            System.out.println ("\nMatriz A transformada em Matriz Indentidade = ");
            for(int i=0;i< matrizA.length;i++){
                for(int j=0;j< matrizA.length;j++){
                    System.out.print ("|"+ matrizA[i][j] +"|");
                }
                System.out.println ();
            }

            System.out.println ("\nMatriz Indentidade transformada na Inversa da Matriz A = ");
            for(int i=0;i< matrizA.length;i++){
                for(int j=0;j< matrizA.length;j++){
                    System.out.print ("|"+ matrizIndent[i][j] +"|");
                }
                System.out.println ();
            }

        }else{
            System.out.println("\nO determinante da matriz é igual a 0, portanto não é possível calcular a inversa!");
        }



        sc.close();}

}
