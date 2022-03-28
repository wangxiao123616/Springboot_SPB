package com.soft.spb.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MD5UtilTest {

    @Test
    void md5() {

        System.out.println(MD5Util.md5("11111111"));
    }

    @Test
    void verify() {
        System.out.println(MD5Util.verify("G18190406", "63de6a56ffa1eab9ca2a7a44c707222c"));
    }
}