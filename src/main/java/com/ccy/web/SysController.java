package com.ccy.web;

import com.ccy.bean.Parameter;
import com.ccy.dto.CollectedValue;
import com.ccy.dto.CollectedValueDto;
import com.ccy.service.CollectedDataService;
import com.ccy.service.ParameterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by caihanbin on 2017/4/30.
 */
@Controller
public class SysController {
    @Autowired
    private CollectedDataService collectedDataService;
    @Autowired
    private ParameterService parameterService;

    /**
     * 用于时间格式化，将字符串转化成date类型
     */
    private DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private DateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /**
     * 用于将List<T>转化成json字符串
     */
    private ObjectMapper mapper=new ObjectMapper();
    /**
     * 按时间查询子系统1的参数值，绘制曲线
     * 按时间显示参数表格
     * @return
     */
    @RequestMapping("/valueListBetweenDate")
    @ResponseBody
    public List<Double> getListBetweenDate(int subsystemId, int parameterId, String beginTime, String endTime) throws ParseException {
        Date beginTime1=sdf.parse(beginTime);
        Date endTime1=sdf.parse(endTime);
        List<CollectedValue> collectedValues=collectedDataService.getBetween(subsystemId,parameterId,beginTime1,endTime1);
        if (collectedValues==null){
            return null;
        }
        List<Double> list=new ArrayList<Double>();
        for (CollectedValue collectedValue:collectedValues){
            list.add(collectedValue.getValue());
        }
        return list;
    }
    @RequestMapping("/valueListAfterDate")
    @ResponseBody
    public List<Double> getListAfterDate(int subsystemId, int parameterId, String beginTime) throws ParseException {
        List<CollectedValue> collectedValues=collectedDataService.getAfter(subsystemId,parameterId,
                sdf.parse(beginTime));
        if (collectedValues==null){
            return null;
        }
        List<Double> list=new ArrayList<Double>();
        for (CollectedValue collectedValue:collectedValues){
            list.add(collectedValue.getValue());
        }
        return list;
    }
    @RequestMapping("/valueTable")
    @ResponseBody
    public String getTable(int subsystemId, int parameterId, String beginTime) throws ParseException, JsonProcessingException {
        List<CollectedValueDto> collectedValueDtos=new ArrayList<CollectedValueDto>();
        List<CollectedValue> collectedValues=collectedDataService.getAfter(subsystemId,parameterId,
                sdf.parse(beginTime));
        if (collectedValues==null){
            return null;
        }
        for (CollectedValue collectedValue:collectedValues){
            CollectedValueDto collectedValueDto=new CollectedValueDto();
            collectedValueDto.setSensorId("sys"+subsystemId+"_"+parameterId);
            collectedValueDto.setValue(collectedValue.getValue());
            collectedValueDto.setCurrentTime(sdf1.format(collectedValue.getTime()));
            collectedValueDto.setState(checkState(subsystemId,parameterId,collectedValue.getValue()));
            collectedValueDtos.add(collectedValueDto);
        }
        String jsonList=mapper.writeValueAsString(collectedValueDtos);
        System.out.println(jsonList);
        return jsonList;
    }
    /**
     * 参数值状态监测,查询表中上下限
     * @param value
     * @param paramId
     * @return
     */
    public String checkState(int subSysId,int paramId,double value) {
        List<Parameter> parameters=parameterService.getBySubsystemId(subSysId);
        Double upper=null;
        Double lower=null;
        for (Parameter parameter:parameters){
            if (parameter.getId()==paramId){
                Parameter tempParam=parameter;
                upper=tempParam.getUpper();
                lower=tempParam.getLower();
            }
        }
        if((upper == null || value <= upper)
                && (lower == null || value >= lower)){
            return "正常";
        } else {
           return "异常";
        }
    }
    @RequestMapping("/getSys1TopValue")
    @ResponseBody
    public String testAjax(int subsystemId,int parameterId){
       CollectedValue cvs=collectedDataService.getCurrentValueById(subsystemId, parameterId);
        double value=cvs.getValue();
        String state=checkState(subsystemId,parameterId,value);
        if(state.equals("正常")){
            return Double.toString(value)+";"+1;
        }else{
            return Double.toString(value)+";"+0;
        }

    }
}
