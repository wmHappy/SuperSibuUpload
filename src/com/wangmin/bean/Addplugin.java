package com.wangmin.bean;
//JSON 格式说明：
//ID 不传 或传0，表示 添加插件，else 根据ID修改。
//plugin":{
//            "id":0,
//            "apkName": "mainTest.apk",
//            "apkSize": 0,
//            "apkmd5": "",
//            "appName": "测试主界面",
//            "priority": -1,
//            "versionCode": "1.4",
//            "packageName": "com.gzsibu.test",
//            "url": "http://172.10.20.134/upload/plugin/mainTest.apk"
//        }

public  class Addplugin {
	public Plugin plugin;

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	public Plugin getPlugin() {
		return this.plugin;
	}

	public static class Plugin {
		public int id;

		public String apkName;

		public int apkSize;

		public String apkmd5;

		public String appName;

		public int priority;

		public String versionCode;

		public String packageName;

		public String url;

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		public void setApkName(String apkName) {
			this.apkName = apkName;
		}

		public String getApkName() {
			return this.apkName;
		}

		public void setApkSize(int apkSize) {
			this.apkSize = apkSize;
		}

		public int getApkSize() {
			return this.apkSize;
		}

		public void setApkmd5(String apkmd5) {
			this.apkmd5 = apkmd5;
		}

		public String getApkmd5() {
			return this.apkmd5;
		}

		public void setAppName(String appName) {
			this.appName = appName;
		}

		public String getAppName() {
			return this.appName;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public int getPriority() {
			return this.priority;
		}

		public void setVersionCode(String versionCode) {
			this.versionCode = versionCode;
		}

		public String getVersionCode() {
			return this.versionCode;
		}

		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}

		public String getPackageName() {
			return this.packageName;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUrl() {
			return this.url;
		}
	}
}
