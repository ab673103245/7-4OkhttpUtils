package qianfeng.a7_4okhttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        MyOkhttpUtils.getData("http://www.tngou.net/api/cook/list?id=62", new CallBack() {
            @Override
            public void onResponse(List<Food> list) {
                StringBuffer result = new StringBuffer();
                for (Food food : list) {
                    result.append(food.getName()).append("\n");
                }
                tv.setText(result.toString());
            }

            @Override
            public void onFailure(String errorMsg) {

            }
        });


}
}
