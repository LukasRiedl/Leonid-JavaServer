package at.htl.leonidServer;

import at.htl.leonidServer.database.Database;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.primefaces.json.JSONObject;
import sun.net.www.http.HttpClient;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class Controller {


    public static String startWeb() throws IOException {

//        URL url = new URL("https://mese.webuntis.com/WebUntis/jsonrpc.do?school=htbla%20linz%20leonding");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//
//        String payload="{\"id\":\"LUKI\",\"method\":\"authenticate\"," +
//                "\"params\":{\"user\":\"in120083\",\"password\":\"luki05525252\"," +
//                "\"client\":\"Client\"},\"jsonrpc\":2.0}";
//
//        connection.setDoInput(true);
//        connection.setDoOutput(true);
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Accept", "application/json");
//        connection.setRequestProperty("Content-Type", "application/json");
//        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
//        writer.write(payload);
//        writer.close();
//        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        StringBuffer jsonString = new StringBuffer();
//        String line;
//        while ((line = br.readLine()) != null) {
//            jsonString.append(line);
//        }
//        br.close();
//        connection.disconnect();
//
//        System.out.println(jsonString.toString());
//
//       String x= jsonString.substring(52,84);
//
//        return x;
        //}
        return null;
    }
}
