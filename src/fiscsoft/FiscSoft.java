/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiscsoft;
import DAO.DBConnection;

/**
 *
 * @author Leonardo
 */
public class FiscSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GerarRelatorio gerarRelatorio = new GerarRelatorio();
        gerarRelatorio.setVisible(true);
    }
    
}
