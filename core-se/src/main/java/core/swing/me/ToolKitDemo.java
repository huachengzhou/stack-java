package core.swing.me;

import java.awt.*;

/**
 * 获取屏幕的宽度和高度
 */
public class ToolKitDemo {
    public static void main(String[] args) {
        Toolkit toolkit =Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();

        System.out.println("width:"+screenWidth+" height:"+screenHeight);
    }
}
