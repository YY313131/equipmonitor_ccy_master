package com.ccy.mobile;

import com.ccy.dto.CollectedValue;
import com.ccy.mobile.bean.MobileResult;
import com.ccy.mobile.bean.SubsystemInfo;
import com.ccy.mobile.bean.UserInfo;
import com.ccy.service.CollectedDataService;
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

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String mobileLogin(String username, String password) {
        String loginstate = userService.checkUserState(username, password);
        MobileResult<UserInfo> mobileResult;
        if (loginstate.equals("userNameNotExist") || loginstate.equals("passwordWrong")) {
            mobileResult = new MobileResult<UserInfo>(false, "login fail");
        } else {
            mobileResult = new MobileResult<UserInfo>(true, new UserInfo(username));
        }
        String json = null;
        try {
            json = mapper.writeValueAsString(mobileResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "/getSubsystemInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getSubsystemInfo(int subsystemId) {
        String json = null;
        Map<Integer, CollectedValue> map =
                collectedDataService.getTopOnes(subsystemId);
        if (map == null) {
            try {
                json = mapper.writeValueAsString(
                        new MobileResult<SubsystemInfo>(false, "query failed"));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            SubsystemInfo subsystemInfo = new SubsystemInfo(subsystemId, map);
            try {
                json = mapper.writeValueAsString(
                        new MobileResult<SubsystemInfo>(true, subsystemInfo));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    @RequestMapping(value = "/getParameterInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getParameterInfo(int subsystemId, int parameterId) {
        String json = null;
        CollectedValue collectedValue = collectedDataService.getTopOne(subsystemId, parameterId);
        MobileResult<CollectedValue> mobileResult;
        if (collectedValue == null) {
            mobileResult = new MobileResult<CollectedValue>(false, "");

        } else {


        }
//        try {
//            json=mapper.writeValueAsString(mobileResult);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        return json;
    }

}
