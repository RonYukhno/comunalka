/** Создание новой вкладки по шаблонной панели */

package communalochka;

import static communalochka.AddNewTabDialog.nameTab;
import static communalochka.AddTariffFrame.nameOfTheTariff;
import static communalochka.MainFrame.tabs;
import javax.swing.*;
import java.awt.*;

public class NewTabPanel extends JPanel {
    
    public NewTabPanel(String nameTab){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                
        JLabel labelTariff = new JLabel("Current tariff: " + nameOfTheTariff );  // + название тарифа
        
        JLabel labelValuePrev = new JLabel("Previous value: ");
        JTextField valuePrev = new JTextField(15);
        
        JLabel labelValueCurrent = new JLabel("Current value: ");
        JTextField valueCurrent = new JTextField(15);
        
        JButton butConsider = new JButton("Consider");
                
        JLabel inTotal = new JLabel("In total: ");  // + результат вычислений
                        
        JPanel panelTariff = new JPanel();
            panelTariff.add(labelTariff);
                                
        JPanel panelPrev = new JPanel();
            panelPrev.add(labelValuePrev);
            panelPrev.add(valuePrev);
                                            
        JPanel panelCurrent = new JPanel();
            panelCurrent.add(labelValueCurrent);
            panelCurrent.add(valueCurrent);
                     
        mainPanel.add(panelTariff);
        mainPanel.add(panelPrev);
        mainPanel.add(panelCurrent);
        mainPanel.add(inTotal);
        mainPanel.add(butConsider);
        
        tabs.add(nameTab, mainPanel);
    }
    
}
