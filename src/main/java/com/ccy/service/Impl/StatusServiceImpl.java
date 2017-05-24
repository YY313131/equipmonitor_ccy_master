package com.ccy.service.Impl;

import com.ccy.bean.ParameterStatus;
import com.ccy.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dsz on 17/5/24.
 */
@Service
public class StatusServiceImpl implements StatusService{

    public Map<Integer, ParameterStatus> getNowParameterStatus(int subSystemId) {
        return null;
    }

    public ParameterStatus getNowParameterStatus(int subSystemId, int parameterId) {
        return null;
    }

    public List<ParameterStatus> getDayAnnormalStatus(int subSystemId, int parameterId, long timeStamp) {
        //TODO 测试实现 后期加底层实现
        List<ParameterStatus> parameterStatuses=new ArrayList<ParameterStatus>();
        for(int i=0;i<10;i++){
            ParameterStatus parameterStatus=new ParameterStatus(new Date());
            parameterStatus.setDetectStatus(-1);
            parameterStatus.setDeviceStatus(-1);
            parameterStatuses.add(parameterStatus);
        }


        return parameterStatuses;
    }
}
