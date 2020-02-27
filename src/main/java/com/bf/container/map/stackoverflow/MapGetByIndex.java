package com.bf.container.map.stackoverflow;

import java.util.LinkedHashMap;

/**
 * @description:
 * @author: bofei
 * @date: 2020-02-24 09:48
 **/
public class MapGetByIndex {
    public Object getElementByIndex(LinkedHashMap map, int index){
        return map.get( (map.keySet().toArray())[ index ] );
    }
}
