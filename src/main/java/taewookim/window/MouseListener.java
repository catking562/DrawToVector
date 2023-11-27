package taewookim.window;

import org.bukkit.configuration.file.YamlConfiguration;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

    final Window win;

    public MouseListener(Window win) {
        this.win = win;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        win.isdrag=true;
        win.listx.clear();
        win.listy.clear();
        win.listx.add(e.getX());
        win.listy.add(e.getY());
        win.gra.setColor(Color.WHITE);
        win.gra.fillRect(0, 0, 500, 500);
        win.gra.setColor(Color.RED);
        win.gra.fillRect(e.getX(), e.getY(), 1, 1);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        win.isdrag=false;
        File file = new File( System.currentTimeMillis() + ".yml");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Properties pro = new Properties();
        pro.setProperty("size", win.listx.size() + "");
        for(int i = 0; i<win.listx.size(); i++) {
            pro.setProperty("x" + i, win.listx.get(i) + "");
            pro.setProperty("y" + i, win.listy.get(i) + "");
        }
        try{
            OutputStream stream = new FileOutputStream(file);
            pro.store(stream, System.currentTimeMillis() + "");
            stream.close();
        }catch(Exception ea) {
            ea.printStackTrace();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        win.listx.add(e.getX());
        win.listy.add(e.getY());
        win.gra.fillRect(e.getX(), e.getY(), 1, 1);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
