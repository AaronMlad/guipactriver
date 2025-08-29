/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guipractice.gui.panels;

import com.mycompany.guipractice.gui.components.SidebarFactory;
import com.mycompany.guipractice.gui.panels.landingpanels.Dashboard;
import com.mycompany.guipractice.gui.panels.landingpanels.Profile;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author amalda
 */
public class Landing extends JPanel{
    private CardLayout cardLayout;
    private JPanel contentPanel;
    public Landing() {
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        initializePanel();
    }
    
    private void initializePanel() {
        this.setLayout(new BorderLayout());
        
        contentPanel.add(new Dashboard(), "DASHBOARD");
        contentPanel.add(new Profile(), "PROFILE");
        this.add(contentPanel, BorderLayout.CENTER);
        
        JPanel sidebar = SidebarFactory.createNavigationSidebar(250, this::handleSidebarEvent);
        this.add(sidebar, BorderLayout.WEST);
        
        handleSidebarEvent("DASHBOARD");
    }
    
    private void handleSidebarEvent(String text) {
        System.out.println("Clicked: " + text);
        switch(text) {
            case "DASHBOARD":
                cardLayout.show(contentPanel, "DASHBOARD");
                break;
            case "PROFILE":
                cardLayout.show(contentPanel, "PROFILE");
                break;
            default:
                System.out.println("GOOEY");
        }
    }
}
