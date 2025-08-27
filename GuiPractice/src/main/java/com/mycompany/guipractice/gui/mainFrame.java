/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guipractice.gui;

import com.mycompany.guipractice.gui.panels.Landing;
import com.mycompany.guipractice.gui.panels.Login;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author amalda
 */
public class mainFrame extends JFrame{
    
    private static CardLayout cardLayout;
    private static JPanel mainPanel;
    
    public mainFrame() {
        initializeFrame();
        setupUI();
    }
    
    private void initializeFrame() {
        this.setTitle("GUI Practice");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(300, 500));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width * 3/4, screenSize.height * 3/4);
        
        
        this.setVisible(true);
    }
    
    private void setupUI() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        mainPanel.add(new Login(), "LOGIN");
        mainPanel.add(new Landing(), "LANDING");
        
        this.setContentPane(mainPanel);
        showCard("LOGIN");
    }
    
    public static void showCard(String text) {
        cardLayout.show(mainPanel, text);
    }
}
