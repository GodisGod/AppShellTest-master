package test.study.appshelltest.Bean;

import java.util.List;

/**
 * Created by 李鸿达 on 2016/9/20.
 */
public class ShowingBean {

    private String director_name;//导演名字
    private String director_url;//导演介绍
    private String grade;//评分
    private String icon;//电影小图标
    private String icon_linkUrl;//电影链接
    private String ChooseTicket;//选座售票链接
    private String Stills;//剧照
    private String HotComments;//热门影评

    private List<String> showactors;
    private List<String> showactors_link;
    //上映日期
    private String play_data1;
    private String play_data2;
    //故事简介
    private String story_brief;
    private String story_link;
    //获取上映电影院数
    private String play_cinemas_count;
    //获取电影名字
    private String movie_name;
    //获取电影类型
    private List<String> showtypes;

    public ShowingBean() {
    }

    public ShowingBean(String director_name, String director_url, String grade, String icon, String icon_linkUrl, String chooseTicket, String stills, String hotComments, List<String> showactors, List<String> showactors_link, String play_data1, String play_data2, String story_brief, String story_link, String play_cinemas_count, String movie_name, List<String> showtypes) {
        this.director_name = director_name;
        this.director_url = director_url;
        this.grade = grade;
        this.icon = icon;
        this.icon_linkUrl = icon_linkUrl;
        ChooseTicket = chooseTicket;
        Stills = stills;
        HotComments = hotComments;
        this.showactors = showactors;
        this.showactors_link = showactors_link;
        this.play_data1 = play_data1;
        this.play_data2 = play_data2;
        this.story_brief = story_brief;
        this.story_link = story_link;
        this.play_cinemas_count = play_cinemas_count;
        this.movie_name = movie_name;
        this.showtypes = showtypes;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public void setDirector_url(String director_url) {
        this.director_url = director_url;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setIcon_linkUrl(String icon_linkUrl) {
        this.icon_linkUrl = icon_linkUrl;
    }

    public void setChooseTicket(String chooseTicket) {
        ChooseTicket = chooseTicket;
    }

    public void setStills(String stills) {
        Stills = stills;
    }

    public void setHotComments(String hotComments) {
        HotComments = hotComments;
    }

    public void setShowactors(List<String> showactors) {
        this.showactors = showactors;
    }

    public void setShowactors_link(List<String> showactors_link) {
        this.showactors_link = showactors_link;
    }

    public void setPlay_data1(String play_data1) {
        this.play_data1 = play_data1;
    }

    public void setPlay_data2(String play_data2) {
        this.play_data2 = play_data2;
    }

    public void setStory_brief(String story_brief) {
        this.story_brief = story_brief;
    }

    public void setStory_link(String story_link) {
        this.story_link = story_link;
    }

    public void setPlay_cinemas_count(String play_cinemas_count) {
        this.play_cinemas_count = play_cinemas_count;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public void setShowtypes(List<String> showtypes) {
        this.showtypes = showtypes;
    }

    public String getDirector_name() {
        return director_name;
    }

    public String getDirector_url() {
        return director_url;
    }

    public String getGrade() {
        return grade;
    }

    public String getIcon() {
        return icon;
    }

    public String getIcon_linkUrl() {
        return icon_linkUrl;
    }

    public String getChooseTicket() {
        return ChooseTicket;
    }

    public String getStills() {
        return Stills;
    }

    public String getHotComments() {
        return HotComments;
    }

    public List<String> getShowactors() {
        return showactors;
    }

    public List<String> getShowactors_link() {
        return showactors_link;
    }

    public String getPlay_data1() {
        return play_data1;
    }

    public String getPlay_data2() {
        return play_data2;
    }

    public String getStory_brief() {
        return story_brief;
    }

    public String getStory_link() {
        return story_link;
    }

    public String getPlay_cinemas_count() {
        return play_cinemas_count;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public List<String> getShowtypes() {
        return showtypes;
    }

    @Override
    public String toString() {
        return "ShowingBean{" +
                "director_name='" + director_name + '\'' +
                ", director_url='" + director_url + '\'' +
                ", grade='" + grade + '\'' +
                ", icon='" + icon + '\'' +
                ", icon_linkUrl='" + icon_linkUrl + '\'' +
                ", ChooseTicket='" + ChooseTicket + '\'' +
                ", Stills='" + Stills + '\'' +
                ", HotComments='" + HotComments + '\'' +
                ", showactors=" + showactors +
                ", showactors_link=" + showactors_link +
                ", play_data1='" + play_data1 + '\'' +
                ", play_data2='" + play_data2 + '\'' +
                ", story_brief='" + story_brief + '\'' +
                ", story_link='" + story_link + '\'' +
                ", play_cinemas_count='" + play_cinemas_count + '\'' +
                ", movie_name='" + movie_name + '\'' +
                ", showtypes=" + showtypes +
                '}';
    }
}
