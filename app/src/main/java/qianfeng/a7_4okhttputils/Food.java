package qianfeng.a7_4okhttputils;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class Food {
    private String keywords;
    private String name;

    public Food() {
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food(String keywords, String name) {
        this.keywords = keywords;
        this.name = name;
    }
}
