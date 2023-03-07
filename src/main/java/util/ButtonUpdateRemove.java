/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mayra
 */
public class ButtonUpdateRemove extends DefaultTableCellRenderer{
    
    private String buttonType;

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
public ButtonUpdateRemove(String buttonType) {
        this.buttonType = buttonType;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
            boolean hasFocus, int row, int col) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));

        
        return label;
    }
    }

    
    
    
    
    

