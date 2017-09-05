package com.clibchina.data.view;

import com.clibchina.data.component.ClibBtn;
import com.clibchina.data.component.ClibGraphPanel;
import com.clibchina.data.data.GraphData;
import com.sun.tools.javac.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

/**
 * Created by changlifeng on 2017/9/5.
 */
public class MainFrame extends JFrame implements MouseListener, KeyListener, MouseMotionListener{

    private int logLine = 0;

    private ClibBtn refreshBtn = new ClibBtn("refresh");
    private ClibBtn exitBtn = new ClibBtn("exit");
    private JPanel mainPanel = new JPanel();
    private JPanel logPanel = new JPanel();
    private JScrollPane logScrollPanel = new JScrollPane();
    private JTextArea logArea = new JTextArea();
    private JPanel ctrlPanel = new JPanel();
    private JPanel showPanel = new JPanel();
    private JPanel funcPanel = new JPanel();
    private JTextField commandField = new JTextField();
    private ClibBtn goBtn = new ClibBtn("GO!");
    private JPanel msgPanel = new JPanel();
    private ClibGraphPanel graphPanel = new ClibGraphPanel();
    private JLabel msgLabel = new JLabel();
    private ClibBtn showGridBtn = new ClibBtn("show grid");
    private ClibBtn saveDataBtn = new ClibBtn("save data");
    private ClibBtn loadDataBtn = new ClibBtn("load data");
    private ClibBtn printDataBtn = new ClibBtn("print data");
    private ClibBtn settingsBtn = new ClibBtn("settings");

    public MainFrame() {
        initMainFrame();
    }

    public void initMainFrame() {
        //窗口定义
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Data Science Test Client");
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        this.setLocation(0, 0);
        this.setUndecorated(false);
        this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(BorderLayout.CENTER, mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.BLACK);
        //组件定义
        refreshBtn.setSize((int) (screenSize.getWidth() * 0.1) - 20, 30);
        refreshBtn.setLocation(10, 10);
        mainPanel.add(refreshBtn);

        showGridBtn.setSize((int) (screenSize.getWidth() * 0.1) - 20, 30);
        showGridBtn.setLocation(10, 50);
        mainPanel.add(showGridBtn);


        logPanel.setSize((int) (screenSize.getWidth() * 0.2), (int) screenSize.getHeight());
        logPanel.setLocation((int) (screenSize.getWidth() * 0.8), 0);
        logPanel.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        logPanel.setLayout(new BorderLayout());
        logPanel.setBackground(Color.BLACK);
        mainPanel.add(logPanel);

        logScrollPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        logPanel.add(logScrollPanel);

        logArea.setBackground(Color.BLACK);
        logArea.setForeground(new Color(39, 139, 34));
        logArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        logArea.setFont(new Font("宋体", Font.BOLD, 14));
        logArea.setEditable(false);
        logScrollPanel.getViewport().add(logArea);

        ctrlPanel.setSize((int) (screenSize.getWidth() * 0.8), (int) (screenSize.getHeight() * 0.25));
        ctrlPanel.setLocation(0, (int) (screenSize.getHeight() * 0.75));
        ctrlPanel.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        ctrlPanel.setBackground(Color.BLACK);
        ctrlPanel.setLayout(null);
        mainPanel.add(ctrlPanel);

        showPanel.setSize((int) (screenSize.getWidth() * 0.7), (int) (screenSize.getHeight() * 0.75));
        showPanel.setLocation((int) (screenSize.getWidth() * 0.1), 0);
        showPanel.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        showPanel.setBackground(Color.BLACK);
        showPanel.setLayout(null);
        mainPanel.add(showPanel);

        funcPanel.setSize((int) (screenSize.getWidth() * 0.1), (int) (screenSize.getHeight() * 0.75));
        funcPanel.setLocation(0, 0);
        funcPanel.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        funcPanel.setBackground(Color.BLACK);
        mainPanel.add(funcPanel);

        commandField.setSize((int) (screenSize.getWidth() * 0.6), 40);
        commandField.setLocation((int) (screenSize.getWidth() * 0.11), 15);
        commandField.setBackground(Color.BLACK);
        commandField.setForeground(new Color(39, 139, 34));
        commandField.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        commandField.setFont(new Font("宋体", Font.BOLD, 16));
        commandField.setCaretColor(Color.WHITE);
        ctrlPanel.add(commandField);

        goBtn.setSize(100, 40);
        goBtn.setLocation((int) (screenSize.getWidth() * 0.71) + 10, 15);
        goBtn.setFont(new Font("宋体", Font.BOLD, 16));
        ctrlPanel.add(goBtn);

        exitBtn.setSize((int) (screenSize.getWidth() * 0.1) - 20, 30);
        exitBtn.setLocation(10, ctrlPanel.getHeight() - exitBtn.getHeight() - 10);
        ctrlPanel.add(exitBtn);

        saveDataBtn.setSize((int) (screenSize.getWidth() * 0.1) - 20, 30);
        saveDataBtn.setLocation(10, 10);
        ctrlPanel.add(saveDataBtn);

        loadDataBtn.setSize((int) (screenSize.getWidth() * 0.1) - 20, 30);
        loadDataBtn.setLocation(10, 50);
        ctrlPanel.add(loadDataBtn);

        printDataBtn.setSize((int) (screenSize.getWidth() * 0.1) - 20, 30);
        printDataBtn.setLocation(10, 90);
        ctrlPanel.add(printDataBtn);

        settingsBtn.setSize((int) (screenSize.getWidth() * 0.1) - 20, 30);
        settingsBtn.setLocation(10, 130);
        ctrlPanel.add(settingsBtn);

        msgPanel.setSize((int) (screenSize.getWidth() * 0.7), (int) (screenSize.getHeight() * 0.1));
        msgPanel.setLocation(0, 0);
        msgPanel.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        msgPanel.setBackground(Color.BLACK);
        msgPanel.setLayout(null);
        showPanel.add(msgPanel);

        msgLabel.setOpaque(true);
        msgLabel.setSize((int) (screenSize.getWidth() * 0.7), (int) (screenSize.getHeight() * 0.1));
        msgLabel.setLocation(0, 0);
        msgLabel.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        msgLabel.setBackground(Color.BLACK);
        msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        msgLabel.setFont(new Font("宋体", Font.BOLD, 16));
        msgLabel.setBackground(Color.BLACK);
        msgLabel.setForeground(new Color(39, 139, 34));
        showPanel.add(msgLabel);

        graphPanel.setSize((int) (screenSize.getWidth() * 0.7), (int) (screenSize.getHeight() * 0.65));
        graphPanel.setLocation(0, (int) (screenSize.getHeight() * 0.1));
        graphPanel.setBorder(BorderFactory.createLineBorder(new Color(39, 139, 34)));
        graphPanel.setBackground(Color.BLACK);
        graphPanel.setOriginX(20);
        graphPanel.setOriginY((int) (screenSize.getHeight() * 0.65) - 20);
        showPanel.add(graphPanel);

        //时间绑定部分
        refreshBtn.addMouseListener(this);
        exitBtn.addMouseListener(this);
        commandField.addKeyListener(this);
        goBtn.addMouseListener(this);
        graphPanel.addMouseListener(this);
        graphPanel.addMouseMotionListener(this);
        showGridBtn.addMouseListener(this);

        //呈现部分
        this.setVisible(true);
    }

    private void sendCommand() {
        if ("".equals(commandField.getText())) {
            return;
        }
        log(commandField.getText());
        if ("exit".equals(commandField.getText())) {
            exit();
        } else if ("show point".equals(commandField.getText())) {
            showPoint();
        } else if ("clear log".equals(commandField.getText())) {
            this.logArea.setText("");
            logLine = 0;
        } else if (commandField.getText().indexOf("remove point ") > -1) {
            try {
                String temp = commandField.getText().split("remove point ")[1];
                temp = temp.trim();
                int pointIndex = Integer.valueOf(temp);
                log("remove point index : " + pointIndex);
                GraphData.removePointMap(pointIndex);
                log("remove finished!");
            } catch (Exception e) {
                log("input msg error~!");
            }
        } else if ("remove all point".equals(commandField.getText())) {
            GraphData.removeAllPointMap();
        }
        commandField.setText("");
    }

    private void graphPanelMouseMoveEvent(int x, int y) {
        if (x < this.graphPanel.getOriginX() || y > this.graphPanel.getOriginY()) {
            msg("(-,-)");
            return;
        }
        int tempX = x - this.graphPanel.getOriginX();
        int tempY = this.graphPanel.getOriginY() - y;
        msg("(X:" + tempX + ", Y:" + tempY + ")");
    }

    private void savePoint(int x, int y) {
        if (x < this.graphPanel.getOriginX() || y > this.graphPanel.getOriginY()) {
            return;
        }
        int tempX = x - this.graphPanel.getOriginX();
        int tempY = this.graphPanel.getOriginY() - y;
        log("save point : (" + tempX + ", " + tempY + ")");
        GraphData.putPointMap(Pair.of(tempX, tempY));
    }

    private void showPoint() {
        Map<Integer, Pair<Integer, Integer>> pointMap = GraphData.getPointMap();
        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : pointMap.entrySet()) {
            log(entry.getKey() + " : (" + entry.getValue().fst + "," + entry.getValue().snd + ")");
        }
    }

    public void log(String context) {
        if (logLine == 51) {
            this.logArea.setText("");
            logLine = 0;
        }
        this.logArea.append(context);
        this.logArea.append("\n");
        logLine ++;
    }

    public void msg(String context) {
        this.msgLabel.setText(context);
    }

    private void exit() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                    log("Bye~!");
                    Thread.sleep(500);
                    System.exit(0);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == exitBtn) {
            exit();
        } else if (e.getSource() == goBtn) {
            sendCommand();
        }
    }

    public void mousePressed(MouseEvent e) {
        if (e.getSource() == graphPanel) {
            savePoint(e.getX(), e.getY());
        } else if (e.getSource() == showGridBtn) {
            if (this.graphPanel.isShowGrid()){
                this.graphPanel.setShowGrid(false);
            } else {
                this.graphPanel.setShowGrid(true);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == graphPanel) {
            graphPanelMouseMoveEvent(e.getX(), e.getY());
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == graphPanel) {
            msg("");
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getSource() == commandField) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                sendCommand();
                return;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        if (e.getSource() == graphPanel) {
            graphPanelMouseMoveEvent(e.getX(), e.getY());
        }
    }
}
