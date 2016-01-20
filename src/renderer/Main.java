package renderer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
   private static final String INTRO = "MainMenu";
   private static final String GAME = "game";
   private CardLayout cardlayout = new CardLayout();
   private JPanel mainPanel = new JPanel(cardlayout);
   private IntroPanel introPanel = new IntroPanel();
   private GamePanel gamePanel = new GamePanel();
   
   private JButton back = new JButton("main menu");
   public Main() {
      mainPanel.add(introPanel.getMainComponent(), INTRO);
      mainPanel.add(gamePanel.getMainComponent(), GAME);

      introPanel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cardlayout.show(mainPanel, GAME);
         }
      });

      gamePanel.addBackActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cardlayout.show(mainPanel, INTRO);
         }
      });
   }

   private JComponent getMainComponent() {
      return mainPanel;
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("FALLOUT TNG");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Main().getMainComponent());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
           createAndShowUI();
         }
      });
   }
}

class IntroPanel {
   private JPanel mainPanel = new JPanel();
   private JButton start = new JButton("Start");
   private JButton exit = new JButton("Exit");

   public IntroPanel() {
      mainPanel.setLayout(new FlowLayout());
      start = new JButton("Start");
      start.setBounds(840, 191, 182, 47);
      exit = new JButton("exit");
      exit.setBounds(840, 191, 182, 47);

     
      mainPanel.add(start);
      
      mainPanel.add(exit);

      exit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Window win = SwingUtilities.getWindowAncestor(mainPanel);
            win.dispose();
         }
      });
   }

   public void addActionListener(ActionListener listener) {
     start.addActionListener(listener);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

}

class GamePanel {
   private static final Dimension MAIN_SIZE = new Dimension(700, 525);
   private JPanel mainPanel = new JPanel();
 WorldLayout game = new WorldLayout();
   
   private JButton back;

   public GamePanel() {
     
      back = new JButton("return to main menu");

     
      mainPanel.add(back);
      mainPanel.setPreferredSize(MAIN_SIZE);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void addBackActionListener(ActionListener listener) {
      back.addActionListener(listener);
   }

}


