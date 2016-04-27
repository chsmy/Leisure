package com.chs.leisure.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Title: FileUtils.java
 * Description: 对sd卡的文件相关操作
 * @author ysq
 */
public class FileUtils {

	/**
	 * 判断sdcrad是否已经安装
	 * @return boolean true安装 false 未安装
	 */
	public static boolean isSDCardMounted(){
		return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
	}
	
	/**
	 * 得到sdcard的路径
	 * @return
	 */
	public static String getSDCardRoot(){
		System.out.println(isSDCardMounted()+ Environment.getExternalStorageState());
		if(isSDCardMounted()){
			return Environment.getExternalStorageDirectory().getAbsolutePath();
		}
		return "";
	}
	/**
	 * 创建文件的路径及文件
	 * @param path 路径，方法中以默认包含了sdcard的路径，path格式是"/path...."
	 * @param filename 文件的名称
	 * @return 返回文件的路径，创建失败的话返回为空
	 */
	public static String createMkdirsAndFiles(String path, String filename) {
		if (TextUtils.isEmpty(path)) {
			throw new RuntimeException("路径为空");
		}
		path = getSDCardRoot()+path;
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.mkdirs();
			} catch (Exception e) {
				throw new RuntimeException("创建文件夹不成功");
			}
		} 
		File f = new File(file, filename);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException("创建文件不成功");
			}
		}
		return f.getAbsolutePath();
	}
	
	/**
	 * 把内容写入文件
	 * @param path 文件路径
	 * @param text 内容
	 */
	public static void write2File(String path, String text, boolean append){
		BufferedWriter bw = null;
		try {
			//1.创建流对象
			bw = new BufferedWriter(new FileWriter(path,append));
			//2.写入文件
			bw.write(text);
			//换行刷新
			bw.newLine();
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//4.关闭流资源
			if(bw!= null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 删除文件
	 * @param path
	 * @return
	 */
	public static boolean deleteFile(String path){
		if(TextUtils.isEmpty(path)){
			throw new RuntimeException("路径为空");
		}
		File file = new File(path);
		if(file.exists()){
			try {
				file.delete();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 获取文件夹大小
	 * @param file File实例
	 * @return long
	 */
	public static long getFolderSize(java.io.File file){

		long size = 0;
		try {
			java.io.File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++)
			{
				if (fileList[i].isDirectory())
				{
					size = size + getFolderSize(fileList[i]);

				}else{
					size = size + fileList[i].length();

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return size/1048576;
		return size;
	}

	/**
	 * 转换文件大小
	 *
	 * @param fileS
	 * @return
	 */
	public static String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

	//递归删除文件及文件夹
	public static void deleteFiles(File file) {
		if (file.isFile()) {
			file.delete();
			return;
		}

		if(file.isDirectory()){
			File[] childFiles = file.listFiles();
			if (childFiles == null || childFiles.length == 0) {
				file.delete();
				return;
			}

			for (int i = 0; i < childFiles.length; i++) {
				deleteFiles(childFiles[i]);
			}
			file.delete();
		}
	}

	/**
	 * 删除指定目录下文件及目录
	 * @param deleteThisPath
//	 * @param filepath
	 * @return
	 */
	public static void deleteFolderFile(String filePath, boolean deleteThisPath) {
		if (!TextUtils.isEmpty(filePath)) {
			try {
				File file = new File(filePath);
				if (file.isDirectory()) {// 处理目录
					File files[] = file.listFiles();
					for (int i = 0; i < files.length; i++) {
						deleteFolderFile(files[i].getAbsolutePath(), true);
					}
				}
				if (deleteThisPath) {
					if (!file.isDirectory()) {// 如果是文件，删除
						file.delete();
					} else {// 目录
						if (file.listFiles().length == 0) {// 目录下没有文件或者目录，删除
							file.delete();
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
