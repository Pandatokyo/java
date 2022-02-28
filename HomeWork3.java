public class HomeWork3 {
    public static void main(String[] args) {
        int[] myArray = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arrayTwo = {1, 2, 3, 4, 5}
        changeDigit(); /* 1 задание*/
        makeBigArray(); /* 2 задание*/
        changeArray(); /* 3 задание*/
        makeDoubleArray(); /* 4 задание */
        makeArray(5, 13); /* 5 задание */
        findMinMax(); /* 6 задание */
        checkBalance(myArray); /* 7 задание */
        moveArray(arrayTwo); /* 8 задание */
    }

    public static void changeDigit() {
        int[] arr = {1, 0, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            }
            if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
    }

    public static void makeBigArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                int a = array[i];
                array[i] = a * 2;
            }
        }
    }

    public static void makeDoubleArray() {
        int[][] array = new int[8][8];
        /* заполним двойками, чтобы единицы были различимы*/
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i + j == 7) {
                    array[i][j] = 1;
                } else if (i == j) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 2;
                }
            }
        }
    }

    public static void makeArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        /* IDE предлагает метод fill, который работает также как этот цикл*/
    }

    public static int[] findMinMax() {
        int min = 100000;
        int max = -100000;
        /* в качестве минимального и максимального значений можно использовать лимиты int, но в этом примере
        для наглядности я использовал 100000 и -100000 и массив, где числа находятся в пределе этих двух
        значений.
         */
        int[] arr = {10, 123, -13, 432, 900, -5, -123, 444};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        /* IDE также предлагает этот цикл заменить на более короткий (for j : arr), но я не уверен,
        проходили ли мы такой способ.
         */
        return new int[] {min, max};
    }

    public static boolean checkBalance(int[] arr) {
        int firstSum = 0;
        for (int i = 0; i < arr.length; i++) {
            firstSum += arr[i];
            int secondSum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j > i) secondSum += arr[j];
                else secondSum += 0;
            }
            if (firstSum == secondSum) {
                return true;
            }
        }
        return false;
    }
    public static void moveArray(int[]) {

    }
}

