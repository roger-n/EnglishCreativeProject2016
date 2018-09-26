package main;

public class IsGameOver {
    static String winOrLose;
    static String scoreString;
    static long score;
    public static void IsGameOverMethod(){

        if(MainWindow.playerHp <=0){
            MainWindow.endTime = System.nanoTime();
            MainWindow.time = (MainWindow.endTime - MainWindow.startTime)/1000000000;
            MainWindow.playerHp = 0;

            MainWindow.topBarLabel1a.setText(MainWindow.playerHp + "HP");
            MainWindow.topBarLabel1b.setText("STR: " + MainWindow.playerPower);
            MainWindow.topBarLabel2.setText("Computer HP: " + MainWindow.computerHp);

            MainWindow.gameGoing = false;
            MainWindow.left.setEnabled(false);
            MainWindow.right.setEnabled(false);
            MainWindow.fire.setEnabled(false);

            for (int i = 0; i < 10; i++){
                for (int b = 0; b < 10; b++){
                    MainWindow.gameGrid[i][b].setIcon(null);
                    MainWindow.gameGrid[i][b].setText(null);

                    MainWindow.gameGrid[1][3].setText("G");
                    MainWindow.gameGrid[1][4].setText("A");
                    MainWindow.gameGrid[1][5].setText("M");
                    MainWindow.gameGrid[1][6].setText("E");
                    MainWindow.gameGrid[2][3].setText("O");
                    MainWindow.gameGrid[2][4].setText("V");
                    MainWindow.gameGrid[2][5].setText("E");
                    MainWindow.gameGrid[2][6].setText("R");

                    MainWindow.gameGrid[3][1].setText("Y");
                    MainWindow.gameGrid[3][2].setText("O");
                    MainWindow.gameGrid[3][3].setText("U");
                    MainWindow.gameGrid[3][4].setText("");
                    MainWindow.gameGrid[3][5].setText("L");
                    MainWindow.gameGrid[3][6].setText("O");
                    MainWindow.gameGrid[3][7].setText("S");
                    MainWindow.gameGrid[3][8].setText("E");
                    MainWindow.gameGrid[3][9].setText(".");

                    MainWindow.gameGrid[8][1].setText("W");
                    MainWindow.gameGrid[8][2].setText("H");
                    MainWindow.gameGrid[8][3].setText("A");
                    MainWindow.gameGrid[8][4].setText("T");
                    MainWindow.gameGrid[8][5].setText("");
                    MainWindow.gameGrid[8][6].setText("W");
                    MainWindow.gameGrid[8][7].setText("A");
                    MainWindow.gameGrid[8][8].setText("S");
                    MainWindow.gameGrid[8][9].setText("");
                    MainWindow.gameGrid[9][0].setText("Y");
                    MainWindow.gameGrid[9][1].setText("O");
                    MainWindow.gameGrid[9][2].setText("U");
                    MainWindow.gameGrid[9][3].setText("R");
                    MainWindow.gameGrid[9][4].setText("");
                    MainWindow.gameGrid[9][5].setText("D");
                    MainWindow.gameGrid[9][6].setText("E");
                    MainWindow.gameGrid[9][7].setText("M");
                    MainWindow.gameGrid[9][8].setText("O");
                    MainWindow.gameGrid[9][9].setText("N      ?");



                }
            }
        } else if (MainWindow.computerHp <= 0){
            MainWindow.endTime = System.nanoTime();
            MainWindow.time = (MainWindow.endTime - MainWindow.startTime)/1000000000;
            score = MainWindow.playerHp + 2 * MainWindow.playerPower + 50 - MainWindow.time / 2;
            scoreString = score + "";
            winOrLose = "player";
            MainWindow.computerHp = 0;

            MainWindow.topBarLabel1a.setText(MainWindow.playerHp + "HP");
            MainWindow.topBarLabel1b.setText("STR: " + MainWindow.playerPower);
            MainWindow.topBarLabel2.setText("Computer HP: " + MainWindow.computerHp);

            MainWindow.gameGoing = false;
            MainWindow.left.setEnabled(false);
            MainWindow.right.setEnabled(false);
            MainWindow.fire.setEnabled(false);

            for (int i = 0; i < 10; i++){
                for (int b = 0; b < 10; b++){
                    MainWindow.gameGrid[i][b].setIcon(null);
                    MainWindow.gameGrid[i][b].setText(null);

                    MainWindow.gameGrid[1][3].setText("G");
                    MainWindow.gameGrid[1][4].setText("A");
                    MainWindow.gameGrid[1][5].setText("M");
                    MainWindow.gameGrid[1][6].setText("E");
                    MainWindow.gameGrid[2][3].setText("O");
                    MainWindow.gameGrid[2][4].setText("V");
                    MainWindow.gameGrid[2][5].setText("E");
                    MainWindow.gameGrid[2][6].setText("R");

                    MainWindow.gameGrid[3][2].setText("Y");
                    MainWindow.gameGrid[3][3].setText("O");
                    MainWindow.gameGrid[3][4].setText("U");
                    MainWindow.gameGrid[3][5].setText("");
                    MainWindow.gameGrid[3][6].setText("W");
                    MainWindow.gameGrid[3][7].setText("I");
                    MainWindow.gameGrid[3][8].setText("N");
                    MainWindow.gameGrid[3][9].setText("!");

                    MainWindow.gameGrid[5][2].setText("S");
                    MainWindow.gameGrid[5][3].setText("C");
                    MainWindow.gameGrid[5][4].setText("O");
                    MainWindow.gameGrid[5][5].setText("R");
                    MainWindow.gameGrid[5][6].setText("E  :");

                    MainWindow.gameGrid[5][8].setText(scoreString);

                    MainWindow.gameGrid[8][1].setText("W");
                    MainWindow.gameGrid[8][2].setText("H");
                    MainWindow.gameGrid[8][3].setText("A");
                    MainWindow.gameGrid[8][4].setText("T");
                    MainWindow.gameGrid[8][5].setText("");
                    MainWindow.gameGrid[8][6].setText("W");
                    MainWindow.gameGrid[8][7].setText("A");
                    MainWindow.gameGrid[8][8].setText("S");
                    MainWindow.gameGrid[8][9].setText("");
                    MainWindow.gameGrid[9][0].setText("Y");
                    MainWindow.gameGrid[9][1].setText("O");
                    MainWindow.gameGrid[9][2].setText("U");
                    MainWindow.gameGrid[9][3].setText("R");
                    MainWindow.gameGrid[9][4].setText("");
                    MainWindow.gameGrid[9][5].setText("D");
                    MainWindow.gameGrid[9][6].setText("E");
                    MainWindow.gameGrid[9][7].setText("M");
                    MainWindow.gameGrid[9][8].setText("O");
                    MainWindow.gameGrid[9][9].setText("N      ?");
                }
            }
        } else{}

    }
}