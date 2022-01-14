/*
package com.bf.util;

*/
/**
 * @description:
 * @author: bofei
 * @date: 2019-12-26 10:26
 **//*


import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PubRestrictUtils {

    public static final String USER_SEX = "USER_SEX";
    public static final String AREA_TYPE = "AREA_TYPE";
    public static final String USER_STATE = "USER_STATE";
    */
/**
     *  字典表： Map<关键词, Map<SERIAL_NO, 中文名>>
     *//*

    private Map<String, Map<BigDecimal, Object>> propertys = new HashMap<String, Map<BigDecimal, Object>>();

    @Autowired
    private PubRestrictDao pubRestrictDao;


    @PostConstruct
    public void init(){
        loadRestrict(USER_SEX);
        loadRestrict(AREA_TYPE);
        loadRestrict(USER_STATE);
    }

    public void loadRestrict(String keyWord){
        List<Map<String, Object>> list = pubRestrictDao.getPubRestrictByKeyWord(keyWord);
        if (list.isEmpty()){
            return;
        }
        Map<BigDecimal, Object> propertys = new HashMap<BigDecimal, Object>(list.size());
        for (Map<String, Object> map : list){
            propertys.put((BigDecimal) MapUtils.getObject(map,"SERIAL_NO"), MapUtils.getString(map,"DESC_CHINA") );
        }
        this.propertys.put(keyWord, propertys);
    }

    public String getUserSex(BigDecimal code){
        return get(USER_SEX, code);
    }

    public String getAreaType(BigDecimal code){
        return get(AREA_TYPE, code);
    }

    public String getUserState(BigDecimal code){
        return get(USER_STATE, code);
    }


    public String get(String keyWord, BigDecimal code){
        Map<BigDecimal, Object> propertys = getProperty( keyWord);
        if (MapUtils.isEmpty(propertys)){
            return code.toString();
        }
        String property = MapUtils.getString(propertys, code, code.toString());
        return property;

    }

    public Map<BigDecimal, Object> getProperty(String keyWord){
        return propertys.get(keyWord);

    }

    public Map<String, Map<BigDecimal, Object>> getPropertys() {
        return propertys;
    }
}
*/
