package com.wdq.basic;

/**
 * @author wudq
 * @date 2020/4/15 0015
 * @Description: TODO
 */
public class LogBitStatus {

    public static final    int INIT              = 1<<0;   //默认
    public static volatile int LOG_STATUS        = INIT;   //日志状态
    public static volatile int BACKUP_STATUS     = INIT;   //备份状态
    public static final    int WAYBILL           = INIT<<1;//运单
    public static final    int WAYBILLTMS        = INIT<<2;//货主运单
    public static final    int WAYBILLCAR        = INIT<<3;//运单车辆

    public static final int ALL = INIT|WAYBILL|WAYBILLTMS|WAYBILLCAR;

    /**
     * 检查状态
     * @param value
     * @return
     */
    public static boolean hasStatus(int status, int value) {
        return (status & value) != 0;
    }

    /**
     * 添加日志打印状态
     * @param value  需要添加状态值
     * @return 新的状态值
     */
    public static void addLogStatus(int value) {
        if (hasStatus(LOG_STATUS,value)) {
            return;
        }
        LOG_STATUS = LOG_STATUS | value;
    }

    /**
     * 添加备份状态
     * @param value  需要添加状态值
     * @return 新的状态值
     */
    public static void addBackStatus( int value) {
        if (hasStatus(BACKUP_STATUS,value)) {
            return;
        }
        BACKUP_STATUS = BACKUP_STATUS | value;
    }

    public static void main(String[] args) {
        System.out.println("all："+ALL);
        addBackStatus(WAYBILL);
        System.out.println("开启运单日志："+BACKUP_STATUS);
        addBackStatus(WAYBILLTMS);
        System.out.println("开启货主运单日志："+BACKUP_STATUS);
        addBackStatus(WAYBILLCAR);
        System.out.println("开启运单车辆日志："+BACKUP_STATUS);


        System.out.println("是否打印了运单日志:" + hasStatus(BACKUP_STATUS,WAYBILL));
        System.out.println("是否打印了 货主运单日志:" + hasStatus(BACKUP_STATUS,WAYBILLTMS));
        System.out.println("是否打印了运单车辆:" + hasStatus(BACKUP_STATUS,WAYBILLCAR));

    }

}
