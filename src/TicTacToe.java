import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
   // JFrame: The main window of a Java Swing application.
   // JPanel: A container for organizing and grouping other components.
    //     JLabel: A component for displaying text or images.
    // TEXT FEILD : A text box component that can be used to add ,set,get text
    //setBackground: Changes the background color of a component.
    //setForeground: Changes the text (foreground) color of a component.
    //the arrangement of components inside a container called Layout
   // we have nullLayout ,BorderLayout ,Flow Layout, Grid Layout ,GardBag Layout,Card Layout ,Group Layout,Box Layout
    // a border components in five area : NORTH,SOUTH,WEST,EAST,CENTER
    //GridLayout(int rows, int cols): Creates a grid layout with the specified number of rows and columns.



     Random r=new Random();
     JFrame frame=new JFrame();
         JPanel Panel=new JPanel();
            JPanel Buttonpanel =new JPanel();
          JLabel textfeild=new JLabel();
        JButton[]buttons=new JButton[9];
        boolean palyturn;


       public TicTacToe(){
           frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
             frame.setSize(800,800);
           frame.getContentPane().setBackground(new Color(50,50,50));
           frame.setLayout(new BorderLayout());
           frame.setVisible(true);


           textfeild.setBackground(new Color(25,25,25));
               textfeild.setForeground(Color.orange);
                    textfeild.setFont(new Font("Ink Free",Font.PLAIN,75));
                  textfeild.setHorizontalAlignment(textfeild.CENTER);
                textfeild.setText("Tic-Tac-Toe");
            textfeild.setOpaque(true);

            Panel.setLayout(new BorderLayout());
            Panel.setBounds(0,0,800,100);

           Buttonpanel.setLayout(new GridLayout(3,3));
                  Buttonpanel.setBackground(new Color(150,150,150));

                  for(int i=0;i<9;i++){
                      buttons[i]=new JButton(); // every loop will creat a Button
                      Buttonpanel.add(buttons[i]); // then add it to panel
                      buttons[i].setFont(new Font("MV BoLi",Font.BOLD,120));
                      buttons[i].setFocusable(false);
                      buttons[i].addActionListener(this);
                  }

            Panel.add(textfeild);
            frame.add(Panel,BorderLayout.NORTH);
            frame.add(Buttonpanel);


            firstTurn();



       }
       @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getText().equals("")) {
                if (palyturn) {
                    buttons[i].setForeground(Color.RED);
                    buttons[i].setText("X");
                    palyturn = false;
                    textfeild.setText("O Turn");
                } else {
                    buttons[i].setForeground(Color.GREEN);
                    buttons[i].setText("O");
                    palyturn = true;
                  textfeild.setText("X Turn");
                }
              Check();
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(r.nextInt(2)==0) {
            palyturn=true;
            textfeild.setText("X turn");
        }
        else {
            palyturn=false;
            textfeild.setText("O turn");
        }
    }
    public void Check(){
           // check the rows
           if((buttons[0].getText()=="X") &&((buttons[1].getText() == "X"))&&(buttons[2].getText()=="X")){
             Xwins(0,1,2);
           }
         if((buttons[3].getText()=="X") &&((buttons[4].getText()=="X"))&&(buttons[5].getText()=="X")){
            Xwins(3,4,5);
        }
        if((buttons[6].getText()=="X") &&((buttons[7].getText()=="X"))&&(buttons[8].getText()=="X")){
           Xwins(6,7,8);
        }
       //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // the col
       if((buttons[0].getText()=="X") &&((buttons[3].getText()=="X"))&&(buttons[6].getText()=="X")){
            Xwins(0,3,6);
        }
        if((buttons[1].getText()=="X") &&((buttons[4].getText()=="X"))&&(buttons[7].getText()=="X")){
            Xwins(1,4,7);
        }
         if((buttons[2].getText()=="X") &&((buttons[5].getText()=="X"))&&(buttons[8].getText()=="X")){
            Xwins(2,5,8);
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if((buttons[0].getText()=="X") &&((buttons[4].getText()=="X"))&&(buttons[8].getText()=="X")){
            Xwins(0,4,8);
        }
        if((buttons[2].getText()=="X") &&((buttons[4].getText()=="X"))&&(buttons[6].getText()=="X")){
            Xwins(2,4,6);
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //=====================================================================================================
        // check the o

        if((buttons[0].getText()=="O") &&((buttons[1].getText()=="O"))&&(buttons[2].getText()=="O")){
            Xwins(0,1,2);
        }
         if((buttons[3].getText()=="O") &&((buttons[4].getText()=="O"))&&(buttons[5].getText()=="O")){
            Xwins(3,4,5);
        }
       if((buttons[6].getText()=="O") &&((buttons[7].getText()=="O"))&&(buttons[8].getText()=="O")){
            Xwins(6,7,8);
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // the col
         if((buttons[0].getText()=="O") &&((buttons[3].getText()=="O"))&&(buttons[6].getText()=="O")){
            Xwins(0,3,6);
        }
       if((buttons[1].getText()=="O") &&((buttons[4].getText()=="O"))&&(buttons[7].getText()=="O")){
            Xwins(1,4,7);
        }
         if((buttons[2].getText()=="O") &&((buttons[5].getText()=="O"))&&(buttons[8].getText()=="O")){
            Xwins(2,5,8);
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if((buttons[0].getText()=="O") &&((buttons[4].getText()=="O"))&&(buttons[8].getText()=="O")){
            Xwins(0,4,8);
        }
         if((buttons[2].getText()=="O") &&((buttons[4].getText()=="O"))&&(buttons[6].getText()=="O")){
            Xwins(2,4,6);
        }
        try {
            noonewins();
        } catch (nowinner e) {
            textfeild.setText("no one wins ");
        }



    }

    public void Xwins(int a,int b,int c){
       buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfeild.setText("X wins ");
    }
    public void Owins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfeild.setText("O wins ");
    }
    public void noonewins() throws nowinner {
        boolean boardFull = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().isEmpty()) {
                boardFull = false;
                break;
            }
        }
        if (boardFull) {
            throw new nowinner();
        }
    }





}
