package com.clibchina.data.component;

import com.clibchina.data.data.GraphData;
import com.sun.tools.javac.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created by changlifeng on 2017/9/6.
 */
public class ClibGraphPanel extends JPanel {

    private int originX = 0;
    private int originY = 0;
    private boolean showGrid = false;

    private Thread thread;

    public ClibGraphPanel() {
        thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    whileRefresh();
                }
            }
        });
        thread.start();
    }

    public ClibGraphPanel(int x, int y) {
        this.originX = x;
        this.originY = y;
        thread = new Thread(new Runnable() {
            public void run() {
                whileRefresh();
            }
        });
        thread.start();
    }

    private void whileRefresh() {
        while(true) {
            display();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void display() {
        //重绘JPanel
        this.repaint();
    }

    /**
     * repaint方法会调用paint方法，并自动获得Graphics对像
     * 然后可以用该对像进行2D画图
     * 注：该方法是重写了JPanel的paint方法
     */
    public void paint(Graphics g) {
        //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.GRAY);
        g2d.drawLine(originX, originY, originX, 20);
        g2d.drawLine(originX, originY, this.getWidth() - 20, originY);

        g2d.drawLine(originX, 20, originX + 10, 30);
        g2d.drawLine(originX, 20, originX - 10, 30);
        g2d.drawLine(this.getWidth() - 20, originY, this.getWidth() - 30, originY - 10);
        g2d.drawLine(this.getWidth() - 20, originY, this.getWidth() - 30, originY + 10);

        g2d.setColor(Color.DARK_GRAY);
        if (showGrid) {
            int tempX = 50;
            while (tempX < this.getWidth() - 30) {
                g2d.drawLine(this.originX + tempX, this.originY, this.originX + tempX, 30);
                tempX += 50;
            }

            int tempY = this.originY - 50;
            while (tempY > 30) {
                g2d.drawLine(this.originX, tempY, this.getWidth() - 30, tempY);
                tempY -= 50;
            }
        }

        g2d.setColor(new Color(39, 139, 34));
        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : GraphData.getPointMap().entrySet()) {
            g2d.drawLine(this.originX + entry.getValue().fst - 5, this.originY - entry.getValue().snd, this.originX + entry.getValue().fst + 5, this.originY - entry.getValue().snd);
            g2d.drawLine(this.originX + entry.getValue().fst, this.originY - entry.getValue().snd - 5, this.originX + entry.getValue().fst, this.originY - entry.getValue().snd + 5);
        }

//        g2d.fill3DRect(10, 10, 100, 100, true);//填充一个矩形
    }

    public int getOriginY() {
        return originY;
    }

    public void setOriginY(int originY) {
        this.originY = originY;
    }

    public int getOriginX() {
        return originX;
    }

    public void setOriginX(int originX) {
        this.originX = originX;
    }

    public boolean isShowGrid() {
        return showGrid;
    }

    public void setShowGrid(boolean showGrid) {
        this.showGrid = showGrid;
    }
}
