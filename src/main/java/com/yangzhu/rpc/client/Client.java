package com.yangzhu.rpc.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author bgmyangzhu
 * @date 2024/11/8 20:29
 */
public class Client {
    private static final Integer PORT = 12345;

    
    public static void main(String[] args) throws IOException {
        run();
    }
    
    public static void run() throws IOException {
        Socket socket = new Socket("localhost",PORT);
        try(InputStream input = socket.getInputStream()){
            try(OutputStream output = socket.getOutputStream()){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
                BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

                //向服务器发送一行字符串
                String messageToSend = "Hello, Server!kjahsdf";
                writer.write(messageToSend);
                writer.newLine(); //添加换行符, 表示一行的结束
//                writer.flush(); 
                
                //接受用户输入
                Scanner scanner = new Scanner(System.in);
                
                while(true){
                    System.out.println(">>> ");
                    String s = scanner.nextLine();
                    writer.write(s);
                    writer.newLine();
                    writer.flush();
                    
                 
                    if (s.equals("bye")){
                        break;
                    }
                }
                
            }
            
        }
        
       
    }
}
