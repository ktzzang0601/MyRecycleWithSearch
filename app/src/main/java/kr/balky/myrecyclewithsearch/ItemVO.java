package kr.balky.myrecyclewithsearch;

/**
 * Created by Cheetah.Park on 2019-03-29.
 */
public class ItemVO {


    int id;
    int imgId;
    String title;
    String content;

    public ItemVO(int id, int imgId, String title, String content) {
        this.id = id;
        this.imgId = imgId;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
