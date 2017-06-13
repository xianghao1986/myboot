package com.wtsd.dubbo;

import java.util.Map;

/**
 * Created by xianghao on 2017/5/26.
 */
public interface ServiceTest {

    public String test(String str);

    public void noRespTest(String str) throws InterruptedException;

    public Map<String, String> test2(Map<String, String > map);
}
