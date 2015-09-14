package com.wangmin.utils;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class DialogUtils {
	public static void showMessageDialog(Component component, String messsage,
			DialogType type) {
		switch (type) {
		case NORMAL:
			JOptionPane.showMessageDialog(component, messsage);
			break;
		default:
			break;
		}
	}

	public static int showYesNoDialog(Component component, String msg,
			DialogType type) {
		switch (type) {
		case NORMAL:
			int showConfirmDialog = JOptionPane.showConfirmDialog(component,
					msg);
			return showConfirmDialog;
		default:
			break;
		}
		return 0;

	}

	public enum DialogType {
		NORMAL
	}

	public static File getFile(Component component, final String selection,
			String path) {
		JFileChooser jfc = null;
		if (path != null) {
			jfc = new JFileChooser(path);
		} else {
			jfc = new JFileChooser();
		}
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (selection != null) {
			jfc.setFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return null;
				}

				@Override
				public boolean accept(File f) {
					return f.isDirectory() || f.getName().endsWith(selection);
				}
			});
		}
		int showDialog = jfc.showDialog(component, "Ñ¡Ôñ");
		File file = null;
		if (showDialog == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
		}
		return file;
	}
}
