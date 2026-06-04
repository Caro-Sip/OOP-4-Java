package Ex1;


public class GridManagement implements GridLayout {
    private int[][] gridArray = new int[7][7];

    @Override
    public void insertAtRow(int rowNumber, int[] values) {
        for(int i = 0; i < 7; i++){
            gridArray[rowNumber][i] = values[i];
        }
        return;
    }

    @Override
    public void insertAtColumn(int columnNumber, int[] values) {
        for(int i = 0; i < 7; i++){
            gridArray[i][columnNumber] = values[i];
        }
        return;
    }

    @Override
    public void clearAtRow(int rowNumber) {
        for(int i = 0; i < 7; i++){
            gridArray[rowNumber][i] = 0;
        }
        return;
    } 
    @Override
    public void clearAtColumn(int columnNumber) {
        for(int i = 0; i < 7; i++){
            gridArray[i][columnNumber] = 0;
        }
        return;
    }

    @Override
    public void updateCell(int rowNumber, int columnNumber, int values) {
        gridArray[rowNumber][columnNumber] = values;   
        return;
    }

    @Override
    public void displayGrid() {
        // print row index
        System.out.print("   ");
        for(int i = 0; i < 7; i++) System.out.print(" " +i);
        System.out.println();
        System.out.print("   ");
        for(int i = 0; i < 7; i++) System.out.print(" -");
        System.out.println();

        for(int c = 0; c < 7; c++) {
            System.out.print(c+" -");

            for(int i = 0; i < 7; i++){
                System.out.print(" "+gridArray[c][i]);
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        for(int i=0;i < 7;i++){
            clearAtRow(i);
            clearAtColumn(i);
        }
        return;
    }
    
}
