public class AlgoritmosOrdenacao {
    
    public static void bubbleSort(int array[]) {
        for(int i = array.length - 1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void quickSort(int array[]) {
        quickSort(array, 0, array.length - 1);
    }
    
    private static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int pivotId = (end + begin) / 2;
        int pivot = array[pivotId];
        swap(array, pivotId, end);

        int left = partition(array, begin, end, pivot);

        quickSort(array, begin, left - 1);
        quickSort(array, left + 1, end);
    }

    private static int partition(int[] array, int begin, int end, int pivot) {
        int left = begin;
        int right = end - 1;

        while (left < right) {
            while (array[left] <= pivot && left < right) {
                left++;
            }

            while (array[right] >= pivot && left < right) {
                right--;
            }

            swap(array, left, right);
        }

        if (array[left] > array[end]) {
            swap(array, left, end);
        } else {
            left = end;
        }

        return left;
    }
    
    public static void mergeSort(int array[]) {
        if(array.length > 1) {
            int mid = array.length / 2;
            int leftHalf[] = new int[mid];
            int rightHalf[] = new int[array.length - mid];

            for(int i = 0; i < mid; i++) {
                leftHalf[i] = array[i];
            }

            for(int i = mid; i < array.length; i++) {
                rightHalf[i - mid] = array[i];
            }

            mergeSort(leftHalf);
            mergeSort(rightHalf);
            merge(array, leftHalf, rightHalf);
        }
    }

    private static void merge(int array[], int leftHalf[], int rightHalf[]) {
        int i = 0, j = 0, k = 0;

        while(i < leftHalf.length && j < rightHalf.length) {
            if(leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }

            k++;
        }

        while(i < leftHalf.length) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while(j < rightHalf.length) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void heapSort(int array[]) {
        int n = array.length;

        buildMaxHeap(array);
        
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
  
            maxHeapify(array, i, 0);
        }
    }

    private static void buildMaxHeap(int array[]) {
        for(int i = (array.length / 2) - 1; i >= 0; i--) {
            maxHeapify(array, array.length, i);
        }
    }
    private static void maxHeapify(int array[], int n, int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);
  
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
            
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }
        
        if (largest != i) {
            swap(array, i, largest);
            maxHeapify(array, n, largest);
        }
    }
    
    private static int parent(int i) {
        return i / 2;
    }

    private static int left(int i) {
        return 2 * i;
    }

    private static int right(int i) {
        return (2 * i) + 1;
    }

    public static void insertionSort(int array[]) {
        int temp, j;

        for(int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;

            while(j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }
    }

    public static void selectionSort(int array[]) {
        int min;

        for(int i = 0; i < array.length; i++) {
            min = i;

            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }

            if(array[i] != array[min]) {
                swap(array, i, min);
            }
        }
    }

    private static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}