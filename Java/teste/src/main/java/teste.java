public class teste {
    public static void main(String[] args) {

        int qtdLinhas = 10;
        int qtdColunas = 10;
        int[] matriz ;

        for(int i = 0; i<qtdLinhas; i++){
            for(int j = 0; j<qtdColunas; j++){
                System.out.println(2 * matriz[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
}
