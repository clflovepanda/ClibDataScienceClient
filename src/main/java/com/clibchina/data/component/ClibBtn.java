package com.clibchina.data.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by changlifeng on 2017/9/5.
 */
public class ClibBtn extends JLabel implements MouseListener{


    public ClibBtn() {
        super();
        init();
    }

    public ClibBtn(String text) {
        super(text);
        init();
    }

    public void init() {
        Font font = new Font("宋体", Font.BOLD, 16);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        this.setBackground(Color.BLACK);
        this.setForeground(new Color(39, 139, 34));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(font);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        this.setBackground(new Color(56, 94, 15));
        this.setForeground(Color.WHITE);
    }

    public void mouseReleased(MouseEvent e) {
        this.setBackground(new Color(39, 139, 34));
        this.setForeground(Color.WHITE);
    }

    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(39, 139, 34));
        this.setForeground(Color.WHITE);
    }

    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.BLACK);
        this.setForeground(new Color(39, 139, 34));
    }
}
