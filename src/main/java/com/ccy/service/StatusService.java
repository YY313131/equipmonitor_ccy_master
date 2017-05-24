package com.ccy.service;

import com.ccy.bean.ParameterStatus;

import java.util.List;
import java.util.Map;

/**
 * Created by dsz on 17/5/24.
 *
 * 用来获取参数状态的服务
 */
public interface StatusService {

    /**
     * 根据子系统id获得 ParameterId对应最新的状态
     * @param subSystemId
     * @return
     */
    Map<Integer, ParameterStatus> getNowParameterStatus(int subSystemId);


    /**
     * 通过子系统id 和参数id获取最新参数状态
     * @param subSystemId
     * @param parameterId
     * @return
     */
    ParameterStatus getNowParameterStatus(int subSystemId, int parameterId);


    /**
     * 获取一天的异常状态
     * @param subSystemId
     * @param parameterId
     * @param timeStamp
     * @return
     */

    List<ParameterStatus> getDayAnnormalStatus(int subSystemId, int parameterId, long timeStamp);








}
