package tup.lucene.queries;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateTestDemo1 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyDDmm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE,100);
        Date date1 = calendar.getTime();
        String a = sdf.format(date1);
        System.out.println(a);
        JSONArray cabinGrade = new JSONArray();
        String cabins = "Y,C,S";
        String[] cabinsArr = cabins.split(",");

        for(int i = 0;i < cabinsArr.length;i++){
            cabinGrade.add(cabinsArr[i]);
        }
        String ac = cabinGrade.toJSONString();
        System.out.println(ac);
        JSON.parseArray()
    }
}
