/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.guipractice;

import com.mycompany.guipractice.gui.mainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author amalda
 */
public class GuiPractice {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        mainFrame main = new mainFrame();
        main.setVisible(true);
    }
}
