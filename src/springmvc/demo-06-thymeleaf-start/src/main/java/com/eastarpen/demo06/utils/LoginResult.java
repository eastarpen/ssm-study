package com.eastarpen.demo06.utils;

import com.alibaba.fastjson.JSON;

public class LoginResult {

    private String user;

    private int resultCode;

    private String msg;

    public LoginResult(int resultCode, String user) {
        this.user = user;
        this.resultCode = resultCode;
        switch (resultCode) {
            case Constant.LOGIN_SUCCESS:
                this.msg = Constant.LOGIN_SUCCESS_INFO;
                break;
            case Constant.NO_USERNAME:
                this.msg = Constant.NO_USERNAME_INFO;
                break;
            case Constant.PASSWORD_WRONG:
                this.msg = Constant.PASSWORD_WRONG_INFO;
                break;
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
