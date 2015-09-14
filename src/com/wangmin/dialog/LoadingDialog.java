/*
 * LoadingDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package com.wangmin.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import com.wangmin.utils.HttpUtils;
import com.wangmin.utils.ResourceUtils;

/**
 *
 * @author  __USER__
 */
public class LoadingDialog extends javax.swing.JDialog {

	/** Creates new form LoadingDialog */
	public LoadingDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		setUndecorated(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 476,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 333,
				Short.MAX_VALUE));

		pack();
		initView();
	}// </editor-fold>
	

	//GEN-END:initComponents
	/**
	 * @param args the command line arguments
	 */
//	public static void main(String args[]) {
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				LoadingDialog dialog = new LoadingDialog(
//						new javax.swing.JFrame(), true);
//				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//					public void windowClosing(java.awt.event.WindowEvent e) {
//						System.exit(0);
//					}
//				});
//				dialog.setVisible(true);
//			}
//		});
//	}
	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	// End of variables declaration//GEN-END:variables
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(image == null){
			try{
				image = ResourceUtils.loadBufferedImageLocation("loding.jpg");
			}catch (Exception e) {
			   image = null;
			}
		}
		if(image == null){
			image = HttpUtils.loadImage("http://picapi.ooopic.com/10/61/91/29b1OOOPIC90.jpg");
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.RED);
		Font f = new Font("����", Font.BOLD, 20);
		g.setFont(f);
		FontMetrics fm = new JLabel().getFontMetrics(f);
		int stringWidth = fm.stringWidth(textString);
		int height = fm.getHeight();
		int centerx = (getWidth() - stringWidth)/2;
		int centery = (getHeight() - height)/2;
		g.drawString(textString, centerx, centery);
	}
	private void initView() {
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (width - getWidth())/2;
		int y = (height - getHeight())/2;
		setLocation(x, y);
		setAlwaysOnTop(true);
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(size == 6){
					add = false;
				}else if(size == 0){
					add = true;
				}
				if(add){
					size ++;
				}else{
					size--;
				}
				textString = loadtingText.substring(0, (loadtingText.length()-(6-size)));
				repaint();
			}
		}, 0, 500);
	}
	private BufferedImage image = null;
	private static final String loadtingText = "���ڶ�ȡ���ݣ����Ժ�......";
	private String textString = loadtingText;
	int size = 6;
	boolean add = false;
	Timer timer = null;
}