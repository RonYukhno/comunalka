package communalochka;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    public static double sumOfAll;
    public static JTabbedPane tabs;
       
    public MainFrame() {
        final JFrame frame = new JFrame("Коммуналочка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Создаем меню-бар */
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
            
            JMenuItem newMenu = new JMenuItem("New");
            file.add(newMenu);
            
            JMenuItem openMenu = new JMenuItem("Open");
            file.add(openMenu);
            
            
            JMenuItem saveMenu = new JMenuItem("Save");
            file.add(saveMenu);
            
            
            file.addSeparator();
            
            JMenuItem tariffMenu = new JMenuItem("Tariff");
            file.add(tariffMenu);
            tariffMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new TariffFrame().show();
                }   
            });
            
            file.addSeparator();
            
            JMenuItem closeMenu = new JMenuItem("Close");
            file.add(closeMenu);
            closeMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                } 
            });
            
        JMenuItem addTab = new JMenuItem("New tab");
        JMenuItem delTab = new JMenuItem("Delete tab");
                           
        menuBar.add(file);
        frame.setJMenuBar(menuBar);
        
        /* Создаем панель вкладок */
        tabs = new JTabbedPane();
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
                           
        /* добавление новой вкладки */
        addTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddNewTabDialog(frame, false).show();
            }
        });
        menuBar.add(addTab);
        
        /* удаление новой вкладки */
        delTab.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               int select = tabs.getSelectedIndex();
               if (select >= 0) {
                   tabs.removeTabAt(select);
               }
           } 
        });
        menuBar.add(delTab);
        
        /* Выводим общую сумму */
        JLabel sumLabel = new JLabel("Sum: " + sumOfAll);  // sumOfAll - общая сумма со всех вкладок
        menuBar.add(sumLabel);
        
        new NewTabPanel("Electricity");
                        
        content.add(tabs, BorderLayout.CENTER);
                       
        frame.getContentPane().add(content);
        
        frame.setPreferredSize(new Dimension(350, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
                
    }
}
