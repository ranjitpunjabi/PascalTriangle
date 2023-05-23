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

    /******************************************************************
     METHOD 1 - LOOP
     ******************************************************************/
    public static void pascal_loop(int lines) {
        // number of lines
        for (int row = 0; row < lines; row++) {

            // number of spaces
            for (int space = 1; space < lines - row; space++) {
                System.out.print(" ");
            }

//            reset number to 1
            int number = 1;

            for (int column = 0; column <= row; column++) {
                System.out.print(number + " ");
                // Binomial Expansion
                number = number * (row - column) / (column + 1);
            }
            System.out.println();
        }
    }

    /******************************************************************
     METHOD 2 - RECURSIVE
     ******************************************************************/
    public static void pascal_recursive(int lines){
        // number of lines
        for(int row=0; row<lines; row++){
            // number of spaces
            for(int space=1; space<lines-row; space++){
                System.out.print(" ");
            }
            for(int column=0; column<=row; column++){
                System.out.print(pascal_rec(row, column) + " ");
            }
            System.out.println();
        }
    }

    public static int pascal_rec(int row, int column){
        if(column==0 || column == row){
            return 1;
        }

        // (previous row and current_column-1) + (previous row and current_column)
        return pascal_rec(row-1, column-1) + pascal_rec (row-1, column);
    }


  /******************************************************************
     METHOD 3 - MEMOIZATION AND RECURSIVE
  ******************************************************************/
    public static void pascal_memoization(int lines){
        // number of lines
        for(int row=0; row<lines; row++){

            // number of spaces
            for(int space=1; space<lines-row; space++){
                System.out.print(" ");
            }

            for(int column=0; column<=row; column++){
                System.out.print(pascal_memo(row, column) + " ");
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

        // Get from Cache - memoization
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        // (previous row and current_column-1) + (previous row and current_column)
        result = pascal_memo(row-1, column-1) + pascal_memo (row-1, column);

        // Store in Cache - memoization
        cache.put(key, result);

        return result;
    }
}
