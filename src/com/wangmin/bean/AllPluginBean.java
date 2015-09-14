package com.wangmin.bean;
import java.util.List;
public class AllPluginBean {
	private List<pluginList> pluginLists;

	private Data data;

	private String code;

	private String msg;

	public void setPluginList(List<pluginList> pluginList) {
		this.pluginLists = pluginList;
	}

	public List<pluginList> getPluginList() {
		return this.pluginLists;
	}

	public List<pluginList> getPluginLists() {
		return pluginLists;
	}

	public void setPluginLists(List<pluginList> pluginLists) {
		this.pluginLists = pluginLists;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public class pluginList {
		private String apkName;

		private String apkmd5;

		private String packageName;

		private String versionCode;

		private String url;

		private String request_ip;

		private String appName;

		private int createtime;

		private int id;

		private int delflag;

		private int apkSize;

		public void setApkName(String apkName) {
			this.apkName = apkName;
		}

		public String getApkName() {
			return this.apkName;
		}

		public void setApkmd5(String apkmd5) {
			this.apkmd5 = apkmd5;
		}

		public String getApkmd5() {
			return this.apkmd5;
		}

		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}

		public String getPackageName() {
			return this.packageName;
		}

		public void setVersionCode(String versionCode) {
			this.versionCode = versionCode;
		}

		public String getVersionCode() {
			return this.versionCode;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUrl() {
			return this.url;
		}

		public void setRequest_ip(String request_ip) {
			this.request_ip = request_ip;
		}

		public String getRequest_ip() {
			return this.request_ip;
		}

		public void setAppName(String appName) {
			this.appName = appName;
		}

		public String getAppName() {
			return this.appName;
		}

		public void setCreatetime(int createtime) {
			this.createtime = createtime;
		}

		public int getCreatetime() {
			return this.createtime;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		public void setDelflag(int delflag) {
			this.delflag = delflag;
		}

		public int getDelflag() {
			return this.delflag;
		}

		public void setApkSize(int apkSize) {
			this.apkSize = apkSize;
		}

		public int getApkSize() {
			return this.apkSize;
		}
	}

	public class Data {
		private String versioncode;

		private String url;

		public void setVersioncode(String versioncode) {
			this.versioncode = versioncode;
		}

		public String getVersioncode() {
			return this.versioncode;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUrl() {
			return this.url;
		}

	}
}