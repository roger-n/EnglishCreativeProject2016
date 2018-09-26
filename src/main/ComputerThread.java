package main;

public class ComputerThread implements Runnable{
    public void run(){

        while(MainWindow.gameGoing){

            MainWindow.actualTime2 = System.nanoTime();
            MainWindow.actualTime = MainWindow.actualTime2 - MainWindow.actualTime1;


            if (MainWindow.actualTime > 200000000){
                //----Start

                for (int u = 0; u < 10; u++){

                    if (MainWindow.yourShotCoorsY[u] == -1){
                        MainWindow.gameGrid[MainWindow.yourShotCoorsY[u]+1][MainWindow.yourShotCoorsX[u]].setText(null);

                        MainWindow.yourShotCoorsY[u] = 9;
                        MainWindow.yourShotCoorsX[u] = 0;
                    }
                }
                for (int p = 0; p < 10; p++){
                    if (MainWindow.yourShotCoorsY[p] <= 8){
                        MainWindow.gameGrid[MainWindow.yourShotCoorsY[p]+1][MainWindow.yourShotCoorsX[p]].setText(null);
                        MainWindow.gameGrid[MainWindow.yourShotCoorsY[p]][MainWindow.yourShotCoorsX[p]].setText("     o    ");
                    }

                }
                //----End
                for (int u = 0; u < 10; u++){

                    if (MainWindow.theirShotCoorsY[u] == 10){
                        MainWindow.gameGrid[MainWindow.theirShotCoorsY[u]-1][MainWindow.theirShotCoorsX[u]].setText(null);

                        MainWindow.theirShotCoorsY[u] = 0;
                        MainWindow.theirShotCoorsX[u] = 0;
                        MainWindow.theirShotType[u] = 0;

                    }
                }

                for (int p = 0; p < 10; p++){
                    if (MainWindow.theirShotCoorsY[p] >= 1){
                        MainWindow.gameGrid[MainWindow.theirShotCoorsY[p]-1][MainWindow.theirShotCoorsX[p]].setText(null);
                        MainWindow.gameGrid[MainWindow.theirShotCoorsY[p]][MainWindow.theirShotCoorsX[p]].setText(MainWindow.shotTypes[MainWindow.theirShotType[p]]);
                    }

                }
                //MOVEMENT------------------------------------------------------------------------------------------------------------------------
                MainWindow.gameGrid[0][MainWindow.xCoorComputer1].setIcon(null);
                MainWindow.gameGrid[0][MainWindow.xCoorComputer2].setIcon(null);
                MainWindow.computerLeftOrRight = MainWindow.randomGenerator.nextInt(2);
                if (MainWindow.computerLeftOrRight == 0){
                    MainWindow.xCoorComputer1 -=1;
                    MainWindow.xCoorComputer2 -=1;
                    if (MainWindow.xCoorComputer1 < 0){
                        MainWindow.xCoorComputer2 = 1;
                        MainWindow.xCoorComputer1 = 0;
                    }
                    MainWindow.theirShotCoorsX[MainWindow.theirShotCounter] = MainWindow.xCoorComputer1;
                } else if (MainWindow.computerLeftOrRight ==1){
                    MainWindow.xCoorComputer1 +=1;
                    MainWindow.xCoorComputer2 +=1;
                    if (MainWindow.xCoorComputer2 > 9){
                        MainWindow.xCoorComputer1 = 8;
                        MainWindow.xCoorComputer2 = 9;
                    }
                }

                //----Start
                if (MainWindow.youFired == true){
                    MainWindow.yourShotCoorsX[MainWindow.yourShotCounter] = MainWindow.xCoorPlayer;
                    MainWindow.yourShotCoorsY[MainWindow.yourShotCounter] = 8;
                    MainWindow.gameGrid[MainWindow.yourShotCoorsY[MainWindow.yourShotCounter]][MainWindow.yourShotCoorsX[MainWindow.yourShotCounter]].setText("     o    ");
                    MainWindow.yourShotCounter ++;
                    MainWindow.youFired = false;
                }
                //----End
                //------------------------------------------------------------------------------------------------------------------------------------
                MainWindow.doTheyShoot = MainWindow.randomGenerator.nextInt(4);
                if (MainWindow.doTheyShoot == 0 || MainWindow.doTheyShoot == 1){
                    MainWindow.theirShotCoorsX[MainWindow.theirShotCounter] = MainWindow.xCoorComputer1;
                    MainWindow.theirShotCoorsY[MainWindow.theirShotCounter] = 1;
                    MainWindow.theirShotType[MainWindow.theirShotCounter] = MainWindow.shotTypeRandom = MainWindow.randomGenerator.nextInt(16);

                    MainWindow.gameGrid[MainWindow.theirShotCoorsY[MainWindow.theirShotCounter]][MainWindow.theirShotCoorsX[MainWindow.theirShotCounter]].setText(MainWindow.shotTypes[MainWindow.theirShotType[MainWindow.theirShotCounter]]);
                    MainWindow.theirShotCounter ++;

                } else {

                }


                //REPAINT CPU---------------------------------------------------------------------------------------------------------------------------
                MainWindow.gameGrid[0][MainWindow.xCoorComputer1].setIcon(MainWindow.computer1);
                MainWindow.gameGrid[0][MainWindow.xCoorComputer2].setIcon(MainWindow.computer2);
                //--------------------------------------------------------------------------------------------------------------------------------------

                for (int y = 0; y < 10; y++){
                    if (MainWindow.theirShotCoorsY[y] != 0){
                        MainWindow.theirShotCoorsY[y]++;
                    }
                }

                if (MainWindow.theirShotCounter == 9){
                    MainWindow.theirShotCounter = 0;
                }
                //----------------------------------------
                for (int n = 0; n < 10; n++){
                    if (MainWindow.yourShotCoorsY[n] < 9){
                        MainWindow.yourShotCoorsY[n] -=1;
                    }
                }

                if (MainWindow.yourShotCounter == 9){
                    MainWindow.yourShotCounter = 0;
                }

                //---------------------------------------------------------------------
                //----------------------------------------------------------------------
                //-----------------------------------------------------------------------
                //------------------------------------------------------------------------


                for (int o = 0; o < 10; o++){
                    if ((MainWindow.xCoorComputer1 == MainWindow.yourShotCoorsX[o] || MainWindow.xCoorComputer2 == MainWindow.yourShotCoorsX[o]) &&
                            MainWindow.yourShotCoorsY[o] == -1){                                   //-1 because yourShotCoorsY has already been decremented
                        MainWindow.computerHp -= MainWindow.playerPower;

                        MainWindow.topBarLabel1a.setText(MainWindow.playerHp + "HP");
                        MainWindow.topBarLabel1b.setText("STR: " + MainWindow.playerPower);
                        MainWindow.topBarLabel2.setText("Computer HP: " + MainWindow.computerHp);

                    }
                }
                for (int a = 0; a < 10; a++){
                    if ((MainWindow.xCoorPlayer == MainWindow.theirShotCoorsX[a]) && (MainWindow.theirShotCoorsY[a] == 10)){  //10 because theirShotCoorsY already incremented

                        if (MainWindow.theirShotType[a] == 0){
                            MainWindow.playerHp *= 1.5;
                            MainWindow.playerPower /= 1.5;
                        } else if (MainWindow.theirShotType[a] == 1){
                            MainWindow.playerHp /= 1.5;
                            MainWindow.playerPower *= 1.5;
                        } else{
                            MainWindow.playerHp -= 25;
                        }
                        MainWindow.topBarLabel1a.setText(MainWindow.playerHp + "HP");
                        MainWindow.topBarLabel1b.setText("STR: " + MainWindow.playerPower);
                        MainWindow.topBarLabel2.setText("Computer HP: " + MainWindow.computerHp);
                    }
                }

                IsGameOver.IsGameOverMethod();

                MainWindow.actualTime1 = System.nanoTime();
            }

        }

    }

}