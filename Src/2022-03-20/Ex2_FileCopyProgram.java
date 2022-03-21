package org.zerock;

import java.io.*;

public class Ex2_FileCopyProgram {
    public static void main(String[] args) throws Exception {

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream("C://zzz//https://img.etoday.co.kr/pto_db/2017/11/20171121043733_1154211_600_600.jpg");
            out = new FileOutputStream("dialia.jpg");

            byte[] buffer = new byte[10000];

            while (true) {

                int data = in.read(buffer);
                System.out.println(data);
                if (data == -1) {
                    break;
                }
                out.write(data);
            }//end while

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if( in != null){
                try {
                    in.close();
                } catch (Exception e) {}
                try {
                    out.close();
                } catch (Exception e) {}
            }
        }//end finally
    }//end main
}
