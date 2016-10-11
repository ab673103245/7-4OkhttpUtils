package qianfeng.a7_4okhttputils;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public interface CallBack {
        public void onResponse(List<Food> list);

        public void onFailure(String errorMsg);

}
