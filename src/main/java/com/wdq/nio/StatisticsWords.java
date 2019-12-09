package com.wdq.nio;

import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RecursiveTask;

/**
 * 统计单词在文件中出现的次数
 *
 * Fork/Join任务切割
 *
 */
public class StatisticsWords extends RecursiveTask<Integer> {

//    private static final String path = "d:\\Users\\jiachao\\Desktop\\FKH临时文件\\test.txt";
    private static final String PATH = "D:\\mnt\\syslogs\\tomcat\\fkh-web-tms\\local_2018-12-04.log";
    private static final int SHARD_SIZE = 20 * 1024 * 1024; //20M
    private static final String KEY_WORD = "spring";

    static FileInputStream is;
    //文件大小（byte）
    static int fileSize;
    static {
        try {
            is = new FileInputStream(new File(PATH));
            fileSize = is.available();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int start;
    private int end;

    public static void main(String[] args) {
        try {
            System.out.println("fileSize:" +fileSize);
            long startTime = System.currentTimeMillis();
            long startNonTime = System.nanoTime();
            StatisticsWords statisticsWords = new StatisticsWords(0,fileSize);

//            char[] sourceChars = statisticsWords.channelFileReader();
//            char[] wordChars = KEY_WORD.toCharArray();
//            int count = statistics(sourceChars, wordChars);
//
//            long endTime = System.currentTimeMillis();
//            System.out.println("nio  " + KEY_WORD + " 出现次数:" + count + "  统计耗时：" + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();

            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask<Integer> res = pool.submit(statisticsWords);
            int count2 = res.get();

            long endTime = System.currentTimeMillis();
            long endNonTime = System.nanoTime();
            System.out.println(endNonTime - startNonTime);
            System.out.println("Fork  " + KEY_WORD + " 出现次数:" + count2 + "  统计耗时 ：" + (endTime - startTime) + " ms");
            pool.shutdown();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Runtime.getRuntime().gc();
        }


    }

    /**
     *
     * @param start
     * @param end    初始大小为fileSize
     */
    public StatisticsWords(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        char[] wordChars = KEY_WORD.toCharArray();
        int count = 0;
        boolean computeAble = (end - start) <= SHARD_SIZE ;
        //文件流分区小于 ByteBuffer容量，执行单词查找
        if (computeAble) {
//            System.out.println("start:"+start + "  end:"+end + "  computeAble:"+computeAble);
            char[] sourceChars = channelFileReader(start, end -start);
            count = statistics(sourceChars, wordChars);
        } else {//文件流分区大于ByteBuffer容量，切割小任务
            int mid = (start + end) / 2;
            StatisticsWords leftWordsTask  = new StatisticsWords(start, mid);
            StatisticsWords rightWordsTask  = new StatisticsWords(mid + 1, end);
            leftWordsTask.fork();
            rightWordsTask.fork();

            int left = leftWordsTask.join();
            int right = rightWordsTask.join();
            count = left + right;
        }
        return count;
    }

    /**
     * 通道读取文件
     * @return
     */
    public char[] channelFileReader() {
        // byteBuffer不能声明为成员变量，否者线程不安全  TODO: 2018/12/6
        ByteBuffer byteBuffer = ByteBuffer.allocate(300 * 1024 * 1024);
        FileChannel fileChannel = is.getChannel();
        //文件通道将文件写如缓冲区
        int res = -1;
        try {
            res = fileChannel.read(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //filp() 字面意思：反转buffer
        //作用：将buffer的指针指向buffer起始位置，这样就可以读取buffer中的内容了，
        //      若不调用此方法读取不到buffer中的内容，因为是从buffer结尾位置开始读
        byteBuffer.flip();
        if (res != -1) {
            CharBuffer charBuffer = Charset.forName("UTF-8").decode(byteBuffer);
            char[] chars = charBuffer.array();
            return chars;
        }
        return null;
    }

    /**
     *
     * 1、nio 文件通道读取文件
     * 2、内存映射buffer
     * 3、映射buffer写入ByteBuffer缓冲流
     * @return
     */
    public char[] channelFileReader(int offset, int length) {
        // byteBuffer不能声明为成员变量，否者线程不安全，length不完全相同，造成BufferUnderflowException TODO: 2018/12/6
        ByteBuffer byteBuffer;
        byte[] bytes = new byte[length];
        FileChannel fileChannel = is.getChannel();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        reader.readLine();
        MappedByteBuffer mappedByteBuffer = null;
        try {
            // MappedByteBuffer与ByteBuffer的关系 TODO: 2018/12/6
            mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, offset, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byteBuffer = mappedByteBuffer.get(bytes, 0, length);
        //文件通道将文件写如缓冲区
        //filp() 字面意思：反转buffer
        //作用：将buffer的指针指向buffer起始位置，这样就可以读取buffer中的内容了，
        //      若不调用此方法读取不到buffer中的内容，因为是从buffer结尾位置开始读
        byteBuffer.flip();
        long start = System.currentTimeMillis();
        CharBuffer charBuffer = Charset.forName("UTF-8").decode(byteBuffer);

        long end = System.currentTimeMillis();
        char[] chars = charBuffer.array();
        System.out.println(end - start + "ms");

        Runtime.getRuntime().gc();
        return chars;
    }


    /**
     * 暴力匹配
     * @param sourceChars
     * @param wordChars
     * @return
     */
    public static int statistics(char[] sourceChars, char[] wordChars) {
        int i = 0;
        int count = 0;
        // TODO: sspring无法匹配，算法有待完善 2018/12/5
        for (char strChar : sourceChars) {
            if(strChar != wordChars[i]) {
                i = 0;
                continue;
            }
            if (++i == wordChars.length) {
                i = 0;
                ++count;
            }
        }
        return count;
    }

    /**
     * KMP
     * @return
     */
    public int KmpStr() {
        return 0;
    }
}


/**
 * 统计单词在文件中出现的次数
 */
class StatisticsWords$2 {

    //    private static final String path = "d:\\Users\\jiachao\\Desktop\\FKH临时文件\\test.txt";
    private static final String path = "D:\\mnt\\syslogs\\tomcat\\fkh-web-tms\\local_2018-12-04.log";
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String keyword = "spring";
        //        statistics(keyword);
        File file = new File(path);
        int count = 0;
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (true) {
                String text = bufferedReader.readLine();
                if (null == text) {
                    break;
                }
//                System.out.println(line++ + "行");
                count = count + statistics(text, keyword);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("io   " + keyword+" 出现次数:" + count + "  统计耗时：" + (endTime - startTime) + "ms");

    }


    /**
     * 暴力匹配
     * @param text
     * @param word
     * @return
     */
    public static int statistics(String text, String word) {
        //        String str = "sssspringsssssawerrwerspinspring3fsqw3spring4";
        char[] strChars = text.toCharArray();
        char[] wordChars = word.toCharArray();
        int i = 0;
        int count = 0;
        for (char strChar : strChars) {
            if(strChar != wordChars[i]) {
                i = 0;
                continue;
            }
            if (++i == wordChars.length) {
                i = 0;
                ++count;
            }
        }
//        System.out.println("总计：" + count);
        return count;
    }

    /**
     * KMP
     * @return
     */
    public int KmpStr() {
        return 0;
    }
}

