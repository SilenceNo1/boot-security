package com.boot.security.server.utils;

/**
 * 邀请码生成器，算法原理：<br/>
 * 1) 获取id: 1127738 <br/>
 * 2) 使用自定义进制转为：gpm6 <br/>
 * 3) 转为字符串，并在后面加'o'字符：gpm6o <br/>
 * 4）在后面随机产生若干个随机数字字符：gpm6o7 <br/>
 * 转为自定义进制后就不会出现o这个字符，然后在后面加个'o'，这样就能确定唯一性。最后在后面产生一些随机字符进行补全。<br/>
 * 
 * @author jiayu.qiu
 */
public class ShareCodeUtil {

    /** 自定义进制(0,1没有加入,容易与o,l混淆) */
    private static final char[] R = new char[] { 'Q', 'W', 'E', 'A', 'S', 'D', 'Z', 'X', 'C', 'P', 'I', 'K', 'M', 'J', 'U', 'F', 'R', 'V', 'Y', 'L', 'T', 'N', 'B', 'G', 'H', 'O' };

    /** (不能与自定义进制有重复) */
    private static final char B = 'o';

    /** 进制长度 */
    private static final int BINLEN = R.length;

    /** 序列最小长度 */
    private static final int S = 7;

    /** 序列最小长度 */
    private static final int N = 8;

    /**
     * 根据ID生成六位随机码
     * 
     * @param id ID
     * @return 随机码
     */
    public static String toSerialCode(int id) {
        int index = (int) (Math.random() * (R.length));
        String str = R[index] + "";
        Integer code = (int) ((Math.random() * 9 + 1) * 100000);
        str += code;
        if (id == 6) {
            if (str.length() > S) {
                str = str.substring(0, S);
            }
        } else {
            if (str.length() > N) {
                str = str.substring(0, N);
            }
        }

        return str;
    }
}
