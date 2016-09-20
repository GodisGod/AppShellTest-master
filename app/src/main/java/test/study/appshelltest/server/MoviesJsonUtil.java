package test.study.appshelltest.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import test.study.appshelltest.utils.LogUtil;

/**
 * Created by 李鸿达 on 2016/9/19.
 */
public class MoviesJsonUtil {

    public static void analysis(String json) {
         List<String> willtypes;
        LogUtil.HDLog("ssssssssssssssssss");
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
                String star_1_name = StarObject.getJSONObject("1").getString("name");
                String star_1_link = StarObject.getJSONObject("1").getString("link");
                String star_2_name = StarObject.getJSONObject("2").getString("name");
                String star_2_link = StarObject.getJSONObject("2").getString("link");
                String star_3_name = StarObject.getJSONObject("3").getString("name");
                String star_3_link = StarObject.getJSONObject("3").getString("link");
                String star_4_name = StarObject.getJSONObject("4").getString("name");
                String star_4_link = StarObject.getJSONObject("4").getString("link");
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
                String type1 = TypeObject.getJSONObject("1").getString("name");
//              String type2 = TypeObject.getJSONObject("2").getString("name");
                 willtypes = new ArrayList<String>();
                for (int j=0;j<4;j++){
                    try {
                        willtypes.add(TypeObject.getJSONObject(j+"").getString("name"));
                        LogUtil.HDLog("willtypes:  "+TypeObject.getJSONObject(j+"").getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                LogUtil.HDLog("解析电影：" +
                        title + title_url + "\n" +
                        "" + star_1_name + movie_name + "\n" +
                        star_2_name + "\n" + play_data1 + "\n" + type1 + "\n" + play_cinemas_count);
            }

            //获取即将上映
            JSONObject WillShowingObject = (JSONObject) dataarry.get(1);
            JSONArray willobject = WillShowingObject.getJSONArray("data");
           for (int i=0;i<willobject.length();i++){
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
               String w_star_1_name = w_StarObject.getJSONObject("1").getString("name");
               String w_star_1_link = w_StarObject.getJSONObject("1").getString("link");
               String w_star_2_name = w_StarObject.getJSONObject("2").getString("name");
               String w_star_2_link = w_StarObject.getJSONObject("2").getString("link");
               String w_star_3_name = w_StarObject.getJSONObject("3").getString("name");
               String w_star_3_link = w_StarObject.getJSONObject("3").getString("link");
               String w_star_4_name = w_StarObject.getJSONObject("4").getString("name");
               String w_star_4_link = w_StarObject.getJSONObject("4").getString("link");
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
               String w_type1 = w_TypeObject.getJSONObject("1").getString("name");

               LogUtil.HDLog("即将上映的电影："+"\n"+
               w_director_name+"\n"+
               w_play_data1+"\n"+
               w_star_1_name+"\n"+
               w_star_2_name+"\n"+
               w_story_brief+"\n"+
               w_type1+"\n"
               );
           }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
