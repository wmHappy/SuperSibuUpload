/*
 * UploadPlugin.java
 *
 * Created on __DATE__, __TIME__
 */

package com.wangmin.upload;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apkinfo.api.GetApkInfo;
import org.apkinfo.api.domain.ApkInfo;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wangmin.bean.APKinfo;
import com.wangmin.bean.Addplugin;
import com.wangmin.bean.AllPluginBean;
import com.wangmin.bean.MySaveInfo;
import com.wangmin.bean.Addplugin.Plugin;
import com.wangmin.bean.AllPluginBean.pluginList;
import com.wangmin.dialog.LoadingDialog;
import com.wangmin.dialog.LoadingWaitDialog;
import com.wangmin.dialog.LoginDialog;
import com.wangmin.dialog.LoginDialog.OkListener;
import com.wangmin.utils.DialogUtils;
import com.wangmin.utils.FtpUtls;
import com.wangmin.utils.HttpUtils;
import com.wangmin.utils.IOutils;
import com.wangmin.utils.DialogUtils.DialogType;

/**
 *
 * @author  __USER__
 */
public class UploadPlugin extends javax.swing.JFrame {

	/** Creates new form UploadPlugin */
	public UploadPlugin() {
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

		title = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		ftpAddress = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		serverAddress = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		ApkAddress = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		ftpDir = new javax.swing.JTextField();
		ckftpDir = new javax.swing.JCheckBox();
		jLabel8 = new javax.swing.JLabel();
		ApkName = new javax.swing.JTextField();
		cbLogin = new javax.swing.JCheckBox();
		jLabel9 = new javax.swing.JLabel();
		uploadProgressBar = new javax.swing.JProgressBar();
		btUpload = new javax.swing.JButton();
		toolMsg = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		apkName = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		apkVersionName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		apkVersionCode = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		title.setText("ftp\u670d\u52a1\u5668\u4e0a\u4f20\u5de5\u5177");

		jLabel2.setText("ftp\u670d\u52a1\u5668\u5730\u5740\uff1a");

		jLabel5.setText("\u670d\u52a1\u5668\u7aefip\u5730\u5740:");

		jLabel6.setText("ftp\u4e0a\u4f20\u76ee\u5f55:");

		jLabel7.setText("apk\u6587\u4ef6\u76ee\u5f55\uff1a");

		jButton1.setText("\u6d4f\u89c8");

		ckftpDir.setText("\u66f4\u6539");

		jLabel8.setText("\u4e0a\u4f20ftp\u540d\u79f0\uff1a");

		cbLogin.setText("\u533f\u540d\u767b\u5f55");

		jLabel9.setText("\u64cd\u4f5c\u8fdb\u5ea6\uff1a");

		btUpload.setText("\u5f00\u59cb\u4e0a\u4f20");

		jButton2.setText("\u7ba1\u7406\u4e2d\u5fc3");

		jLabel1.setText("apk\u5305\u540d\uff1a");

		jLabel3.setText("\u7248\u672c\u540d\u79f0\uff1a");

		jLabel4.setText("\u7248\u672c\u53f7\uff1a");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																title,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																597,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				toolMsg,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				409,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton2)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btUpload)
																		.addContainerGap())
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jLabel7))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												ApkAddress,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												429,
																												Short.MAX_VALUE)
																										.addGap(
																												6,
																												6,
																												6)
																										.addComponent(
																												jButton1))
																						.addComponent(
																								serverAddress,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								492,
																								Short.MAX_VALUE)
																						.addComponent(
																								ftpAddress,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								492,
																								Short.MAX_VALUE))
																		.addContainerGap())
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel6)
																														.addComponent(
																																jLabel1))
																										.addGap(
																												26,
																												26,
																												26))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel9,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												92,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								uploadProgressBar,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								488,
																								Short.MAX_VALUE)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																apkName,
																																javax.swing.GroupLayout.Alignment.LEADING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																145,
																																Short.MAX_VALUE)
																														.addComponent(
																																ftpDir,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																145,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																ckftpDir)
																														.addComponent(
																																jLabel3))
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addGroup(
																																layout
																																		.createSequentialGroup()
																																		.addGap(
																																				29,
																																				29,
																																				29)
																																		.addComponent(
																																				cbLogin))
																														.addGroup(
																																layout
																																		.createSequentialGroup()
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				apkVersionName)))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jLabel8)
																														.addComponent(
																																jLabel4))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																apkVersionCode)
																														.addComponent(
																																ApkName,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																90,
																																Short.MAX_VALUE))))
																		.addContainerGap()))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(title)
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																ftpAddress,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																35,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																serverAddress,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																ApkAddress,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																34,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(jLabel3)
														.addComponent(
																apkVersionName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel4)
														.addComponent(
																apkVersionCode,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																apkName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(jLabel8)
														.addComponent(
																ApkName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(cbLogin)
														.addComponent(ckftpDir)
														.addComponent(
																ftpDir,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																34,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																uploadProgressBar,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																26,
																Short.MAX_VALUE)
														.addComponent(jLabel9))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jButton2)
																		.addComponent(
																				btUpload))
														.addComponent(
																toolMsg,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																32,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		pack();
		initView();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				final LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
				new Thread(){
					public void run() {
						dialog.setVisible(true);
					};
				}.start();
				final UploadPlugin uploadPlugin = new UploadPlugin();
				loadData(dialog, uploadPlugin);
			}
		});
	}
	
	private static void loadData(final LoadingDialog dialog,
			final UploadPlugin uploadPlugin) {
		new Thread(){
			public void run() {
				Properties properties = new Properties();
				Gson gson = new Gson();
				getAllPluginPath = "http://172.10.100.241:8666";
				String encode = "utf-8";
				File file = new File(System.getProperty("user.home")+File.separator+"pluginConfig.properties");
				try {
					properties.load(new FileInputStream(file));
					getAllPluginPath = properties.getProperty("serverUrl");
					encode = properties.getProperty("serverEncode");
					String json = HttpUtils.getJson(dialog,getAllPluginPath+"/public/plugins/get", encode);
					if(json == null){
						JOptionPane.showMessageDialog(null, "��ȡ���в����Ϣʧ�ܣ�������properties�ļ���������ַserverUrl���ַ�����encode");
						dialog.setVisible(false);
						uploadPlugin.setVisible(true);
						return;
					}
					AllPluginBean allPluginBean = gson.fromJson(json, AllPluginBean.class);
					uploadPlugin.setAllPluginBean(allPluginBean);
					dialog.setVisible(false);
					uploadPlugin.setVisible(true);
				} catch (Exception e) {
					String json = HttpUtils.getJson(dialog,getAllPluginPath+"/public/plugins/get", encode);
					if(json == null){
						JOptionPane.showMessageDialog(null, "��ȡ���в����Ϣʧ�ܣ�������properties�ļ���������ַserverUrl���ַ�����encode");
						dialog.setVisible(false);
						uploadPlugin.setVisible(true);
						return;
					}
					AllPluginBean allPluginBean = gson.fromJson(json, AllPluginBean.class);
					uploadPlugin.setAllPluginBean(allPluginBean);
					dialog.setVisible(false);
					uploadPlugin.setVisible(true);
				}
			};
		}.start();
	}

	private void initView() {
		setTitle("myftp");
		if(mySaveInfo != null){
			UploadPlugin.this.apkName.setText(mySaveInfo.apkPackageName == null?"":mySaveInfo.apkPackageName);
			ApkAddress.setText(mySaveInfo.apkUrl == null?"":mySaveInfo.apkUrl);
			apkVersionCode.setText(mySaveInfo.apkVersionCode == null?"":mySaveInfo.apkVersionCode);
			apkVersionName.setText(mySaveInfo.apkVersionName == null?"":mySaveInfo.apkVersionName);
			ftpDir.setText(mySaveInfo.ftpsuberUrl == null?"":mySaveInfo.ftpsuberUrl);
			ftpAddress.setText(mySaveInfo.ftpUtl == null?"":mySaveInfo.ftpUtl);
			serverAddress.setText(mySaveInfo.serverUrl == null?"":mySaveInfo.serverUrl);
		}
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("����", Font.BOLD, 20));
		ftpDir.setHorizontalAlignment(JTextField.CENTER);
		ApkName.setHorizontalAlignment(JTextField.CENTER);
		toolMsg.setBorder(BorderFactory.createEmptyBorder());
		toolMsg.setEditable(false);
		toolMsg.setHorizontalAlignment(JTextField.CENTER);
		apkName.setEditable(false);
		apkVersionCode.setEditable(false);
		apkVersionName.setEditable(false);
		cbLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!cbLogin.isSelected()) {
					LoginDialog dialog = new LoginDialog(UploadPlugin.this,
							true);
					dialog.setOkListener(new OkListener() {
						@Override
						public void ok(String username, String password) {
							ftpusername = username;
							ftpPassword = password;
							cbLogin.setSelected(false);
						}

						@Override
						public void cancel() {
							cbLogin.setSelected(true);
						}
					});
					dialog.setVisible(true);
				} else {
					ftpusername = null;
					ftpPassword = null;
				}
			}
		});
		ckftpDir.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				ftpDir.setEditable(ckftpDir.isSelected());
			}
		});
		jButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File file = DialogUtils.getFile(UploadPlugin.this, ".apk", ""
						.equals(ApkAddress.getText().toString()) ? null
						: ApkAddress.getText().toString());
				if (file != null) {
					apkName.setText("");
					apkVersionName.setText("");
					apkVersionCode.setText("");
					ApkAddress.setText(file.getAbsolutePath());
					ApkInfo apkInfo;
					try {
						apkInfo = GetApkInfo.getApkInfoByFilePath(file.getAbsolutePath());
						aKinfo = new APKinfo();
						aKinfo.packageName = apkInfo.getPackageName();
						apkName.setText(apkInfo.getPackageName());
						apkVersionName.setText(apkInfo.getVersionName());
						apkVersionCode.setText(apkInfo.getVersionCode());
					} catch (Exception e1) {
						DialogUtils.showMessageDialog(UploadPlugin.this, "��ȡapk�ļ���Ϣʧ��"+e1.getMessage(), DialogType.NORMAL);
						toolMsg.setText("��ȡapk�ļ���Ϣʧ��...");
						ApkAddress.setText("");
					}
				}
			}
		});
		btUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ftpAddress.getText().equals("")) {
					DialogUtils.showMessageDialog(UploadPlugin.this,
							"ftp��ַ����Ϊ��", DialogType.NORMAL);
					return;
				} else if (serverAddress.getText().equals("")) {
					DialogUtils.showMessageDialog(UploadPlugin.this,
							"��������ַ����Ϊ��", DialogType.NORMAL);
					return;
				} else if (ApkAddress.getText().equals("")) {
					DialogUtils.showMessageDialog(UploadPlugin.this,
							"apk��ַ����Ϊ��", DialogType.NORMAL);
					return;
				} else if (ApkName.getText().equals("")) {
					DialogUtils.showMessageDialog(UploadPlugin.this,
							"ftp apk���Ʋ���Ϊ��", DialogType.NORMAL);
					return;
				} else if (ftpDir.getText().equals("")) {
					DialogUtils.showMessageDialog(UploadPlugin.this,
							"ftp�ϴ�����Ϊ��", DialogType.NORMAL);
					return;
				}
				final LoadingWaitDialog dialog = new LoadingWaitDialog(
						UploadPlugin.this, true);
				dialog.setText("�����ϴ�ftp......");
				toolMsg.setText("�����ϴ�ftp......");
				new Thread(){
					public void run() {
						dialog.setVisible(true);
					};
				}.start();
				new Thread() {
					@Override
					public void run() {
						FtpUtls ftpUtls = new FtpUtls();
						try {
							ftpUtls.connect(ftpAddress.getText(), 21,
									ftpusername, ftpPassword);
							ftpUtls.upload(new File(ApkAddress.getText()),
									ftpDir.getText());
							String apkName = UploadPlugin.this.ApkName.getText();
							Addplugin addplugin = new Addplugin();
							addplugin.plugin = null;
							List<pluginList> pluginList = allPluginBean.getPluginList();
							for(int i = 0;i<pluginList.size();i++){
								pluginList pluginList2 = pluginList.get(i);
								if(pluginList2.getPackageName().equals(UploadPlugin.this.apkName.getText())){
									addplugin.plugin = new Plugin();
									addplugin.plugin.id = pluginList2.getId();
									addplugin.plugin.apkmd5 = pluginList2.getApkmd5();
									addplugin.plugin.apkSize = (int) new File(ApkAddress.getText().toString()).length();
									addplugin.plugin.apkName = apkName;
									addplugin.plugin.priority = -1;
									addplugin.plugin.url = "http://"+ftpAddress.getText().toString()+ftpDir.getText()+"/"+apkName;
									char c = pluginList2.getVersionCode().charAt(pluginList2.getVersionCode().length()-1);
									if(c == '9'){
										c='0';
									}else{
										c=(char) (c+1);
									}
									addplugin.plugin.versionCode = pluginList2.getVersionCode().substring(0,pluginList2.getVersionCode().length()-1)+c;
									addplugin.plugin.appName = pluginList2.getAppName();
									addplugin.plugin.packageName = pluginList2.getPackageName();
								}
							}
							if(addplugin.plugin == null){
								DialogUtils.showMessageDialog(UploadPlugin.this, "��������δ�ҵ���֮�����ƵĲ��"+new Gson().toJson(allPluginBean), DialogType.NORMAL);
							}else{
								dialog.setText("�����޸İ汾��...");
								toolMsg.setText("�����޸İ汾��...");
								String json = HttpUtils.getJson(UploadPlugin.this, "http://"+serverAddress.getText()+":8666/public/plugins/set?json="+new Gson().toJson(addplugin), "gbk");
								JSONObject jsonObject = new JSONObject(json);
								String code = jsonObject.getString("code");
								if("0".equals(code)){
									toolMsg.setText("�����ɹ�");
									MySaveInfo info = new MySaveInfo();
									info.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
									info.apkPackageName = UploadPlugin.this.apkName.getText();
									info.apkUrl = ApkAddress.getText().toString();
									info.apkVersionCode = apkVersionCode.getText().toString();
									info.apkVersionName = apkVersionName.getText();
									info.ftpsuberUrl = ftpDir.getText();
									info.ftpUtl = ftpAddress.getText();
									info.serverUrl = serverAddress.getText().toString();
									savePlugin(mySaveInfo);
								}else{
									toolMsg.setText("����ʧ��");
								}
							}
							dialog.setVisible(false);
							dialog.dispose();
						} catch (Exception e) {
							DialogUtils.showMessageDialog(UploadPlugin.this, "�ϴ�ʧ��", DialogType.NORMAL);
							dialog.setVisible(false);
							dialog.dispose();
							toolMsg.setText("����ʧ��");
							return;
						}
					}
				}.start();
			}
		});
		ApkName.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!ApkName.getText().endsWith(".apk")) {
					ApkName.removeFocusListener(this);
					toolMsg.setForeground(Color.red);
					toolMsg.setText("ftp apk���Ʋ���Ϊ��,�ұ�����apk�ļ�");
					ApkName.requestFocus();
					ApkName.addFocusListener(this);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		cbLogin.setSelected(true);
		ckftpDir.setSelected(true);
		ApkAddress.setEditable(false);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField ApkAddress;
	private javax.swing.JTextField ApkName;
	private javax.swing.JTextField apkName;
	private javax.swing.JTextField apkVersionCode;
	private javax.swing.JTextField apkVersionName;
	private javax.swing.JButton btUpload;
	private javax.swing.JCheckBox cbLogin;
	private javax.swing.JCheckBox ckftpDir;
	private javax.swing.JTextField ftpAddress;
	private javax.swing.JTextField ftpDir;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField serverAddress;
	private javax.swing.JLabel title;
	private javax.swing.JTextField toolMsg;
	private javax.swing.JProgressBar uploadProgressBar;
	// End of variables declaration//GEN-END:variables
	private String ftpusername;
	private String ftpPassword;
	private APKinfo aKinfo;
	private static MySaveInfo mySaveInfo;
	private static AllPluginBean allPluginBean;
	private static String getAllPluginPath;
	public AllPluginBean getAllPluginBean() {
		return allPluginBean;
	}

	public void setAllPluginBean(AllPluginBean allPluginBean) {
		this.allPluginBean = allPluginBean;
	}
	static{
		File file = new File(System.getProperty("user.home")+File.separator+"mySaveInfo.json");
		if(file.exists()){
			try {
				String text = IOutils.getText(new FileInputStream(file), true, "utf-8");
				Gson gson = new Gson();
				MySaveInfo mySaveInfo = gson.fromJson(text, MySaveInfo.class);
				UploadPlugin.mySaveInfo = mySaveInfo;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void savePlugin(MySaveInfo mySaveInfo){
		Gson gson = new Gson();
		String json = gson.toJson(mySaveInfo);
		File file = new File(System.getProperty("user.home")+File.separator+"mySaveInfo.json");
		try {
			IOutils.saveText(new FileOutputStream(file), true, "utf-8", json);
		} catch (Exception e) {
			DialogUtils.showMessageDialog(null, "������Ϣʧ��", DialogType.NORMAL);
		}
	}
}