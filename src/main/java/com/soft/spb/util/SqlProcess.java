package com.soft.spb.util;

/**
 * @author nmy
 * @title: SqlProcess
 * @date 2022-04-19 17:44
 */
public class SqlProcess {

    public static boolean transactionalProcess(int... keys) {
        for (int key : keys) {
            if (key < 0) {
                return false;
            }
        }
        return true;
    }
}
