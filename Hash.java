import java.util.Random;
import java.util.Scanner;

public class Hash {

    public static class hash {
        int chave;
        char livre;
    }

    public static final int TAM_VETOR = 1000000;
    static int tam = 10000000;
    static hash tabela[] = new hash[tam];
    static Scanner entrada = new Scanner(System.in);


    public static void inserir(int n) {
        int pos = funcao_hashing(n);

        int i = 0;
        while(i < tam
        && tabela[(pos + i * i) % tam].livre != 'L'
        && tabela[(pos + i * i) % tam].livre != 'R') 
            i++;

        if(i < tam) {
            tabela[(pos + i * i) % tam].chave = n;
            tabela[(pos + i * i) % tam].livre = 'O';
        } else 
            System.out.println("Tabela cheia!");
    }

    public static void inserir(int pos, int n) {
        int i = 0;
        while(i < tam
        && tabela[(pos + i) % tam].livre != 'L'
        && tabela[(pos + i) % tam].livre != 'R')
            i++;

        if(i < tam) {
            tabela[(pos + i) % tam].chave = n;
            tabela[(pos + i) % tam].livre = 'O';
        } else 
            System.out.println("Tabela cheia!");
    }

    public static void remover(int n) {
        int posicao = buscar(n);

        if(posicao < tam)
            tabela[posicao].livre = 'R';

        else
            System.out.println("Elemento nao esta presente.");

    }

    public static int buscar(int n) {
        int i = 0;
        int pos = funcao_hashing(n);

        while(i < tam
        && tabela[(pos + i * i) % tam].livre != 'L'
        && tabela[(pos + i * i) % tam].chave != n)
            i++;

        if(tabela[(pos + i * i) % tam].chave == n
        && tabela[(pos + i * i) % tam].livre != 'R')
            return (pos + i * i) % tam;

        else
            return tam;
    }

    static int funcao_hashing(int num) {
        return num % tam;
    }

    static void mostrar_hash() {
        for(int i = 0; i < tam; i++) {
            if(tabela[i].livre == 'O')
                System.out.println("Entrada " + i + ": " + tabela[i].chave + " " + tabela[i].livre);
        }
    }

    public static void main(String args[]) {
        /*int op, pos;
        int num, i;

        for(i = 0; i < tam; i++) {
            tabela[i] = new hash();
            tabela[i].livre = 'L';
        }

        while(true) {
            System.out.println("\nMENU DE OPCOES\n");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Mostrar tabela hashing");
            System.out.println("3 - Excluir elemento");
            System.out.println("4 - Sair");
            System.out.println("Digite sua opcao: ");

            op = entrada.nextInt();

            switch(op) {
                case 1:
                    System.out.println("Digite um numero: ");
                    num = entrada.nextInt();
                    pos = funcao_hashing(num);
                    inserir(pos, num);
                    break;
                case 2:
                    mostrar_hash();
                    break;
                case 3:
                    System.out.println("Digite um numero: ");
                    num = entrada.nextInt();
                    remover(num);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Entrada invalida!");

            }
        }*/

        
        int vet[] = new int[TAM_VETOR];
        Random rand = new Random();
        int j, aux;
        double inicio, fim, tempo;

        for(int i = 0; i < tam; i++) {
            tabela[i] = new hash();
            tabela[i].livre = 'L';
        }

        for(int i = 0; i < TAM_VETOR; i++) {
            vet[i] = i;
        }

        for(int i = 0; i < TAM_VETOR - 2; i++) {
            j = rand.nextInt(TAM_VETOR);
            aux = vet[i];
            vet[i] = vet[j];
            vet[j] = aux;
        }

        inicio = System.currentTimeMillis() / 1000.0;
        for(int i = 0; i < TAM_VETOR; i++) {
            inserir(vet[i]);
        }
        fim = System.currentTimeMillis() / 1000.0;

        tempo = (fim - inicio);
        System.out.println("Tempo para insersao hash lista encadeada: " + tempo);

        inicio = System.currentTimeMillis() / 1000.0;
        for(int i = 0; i < TAM_VETOR; i++) {
            buscar(vet[i]);
        }
        fim = System.currentTimeMillis() / 1000.0;

        tempo = (fim - inicio);
        System.out.println("Tempo para busca hash lista encadeada: " + tempo);
    }
}