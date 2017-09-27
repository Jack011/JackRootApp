package com.jack.rootapp.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期与时间工具类
 * Created by Administrator on 2017-09-25.
 */

public class DataUtils {

    private DataUtils()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }
    /**
     * 得到年月日的"日"
     */
    private String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("dd");
        return dateFm.format(date);
    }
}
