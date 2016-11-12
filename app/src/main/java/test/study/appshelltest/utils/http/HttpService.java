package test.study.appshelltest.utils.http;


import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;
import test.study.appshelltest.Bean.SearchMoviesBean;

/**
 * Created by marks on 2016/8/5.
 */
public interface HttpService {

    //测试加解密
    @POST("/api/wifi/sync")
    Call<String> uploadWifi(@Body RequestBody datas);

    @GET("/api/wifi/getWifiPass")
    Call<String> downloadWifi();

    //统计服务器     反馈的接口
    @POST("/manage-weshare/device/addFeedback")
    Call<String> uploadFeedbackInfo(@Body RequestBody body);

    //3.3 上传头像修改信息
    @GET("/weshare/ren/gtx/{iconfileid}/{userid}")
    Observable<Integer> saveUserIcon(@Path("iconfileid") String iconpath, @Path("userid") String userid);

    //上传头像
    @Multipart
    @POST("https://global.18wifibank.com/api/wezz/slai")
    Observable<String> uploadUserIcon(
            @Part("describe") String describe,
            @Part("type") String type,
            @Part("userid") String userid,
            @Part("fileName") RequestBody description,
            @Part("file\"; filename=\"image.png\"") RequestBody img
    );

    //哥伦布项目
    //1.1保存用户信息
    @POST("api/user/save")
    Observable<String> saveUserInfo(@Body RequestBody body);
    //todo 1.2查询用户信息

    //2.1 获取我的未读取私信个数接口
    @POST("api/msg/count/{userid}")
    Observable<String> getUnreadMsgCount(@Path("userid") String userid);

    //2.2 获取我的私信列表接口
    @POST("api/msg/myrecied")
    Observable<String> getMyPrivateLetter(@Body RequestBody body);

    //todo 2.3 标识已读私信接口
    @GET("api/msg/setread/{msgid}/{readuser}")
    Observable<String> getReaded(@Path("msgid") String msgid, @Path("readuser") String readuser);

    //todo 2.4 根据原图ID查询对应模板ID接口
    @GET("api/templet/qtmpid/{parentid}")
    Observable<String> getModeIdByPicId(@Path("parentid") String parentid);

    //todo 2.5 根据原图id 查询模板以及对应资源IDs 接口
    @GET("api/templet/qtempinfo/{parentid}")
    Observable<String> getResourceIdByPicId(@Path("parentid") String parentid);

    //todo 2.6 根据模板id 查询模板以及对应资源IDs 接口
    @GET("api/templet/qtempinfox/{parentid}")
    Observable<String> getResourceIdByModeId(@Path("parentid") String parentid);

    //todo 3.1 我的照片信息接口
    @POST("api/myphoto/pts")
    Observable<String> getMyPicInfoByFBID(@Body RequestBody body);

    //4.1  图片，语言信息 流上传
//    userid	上传用户的facebookid	String	f_+fbid
//    uploadType	上传文件类型(打包文件是子文件传2;原图上传是父文件传1)	int
//    context	文本内容(子模板文件传NUll)	String	原图上传的时候带文本内容
//    tempId	子类文件不传，父类文件上传对应的模板id	String
    @Multipart
    @POST("api/file/upload")
    Observable<String> upLoadPicInfo(
            @Part("userid") String facebookid,
            @Part("uploadType") String type,
            @Part("context") String content,
            @Part("tempId") String tempId
    );


    //1.影视搜索
    @GET("video")
    Observable<SearchMoviesBean> SearchMovies(@QueryMap Map<String, String> map);
    //2.最近影讯
    @GET("pmovie?")
    Observable<String> getRecentMovies(@QueryMap Map<String, String> map);
    //3.最新票房榜
    @GET("boxoffice/rank.php?area=CN&dtype=json&key=7080334373d1f2dee5c9c3c2cbb30e9a")
    Observable<String> getMoviesRank();

//    //3.访问百度
//    @GET("www.baidu.com")
//    Observable<String> getBaidu();

}
//http://v.juhe.cn/boxoffice/rank?key=7080334373d1f2dee5c9c3c2cbb30e9a&area=CN
//http://v.juhe.cn/boxoffice/rank.php?key=7080334373d1f2dee5c9c3c2cbb30e9a&area=CN