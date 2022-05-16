import java.util.Random;


public class Teste {
    public static final int TAM_VETOR = 1000000;
    public static void main(String args[]) {
        int mergesort[] = new int[TAM_VETOR];
        int quicksort[] = new int[TAM_VETOR];
        int insertionsort[] = new int[TAM_VETOR];
        int mergesortCrescente[] = new int[TAM_VETOR];
        int quicksortCrescente[] = new int[TAM_VETOR];
        int insertionsortCrescente[] = new int[TAM_VETOR];
        int mergesortDecrescente[] = new int[TAM_VETOR];
        int quicksortDecrescente[] = new int[TAM_VETOR];
        int insertionsortDecrescente[] = new int[TAM_VETOR];

        Random random = new Random();
        
        for(int i = 0; i < TAM_VETOR; i++) {
            mergesort[i] = random.nextInt(10000);
            quicksort[i] = random.nextInt(10000);
            insertionsort[i] = random.nextInt(10000);
        }

        for(int i = 0; i < TAM_VETOR; i++) {
            mergesortCrescente[i] = i;
            quicksortCrescente[i] = i;
            insertionsortCrescente[i] = i;
        }

        for(int i = 0; i < TAM_VETOR; i++) {
            mergesortDecrescente[i] = TAM_VETOR - i;
            quicksortDecrescente[i] = TAM_VETOR - i;
            insertionsortDecrescente[i] = TAM_VETOR - i;
        }
        /*
        
        int quicksortTeste[] = {57, 82, 28, 23, 44, 44, 75, 84, 79, 43};

        for(int i = 0; i < quicksortTeste.length; i++) {
            System.out.print(quicksortTeste[i] + " ");
        }

        System.out.println("\n\n");
        AlgoritmosOrdenacao.quickSort(quicksortTeste);

        for(int i = 0; i < quicksortTeste.length; i++) {
            System.out.print(quicksortTeste[i] + " ");
        }
        */

        double start = System.currentTimeMillis();
        AlgoritmosOrdenacao.mergeSort(mergesort);
        double finish = System.currentTimeMillis();
        System.out.println("Mergesort Aleatorio: " + ((finish - start) / 1000) + "s");

        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.quickSort(quicksort);
        finish = System.currentTimeMillis();
        System.out.println("Quicksort Aleatorio: " + ((finish - start) / 1000) + "s");

        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.insertionSort(insertionsort);
        finish = System.currentTimeMillis();
        System.out.println("Insertionsort Aleatorio: " + ((finish - start) / 1000) + "s\n\n");



        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.mergeSort(mergesortCrescente);
        finish = System.currentTimeMillis();
        System.out.println("Mergesort Crescente: " + ((finish - start) / 1000) + "s");

        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.quickSort(quicksortCrescente);
        finish = System.currentTimeMillis();
        System.out.println("Quicksort Crescente: " + ((finish - start) / 1000) + "s");

        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.insertionSort(insertionsortCrescente);
        finish = System.currentTimeMillis();
        System.out.println("Insertionsort Crescente: " + ((finish - start) / 1000) + "s\n\n");



        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.mergeSort(mergesortDecrescente);
        finish = System.currentTimeMillis();
        System.out.println("Mergesort Decrescente: " + ((finish - start) / 1000) + "s");
        
        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.quickSort(quicksortDecrescente);
        finish = System.currentTimeMillis();
        System.out.println("Quicksort Decrescente: " + ((finish - start) / 1000) + "s");
       
        start = System.currentTimeMillis();
        AlgoritmosOrdenacao.insertionSort(insertionsortDecrescente);
        finish = System.currentTimeMillis();
        System.out.println("Insertionsort Decrescente: " + ((finish - start) / 1000) + "s\n\n");
    }
}