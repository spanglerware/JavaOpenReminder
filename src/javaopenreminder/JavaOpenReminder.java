/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaopenreminder;

/**
 *
 * @author Scott
 */
public class JavaOpenReminder {

    /**
     * @param args the command line arguments
     */
    
    //application entry point
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame2().setVisible(true);
            }
        });
    }
}
