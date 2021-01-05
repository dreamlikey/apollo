package com.wdq.juc;

import org.openjdk.jol.info.ClassLayout;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * The second word of every object header. Points to another object
 * (a metaobject) which describes the layout and behavior of the original object.
 * For Java objects, the "klass" contains a C++ style "vtable".
 *
 * @author wudq
 * @date 2021/01/05
 */
public class ClassHeader {
    byte i;
    short s;
    long j;
    int k,l;
    char c;
    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new ClassHeader());
        System.out.println(layout.toPrintable());
    }
}
