import java.util.*;

public class Main {
    public static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Enter number of lines for a Pascal triangle:");
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();

        System.out.println("Pascal Triangle using Loops");
        pascal_loop(lines);
        System.out.println();

        System.out.println("Pascal Triangle using Recursive Function");
        pascal_recursive(lines);
        System.out.println();

        System.out.println("Pascal Triangle using Memoization and Recursive Function");
        pascal_memoization(lines);
        System.out.println();
    }


    // METHOD 3 - MEMOIZATION AND RECURSIVE
    public static void pascal_memoization(int line){
        for(int i=0; i<line; i++){                   // number of lines
            for(int s=1; s<line-i; s++){             // number of spaces
                System.out.print(" ");
            }
            for(int j=0; j<=i;j++){
                System.out.print(pascal_memo(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascal_memo(int row, int column){
        String key = row + "-" + column;
        int result = 0;

        if(column==0 || column == row){
            return 1;
        }
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        // (previous row and current_column-1) + (previous row and current_column)
        result = pascal_memo(row-1, column-1) + pascal_memo (row-1, column);
        cache.put(key, result);

        return result;
    }


    // METHOD 2 - RECURSIVE
    public static void pascal_recursive(int line){
        // number of lines
        for(int i=0; i<line; i++){

            // number of spaces
            for(int s=1; s<line-i; s++){
                System.out.print(" ");
            }
            for(int j=0; j<=i;j++){
                System.out.print(pascal_rec(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascal_rec(int i, int j){

        int result = 0;
        int num=0;
        if(j==0 || j == i){
            return 1;
        }

        // (previous row and current_column-1) + (previous row and current_column)
        return pascal_rec(i-1, j-1) + pascal_rec (i-1, j);
    }


    // METHOD 1 - LOOP
    public static void pascal_loop(int lines) {
        // number of lines
        for (int i = 0; i < lines; i++) {

            // number of spaces
            for (int s = 1; s < lines - i; s++) {
                System.out.print(" ");
            }

//            reset number to 1
            int number = 1;

            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
