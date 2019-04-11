package com.lr.bridge;

import com.lr.bridge.util.MD5Util;

import java.util.Random;

/**
 * Created by ALTERUI on 2019/4/11 10:01
 */
public class BridgeTest {
    public static void main(String[] args) {
        Random random = new Random();

        String res = MD5Util.getMD5(String.valueOf(random.nextInt(100)));


        System.out.println(res);

    }
}
