package com.wangmin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.wangmin.utils.DialogUtils.DialogType;

public class FtpUtls {
	 private FTPClient ftp =new FTPClient(); 
	    /**  
	     * @param path 上传到ftp服务器哪个路径下     
	     * @param addr 地址  
	     * @param port 端口号  
	     * @param username 用户名  
	     * @param password 密码  
	     * @return  
	     * @throws Exception  
	     */    
	 private String localpath;
	 private String remotePath;
	 public FtpUtls(){
		 initLocalPath();
	 }
	private void initLocalPath() {
		localpath = System.getProperty("user.home")+File.separator+"superSibu";
		 File file = new File(localpath);
		 file.mkdirs();
	}
	 public FtpUtls(String locationPath){
		 this.localpath = locationPath;
	 }
	 public FtpUtls(String locaString,String remotePath){
		 if(locaString == null){
			 initLocalPath();
		 }
		 this.remotePath = remotePath;
	 }
	    public boolean connect(String addr,int port,String username,String password) throws Exception {      
	        boolean result = false;      
	        ftp = new FTPClient();      
	        int reply;      
	        ftp.connect(addr,port); 
	        if(username == null){
	        	username = "anonymous";
	        	password = "614645062@qq.com";
	        }
	        ftp.login(username,password);      
	       // ftp.setFileType(FTPClient.BINARY_FILE_TYPE);      
	        reply = ftp.getReplyCode();      
	        if (!FTPReply.isPositiveCompletion(reply)) {      
	            ftp.disconnect();      
	            return result;      
	        }         
	        result = true;      
	        return result;      
	    }      
	    /**  
	     * @param file 上传的文件或文件夹  
	     * @throws Exception  
	     */    
	    public  void upload(File file,String ServerPath) throws Exception{  
	        if(file.isDirectory()){ 
	        	String dir = ServerPath + "/" +file.getName();
	            ftp.makeDirectory(dir);                
	            ftp.changeWorkingDirectory(file.getName());      
	            String[] files = file.list();             
	            for (int i = 0; i < files.length; i++) {      
	                File file1 = new File(file.getPath()+"\\"+files[i] );      
	                if(file1.isDirectory()){      
	                    upload(file1,dir);      
	                    ftp.changeToParentDirectory();      
	                }else{                    
	                    File file2 = new File(file.getPath()+"\\"+files[i]);      
	                    FileInputStream input = new FileInputStream(file2);
	                    ftp.storeFile(file2.getName(), input);      
	                    input.close();                            
	                }                 
	            }      
	        }else{  
	            ftp.makeDirectory(ServerPath);
	            ftp.changeWorkingDirectory(ServerPath);
	            File file2 = new File(file.getPath());      
	            FileInputStream input = new FileInputStream(file2); 
	            ftp.storeFile(file2.getName(), input);      
	            input.close();        
	        }      
	    }
	    /**
	     * 下载文本文档或者二进制文档
	     * @param remoteFile
	     * @param addr
	     * @param port
	     * @param username
	     * @param password
	     * @return
	     */
	    public String download(String remoteFile,int type){
	         FileOutputStream fos = null; 
	         try { 
	             String remoteFileName = remoteFile; 
	             fos = new FileOutputStream(localpath+File.separator+System.currentTimeMillis()+remoteFile.substring(remoteFile.indexOf("/")+1)); 
	             ftp.setBufferSize(1024); 
	             //设置文件类型（二进制） 
	             ftp.setFileType(type); 
	             ftp.retrieveFile(remoteFileName, fos); 
	             if(type == FTPClient.ASCII_FILE_TYPE){
		             return IOutils.getText( ftp.getInputStream(), true,"GBK");
	             }else{
	            	 return null;
	             }
	         } catch (Exception e) { 
	        	 DialogUtils.showMessageDialog(null, e.getMessage(), DialogType.NORMAL);
				 return null;
	         } finally { 
	             IOutils.closeResource(fos);
	             try { 
	                 ftp.disconnect(); 
	             } catch (IOException e) { 
	                 e.printStackTrace(); 
	                 throw new RuntimeException("关闭FTP连接发生异常！", e); 
	             } 
	         } 
	    }
}
