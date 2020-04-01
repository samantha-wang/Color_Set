package components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args){
        //frame设置
        JFrame frame= new JFrame("Color_Set");
        int x = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        frame.setSize(x,y);//设置界面大小,适配显示器
        frame.setResizable(false);
        frame.setFocusable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        //新建一个分层器，其中背景层jp1在左侧，jp3右侧
        JLayeredPane layeredPane=new JLayeredPane();
        layeredPane.setLayout(new BorderLayout());

        /*建立背景层jp1，jp1中包括label*/
        JPanel jp1=new JPanel();
        jp1.setPreferredSize(new Dimension(y-100,y-100));
        JLayeredPane layeredPane1 = new JLayeredPane();            //在jp1上加分层
        layeredPane1.setPreferredSize(new Dimension(y-100,y-100));  //设置layeredpane1的大小

        //String path;
        /*jp3是GUI右侧部分，中间包括jp2小面板,jp4按钮，jp5色板*/
        JPanel jp3 = new JPanel();
        jp3.setLayout((new BorderLayout()));
        //建立放置在this中的小面板jp2，jp2包括label1，text1，label2，text2
        JPanel jp2=new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));                     //jp2面板布局方式为流式左对齐
        //label1
        JLabel label1=new JLabel("图片路径:");
        label1.setFont(new Font("楷体",Font.BOLD,40));
        label1.setForeground(Color.black);
        jp2.add(label1);
        //text1
        JTextField text1=new JTextField();
        //
        text1.setFont(new Font("Times New Roman",Font.PLAIN,30));
        text1.setPreferredSize(new Dimension(340,50));
        jp2.add(text1);
        jp2.setOpaque(false);
        //label2
        JLabel label2=new JLabel("选择颜色:");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("楷体",Font.BOLD,40));//设置字体大小等
        jp2.add(label2);
        //text2
        JTextField text2=new JTextField();
        text2.setFont(new Font("Times New Roman",Font.PLAIN,30));
        text2.setPreferredSize(new Dimension(340,50));
        jp2.add(text2);

        jp2.setPreferredSize(new Dimension(550,120));         //设置jp2的优先大小
        jp3.add(jp2,BorderLayout.CENTER);


        //文本设置
        JTextArea text=new JTextArea("浔阳江头夜送客，枫叶荻花秋瑟瑟。主人下马客在船，举酒欲饮无管弦。\n" +
                "醉不成欢惨将别，别时茫茫江浸月。忽闻水上琵琶声，主人忘归客不发。\n" +
                "寻声暗问弹者谁，琵琶声停欲语迟。移船相近邀相见，添酒回灯重开宴。\n" +
                "千呼万唤始出来，犹抱琵琶半遮面。转轴拨弦三两声，未成曲调先有情。\n" +
                "弦弦掩抑声声思，似诉平生不得志。低眉信手续续弹，说尽心中无限事。\n" +
                "轻拢慢捻抹复挑，初为霓裳后六幺。大弦嘈嘈如急雨，小弦切切如私语。\n" +
                "嘈嘈切切错杂弹，大珠小珠落玉盘。间关莺语花底滑，幽咽泉流冰下难。\n" +
                "冰泉冷涩弦凝绝，凝绝不通声暂歇。别有幽愁暗恨生，此时无声胜有声。\n" +
                "银瓶乍破水浆迸，铁骑突出刀枪鸣。曲终收拨当心画，四弦一声如裂帛。\n" +
                "东船西舫悄无言，唯见江心秋月白。沉吟放拨插弦中，整顿衣裳起敛容。\n" +
                "自言本是京城女，家在虾蟆陵下住。十三学得琵琶成，名属教坊第一部。\n" +
                "曲罢曾教善才服，妆成每被秋娘妒。五陵年少争缠头，一曲红绡不知数。\n" +
                "钿头银篦击节碎，血色罗裙翻酒污。今年欢笑复明年，秋月春风等闲度。\n" +
                "弟走从军阿姨死，暮去朝来颜色故。门前冷落鞍马稀，老大嫁作商人妇。\n" +
                "商人重利轻别离，前月浮梁买茶去。去来江口守空船，绕船月明江水寒。\n" +
                "夜深忽梦少年事，梦啼妆泪红阑干。我闻琵琶已叹息，又闻此语重唧唧。\n" +
                "同是天涯沦落人，相逢何必曾相识！我从去年辞帝京，谪居卧病浔阳城。\n" +
                "浔阳地僻无音乐，终岁不闻丝竹声。住近湓江地低湿，黄芦苦竹绕宅生。\n" +
                "其间旦暮闻何物？杜鹃啼血猿哀鸣。春江花朝秋月夜，往往取酒还独倾。\n" +
                "岂无山歌与村笛？呕哑嘲哳难为听。今夜闻君琵琶语，如听仙乐耳暂明。\n" +
                "莫辞更坐弹一曲，为君翻作琵琶行。感我此言良久立，却坐促弦弦转急。\n" +
                "凄凄不似向前声，满座重闻皆掩泣。座中泣下谁最多？江州司马青衫湿。");
        text.setFont(new Font("楷体",Font.PLAIN,27));
        text.setBounds(0,0,y-100,y-100);
        text.setOpaque(false);//text背景透明
        layeredPane1.add(text,JLayeredPane.MODAL_LAYER);            //将文字标签放在layeredpane的顶层
        layeredPane1.setVisible(true);
        jp1.add(layeredPane1);
        layeredPane.add(jp1,BorderLayout.CENTER);

        class MouseclickListener extends MouseAdapter{
            String hex;
            Color color;
            @Override
            public void mouseClicked(MouseEvent me) {
                Robot robot = null;
                try {
                    robot = new Robot();
                } catch (AWTException ae) {
                    ae.printStackTrace();
                }
                Point mousePoint = MouseInfo.getPointerInfo().getLocation();
                color = robot.getPixelColor((int)(mousePoint.getX()),(int)(mousePoint.getY()));
                hex = ColorTransfer.toHex(color.getRed(),color.getGreen(),color.getBlue());
                text2.setText(hex);
                //TextArea的颜色改变
                //MouseListener mouselistener = new MouseListener();
                try {
                    text.setForeground(color);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    text.setForeground(Color.black);
                }
            }
            public void mouseExited(MouseEvent me){

            }
        }

        //jp4包含两个button
        JPanel jp4=new JPanel();
        jp4.setLayout(new FlowLayout(FlowLayout.CENTER));                    //面板布局方式为流式中对齐
        //实例化按钮重置
        JButton button1=new JButton("重置");
        button1.setForeground(Color.white);
        button1.setBackground(new Color(220,20,60,255));
        button1.setFont(new Font("楷体",Font.BOLD,40));
        //button1.setBounds(720, 625, 120, 50);
        button1.setPreferredSize(new Dimension(120,50));
        button1.setBorderPainted(false); //设为边界透明
        button1.setBorder(BorderFactory.createRaisedBevelBorder()); //让按钮凸起来
        jp4.add(button1);
        //实例化按钮确定
        JButton button2=new JButton("确定");
        button2.setForeground(Color.white);
        button2.setBackground(new Color(0,128,128,255));
        button2.setFont(new Font("楷体",Font.BOLD,40));
        button2.setBounds(948, 625, 120, 50);
        button2.setBorderPainted(false); //设为边界透明
        button2.setBorder(BorderFactory.createRaisedBevelBorder()); //让按钮凸起来

        button1.setActionCommand("cancel");
        button2.setActionCommand("ok");

        class ButtonClickListener1 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if(command.equals("ok")){
                    //背景图label
                    JLabel label=new JLabel();
                    label.setBounds(0,0,y-100,y-100);        //必须设置label的位置大小
                    //背景图
                    BufferedImage img = null;
                    String path;
                    path = text1.getText();
                    try {
                        img = ImageIO.read(new File(path));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        text1.setText("Please input the correct path");
                        text1.setForeground(Color.RED);
                    }
                    int a = img.getWidth();
                    int b = img.getHeight();
                    int resizeTimes;                                           //计算缩放比例
                    if (a > b){
                        resizeTimes = a/(y-100);
                    } else{
                        resizeTimes = b/(y-100);
                    }
                    Image dimg = img.getScaledInstance(a/resizeTimes, b/resizeTimes, Image.SCALE_SMOOTH);  //创建图像的缩放版本
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    label.setIcon(imageIcon);
                    layeredPane1.add(label, JLayeredPane.DEFAULT_LAYER);           //将图片标签放在layeredpane的底层

                    String color_hex = text2.getText();
                    Color color_set = ColorTransfer.fromStrToARGB(color_hex);
                    try {
                        text.setForeground(color_set);
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                        text.setForeground(Color.black);
                    }

                    //hex = ColorToHex.toHex(color.getRed(),color.getGreen(),color.getBlue());
                    //Color color = Color.RED;



                }
                if(command.equals("cancel")){
                    text1.setText("");
                    text2.setText("");
                }
            }
        }

        button1.addActionListener(new ButtonClickListener1());
        button2.addActionListener(new ButtonClickListener1());
        jp4.add(button2);//放在分层最高层
        jp3.add(jp4, BorderLayout.SOUTH);//放在下面

        //jp5预备放颜色面板
        JLabel jp5 = new JLabel();
        jp5.setPreferredSize(new Dimension(500,500));
        //读取图片
        ImageIcon ima2=new ImageIcon("D:\\workspace\\JavaSpace\\ColorSet\\colors.jpg");
        ima2.setImage(ima2.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        //新建label，label的setIcon为背景图
        JLabel label5=new JLabel();
        label5.setIcon(ima2);
        label5.setSize(500,500);
        label5.addMouseListener(new MouseclickListener());
        jp5.add(label5);//将标签放在jp5中
        jp5.setVisible(true);
        jp5.setOpaque(true);
        jp3.add(jp5,BorderLayout.NORTH);
        layeredPane.add(jp3, BorderLayout.EAST);





        frame.add(layeredPane);
        frame.setVisible(true);

    }






}

class ColorTransfer {

    public static String toHex(int r, int g, int b) {
        return toBrowserHexValue(r) + toBrowserHexValue(g)
                + toBrowserHexValue(b);
    }

    private static String toBrowserHexValue(int rgb) {
        StringBuilder sb = new StringBuilder(
                Integer.toHexString(rgb & 0xff));
        //为什么要和0xff做&运算？保持二进制补码的一致性
        while (sb.length() < 2) {
            sb.append("0");
        }
        return sb.toString().toUpperCase();
    }

    public static Color fromStrToARGB(String str) {
        String str1 = str.substring(0, 2);
        String str2 = str.substring(2, 4);
        String str3 = str.substring(4, 6);
        //String str4 = str.substring(6, 8);
        //int alpha = Integer.parseInt(str1, 16);
        int red = Integer.parseInt(str1, 16);
        int green = Integer.parseInt(str2, 16);
        int blue = Integer.parseInt(str3, 16);
        Color color = new Color(red, green, blue);
        return color;
    }


}
