package com.exception;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-07-17
 */
public class CompleteException {


    private void imooc1() throws Exception {
        throw new Exception("imooc1 has exception ...");
    }

    private void imooc2() throws Exception {
        try {
            imooc1();
        } catch (Exception ex) {
            throw new Exception("imooc2 has exception ...", ex);
        }
    }

    private void imooc3() throws Exception {
        try {
            imooc2();
        } catch (Exception ex) {
            throw new Exception("imooc3 has exception ...", ex);
        }
    }

    public static void main(String[] args) {
        try {
            new CompleteException().imooc3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
