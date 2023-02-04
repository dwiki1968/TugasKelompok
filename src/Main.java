import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] data = new int[5];
        boolean flag = true;

        // menampilkan pilihan menu
        System.out.println("Selamat Datang di Program Simulasi");
        System.out.println("Menu: ");
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort - Ascending");
        System.out.println("3. Simulasi Selection Sort - Ascending");
        System.out.println("4. Simulasi Bubble Sort - Descending");
        System.out.println("5. Simulasi Selection Sort - Descending");
        System.out.println("6. Keluar");

        while (flag) {
            System.out.println();

            // input pilihan menu
            System.out.print("Pilihan: ");
            int choice = sc.nextInt();

            // pengkondisian method / block yang di eksekusi berdasar inputan pilihan menu dari user
            switch (choice) {
                // menu 1. untuk men-generate 5 angka random
                case 1:
                    System.out.print("Batas Bawah: ");
                    int lower = sc.nextInt();
                    System.out.print("Batas Atas: ");
                    int upper = sc.nextInt();

                    for (int i = 0; i < data.length; i++) {
                        data[i] = rand.nextInt(upper - lower + 1) + lower;
                        System.out.print(data[i] + " ");
                    }
                    System.out.println();
                    break;

                // menu 2 bubble sort ascending
                case 2:
                    bubbleSortAscending(data);
                    break;

                // menu 3 selection sort ascending
                case 3:
                    selectionSortAscending(data);
                    break;

                // menu 4 bubble sort descending
                case 4:
                    bubbleSortDescending(data);
                    break;

                // menu 5 selection sort descending
                case 5:
                    selectionSortDescending(data);
                    break;

                // menu 6. Keluar -> mengeluarkan aplikasi dengan meng-set kondisi while loop
                // menjadi false
                case 6:
                    flag = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        sc.close(); // menghindari resource leak dalam penggunaan object scanner

    }

    // method untuk print array to string
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // method untuk bubble sort ascending
    public static void bubbleSortAscending(int[] data) {
        int[] arr = data.clone();
        int n = arr.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1));
            printArray(arr);

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                // print setiap simulasi
                printArray(arr);
            }
            // printing result akhir tiap putaran
            System.out.println("Result of Pass " + (i + 1));
            printArray(arr);
            System.out.println();
        }
    }

    // method untuk selection sort ascending
    public static void selectionSortAscending(int[] data) {
        int[] arr = data.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1));
            printArray(arr);
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            // printing result akhir tiap putaran
            System.out.println("Result of Pass " + (i + 1));
            printArray(arr);
            System.out.println();

        }
    }

    // method untuk bubble sort descending
    public static void bubbleSortDescending(int[] data) {
        int[] arr = data.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1));
            printArray(arr);

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                printArray(arr);

            }
            System.out.println("Result of Pass " + (i + 1));
            printArray(arr);
            System.out.println();

        }
    }

    // method untuk selection sort descending
    public static void selectionSortDescending(int[] data) {
        int[] arr = data.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1));
            printArray(arr);
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;

            System.out.println("Result of Pass " + (i + 1));
            printArray(arr);
            System.out.println();
        }
    }

    // end code
}