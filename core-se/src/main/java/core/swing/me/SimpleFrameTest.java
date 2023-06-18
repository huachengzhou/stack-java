package core.swing.me;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {

    public static  class SimpleFrame extends JFrame{
       private static final int DEFAULT_WIDTH = 300;
       private static final int DEFAULT_HEIGHT = 200;

       public SimpleFrame(){
           setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);//宽和高
           setVisible(true);//窗体可见

//           setUndecorated(false);//关闭所以框架装饰
       }
    }

    public static void main(String[] args) {
        //事件分派线程 代码块
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame simpleFrame = new SimpleFrame();
                simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }


}
