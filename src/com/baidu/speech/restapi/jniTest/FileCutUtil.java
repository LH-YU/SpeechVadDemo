package com.baidu.speech.restapi.jniTest;

import java.io.File;

public class FileCutUtil {  
	  
    static {  
    	System.loadLibrary("libgcc_s_seh-1");
    	System.loadLibrary("libstdc++-6");
    	System.loadLibrary("libwinpthread-1");
    	System.loadLibrary("libFileCutUtil");
    }  
      
    private int mObject;  
    
    public FileCutUtil(char[] filename,char[] output_filename_prefix,char[] output_dir) {  
//    	setFile(filename, output_filename_prefix);  
    }  
      
    public native int setFile(char[] filename,char[] output_filename_prefix,char[] output_dir);  
    protected native void finalize();  
      
    public static void main(String[] args) {  
    	
    	//先创建相应的目录 再传参目录
    	String file = "16k_1.pcm";
    	String realpath = "output_pcm\\"+file.substring(0, file.length()-4);
        File dir = new File(realpath);          
        if(!dir.exists()){  
            dir.mkdirs();  
        } 
    	
    	String url = "pcm/16k_1.pcm";
    	String output = realpath;
    	
    	char[] filename = url.toCharArray();
    	char[] output_filename_prefix = file.toCharArray();
    	char[] output_dir = output.toCharArray();
    	
    	FileCutUtil fileCut = new FileCutUtil(filename, output_filename_prefix,output_dir);  
    	int res = fileCut.setFile(filename, output_filename_prefix,output_dir);

    	System.out.println("执行结束，res:"+res);  
    }  
}
