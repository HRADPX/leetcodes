package com.hr.utils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-20
 */
public abstract class ArrayUtils {

    private static final String DOLLAR = "$";
    private static final String EMPTY = "";
    private static final String COMMA = ",";
    private static final String LEFT = "[";
    private static final String LEFT_LEFT = "[[";
    private static final String RIGHT = "]";
    private static final String RIGHT_RIGHT = "]]";

    /**
     * 将 [[0,1,0],[1,2,1],[0,2,1]] 字符串转二维数组
     */
    public static int[][] parse2DoubleNums(String input) {
        input = StringUtils.trim(input);
        input = StringUtils.replace(input, LEFT_LEFT, EMPTY);
        input = StringUtils.replace(input, RIGHT_RIGHT, EMPTY);
        input = StringUtils.replace(input, "],[", DOLLAR);
        return Arrays.stream(StringUtils.split(input, DOLLAR))
                .map(s -> LEFT + s + RIGHT)
                .map(ArrayUtils::parse2Nums)
                .toArray(int[][]::new);
    }

    /**
     * 将 [0,1,0] 转一维数组
     */
    public static int[] parse2Nums(String input) {
        input = StringUtils.trim(input);
        input = StringUtils.replace(input, LEFT, EMPTY);
        input = StringUtils.replace(input, RIGHT, EMPTY);
        return Arrays.stream(StringUtils.split(input, COMMA))
                .map(NumberUtils::toInt)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
