package main;
import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("unused")
public class MainWindowEvent implements ActionListener, Runnable{
    MainWindow gui;
    Thread playing;
    public MainWindowEvent (MainWindow in){
        gui = in;
    }

    public void actionPerformed(ActionEvent event){
        String buttonClicked = event.getActionCommand();

        MainWindow.actualTime1 = System.nanoTime();
        if (buttonClicked.equalsIgnoreCase("Fire")){

            MainWindow.playerTime2 = System.nanoTime();
            MainWindow.playerTime = MainWindow.playerTime2 - MainWindow.playerTime1;
            if (MainWindow.playerTime > 200000000){
                if (buttonClicked.equalsIgnoreCase("Fire")){
                    MainWindow.youFired = true;



                }
                MainWindow.playerTime1 = System.nanoTime();
            }
        }

        if (buttonClicked.equalsIgnoreCase("<")){
            MainWindow.gameGrid[9][MainWindow.xCoorPlayer].setIcon(null);
            MainWindow.xCoorPlayer -=1;
            if (MainWindow.xCoorPlayer < 0){
                MainWindow.xCoorPlayer = 0;
            } else if (MainWindow.xCoorPlayer > 9){
                MainWindow.xCoorPlayer = 9;
            }
            MainWindow.gameGrid[9][MainWindow.xCoorPlayer].setIcon(MainWindow.player);
        }
        if (buttonClicked.equalsIgnoreCase(">")){
            MainWindow.gameGrid[9][MainWindow.xCoorPlayer].setIcon(null);
            MainWindow.xCoorPlayer ++;
            if (MainWindow.xCoorPlayer < 0){
                MainWindow.xCoorPlayer = 0;
            } else if (MainWindow.xCoorPlayer > 9){
                MainWindow.xCoorPlayer = 9;
            }
            MainWindow.gameGrid[9][MainWindow.xCoorPlayer].setIcon(MainWindow.player);

        }

    }

    public void run() {
        Thread thisThread = Thread.currentThread();
    }


}