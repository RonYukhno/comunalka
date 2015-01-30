package communalochka;

import static communalochka.AddTariffFrame.nameOfTheTariff;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class TariffFrame extends JFrame {
    
    public static DefaultListModel listModel;
    
    public TariffFrame() {
        initComponents();
        setSize(300,200);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    
    

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
 
        listModel = new DefaultListModel();
  
        final JList list = new JList(listModel);
        list.setSelectedIndex(0);
        list.setFocusable(false);
        mainPanel.add(new JScrollPane(list), BorderLayout.CENTER);
 
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 0));
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
 
        JButton addButton = new JButton("Добавить");
        addButton.setFocusable(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddTariffFrame().show();
                int index = listModel.size() - 1;
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        });
        buttonsPanel.add(addButton);
 
        final JButton removeButton = new JButton("Удалить");
        removeButton.setFocusable(false);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel.remove(list.getSelectedIndex());
            }
        });
        buttonsPanel.add(removeButton);
 
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (list.getSelectedIndex() >= 0) {
                    removeButton.setEnabled(true);
                } else {
                    removeButton.setEnabled(false);
                }
            }
        });
 
        getContentPane().add(mainPanel);
    }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TariffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TariffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TariffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TariffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TariffFrame().setVisible(true);
            }
        });
    }
}
