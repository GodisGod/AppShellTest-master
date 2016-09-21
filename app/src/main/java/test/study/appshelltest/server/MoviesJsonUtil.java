package test.study.appshelltest.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import test.study.appshelltest.Bean.ShowingBean;
import test.study.appshelltest.Bean.WillShowBean;
import test.study.appshelltest.Constant;
import test.study.appshelltest.utils.LogUtil;

/**
 * Created by 李鸿达 on 2016/9/19.
 */
public class MoviesJsonUtil {

    public static void analysis(String json) {
        List<String> showactors;
        List<String> showactors_link;
        List<String> showtypes;
        List<String> willtypes;
        List<String> willactors;
        List<String> willactors_link;
        List<ShowingBean> showingBeans = new ArrayList<ShowingBean>();
        List<WillShowBean> willShowBeans = new ArrayList<WillShowBean>();

        try {
            JSONObject object = new JSONObject(json);
            JSONObject result = object.getJSONObject("result");
            String title = result.getString("title");
            String title_url = result.getString("url");

            JSONArray dataarry = result.getJSONArray("data");

            //获取正在上映
            JSONObject ShowingObject = (JSONObject) dataarry.get(0);
            LogUtil.HDLog("ShowingObject  " + ShowingObject.toString());
            JSONArray ShowingArray = ShowingObject.getJSONArray("data");
            for (int i = 0; i < ShowingArray.length(); i++) {
                JSONObject showshow = (JSONObject) ShowingArray.get(i);
                //1、获取导演信息
                JSONObject DirectorObject = showshow.getJSONObject("director")
                        .getJSONObject("data")
                        .getJSONObject("1");
                //获取导演名字
                String director_name = DirectorObject.getString("name");
                String director_url = DirectorObject.getString("link");
                //2、获取评分
                String grade = showshow.getString("grade");
                //3、获取电影Icon
                String icon = showshow.getString("iconaddress");
                //4、获取电影Iconlink
                String icon_linkUrl = showshow.getString("iconlinkUrl");
                //5、选座购票，剧照海报、热门影评
                JSONArray moreObject = showshow.getJSONObject("more").getJSONArray("data");
                String ChooseTicket = ((JSONObject) moreObject.get(0)).getString("link");
                String Stills = ((JSONObject) moreObject.get(1)).getString("link");
                String HotComments = ((JSONObject) moreObject.get(2)).getString("link");
                //6、获取演员 共4个
                JSONObject StarObject = showshow.getJSONObject("star").getJSONObject("data");

                showactors = new ArrayList<String>();
                showactors_link = new ArrayList<String>();
                for (int k = 1; k < 4; k++) {
                    try {
                        showactors.add(StarObject.getJSONObject(k + "").getString("name"));
                        showactors_link.add(StarObject.getJSONObject(k + "").getString("link"));
                        LogUtil.HDLog("showactors:  " + StarObject.getJSONObject(k + "").getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        break;
                    }
                }

                //7、获取上映日期
                JSONObject PlayDateObject = showshow.getJSONObject("playDate");
                String play_data1 = PlayDateObject.getString("data");
                String play_data2 = PlayDateObject.getString("data2");
                //8、获取故事简介
                JSONObject StoryObject = showshow.getJSONObject("story").getJSONObject("data");
                String story_brief = StoryObject.getString("storyBrief");
                String story_link = StoryObject.getString("storyMoreLink");
                //9、获取上映电影院数
                String play_cinemas_count = showshow.getString("subHead");
                //10、获取电影名字
                String movie_name = showshow.getString("tvTitle");
                //11、获取电影类型
                JSONObject TypeObject = showshow.getJSONObject("type").getJSONObject("data");
                showtypes = new ArrayList<String>();
                for (int j = 1; j < 4; j++) {
                    try {

                        showtypes.add(TypeObject.getJSONObject(j + "").getString("name"));
                        LogUtil.HDLog("showtypes:  " + TypeObject.getJSONObject(j + "").getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                ShowingBean showingBean = new ShowingBean();
                showingBean.setChooseTicket(ChooseTicket);
                showingBean.setDirector_url(director_url);
                showingBean.setDirector_name(director_name);
                showingBean.setGrade(grade);
                showingBean.setHotComments(HotComments);
                showingBean.setIcon(icon);
                showingBean.setIcon_linkUrl(icon_linkUrl);
                showingBean.setStills(Stills);
                showingBean.setShowactors(showactors);
                showingBean.setShowactors_link(showactors_link);
                showingBean.setPlay_data1(play_data1);
                showingBean.setPlay_data2(play_data2);
                showingBean.setShowtypes(showtypes);
                showingBean.setStory_link(story_link);
                showingBean.setMovie_name(movie_name);
                showingBean.setStory_brief(story_brief);
                showingBean.setPlay_cinemas_count(play_cinemas_count);
                showingBeans.add(showingBean);
                LogUtil.HDLog("解析电影：" + showingBean.toString());
            }


            //获取即将上映
            JSONObject WillShowingObject = (JSONObject) dataarry.get(1);
            JSONArray willobject = WillShowingObject.getJSONArray("data");
            for (int i = 0; i < willobject.length(); i++) {
                JSONObject willshow = (JSONObject) willobject.get(i);
                //1、获取导演信息
                JSONObject w_DirectorObject = willshow.getJSONObject("director").getJSONObject("data")
                        .getJSONObject("1");
                //获取导演名字
                String w_director_name = w_DirectorObject.getString("name");
                String w_director_url = w_DirectorObject.getString("link");

                //3、获取电影Icon
                String w_icon = willshow.getString("iconaddress");
                //4、获取电影Iconlink
                String w_icon_linkUrl = willshow.getString("iconlinkUrl");
                //5、选座购票，剧照海报、热门影评
                JSONArray w_moreObject = willshow.getJSONObject("more").getJSONArray("data");
                String w_Stills = ((JSONObject) w_moreObject.get(0)).getString("link");
                String w_pianhua = ((JSONObject) w_moreObject.get(1)).getString("link");
                String w_HotComments = ((JSONObject) w_moreObject.get(2)).getString("link");
                //6、获取主演员 共4个
                JSONObject w_StarObject = willshow.getJSONObject("star").getJSONObject("data");

                willactors = new ArrayList<String>();
                willactors_link = new ArrayList<String>();
                for (int z = 1; z < 4; z++) {
                    try {
                        willactors.add(w_StarObject.getJSONObject(z + "").getString("name"));
                        willactors_link.add(w_StarObject.getJSONObject(z + "").getString("link"));
                        LogUtil.HDLog("willactors:  " + w_StarObject.getJSONObject(z + "").getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        break;
                    }
                }

                //7、获取上映日期
                JSONObject w_PlayDateObject = willshow.getJSONObject("playDate");
                String w_play_data1 = w_PlayDateObject.getString("data");
                String w_play_data2 = w_PlayDateObject.getString("data2");
                //8、获取故事简介
                JSONObject w_StoryObject = willshow.getJSONObject("story").getJSONObject("data");
                String w_story_brief = w_StoryObject.getString("storyBrief");
                String w_story_link = w_StoryObject.getString("storyMoreLink");

                //10、获取电影名字
                String w_movie_name = willshow.getString("tvTitle");
                //11、获取电影类型
                JSONObject w_TypeObject = willshow.getJSONObject("type").getJSONObject("data");

                willtypes = new ArrayList<String>();
                for (int j = 1; j < 4; j++) {
                    try {
                        willtypes.add(w_TypeObject.getJSONObject(j + "").getString("name"));
                        LogUtil.HDLog("willtypes:  " + w_TypeObject.getJSONObject(j + "").getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        break;
                    }
                }

                //11、获取电影类型
                WillShowBean willShowBean = new WillShowBean();
                willShowBean.setWilltypes(willtypes);
                willShowBean.setW_icon(w_icon);
                willShowBean.setW_director_name(w_director_name);
                willShowBean.setW_director_url(w_director_url);
                willShowBean.setW_HotComments(w_HotComments);
                willShowBean.setW_icon_linkUrl(w_icon_linkUrl);
                willShowBean.setW_Stills(w_Stills);
                willShowBean.setW_pianhua(w_pianhua);
                willShowBean.setW_play_data1(w_play_data1);
                willShowBean.setW_play_data2(w_play_data2);
                willShowBean.setW_movie_name(w_movie_name);
                willShowBean.setW_story_brief(w_story_brief);
                willShowBean.setW_story_link(w_story_link);
                willShowBean.setWillactors(willactors);
                willShowBean.setWillactors_link(willactors_link);
                willShowBeans.add(willShowBean);
                LogUtil.HDLog("即将上映的电影：" + willShowBean.toString());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Constant.showingBeanList = showingBeans;
        Constant.willShowBeanList = willShowBeans;
    }
}
