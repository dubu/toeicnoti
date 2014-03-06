package com.dubu.toeic.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User: kingkingdubu
 * Date: 14. 3. 7
 * Time: 오전 2:06
 */
public class RunSchedule {

    private static String url = "https://www.parse.com/apps/toeicnoti/push_notifications";

    public static  void main(String[] args){

        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();

        // Create a method instance.
        PostMethod post = new PostMethod(url);

        String pDate  = "2014-03-08";
        String msg = URLEncoder.encode("발표일14.03.14(금) 오후 3시 ");

        Map sche = new HashMap<String,String>();

        sche.put("2014-03-13","발표일14.03.14(금) 오후 3시");
        sche.put("2014-04-02","발표일14.04.03(목) 오후 3시");
        sche.put("2014-04-17","발표일14.04.18(금) 오후 3시");
        sche.put("2014-05-15","발표일14.05.16(금) 오후 3시");
        sche.put("2014-05-28","발표일14.05.29(목) 오후 3시");
        sche.put("2014-06-12","발표일14.06.13(금) 오후 3시");
        sche.put("2014-07-17","발표일14.07.18(금) 오후 3시");
        sche.put("2014-07-30","발표일14.07.31(목) 오후 3시");
        sche.put("2014-08-14","발표일14.08.15(금) 오후 3시");
        sche.put("2014-08-27","발표일14.08.28(목) 오후 3시");
        sche.put("2014-09-18","발표일14.09.19(금) 오후 3시");
        sche.put("2014-10-16","발표일14.10.17(금) 오후 3시");
        sche.put("2014-10-29","발표일14.10.30(목) 오후 3시");
        sche.put("2014-11-13","발표일14.11.14(금) 오후 3시");
        sche.put("2014-12-18","발표일14.12.19(금) 오후 3시");
        sche.put("2015-01-08","발표일15.01.09(금) 오후 3시");

        sche.put("2014-03-30", "정기접수 ~14.03.31(월) 오전 8시");
        sche.put("2014-04-13", "정기접수 ~14.04.14(월) 오전 8시");
        sche.put("2014-04-27", "정기접수 ~14.04.28(월) 오전 8시");
        sche.put("2014-05-26", "정기접수 ~14.05.26(월) 오전 8시");
        sche.put("2014-06-15", "정기접수 ~14.06.16(월) 오전 8시");
        sche.put("2014-06-29", "정기접수 ~14.06.30(월) 오전 8시");
        sche.put("2014-07-13", "정기접수 ~14.07.14(월) 오전 8시");
        sche.put("2014-07-27", "정기접수 ~14.07.28(월) 오전 8시");
        sche.put("2014-08-31", "정기접수 ~14.09.01(월) 오전 8시");
        sche.put("2014-09-14", "정기접수 ~14.09.15(월) 오전 8시");
        sche.put("2014-09-28", "정기접수 ~14.09.29(월) 오전 8시");
        sche.put("2014-10-26", "정기접수 ~14.10.27(월) 오전 8시");
        sche.put("2014-11-30", "정기접수 ~14.12.01(월) 오전 8시");

        String bodyData = "utf8=%E2%9C%93&authenticity_token=bbVEJcvnzx4KmfjHyz4RXViIdCc21y1nl1ZxffnRKY0%3D&target_type=everyone&push_to_android=1&target=%7B%7D&data=" + msg
                + "&data_type=message&push_time_type=time&push_date=" + pDate + "&push_hour=1&push_minute=00&push_ampm=PM&push_tz=%2B09%3A00&expiration_time_type=never&expiration_date=2014-02-24&expiration_hour=1&expiration_minute=35&expiration_ampm=PM&expiration_tz=%2B09%3A00&expiration_interval_num=1&expiration_interval_unit=hours";

        post.setRequestHeader(new Header("Accept","text/html, application/xhtml+xml, */*"));
        post.setRequestHeader(new Header("Referer","https://www.parse.com/apps/toeicnoti/push_notifications/new"));
        post.setRequestHeader(new Header("Accept-Language","ko-KR"));
        post.setRequestHeader(new Header("User-Agent","Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)"));
        post.setRequestHeader(new Header("Content-Type","application/x-www-form-urlencoded"));
        post.setRequestHeader(new Header("Accept-Encoding","gzip, deflate"));
        post.setRequestHeader(new Header("Host","www.parse.com"));
        post.setRequestHeader(new Header("Content-Length",String.valueOf(451+msg.length())));
        post.setRequestHeader(new Header("DNT","1"));
        post.setRequestHeader(new Header("Connection","Keep-Alive"));
        post.setRequestHeader(new Header("Cache-Control","no-cache"));
        post.setRequestHeader(new Header("Cookie","_cb_ls=1; _chartbeat2=j0bzu1d28nhqnlw0.1393007324125.1394120780387.11000000000001; _chartbeat_uuniq=2; _parse_session=BAh7CUkiD3Nlc3Npb25faWQGOgZFRiIlZjdmYzEzZjMwMWQ3OGM4OTQ2MTM5MjNjNjU4ZjBkNjBJIhBfY3NyZl90b2tlbgY7AEZJIjFiYlZFSmN2bnp4NEttZmpIeXo0UlhWaUlkQ2MyMXkxbmwxWnhmZm5SS1kwPQY7AEZJIhV1c2VyX2NyZWRlbnRpYWxzBjsARkkiAYAyOGM1NzExZjI2ZGEyNzViM2Y2ZDhlNzdjN2RmYmQ4MzVmMGJmYzAyNDRiNGZiYWVkY2Y4NDdjZTgxNDE2MmMwNmRjZDdjNWE1YWJlNmJlYzMxOTUwMjczNDU0ZjY5ODVlMjEyMDc3MDk3MWI4ZDA0ZjJjMWU0OTk2YTY5NTA4ZgY7AFRJIhh1c2VyX2NyZWRlbnRpYWxzX2lkBjsARmkCk9A%3D--866849ebaa563a9e8fdd4daec52afb49d4d15b7f; __utma=240432258.1413113385.1393007321.1393149626.1394120692.6; __utmz=240432258.1393007321.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _mkto_trk=id:713-YFQ-084&token:_mch-parse.com-1393007321295-79593; __utmb=240432258.7.10.1394120692; __utmc=240432258; user_credentials=28c5711f26da275b3f6d8e77c7dfbd835f0bfc0244b4fbaedcf847ce814162c06dcd7c5a5abe6bec31950273454f6985e2120770971b8d04f2c1e4996a69508f%3A%3A53395"));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());

        String todayMsg = (String)sche.get(today);
        if(todayMsg != null){
            post.setRequestBody(bodyData);

        }else{
            return;
        }

        // Provide custom retry handler is necessary
//        post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
//                new DefaultHttpMethodRetryHandler(3, false));

        try {
            // Execute the get.
            int statusCode = client.executeMethod(post);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + post.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = post.getResponseBody();          ///
//            InputStream in = post.getResponseBodyAsStream();


            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.out.println(new String(responseBody));

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            post.releaseConnection();         //
        }
    }
}
