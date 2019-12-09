package com.wdq.nio.mando.codec;

/**
 * @author wudq
 * @date 2019/11/20
 */
public final class Header {

    /** manda消息的校验码*/
    private int crcCode = 0xabef0101;

    /** 消息长度，包含消息头和消息体*/
    private int length;

    /** 会话id，集群节点内唯一，会话id生成器生成*/
    private Long sessionId;

    /** 消息id*/
    private Byte type;

    public Header() {
    }

    public int getCrcCode() {
        return crcCode;
    }

    public final void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public int getLength() {
        return length;
    }

    public final void setLength(int length) {
        this.length = length;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Byte getType() {
        return type;
    }

    public final void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Header{" +
            "crcCode=" + crcCode +
            ", length=" + length +
            ", sessionId=" + sessionId +
            ", type=" + type +
            '}';
    }
}
