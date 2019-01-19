package it.unive.dais.commandroid;

/* Not used, for now */
public class MyDraw {

    private final int RIGHE = 7;
    private final int COLONNE = 4;
    private int[][] draw;

    public int getCol(){
        return this.COLONNE;
    }

    public int getRow(){
        return this.RIGHE;
    }

    //check if the matrix `draw` is full of zero or not
    public boolean buttonsNull(){
        for(int i = 0; i < this.RIGHE; i++){
            for(int y = 0; y < this.COLONNE; y++){
                if (this.draw[i][y] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public MyDraw(){
        //initialize
        this.draw = new int[this.RIGHE][this.COLONNE];

        //set every cell to zero
        for(int i = 0; i < this.RIGHE; i++){
            for(int y = 0; y < this.COLONNE; y++){
                this.draw[i][y] = 0;
            }
        }
    }
}
