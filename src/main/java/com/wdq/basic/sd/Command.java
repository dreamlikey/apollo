package com.wdq.basic.sd;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *  命令模式
 * @author wudq
 * @date 2021/08/04
 */
public interface Command {
    Integer execute();
}


class AddCommand implements Command{
    private int a;
    private int b;

    public AddCommand(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer execute() {
        return this.a + this.b;
    }
}

/** 乘法 */
class MultiplyCommand implements Command{
    private int a;
    private int b;

    public MultiplyCommand(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer execute() {
        return this.a * this.b;
    }
}
