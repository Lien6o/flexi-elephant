package com.flexi.elephant.rpc.netty.transport.command;

/**
 * 请求头
 */
public class Header {
    /**
     * 请求id
     */
    private int requestId;
    /**
     * 版本
     */
    private int version;
    /**
     * 类型
     */
    private int type;

    public Header() {}
    public Header(int type, int version, int requestId) {
        this.requestId = requestId;
        this.type = type;
        this.version = version;
    }
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getType() {
        return type;
    }

    public int length() {
        return Integer.BYTES + Integer.BYTES + Integer.BYTES;
    }

    public void setType(int type) {
        this.type = type;
    }
}
