package analiz;
/**
 * Analizador
 */
public class Analizador {

    public int[] acha_sequencia(double[] probs, int[] valores){
        double[] propocao = new double[valores.length];
        double[] propocao2 = new double[valores.length];
        for(int m = 0; m < valores.length; m++){
            propocao[m] = valores[m] * probs[m];
            propocao2[m] = valores[m] * probs[m];
        }

        for (int i = 1; i < propocao.length; ++i) {
            double chave = propocao[i];
            int j = i - 1;
            while (j >= 0 && propocao[j] > chave) {
                propocao[j + 1] = propocao[j];
                j = j - 1;
            }
            propocao[j + 1] = chave;
        }

        double[] ordem = new double [propocao.length]; // cria um novo array
        double y = ordem.length/2; // dar o indice do meio
        double p = Math.ceil(y); // aredonda pra cima o indice
        int r = (int) p;
        ordem[0] = propocao[r]; // move o indice do meio+1 e coloca ele no inicio do outro array
        int t = 1;
        int v = r + 1;
        int l = (int) propocao.length;
        while(r < l){ // coloca todos os elementos mais altos no comeco do array
            if(t + v > l){ // se a soma dos valores for maior que o numero de elementos, pare a execucao do while
                break;
            }
            r = r + 1;
            ordem[t] = propocao[r];
            t = t + 1;
        }
        int x = 0;
        while(t < propocao.length){
            ordem[t] = propocao[x];
            t = t + 1;
            x = x + 1;
        }
        int[] seguencia = new int[ordem.length];
        for(int a = 0; a < ordem.length; a++){
            for(int b = 0; b < ordem.length; b++){
                if(ordem[a] == propocao2[b]){
                    seguencia[a] = b;
                    break;
                }
            }
        }
        return seguencia;
    }
}