package com.lr.bridge;

import com.lr.bridge.util.MD5Util;

import java.util.Random;

/**
 * Created by ALTERUI on 2019/4/11 10:01
 */
public class BridgeTest {
    public static void main(String[] args) {

        String string = "5-10";
        String[] split = string.split("-");

        System.out.println(split[0]);
        System.out.println(split[1]);

    }
}
