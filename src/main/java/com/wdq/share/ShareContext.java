package com.wdq.share;

import java.io.*;

/**
 * @author wudq
 * @date 2019/1/24 002421
 * @Description: 分享内容
 */
public class ShareContext implements Serializable {

    /**分享者token */
    private String Title;
    /**分享链接 */
    private String url;
    /**内容描述 */
    private String content;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ShareContext{" +
            "Title='" + Title + '\'' +
            ", url='" + url + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
