package tup.lucene.queries;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class MD5Test {
    public static String getMD5Str(String str, String encoding) {

        MessageDigest messageDigest = null;
        try {
            String content = str + encoding;
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes(encoding));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }

        public static void main (String[]args) throws UnsupportedEncodingException {
            String content = "tlTU0SxLsGbf0yWzQYq9SMg1u5g="+ "MzBjNDFiNTU1NDM0YTk1ZGY2ODQ2ZDA3NzhjNTY3ZmU=";
            String a = getMD5Str(content,"utf-8");
            System.out.println(a);

            JSONObject request = new JSONObject();
            request.put("cid","1Iz82zsw4gmBOLB");
            request.put("tripTyPe","1");
            request.put("adultNum","1");
            request.put("childNum","1");
            request.put("fromCity","SEL");
            request.put("toCity","SFO");
            request.put("fromDate","20190229");
            request.put("retDate","");
            String b = request.toString();
            System.out.println(b);


            Date date = new Date();
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.setTime(date);
            calendar2.setTime(date);
            int aft = (int)(Math.random() * 300);
            int aftSet = aft + ((int)(Math.random()*5)+10);
            calendar1.add(calendar1.DATE,aft);
            calendar2.add(calendar2.DATE,aftSet);
            Date date1 = calendar1.getTime();
            Date date2 = calendar2.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String  fromDate = sdf.format(date1);
            String toDate = sdf.format(date2);
            System.out.println(fromDate);
            System.out.println(toDate);

            String pattern = ".*routings\":.*";
            boolean isMatch = Pattern.matches(pattern,content);
            System.out.println(isMatch);

        }
}
