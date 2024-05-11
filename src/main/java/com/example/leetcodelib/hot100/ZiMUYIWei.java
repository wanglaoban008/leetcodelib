package com.example.leetcodelib.hot100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: malili008
 * @Date: 2024/4/16 14:02
 * @Description: 字母异位词分组
 */
public class ZiMUYIWei {

    /**
     * @Author malili
     * @Description
     * 1、这里先遍历数组每个字符串，然后处理每个字符串的每个字符，根据字符排序
     * 2、排序后的字符串作为key存到map，value为原始字符串
     * 3、返回所有map的value
     * @Date 14:11 2024/5/11
     * @Param
     * @return
     **/
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int length = str.length();
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                char ss = str.charAt(i);
                stringList.add(String.valueOf(ss));
            }
            stringList.sort(String::compareTo);
            stringList.toString();
            if (map.containsKey(stringList.toString())) {
                map.get(stringList.toString()).add(str);
            }else {
                List<String> list22 = new ArrayList<>();
                list22.add(str);
                map.put(stringList.toString(), list22);
            }
        }
        if (map != null && !map.isEmpty()) {
            map.entrySet().stream().forEach(stringListEntry -> listList.add(stringListEntry.getValue()));
        }
        return listList;
    }



    public static void main(String[] args) {
        String[] ss = new String[]{"malices","extemporizing"};
        List<List<String>> listList = groupAnagrams(ss);
        System.err.println("listList: " + JSON.toJSONString(listList));
    }
}
