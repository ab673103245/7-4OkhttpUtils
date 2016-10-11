package qianfeng.a7_4okhttputils;

import android.os.Handler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class MyOkhttpUtils  {

    private static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();
    private static Handler mHandler = new Handler();

//    public interface CallBack
//    {
//        void onResponse(List<Food> list);
//        void onError(String errorMsg);
//    }

    public static void getData(String httpUrl, final CallBack callBack) {
        final Request request = new Request.Builder().url(httpUrl).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailure(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final List<Food> list = JsonParse.parseJson2List(response.body().string());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onResponse(list);
                        }
                    });
                }
            }
        });
    }



}
