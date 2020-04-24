package cn.zhangchg.leetcode.socket;

/*
 * 文件名：InvokeModel.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved.
 * 描述： InvokeModel.java
 * 修改人：peiyu
 * 修改时间：2017年3月17日
 * 修改内容：新增
 */

import java.io.Serializable;

/**
 * @author peiyu
 */
@SuppressWarnings("rawtypes")
public class InvokeModel implements Serializable {

    /**
     * 添加字段注释.
     */
    private static final long serialVersionUID = 1L;

    private String methodName;
    private String serviceName;
    private Object[] params;
    private Class[] paramsType;

    /**
     * 设置methodName.
     *
     * @return 返回methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置serviceName.
     *
     * @return 返回serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 设置params.
     *
     * @return 返回params
     */
    public Object[] getParams() {
        return params;
    }

    /**
     * 获取methodName.
     *
     * @param methodName 要设置的methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取serviceName.
     *
     * @param serviceName 要设置的serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * 获取params.
     *
     * @param params 要设置的params
     */
    public void setParams(Object[] params) {
        this.params = params;
    }

    /**
     * 设置paramsType.
     *
     * @return 返回paramsType
     */
    public Class[] getParamsType() {
        return paramsType;
    }

    /**
     * 获取paramsType.
     *
     * @param paramsType 要设置的paramsType
     */
    public void setParamsType(Class[] paramsType) {
        this.paramsType = paramsType;
    }
}