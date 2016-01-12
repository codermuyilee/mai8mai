package com.mai8mai.spider.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class DownloadResource {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        download("http://7bv7rb.com1.z0.glb.clouddn.com/99e25c84731e3b33ea184cffa5e0a69d.jpg?imageView2/2/w/224/h/224", "51bi32.jpg","D:\\resources\\image");
    }

    public static void download(String urlString, String filename,String savePath) throws Exception {
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024*100];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }


}

