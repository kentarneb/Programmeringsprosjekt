/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JDialog;

/**
 *
 * @author Gjerde
 */
public class About extends JDialog {

    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        super.setLocationRelativeTo(parent);
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Vi er fire studenter fra HiST som \nfikk i oppgave å lage dette sjakkspillet.\nDet er lov å modifisere spillet, \nmen vi fraskriver oss alt ansvar.\n\n\nMeet your makers:  \nBjørn Tore Gjerde\nJørgen Dalheim Olsen\nJonas Bo Grimsgaard\nMalin Livoll Schei");
        jTextArea1.setFocusable(false);
       
        add(jTextArea1);
        add(jButton1);
        setLayout(new FlowLayout());
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
}
