package com.test.dubboapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ipharmacare.engine.api.run.AuditApi;
import com.ipharmacare.engine.dto.run.request.RunEngineRequestDTO;
import com.ipharmacare.engine.dto.run.response.audit.AuditResultDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ipharmacare.systemcenter.interfaces.auth.*;

public class Demo {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
//        IUser iUser = (IUser) context.getBean("iUser");
//        DtoUser userById = iUser.getUserById(-200L);
//        System.out.println(userById);
//        System.out.println(JSON.toJSONString(userById));

        AuditApi auditApi = (AuditApi) context.getBean("audit");
        String jsonStr = "{\"diagnosisList\":[{\"code\":\"I80.201.0006\",\"diagTime\":\"0014-03-11T09:18:51\",\"isPrimary\":false,\"itemNo\":\"202511_0_I80.201.0006_1\",\"name\":\"下肢深静脉血栓形成\",\"type\":\"主诊断\"}],\"drugOrderList\":[{\"drugDetails\":[{\"checkNurseId\":\"B521\",\"checkNurseName\":\"侯莉文\",\"checkTime\":\"0014-03-11T09:18:51\",\"countUnit\":1,\"deptId\":\"1020900\",\"deptName\":\"血管外科放射介\",\"dispensingNum\":3,\"dispensingUnit\":\"袋\",\"docId\":\"B978\",\"docName\":\"刘昭\",\"docTitle\":\"232\",\"drugAdminRouteName\":\"口服\",\"drugDose\":\"10g\",\"drugSpec\":\"100毫克/袋\",\"drugUsingAim\":\"\",\"drugUsingArea\":\"\",\"drugUsingFreq\":\"QD\",\"drugUsingTimePoint\":\"\",\"durationDays\":1,\"groupNo\":\"12800611\",\"hisProductId\":\"000200\",\"hisProductName\":\"党参\",\"invalidTime\":\"2020-07-22T09:13:08\",\"itemNo\":\"1_187037\",\"medicareType\":\"\",\"orderTime\":\"0014-03-11T09:18:51\",\"orderType\":\"临时医嘱\",\"payType\":\"\",\"specialPromp\":\"\",\"unitPrice\":4.97,\"valid\":true,\"validTime\":\"0014-03-11T09:18:51\"},{\"checkNurseId\":\"B521\",\"checkNurseName\":\"侯莉文\",\"checkTime\":\"0014-03-11T13:18:33\",\"countUnit\":1,\"deptId\":\"1020900\",\"deptName\":\"血管外科放射介\",\"dispensingNum\":5,\"dispensingUnit\":\"袋\",\"docId\":\"B978\",\"docName\":\"刘昭\",\"docTitle\":\"232\",\"drugAdminRouteName\":\"口服\",\"drugDose\":\"10g\",\"drugSpec\":\"100毫克/袋\",\"drugUsingAim\":\"\",\"drugUsingArea\":\"\",\"drugUsingFreq\":\"QD\",\"drugUsingTimePoint\":\"\",\"durationDays\":1,\"groupNo\":\"12800611\",\"hisProductId\":\"000200\",\"hisProductName\":\"党参\",\"invalidTime\":\"2020-07-22T13:12:50\",\"itemNo\":\"1_187071\",\"medicareType\":\"\",\"orderTime\":\"0014-03-11T13:18:33\",\"orderType\":\"临时医嘱\",\"payType\":\"\",\"specialPromp\":\"\",\"unitPrice\":4.97,\"valid\":true,\"validTime\":\"0014-03-11T13:18:33\"},{\"checkNurseId\":\"B521\",\"checkNurseName\":\"侯莉文\",\"checkTime\":\"0014-03-11T13:18:33\",\"countUnit\":1,\"deptId\":\"1020900\",\"deptName\":\"血管外科放射介入科\",\"dispensingNum\":5,\"dispensingUnit\":\"支\",\"docId\":\"B978\",\"docName\":\"刘昭\",\"docTitle\":\"232\",\"drugAdminRouteName\":\"口服\",\"drugDose\":\"40mg\",\"drugSpec\":\"40mg\",\"drugUsingAim\":\"\",\"drugUsingArea\":\"\",\"drugUsingFreq\":\"QD\",\"drugUsingTimePoint\":\"\",\"durationDays\":1,\"groupNo\":\"12800611\",\"hisProductId\":\"04010300\",\"hisProductName\":\"益母草\",\"invalidTime\":\"2020-07-22T13:12:50\",\"itemNo\":\"1_187072\",\"medicareType\":\"\",\"orderTime\":\"0014-03-11T13:18:33\",\"orderType\":\"临时医嘱\",\"payType\":\"\",\"specialPromp\":\"\",\"unitPrice\":100.12,\"valid\":true,\"validTime\":\"0014-03-11T13:18:33\"}],\"eventNo\":\"20200120142\",\"primary\":true}],\"patientInfo\":{\"address\":\"江苏省盐城市射阳县新洋农场二村75幢27号\",\"allergies\":[],\"birthDay\":\"1948-04-03T00:00\",\"birthWeight\":\"\",\"breastFeeding\":\"0\",\"dialysis\":\"0\",\"height\":\"165cm\",\"idNo\":\"320924194804038761\",\"idType\":\"01\",\"name\":\"金学芳\",\"patientNo\":\"20200120142\",\"phoneNo\":\"13851427688\",\"pregnancy\":\"0\",\"sex\":\"M\",\"weight\":\"65kg\"},\"serviceTime\":\"2020-07-21T21:27:17.865\",\"visitInfo\":{\"bedNo\":\"11\",\"eventNo\":\"20200120142\",\"hospitalCode\":\"H0003\",\"inWardName\":\"7C病区\",\"payTypes\":[\"\"],\"sourceType\":\"IPT\",\"visitDate\":\"0014-03-11T13:18:33\",\"visitSource\":\"住院\"}}";
        RunEngineRequestDTO requestDTO = JSONArray.parseObject(jsonStr, RunEngineRequestDTO.class);

////        RunEngineRequestDTO requestDTO = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), RunEngineRequestDTO.class);
        AuditResultDTO auditResultDTO = auditApi.run(requestDTO);
        System.out.println(auditResultDTO);
        System.out.println(JSON.toJSONString(auditResultDTO));
    }
}
