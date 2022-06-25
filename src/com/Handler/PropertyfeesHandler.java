package com.Handler;


import com.View.MainView.MainView;
import com.View.PropertyfesManage.Propertyfees;
import com.View.basic_infoManage.UserManage.UserManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyfeesHandler implements ActionListener {
    private MainView mv;

    public PropertyfeesHandler(MainView mv) {
        this.mv = mv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem jMenuItem = (JMenuItem) e.getSource();
        if("收缴管理".equals(jMenuItem.getText())) {
            try {
                new Propertyfees();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

}
