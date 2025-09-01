/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guipractice.gui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author amalda
 */
public class SidebarFactory {
    private static Color DEFAULT_BG = Color.GRAY;
    private static Color HIGHLIGHTED = new Color(200, 200, 200);
    public static JPanel createNavigationSidebar(int width, Consumer<String> onItemClicked) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(DEFAULT_BG);
        panel.setPreferredSize(new Dimension(width, Integer.MAX_VALUE));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1));
        
        
        
        return panel;
    }
    
    public static JPanel createCollapseableSidebar(int expandedWidth, int collapsedWidth, Consumer<String> onItemClicked) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(expandedWidth,Integer.MAX_VALUE));
        panel.setBackground(DEFAULT_BG);
        
        JButton button = new JButton("📁");
        button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        
        addNavigationItem(contentPanel, "DASHBOARD", "(●'◡'●)", onItemClicked);
        addNavigationItem(contentPanel, "PROFILE", "(*/ω＼*)", onItemClicked);
        addNavigationItem(contentPanel, "ABOUT", "(⌐■_■)", onItemClicked);
        addNavigationItem(contentPanel, "SETTINGS", "ヾ(⌐■_■)ノ♪", onItemClicked);
        addNavigationItem(contentPanel, "LOGOUT", "（＾∀＾●）ﾉｼ", onItemClicked);
        
        panel.add(button, BorderLayout.NORTH);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        button.addActionListener(e -> {
           boolean isCollapsed = panel.getWidth() == collapsedWidth;
           int newWidth = isCollapsed ? expandedWidth : collapsedWidth;
           panel.setPreferredSize(new Dimension(newWidth, Integer.MAX_VALUE));
           button.setText(isCollapsed ? "📂" : "📁");
           contentPanel.setVisible(isCollapsed);
           
           panel.revalidate();
           panel.repaint();
        });
        return panel;
    }
    
    private static void addNavigationItem(JPanel panel, String text, String icon, Consumer<String> onItemClicked) {
        JButton button = new JButton(text + " " + icon);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMinimumSize(new Dimension(Integer.MAX_VALUE, 10));
        button.setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button.setHorizontalAlignment(JButton.LEFT); //da text of da button
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setContentAreaFilled(true);
        button.setFocusable(false);
        button.setFocusPainted(false);
        
        
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(HIGHLIGHTED);
                button.setOpaque(true);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(null);
                button.setOpaque(false);
            }
    });
        button.addActionListener(e -> {
            onItemClicked.accept(text.toUpperCase());
        });
        
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
    }
    
}
