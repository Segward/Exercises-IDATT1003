import java.util.Scanner;
import java.util.Vector;

// This program prints a multiplication table from user input
public class MultiplicationTable {
    // This is the scanner used for getting user input
    static Scanner scan = new Scanner(System.in);

    public static class InnerMulTable {
        // These are the variables of the class
        public int tableMultiple;
        public int tableRange;
        Vector<Integer> table = new Vector<>();

        // This is the constructor of the inner multiplication table
        public InnerMulTable(int tableMultiple, int tableRange) {
            this.tableMultiple = tableMultiple;
            this.tableRange = tableRange;
            // Add elements to table
            for (int i = 1; i <= tableRange; ++i) {
                table.addElement(i*tableMultiple);
            }
        }

        // Print the contents of the table
        public void printTable() {
            System.out.println(String.format("\nMultiplication Table for %s", tableMultiple));
            for (int i : table) {
                System.out.println(String.format("%s * %s = %s", 
                tableMultiple, i/tableRange, i));
            }
        }
    }

    // This class represents a multiplication table
    public static class OuterMulTable {
        // These are the variables of the class
        public int tableMultiplierStart;
        public int tableMultiplierEnd;
        public int tableRange;
        Vector<InnerMulTable> multiplicationTable = new Vector<>();

        // This is the constructor of the outer multiplication table
        public OuterMulTable(int tableMultiplierStart, int tableMultiplierEnd, int tableRange) {
            this.tableMultiplierStart = tableMultiplierStart;
            this.tableMultiplierEnd = tableMultiplierEnd;
            this.tableRange = tableRange;
            
            // Add elements to multiplicationTable
            for (int i = tableMultiplierStart; i <= tableMultiplierEnd; ++i) {
                InnerMulTable innerMulTable = new InnerMulTable(i, tableRange);
                multiplicationTable.addElement(innerMulTable);
            }
        }

        // This function prints the multiplication table
        public void printTable() {
            // The multiplication table point
            for (InnerMulTable innerMulTable : multiplicationTable) {
                innerMulTable.printTable();
            }
        }
    }

    // This function gets the user input for the start of the multiplication table
    public static int getMultiplicationTableStart() {   
        System.out.print("\nChoose a multiplication table starting point: ");
        int tableMultiplierStart = scan.nextInt();
        return tableMultiplierStart;
    }

    // This function gets the user input for the end of the multiplication table
    public static int getMultiplicationTableEnd() {   
        System.out.print("\nChoose a multiplication table ending point: ");
        int tableMultiplierEnd = scan.nextInt();
        return tableMultiplierEnd;
    }

    // This function gets the user input for the range of the multiplication table
    public static int getTableRange() {
        System.out.print("\nChoose a table range: ");
        int tableRange = scan.nextInt();
        return tableRange;
    }

    // This function gets the user input for the multiplication table and its range
    public static OuterMulTable getMulTable() {
        int tableMultiplierStart = getMultiplicationTableStart();
        int tableMultiplierEnd = getMultiplicationTableEnd();
        int tableRange = getTableRange();
        return new OuterMulTable(tableMultiplierStart, tableMultiplierEnd, tableRange);
    }

    // This function gets the multiplication table and prints it
    public static boolean getNewMultiplicationTable() {
        try {
            OuterMulTable multiplicationTable = getMulTable();
            multiplicationTable.printTable();
            return true;  
        }

        // Catch the exception if the user input is not a number
        catch (Exception e) {
            System.out.println("invalid number");
            return false;
        }
    }

    // This is the main function
    public static void main(String[] args)  {
        do {
            // This part does absolutely nothing
        } while (getNewMultiplicationTable());
        scan.close();
    }
}
