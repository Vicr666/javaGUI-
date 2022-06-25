package com.Handler;

import com.MainForm;
import com.View.MainView.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {

    private MainForm mf;

    public LoginHandler(MainForm mf) {
        this.mf = mf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("重置".equals(text)) {
            mf.getUserTxt().setText("");
            mf.getPwdField().setText("");

        }else if ("登录".equals(text)) {
            String user = mf.getUserTxt().getText();
            char[] chars= mf.getPwdField().getPassword();
            String pwd = new String(chars);
            System.out.println("user:" + user + "\npassword:" + pwd);
            boolean flag = true;
            if(flag) {
                MainView mainview = new MainView();
                mainview.update(mainview);
                mf.dispose();
            }else {
                JOptionPane.showMessageDialog(mf, "用户名密码错误");
            }

        }
    }

}
