package com.gw.seckill.constants;

public class ConstantClassFunction {
    //加密的哈希次数
    private static final Integer HASH_ITERATIONS = 2;
    //加密算法
    private static final String ALGORITHM_NAME = "md5";
    //游客权限
    private static final String VISITOR = "2";
    //添加用户时的默认密码
    private static final String DEFAULT_PASSWORD = "123456";
    //文件上传服务器地址
    private static final String FILE_UPLOAD_URL = "http://120.79.214.81/";
    private static final String ACTIVATE_URL = "http://127.0.0.1:6689/";

    public static Integer getHASH_ITERATIONS(){
        return HASH_ITERATIONS;
    }
    public static String getALGORITHM_NAME(){
        return ALGORITHM_NAME;
    }
    public static String getVISITOR(){
        return VISITOR;
    }
    public static String getDEFAULT_PASSWORD(){
        return DEFAULT_PASSWORD;
    }
    public static String getFILE_UPLOAD_URL(){
        return FILE_UPLOAD_URL;
    }
    public static String getACTIVATE_URL(){
        return ACTIVATE_URL;
    }
}
