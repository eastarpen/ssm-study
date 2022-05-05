package com.eastarpen.demo06.utils;

import com.alibaba.fastjson.JSON;

public class OperationResult {

    private String operation;

    private boolean success;

    public OperationResult() { }
    public OperationResult(String operation, boolean success) {
        this.operation = operation;
        this.success = success;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
