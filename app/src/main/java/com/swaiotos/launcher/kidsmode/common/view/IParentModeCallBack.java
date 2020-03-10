package com.swaiotos.launcher.kidsmode.common.view;

/**
 * @ Created on: 2020/1/8
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public interface IParentModeCallBack {
    /**
     * 输入答案正确，回调此方法
     * */
    void rightAnswer();

    /**
     * 输入答案错误，回调此方法
     * */
    void wrongAnswer();
}
