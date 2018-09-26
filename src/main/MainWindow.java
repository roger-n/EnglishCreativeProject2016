package main;        						//NOTE X AND Y COORDINATES ARE FLIPPED FOR GRIDDING
import javax.swing.*;						//800+ lines of code
import java.util.Random;					//10+ hours
import java.awt.*;							//3 Threads
import java.awt.event.*;					//35 KB JAR File
//30 MB Project Size
@SuppressWarnings("unused")					//Eclipse Luna
public class MainWindow extends JFrame implements KeyListener{
    MainWindowEvent event = new MainWindowEvent(this);

    static long startTime = System.nanoTime();
    static long endTime = System.nanoTime();
    static long time;

    static int playerHp = 100;
    static int playerPower = 4;
    static int computerHp = 400;

    static JLabel topBarLabel1a;
    static JLabel topBarLabel1b;
    static JLabel topBarLabel2;

    static JButton fire;
    static JButton left;
    static JButton right;

    static JLabel[][] gameGrid;

    static ImageIcon player;
    static ImageIcon computer1;
    static ImageIcon computer2;

    static int xCoorPlayer = 5;
    static int xCoorComputer1 = 4;
    static int xCoorComputer2 = 5;

    static long playerTime1 = System.nanoTime();
    static long playerTime2 = System.nanoTime();
    static long playerTime = System.nanoTime();

    static long actualTime1 = System.nanoTime();
    static long actualTime2 = System.nanoTime();
    static long actualTime = System.nanoTime();


    static int[] yourShotCoorsX;
    static int[] yourShotCoorsY;
    static int yourShotCounter = 0;

    static int[] theirShotCoorsX;
    static int[] theirShotCoorsY;
    static int[] theirShotType;
    static String[] shotTypes;
    static int shotTypeRandom;

    static int theirShotCounter = 0;
    static int doTheyShoot;

    static int computerLeftOrRight = 0;
    static Random randomGenerator = new Random();

    static boolean gameGoing = true;
    static boolean youFired = false;

    //static int[] heartCanisterCoorsX;
    //static int[] heartCanisterCoorsY;

    //static int[] powerCanisterCoorsX;
    //static int[] powerCanisterCoorsY;

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public MainWindow() {

        super("What's Your Demon?");
        setSize(355,500);
        setResizable(false);

        player = new ImageIcon(getClass().getResource("/res/Images/SpitfirePlayer.png"));
        computer1 = new ImageIcon(getClass().getResource("/res/Images/B17Computer1.png"));
        computer2 = new ImageIcon(getClass().getResource("/res/Images/B17Computer2.png"));

        ImageIcon img = new ImageIcon(getClass().getResource("/Images/YinYang.png"));
        this.setIconImage(img.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel background = new JPanel();
        setLayout(new BorderLayout());

        BorderLayout layout = new BorderLayout();
        background.setLayout(layout);

        GridLayout topBarLayout = new GridLayout(1, 2);
        GridLayout topBarLayout1 = new GridLayout(1, 2);
        GridLayout topBarLayout1a = new GridLayout(1, 1);
        GridLayout topBarLayout1b = new GridLayout(1, 1);
        GridLayout topBarLayout2 = new GridLayout(1, 1);

        GridLayout gameLayout = new GridLayout(10, 10);

        GridLayout buttonsLayout = new GridLayout(2, 1);
        GridLayout buttonsLayout1 = new GridLayout(1, 1);
        GridLayout buttonsLayout2 = new GridLayout(1, 2);
        GridLayout buttonsLayout2a = new GridLayout(1, 1);
        GridLayout buttonsLayout2b = new GridLayout(1, 1);


        JPanel topBar = new JPanel();
        JButton topBar1 = new JButton();
        topBar1.setEnabled(false);
        JButton topBar1a = new JButton();
        topBar1a.setEnabled(false);
        JButton topBar1b = new JButton();
        topBar1b.setEnabled(false);
        JButton topBar2 = new JButton();
        topBar2.setEnabled(false);
        topBarLabel1a = new JLabel(playerHp + "HP");
        topBarLabel1a.setFont(new Font("", Font.BOLD, 9));
        topBarLabel1b = new JLabel("STR: " + playerPower);
        topBarLabel1b.setFont(new Font("", Font.BOLD, 8));
        topBarLabel2 = new JLabel("Computer HP: " + computerHp);

        JPanel game = new JPanel();
        gameGrid = new JLabel[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++){
                gameGrid[i][j] = new JLabel();
            }
        }

        yourShotCoorsX = new int[10];
        yourShotCoorsY = new int[10];
        theirShotCoorsX = new int[10];
        theirShotCoorsY = new int[10];
        theirShotType = new int[10];


        for(int i = 0; i < 10; i++){
            yourShotCoorsX[i] = 0;
            yourShotCoorsY[i] = 0;
            theirShotCoorsX[i] = 0;
            theirShotCoorsY[i] = 0;
            theirShotType[i] = 0;

        }

        shotTypes = new String[16];
        shotTypes[0] = "   <+>";
        shotTypes[1] = "   <!>";
        for(int i = 2; i < 16; i++){
            shotTypes[i] = "    |    ";
        }

        gameGrid[9][xCoorPlayer].setIcon(player);
        gameGrid[0][xCoorComputer1].setIcon(computer1);
        gameGrid[0][xCoorComputer2].setIcon(computer2);

        JPanel buttons = new JPanel();
        JPanel buttons1 = new JPanel();
        JPanel buttons2 = new JPanel();
        JPanel buttons2a = new JPanel();
        JPanel buttons2b = new JPanel();


        fire = new JButton("Fire");
        left = new JButton("<");
        right = new JButton(">");
        fire.addKeyListener(this);
        left.addKeyListener(this);
        right.addKeyListener(this);


        fire.addActionListener(event);
        left.addActionListener(event);
        right.addActionListener(event);


        topBar.setLayout(topBarLayout);
        topBar1.setLayout(topBarLayout1);
        topBar1a.setLayout(topBarLayout1a);
        topBar1a.add(topBarLabel1a);
        topBar1b.setLayout(topBarLayout1b);
        topBar1b.add(topBarLabel1b);
        topBar1.add(topBar1a);
        topBar1.add(topBar1b);

        topBar2.setLayout(topBarLayout2);
        topBar2.add(topBarLabel2);
        topBar.add(topBar1);
        topBar.add(topBar2);

        game.setLayout(gameLayout);
        for (int q = 0; q < 10; q++){
            for (int w = 0; w < 10; w++){
                game.add(gameGrid[q][w]);
            }
        }

        buttons.setLayout(buttonsLayout);
        buttons1.setLayout(buttonsLayout1);
        buttons1.add(fire);
        buttons2.setLayout(buttonsLayout2);
        buttons2a.setLayout(buttonsLayout2a);
        buttons2a.add(left);
        buttons2b.setLayout(buttonsLayout2b);
        buttons2b.add(right);
        buttons2.add(buttons2a);
        buttons2.add(buttons2b);
        buttons.add(buttons1);
        buttons.add(buttons2);

        background.add(topBar, BorderLayout.NORTH);
        background.add(game, BorderLayout.CENTER);
        background.add(buttons, BorderLayout.SOUTH);

        add(background);

        setVisible(true);
        new Thread(new ComputerThread()).start();

    }

    public void keyPressed(KeyEvent input) {
        char key = input.getKeyChar();
        if (key == ','){
            gameGrid[9][xCoorPlayer].setIcon(null);
            xCoorPlayer -=1;
            if (xCoorPlayer < 0){
                xCoorPlayer = 0;
            } else if (xCoorPlayer > 9){
                xCoorPlayer = 9;
            }
            gameGrid[9][xCoorPlayer].setIcon(player);
        }
        if (key == '.'){
            gameGrid[9][xCoorPlayer].setIcon(null);
            xCoorPlayer ++;
            if (xCoorPlayer < 0){
                xCoorPlayer = 0;
            } else if (xCoorPlayer > 9){
                xCoorPlayer = 9;
            }
            gameGrid[9][xCoorPlayer].setIcon(player);

        }
        if (key == 'z'){

            playerTime2 = System.nanoTime();
            playerTime = playerTime2 - playerTime1;
            if (playerTime > 300000000){
                youFired = true;

                playerTime1 = System.nanoTime();
            }
        }

    }

    public void keyReleased(KeyEvent txt) {
        //Do Nothing

    }
    public void keyTyped(KeyEvent txt) {
        //Do Nothing

    }



    public static void main (String[] arguments){
        MainWindow window = new MainWindow();

    }

}