package com.wdq.nio.mando.codec;

import java.io.*;

/**
 * mando协议消息定义
 * @author wudq
 * @date 2019/11/20
 */
public final class MandoMessage implements Serializable {

    private Header header;

    private Object body;

    public MandoMessage() {
    }

    public Header getHeader() {
        return header;
    }

    public final void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public final  void setBody(Object body) {
        this.body = body;
    }
}
