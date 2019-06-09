package com.wd.tech.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Author: zhang
 * @Date: 2019/6/9 13:06
 * @Description:
 */
@Entity
public class MyId {
    String userId;
    String sessionId;
    @Generated(hash = 1949955962)
    public MyId(String userId, String sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
    }
    @Generated(hash = 2141322426)
    public MyId() {
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getSessionId() {
        return this.sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
