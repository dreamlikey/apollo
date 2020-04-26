package com.wdq.basic;

/**
 * @author wudq
 * @date 2020/4/15
 * 位运算处理状态的工具类
 *
 * 1.位与
 * A & B : A和B对应的二进制数位都为1时,结果才为1,其他情况为0.
 * A     =  001101 // 13
 * B     =  100101 // 37
 * A & B =  000101 // 5
 * 2.位或
 * A | B : A和B对应的二进制数位都为0时，结果才为0,其他情况为1.
 * A     =  001101 // 13
 * B     =  100101 // 37
 * A | B =  101101 // 45
 * 3.位非
 * ~A : 将a的二进制表示每一位进行取反操作,0变1,1变0.相当于相反数 - 1
 * A     =  001101 // 13
 * ~A    =  11111111111111111111111111110010 // int32位,补码表示,第一位为符号位
 * // 根据上诉补码转原码为
 * //       10000000000000000000000000001110 // -14
 * 4.左移操作
 * A << B：将A的二进制表示的每一位向左移B位， 左边超出的位截掉，右边不足的位补0。在取值范围内,移动一位相当于乘2.
 * A     =  001101 // 13
 * A << 1 = 011010 // 26
 */
public class 状态标识位运算 {

    //A:语文 B:数学 C:英语 D:物理 E:化学 F:生物 G:历史 H:地理

    // 二进制表示 0001 没有交任何作业
    public static final int NONE              = 1<<0;   //默认
    public static final int CHINESE           = NONE<<1;//语文
    public static final int MATH              = NONE<<2;//数学
    public static final int ENGLISH           = NONE<<3;//英语
    public static final int PHYSICS           = NONE<<4;//物理
    public static final int CHEMISTRY         = NONE<<5;//化学
    public static final int BIOLOGY           = NONE<<6;//生物
    public static final int HISTORY           = NONE<<7;//历史
    public static final int GEOGRAPHY         = NONE<<8;//地理

    public static final int ALL =NONE|CHINESE|MATH|ENGLISH|PHYSICS|CHEMISTRY|BIOLOGY|HISTORY|GEOGRAPHY;

    /**
     * @param status 所有状态值
     * @param value  需要判断状态值
     * @return 是否存在
     */
    public static boolean hasStatus(long status, long value) {
        return (status & value) != 0;
    }

    /**
     * @param status 已有状态值
     * @param value  需要添加状态值
     * @return 新的状态值
     */
    public static long addStatus(long status, long value) {
        if (hasStatus(status, value)) {
            return status;
        }
        return (status | value);
    }

    /**
     * @param status 已有状态值
     * @param value  需要删除状态值
     * @return 新的状态值
     */
    public static long removeStatus(long status, long value) {
        if (!hasStatus(status, value)) {
            return status;
        }
        return status ^ value;
    }

    /**
     * 是否交了含有全部状态
     * @param status
     * @return
     */
    public static boolean hasAllStatus(long status) {
        return (status & ALL) == ALL;
    }

    public static void main(String[] args) {

        long status = addStatus(NONE, CHINESE);
        System.out.println("小明交了语文作业:" + status);

        status = addStatus(status, PHYSICS);
        System.out.println("小明又交了物理作业:" + status);

        status = addStatus(status, HISTORY);
        System.out.println("小明还交了历史作业:" + status);

        status = removeStatus(status, HISTORY);
        System.out.println("小明撤销了历史作业:" + status);

        System.out.println("小明是否交了语文作业:" + hasStatus(status, CHINESE));
        System.out.println("小明是否交了历史作业:" + hasStatus(status, HISTORY));
        System.out.println("小明是否交了生物作业:" + hasStatus(status, BIOLOGY));
        System.out.println("小明是否交了全部作业:" + hasAllStatus(status));
    }
}
