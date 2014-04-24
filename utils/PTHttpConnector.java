package jp.co.mixi.androidtraining.graduates2014.app.utils;

/**
 * Created by kiyoto.onozawa on 2014/04/24.
 */
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

public class PTHttpConnector {
    public static String connectAsGet(String urlStr){
        URL url = null;
        HttpURLConnection connection = null;
        StringBuilder src = new StringBuilder();
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (true)
            {  String line = reader.readLine();
                if ( line == null ) break;
                src.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (connection != null){
                connection.disconnect();
            }
        }
        return src.toString();
    }
}
