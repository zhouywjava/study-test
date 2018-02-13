package Logger;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * Created by zhouyiwei on 2018/2/13.
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
        if(System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null){
            //如果没有设置配置类，如果没有设置配置文件
            try {
                //获得日志记录器com.horstman.corejava,并设置日志记录等级为全部等级
            Logger.getLogger("com.horstman.corejava").setLevel(Level.ALL);
            final int LOG_ROTATION_COUNT = 10;
            //日志文件处理器 在打开一个新的日志文件之前，日志文件可以包含的近视最大字节数   循环序列的文件数量
            Handler handler = new FileHandler("%h/LoggingImageViewer.log",0,LOG_ROTATION_COUNT);
            //为日志记录器指定对应的日志文件处理器
            Logger.getLogger("com.horstman.corejava").addHandler(handler);
            } catch (IOException e) {
                e.printStackTrace();
                Logger.getLogger("com.horstman.corejava").log(Level.SEVERE,"cant create log file handler",e);
            }
        }
        EventQueue.invokeLater(()->{
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.horstman.corejava").addHandler(windowHandler);

            //构造JFrame类，就是在画图,Jfram的内容在实现类的构造器里了
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.horstman.corejava").fine("Showing frame");
            frame.setVisible(true);
        });
    }
}
class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private static Logger logger = Logger.getLogger("com.hostman.corejava");
    public ImageViewerFrame(){
        logger.entering("ImageViewerFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        //设置选项按钮以及其事件处理
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener((e)->{
            logger.entering("ImageVieweerFrame.FileOpenLisener","actionPerformed",e);

            //文件选择类，打开系统文件选择
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });
            int r = chooser.showOpenDialog(ImageViewerFrame.this);
            if(r == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE,"Reading file {0}",name);
                //在label中展示选择的图片
                label.setIcon(new ImageIcon(name));
            }else logger.fine("File open dialog canceled.");
            logger.exiting("ImageViewerFrame.FileOpenListener","actionPerformed");
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener((e)->{
           logger.fine("Exiting.");
           System.exit(0);
        });

        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame","<init>");
    }
}
class WindowHandler extends StreamHandler {
    private JFrame frame;

    //自定义的日志处理器，也同样打开一个窗口显示日志
    public WindowHandler(){
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                output.append(new String(b,off,len));
            }
        });
    }

    @Override
    public void publish(LogRecord logRecord){
        if(!frame.isVisible()) return;
        super.publish(logRecord);
        flush();
    }
}
