package com.domain.rwfile;

import java.io.*;

/**
 * Created by iwan on 16/1/9.
 */
public class ReadFile {
    public static void main(String[] args) {

        /**
         * 读取方法
         */

        //定义文件对象,
        //可以指定路径,这里用的时相对路径
        File file = new File("text.txt");
        //判断文件是否存在
        if(file.exists()){
            System.err.println("exist");


            try {



                //1 创建文件输入流(字节流)
                FileInputStream fis = new FileInputStream(file);
                //2 读取输入流(字符流)
                InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
                //3 缓冲读取InputStreamReader字节流
                BufferedReader br = new BufferedReader(isr);

                //临时存放读取到的一行数据
                String line;

                //开始读取
                //line等于读取到的一行数据,如果line读到的值不是空,说明还没有读完
                while ((line = br.readLine()) != null){
                    //输出一行数据
                    System.out.println(line);
                }

                //关闭流,先打开流后关闭
                br.close();
                isr.close();
                fis.close();




            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /**
         * 写入方法
         */

        try {


            //文件输出流
            //新建文件对象
            //arg:新文件名,
            File newfile = new File("newtext.txt");
            //文件输出流,如果文件不存在,会自动创建这个文件(字节流),如果文件存在会被完全覆盖,
            //FileOutputStream(arg1:字符串或者文件名, arg2:true追加写入,false覆盖写入)
            FileOutputStream fos = new FileOutputStream(newfile,true);
            //写入流(字符流)
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            //缓冲写入
            BufferedWriter bw = new BufferedWriter(osw);


            //开始一行一行写入
            bw.write("《赠东邻王十三》\n");
            bw.write("年代:唐 作者: 白居易\n");
            bw.write("携手池边月，开襟竹下风。\n");
            bw.write("驱愁知酒力，破睡见茶功。\n");
            bw.write("居处东西接，年颜老少同。\n");
            bw.write("能来为伴否？伊上作渔翁。\n");


            //任务完成关闭流,先创建的后关闭
            bw.close();
            osw.close();
            fos.close();

            System.out.println("写入完成");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
