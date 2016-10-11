package qianfeng.a7_4okhttputils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class JsonParse {
    public static List<Food> parseJson2List(String json) {
        List<Food> list = new ArrayList<>();
        try {
            JSONArray tngou = new JSONObject(json).getJSONArray("tngou");
            for (int i = 0; i < tngou.length(); i++) {
                JSONObject data = tngou.getJSONObject(i);
                String name = data.getString("name");
                String keywords = data.getString("keywords");
                list.add(new Food(keywords,name));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
