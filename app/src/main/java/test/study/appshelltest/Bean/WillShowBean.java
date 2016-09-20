package test.study.appshelltest.Bean;

import java.util.List;

/**
 * Created by 李鸿达 on 2016/9/20.
 */
public class WillShowBean {
    //获取导演名字
    private String w_director_name;
    private String w_director_url;
    //3、获取电影Icon
    private String w_icon;
    //4、获取电影Iconlink
    private String w_icon_linkUrl;
    //5、选座购票，剧照海报、热门影评
    private String w_Stills;
    private String w_pianhua;
    private String w_HotComments;
    //6、获取主演员 共4个
    private List<String> willactors;
    private List<String> willactors_link;
    //7、获取上映日期
    private String w_play_data1;
    private String w_play_data2;
    //8、获取故事简介
    private String w_story_brief;
    private String w_story_link;
    //10、获取电影名字
    private String w_movie_name;
    //11、获取电影类型
    private List<String> willtypes;

    public WillShowBean() {
    }

    public WillShowBean(String w_director_name, String w_director_url, String w_icon, String w_icon_linkUrl, String w_Stills, String w_pianhua, String w_HotComments, List<String> willactors, List<String> willactors_link, String w_play_data1, String w_play_data2, String w_story_brief, String w_story_link, String w_movie_name, List<String> willtypes) {
        this.w_director_name = w_director_name;
        this.w_director_url = w_director_url;
        this.w_icon = w_icon;
        this.w_icon_linkUrl = w_icon_linkUrl;
        this.w_Stills = w_Stills;
        this.w_pianhua = w_pianhua;
        this.w_HotComments = w_HotComments;
        this.willactors = willactors;
        this.willactors_link = willactors_link;
        this.w_play_data1 = w_play_data1;
        this.w_play_data2 = w_play_data2;
        this.w_story_brief = w_story_brief;
        this.w_story_link = w_story_link;
        this.w_movie_name = w_movie_name;
        this.willtypes = willtypes;
    }

    public void setW_director_name(String w_director_name) {
        this.w_director_name = w_director_name;
    }

    public void setW_director_url(String w_director_url) {
        this.w_director_url = w_director_url;
    }

    public void setW_icon(String w_icon) {
        this.w_icon = w_icon;
    }

    public void setW_icon_linkUrl(String w_icon_linkUrl) {
        this.w_icon_linkUrl = w_icon_linkUrl;
    }

    public void setW_Stills(String w_Stills) {
        this.w_Stills = w_Stills;
    }

    public void setW_pianhua(String w_pianhua) {
        this.w_pianhua = w_pianhua;
    }

    public void setW_HotComments(String w_HotComments) {
        this.w_HotComments = w_HotComments;
    }

    public void setWillactors(List<String> willactors) {
        this.willactors = willactors;
    }

    public void setWillactors_link(List<String> willactors_link) {
        this.willactors_link = willactors_link;
    }

    public void setW_play_data1(String w_play_data1) {
        this.w_play_data1 = w_play_data1;
    }

    public void setW_play_data2(String w_play_data2) {
        this.w_play_data2 = w_play_data2;
    }

    public void setW_story_brief(String w_story_brief) {
        this.w_story_brief = w_story_brief;
    }

    public void setW_story_link(String w_story_link) {
        this.w_story_link = w_story_link;
    }

    public void setW_movie_name(String w_movie_name) {
        this.w_movie_name = w_movie_name;
    }

    public void setWilltypes(List<String> willtypes) {
        this.willtypes = willtypes;
    }

    public String getW_director_name() {
        return w_director_name;
    }

    public String getW_director_url() {
        return w_director_url;
    }

    public String getW_icon() {
        return w_icon;
    }

    public String getW_icon_linkUrl() {
        return w_icon_linkUrl;
    }

    public String getW_Stills() {
        return w_Stills;
    }

    public String getW_pianhua() {
        return w_pianhua;
    }

    public String getW_HotComments() {
        return w_HotComments;
    }

    public List<String> getWillactors() {
        return willactors;
    }

    public List<String> getWillactors_link() {
        return willactors_link;
    }

    public String getW_play_data1() {
        return w_play_data1;
    }

    public String getW_play_data2() {
        return w_play_data2;
    }

    public String getW_story_brief() {
        return w_story_brief;
    }

    public String getW_story_link() {
        return w_story_link;
    }

    public String getW_movie_name() {
        return w_movie_name;
    }

    public List<String> getWilltypes() {
        return willtypes;
    }

    @Override
    public String toString() {
        return "WillShowBean{" +
                "w_director_name='" + w_director_name + '\'' +
                ", w_director_url='" + w_director_url + '\'' +
                ", w_icon='" + w_icon + '\'' +
                ", w_icon_linkUrl='" + w_icon_linkUrl + '\'' +
                ", w_Stills='" + w_Stills + '\'' +
                ", w_pianhua='" + w_pianhua + '\'' +
                ", w_HotComments='" + w_HotComments + '\'' +
                ", willactors=" + willactors +
                ", willactors_link=" + willactors_link +
                ", w_play_data1='" + w_play_data1 + '\'' +
                ", w_play_data2='" + w_play_data2 + '\'' +
                ", w_story_brief='" + w_story_brief + '\'' +
                ", w_story_link='" + w_story_link + '\'' +
                ", w_movie_name='" + w_movie_name + '\'' +
                ", willtypes=" + willtypes +
                '}';
    }
}
