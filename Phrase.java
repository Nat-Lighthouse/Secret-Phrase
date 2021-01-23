   /*
      Created By: Jonathan F. gubot
      Created On: January 22, 2021
   */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Phrase extends JPanel implements ActionListener
{  
   private Font title = new Font("Verdana", Font.BOLD, 30);
   private Font sub = new Font("Arial", Font.ITALIC, 18);
   private Font note = new Font("Calibri", Font.BOLD, 15);
   private Font guess = new Font("Tahoma", Font.BOLD, 40);
   
   private String[] buttonNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                                 "U", "V", "W", "X", "Y", "Z"};
   private JButton[] key = new JButton[26];
   private boolean checkA = false, checkB = false, checkC = false, checkD = false, checkE = false, 
                   checkF = false, checkG = false, checkH = false, checkI = false;
   private int score = 0;
   private byte mistake = 0;
   
   public Phrase()
   {
      setLayout(null);
      setBackground(Color.BLACK);
      buttons();
   }
   
   public void buttons()
   {
      int left = 20, leftB = 12, leftC = 125;
      for(byte i = 0; i<key.length; i++)
      {
         key[i] = new JButton(buttonNames[i]);
         add(key[i]);
         key[i].addActionListener(this);
         if(i < 10)
         {
            
            key[i].setBounds(left, 260, 50, 50);
            left += 55;
         }
         else if(i >= 10 && i<20)
         {
            key[i].setBounds(leftB, 315, 50, 50);
            leftB += 57;
         }
         else
         {
            key[i].setBounds(leftC, 370, 50, 50);
            leftC += 57;
         }
      }
   }
   
   @Override   //Optional
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.setFont(title);
      if(score == 9)
      {
         g.setColor(Color.WHITE);
      }
      g.drawString("Secret Phrase Game", 120, 40);
      g.setFont(sub);
      g.drawString("Guess the phrase by pressing Keys", 145, 70);
      g.setFont(note);
      g.drawString("Note: You only have 3 limits of mistakes", 30, 450);
      g.drawString("Mistake/s:", 480, 450);
      g.drawString(" " + mistake, 550, 450);
      
      //Phrase to guess
      //45 x-cord gap
      if(score == 9)
      {
         g.setColor(Color.RED);
         g.fillRect(40, 150, 500, 75);
         g.clearRect(65, 160, 450, 50);
      }
      g.setFont(guess);
      g.setColor(Color.RED);
      /*_____________________________*/
      if(checkA == true)
      {
         g.drawString("L", 75, 200);
      }
      else
      {
         g.drawString("*", 75, 200);
      }
      /*_____________________________*/
      if(checkB == true)
      {
         g.drawString("i", 120, 200);
      }
      else
      {
         g.drawString("*", 120, 200);
      }
      /*_____________________________*/
      if(checkC == true)
      {
         g.drawString("g", 165, 200);
      }
      else
      {
         g.drawString("*", 165, 200);
      }
      /*_____________________________*/
      if(checkD == true)
      {
         g.drawString("h", 210, 200);
         g.drawString("h", 300, 200);
      }
      else
      {
         g.drawString("*", 210, 200);
         g.drawString("*", 300, 200);
      }
      /*_____________________________*/
      if(checkE == true)
      {
         g.drawString("t", 255, 200);
      }
      else
      {
         g.drawString("*", 255, 200);
      }
      /*_____________________________*/
      //
      /*_____________________________*/
      if(checkF == true)
      {
         g.drawString("o", 345, 200);
      }
      else
      {
         g.drawString("*", 345, 200);
      }
      /*_____________________________*/
      if(checkG == true)
      {
         g.drawString("u", 390, 200);
      }
      else
      {
         g.drawString("*", 390, 200);
      }
      /*_____________________________*/
      if(checkH == true)
      {
         g.drawString("s", 435, 200);
      }
      else
      {
         g.drawString("*", 435, 200);
      }
      /*_____________________________*/
      if(checkI == true)
      {
         g.drawString("e", 480, 200);
      }
      else
      {
         g.drawString("*", 480, 200);
      }
      /*_____________________________*/
      
      if(mistake == 3)
      {
         restart();   
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      for(byte i = 0; i<key.length; i++)
      {
         if(source == key[11])
         {
            checkA = true;
            repaint();  
            key[11].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[8])
         {
            checkB = true;
            repaint();
            key[8].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[6])
         {
            checkC = true;
            repaint();
            key[6].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[7])
         {
            checkD = true;
            repaint();
            key[7].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[19])
         {
            checkE = true;
            repaint();
            key[19].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[14])
         {
            checkF = true;
            repaint();
            key[14].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[20])
         {
            checkG = true;
            repaint();
            key[20].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[18])
         {
            checkH = true;
            repaint();
            key[18].setEnabled(false);
            score++;
            break;
         }
         else if(source == key[4])
         {
            checkI = true;
            repaint();
            key[4].setEnabled(false);
            score++;
            break;
         }
         else
         {
            mistake++;
            repaint();
            break;
         }
      }  
   }
   
   public void restart()
   {
      checkA = false; checkB = false; checkC = false; checkD = false; checkE = false; 
      checkF = false; checkG = false; checkH = false; checkI = false;
      score = 0;
      mistake = 0;
      
      for(byte i = 0; i<key.length; i++)
      {
         key[i].setEnabled(true);
      }
      repaint();
   }
   
   
   public static void main(String[] args)
   {
      
      Phrase one = new Phrase();
      //Phrase2 two = new Phrase2();
      JFrame frame = new JFrame();
      
   
      frame.add(one);
      /*____________________________*/
         //frame.add(two);
      frame.setSize(600, 500);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}