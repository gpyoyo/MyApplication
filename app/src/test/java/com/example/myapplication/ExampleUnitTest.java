package com.example.myapplication;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.xml.transform.Source;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        assertEquals(4, 2 + 2);
    }
    @Test
    public void test1(){
        try {
            Socket socket = new Socket("www.baidu.com",80);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            outputStream.write("GET / HTTP/1.1\n".getBytes());
            outputStream.write("Host: www.baidu.com\n\n".getBytes());


            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }

//            int line = 0;
//            byte[] buff = new byte[1024];
//            while((line=inputStream.read(buff))!=-1){
//                String s = new String(buff);
//                System.out.println(s);
//            }

            inputStream.close();
            outputStream.close();
            socket.close();




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.baidu.com").get().build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.headers().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}