import java.util.Random;
import java.util.Scanner;

public class HashLista {
    public static class hash {
        int chave;
        hash prox;
    }
    public static final int TAM_VETOR = 10000000; //Nº de chaves inseridas
    static int tam = 100000; //Nº de linhas na tabela
    static hash tabela[] = new hash[tam];
    static Scanner entrada = new Scanner(System.in);

    public static void inserir(int num) {
        int pos = funcao_hashing(num);

        hash novo;
        novo = new hash();
        novo.chave = num;
        novo.prox = tabela[pos];
        tabela[pos] = novo;
    }

    public static void inserir(int pos, int n) {
        hash novo;
        novo = new hash();
        novo.chave = n;
        novo.prox = tabela[pos];
        tabela[pos] = novo;
    }

    static int funcao_hashing(int num) {
        return num % 97;
    }

    static void mostrar_hash() {
        hash aux;
        for(int i = 0; i < tam; i++) {
            aux = tabela[i];

            while(aux != null) {
                System.out.println("Entrada " + i + ": " + aux.chave);
                aux = aux.prox;
            }
        }
    }

    static int buscar(int num) {
        int pos = funcao_hashing(num);
        hash aux;

        if(tabela[pos] != null) {
            if(tabela[pos].chave == num)
                return tabela[pos].chave;
            
            else {
                aux = tabela[pos].prox;

                while(aux != null && aux.chave != num) {
                    aux = aux.prox;
                }

                if(aux != null)
                    return aux.chave;

                else
                    return -1;
            }
        } else 
            return -1;
    }

    static void excluir_hash(int num) {
        int pos = funcao_hashing(num);
        hash aux;

        if(tabela[pos] != null) {
            if(tabela[pos].chave == num)
                tabela[pos] = tabela[pos].prox;
            
            else {
                aux = tabela[pos].prox;
                hash ant = tabela[pos];

                while(aux != null && aux.chave != num) {
                    ant = aux;
                    aux = aux.prox;
                }

                if(aux != null)
                    ant.prox = aux.prox;

                else
                    System.out.println("Numero nao encontrado");
            }
        } else 
            System.out.println("Numero nao encontrado");

    }

    public static void main(String args[]) {
        /*int op, pos;
        int num;

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
                    excluir_hash(num);
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