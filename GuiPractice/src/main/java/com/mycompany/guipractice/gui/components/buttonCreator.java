/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guipractice.gui.components;

import com.mycompany.guipractice.gui.mainFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author amalda
 */
public class buttonCreator extends JButton{
    public buttonCreator(String text) {
        setPreferredSize(new Dimension(200, 20));
        setBackground(Color.WHITE);
        setFocusable(false);
        setText(text);
        addActionListener(e -> {
            mainFrame.showCard("LANDING");
        });
    }
}
