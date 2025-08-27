/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guipractice.gui.panels;
import com.mycompany.guipractice.gui.components.buttonCreator;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author amalda
 */
public class Login extends JPanel{
    public Login() {
        setBackground(Color.RED);
        this.add(new buttonCreator("LOGIN"));
        this.add(new buttonCreator("SIGNUP"));
        
    }
}
