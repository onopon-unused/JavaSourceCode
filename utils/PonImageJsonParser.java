package jp.co.mixi.androidtraining.graduates2014.app.utils;

/**
 * Created by kiyoto.onozawa on 2014/04/24.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class PonImageJsonParser {
    public static JSONObject getJsonObject(String jsonStr){
        JSONObject object = null;
        try {
            object = new JSONObject(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return object;
    }

    public static String getImageUrlString(JSONObject object){
        try {
            JSONObject responseData = object.getJSONObject("responseData");
            JSONArray results = responseData.getJSONArray("results");
//            unescapedUrl
            JSONObject obj = results.getJSONObject(0);
            return obj.getString("unescapedUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NotFound";
    }

    public static String getImageUrlString(String source){
        try {
            JSONObject obj = new JSONObject(source);
            return getImageUrlString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NotFound";
    }

}
