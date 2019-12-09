package com.wdq.nio.mando.codec;

/**
 * 消息类型
 * @author wudq
 * @date 2019/11/25
 */
public enum MessageType {
    SERVICE_REQ((byte) 0),
    SERVICE_RESP((byte) 1),
    ONE_WAY((byte) 2),
    LOGIN_REQ((byte) 3),
    LOGIN_RESP((byte) 4),
    HEARTBEAT_REQ((byte) 5),
    HEARTBEAT_RESP((byte) 6);

    public byte type;

    MessageType(byte type) {
        this.type = type;
    }
}
