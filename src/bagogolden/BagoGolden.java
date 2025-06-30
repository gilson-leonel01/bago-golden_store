/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bagogolden;

import bagogolden.views.ConsoleView;
import bagogolden.views.UserView;

/**
 *
 * @author gilso
 */
public class BagoGolden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConsoleView console = new ConsoleView();
        console.start();
        
        UserView uv = new UserView();
        uv.setVisible(true);
    }
}
