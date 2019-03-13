/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucommusic;
import controller.Manager;
import windows.Login;

/**
 *
 * @author Yuli
 */
public class StucomMusic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login(null, true);
        login.setLocationRelativeTo(null);
        login.setVisible(true);        
    }
}
