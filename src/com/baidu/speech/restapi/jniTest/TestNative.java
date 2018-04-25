package com.baidu.speech.restapi.jniTest;

public class TestNative {  
    
    public native void sayHello();
      
    public static void main(String[] args) {  
          
        System.loadLibrary("libNativeProject"); //载入dll库  
        TestNative test = new TestNative();  
        test.sayHello(); //调用本地方法</span>  
    }  
}  
