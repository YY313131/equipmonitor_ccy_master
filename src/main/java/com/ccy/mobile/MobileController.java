package com.ccy.mobile;

import com.ccy.bean.Parameter;
import com.ccy.bean.ParameterStatus;
import com.ccy.dto.CollectedValue;
import com.ccy.mobile.bean.*;
import com.ccy.service.CollectedDataService;
import com.ccy.service.ParameterService;
import com.ccy.service.StatusService;
import com.ccy.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/22.
 */
@Controller
@RequestMapping("/mobile")
public class MobileController {

    private final Logger logger = LoggerFactory.getLogger(MobileController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CollectedDataService collectedDataService;

    @Autowired
    private ParameterService parameterService;

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public MobileResult<UserInfo> mobileLogin(String username, String password) {
        String loginstate = userService.checkUserState(username, password);
        MobileResult<UserInfo> mobileResult;
        if (loginstate.equals("userNameNotExist") || loginstate.equals("passwordWrong")) {
            mobileResult = new MobileResult<UserInfo>(false, "login fail");
        } else {
            mobileResult = new MobileResult<UserInfo>(true, new UserInfo(username));
        }

        return mobileResult;
    }

    @RequestMapping(value = "/getSubsystemInfo", method = RequestMethod.GET)
    @ResponseBody
    public MobileResult<SubsystemInfo> getSubsystemInfo(int subsystemId) {

        Map<Integer, CollectedValue> cmap =
                collectedDataService.getTopOnes(subsystemId);
        //参数的固有属性 上下限 名称等信息
        List<Parameter>pnlist=parameterService.getBySubsystemId(subsystemId);

        //TODO 现在没有参数状态需要后期加入

        SubsystemInfo subsystemInfo =
                new SubsystemInfo(subsystemId,cmap,null,pnlist);

        return  new MobileResult<SubsystemInfo>(true, subsystemInfo);
    }

    @RequestMapping(value = "/getParameterInfo", method = RequestMethod.GET)
    @ResponseBody
    public MobileResult<ParameterInfo> getParameterInfo(int subsystemId, int parameterId) {

        CollectedValue collectedValue =
                collectedDataService.getTopOne(subsystemId, parameterId);
        Parameter parameter=parameterService.getById(parameterId);
        MobileResult<ParameterInfo> mobileResult;
        if (collectedValue == null) {
            mobileResult = new MobileResult<ParameterInfo>(false, "acquire data fail");
        } else {
            ParameterInfo parameterInfo=new ParameterInfo();
            parameterInfo.setCollectedValue(collectedValue);
            parameterInfo.setParameterId(parameterId);
            if(parameter!=null){
                parameterInfo.setParameter(parameter);
            }
            mobileResult=new MobileResult<ParameterInfo>(true,parameterInfo);
        }
        return mobileResult;
    }

    @RequestMapping(value = "/getHistoryParamterValue", method = RequestMethod.GET)
    @ResponseBody
    public MobileResult<HistoryParameterValue> getHistoryParamterValue(
            int subsystemId, int parameterId,long timeStamp
       ) {
        logger.info("getHistoryParamterValue");
        MobileResult<HistoryParameterValue> mobileResult;
       List<CollectedValue>collectedValues= collectedDataService.getDayValueById(subsystemId,parameterId,timeStamp);
        if(collectedValues==null){
            mobileResult=new MobileResult<HistoryParameterValue>(false,"acquire data fail");
        }else {
            HistoryParameterValue hisPv=new HistoryParameterValue(parameterId,collectedValues);
            mobileResult=new MobileResult<HistoryParameterValue>(true,hisPv);
        }
        return mobileResult;
    }

    @RequestMapping(value = "/getHistoryAbnormalValue", method = RequestMethod.GET)
    @ResponseBody
    public MobileResult<HistoryAbnormalValue> getHistoryAbnormalValue(
            int subsystemId, int parameterId,long timeStamp)  {

        MobileResult<HistoryAbnormalValue> mobileResult;

        List<ParameterStatus> abnoramls =
                statusService.getDayAnnormalStatus(subsystemId,parameterId,timeStamp);
        if(abnoramls==null){
            mobileResult=new MobileResult<HistoryAbnormalValue>(false,"acquire data fail");
        }else{
            HistoryAbnormalValue abnormalStatus=new HistoryAbnormalValue(parameterId,abnoramls);
            mobileResult=new MobileResult<HistoryAbnormalValue>(true,abnormalStatus);
        }

        //TODO
        return mobileResult;
    }

}
