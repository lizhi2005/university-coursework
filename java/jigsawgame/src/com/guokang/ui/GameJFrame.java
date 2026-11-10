package com.guokang.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    int[][] data = new int[4][4];
    //    记录空白方块的位置
    int x = 0;
    int y = 0;
    int step=0;

    int [][] win=new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0}
    };
    JMenuItem replayItem = new JMenuItem("重新开始");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");

    public GameJFrame() {
        //        创建主界面  设置宽高
        initJFrame();
//        初始化数据
        initData();
//        初始化菜单栏
        initJMenuBar();
//        初始化图片
        initImage();

        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();

        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;

            }
                data[i / 4][i % 4] = tempArr[i];


        }

    }

    private void initImage() {
        this.getContentPane().removeAll();
if(victory()){
    JLabel jLabel = new JLabel(new ImageIcon("D:\\Java-project\\jigsawgame\\image\\win.png"));
    jLabel.setBounds(203, 283, 197, 73);
    this.getContentPane().add(jLabel);

}
        JLabel stepCount= new JLabel("当前步数："+step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);
        //        创建ImageIcon对象
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                //        创建Jlabel对象
                JLabel jLabel = new JLabel(new ImageIcon("D:\\Java-project\\jigsawgame\\image\\animal\\animal3\\" + num + ".jpg"));
                //指定图片位置
                jLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(1));
                //添加到界面里
                //        this.add(jLabel);
                this.getContentPane().add(jLabel);

            }
        }
        JLabel background = new JLabel(new ImageIcon("D:\\Java-project\\jigsawgame\\image\\background.png"));
        background.setBounds(2, 5, 580, 630);
        this.getContentPane().add(background);
        //刷新一下
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);
//        给条目绑定事件
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //        设置布局为null
        this.setLayout(null);
        this.setSize(580, 680);
        this.setTitle("拼图单机版");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//按下不松
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon("D:\\Java-project\\jigsawgame\\image\\animal\\animal3\\all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            JLabel background = new JLabel(new ImageIcon("D:\\Java-project\\jigsawgame\\image\\background.png"));
            background.setBounds(2, 5, 580, 630);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }
        int code = e.getKeyCode();
        System.out.println(code);
        if (code == 37) {
//            向左移动
            if (y > 0) {
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                step++;
                initImage();
            } else {
                JOptionPane.showMessageDialog(this, "不能向左移动");
            }
        } else if (code == 38) {
//            向上移动
            if (x > 0) {
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                step++;
                initImage();
            } else {
                JOptionPane.showMessageDialog(this, "不能向上移动");
            }
        } else if (code == 39) {
//            向右移动
            if (y < 3) {
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                step++;
                initImage();
            } else {
                JOptionPane.showMessageDialog(this, "不能向右移动");
            }
        } else if (code == 40) {
//            向下移动
            if (x < 3) {
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                step++;
                initImage();
            } else {
                JOptionPane.showMessageDialog(this, "不能向下移动");
            }
        } else if (code == 65) {
//            按键A
            initImage();
        } else if(code==87){
//            按键W
        data=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0}
            };
        initImage();
    }

    }


    public boolean victory(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==replayItem){
            step=0;
            initData();
            initImage();


        } else if(obj==reloginItem){
            this.setVisible(false);
            new LoginJFrame();

        }
        else if(obj==closeItem){
            System.exit(0);
        }
        else if(obj==accountItem){
            JOptionPane.showMessageDialog(this, "公众号：guokang123");
        }
    }
}