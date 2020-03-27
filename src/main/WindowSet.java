package main;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class WindowSet extends JFrame{
    //GUI
    public void window_set(){
        setSize(800,600);  //定义JFrame属性
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Pic());  //将背景图添加到JFrame中
    }

    public static void main(String[] args) throws IOException{


        WindowSet window = new WindowSet();
        window.window_set();

    }
}

class Pic extends JPanel{
    //背景图
    static BufferedImage image = null;
    static File file = null;

    public void paintComponent(Graphics g){
        try{
            file = new File("D:\\workspace\\JavaSpace\\test.jpg"); //读取图片
            image = ImageIO.read(file);
        }catch(IOException e){
            System.out.println("Error:" + e);
        }
        //super.paint(g);
        image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_AREA_AVERAGING));
        g.drawImage(image,0,0,null);   //drawImage绘制图片
    }

}

