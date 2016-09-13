package test.study.appshelltest.Bean;

import java.util.List;

/**
 * Created by 李鸿达 on 2016/9/13.
 */
public class MoviesRankBean {

    /**
     * resultcode : 200
     * reason : success
     * result : [{"rid":"1","name":"中国合伙人","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥20900万","tboxoffice":"￥31700万"},{"rid":"2","name":"钢铁侠3","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥4480万","tboxoffice":"￥74480万"},{"rid":"3","name":"疯狂原始人","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥3050万","tboxoffice":"￥35240万"},{"rid":"4","name":"遗落战境","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥2680万","tboxoffice":"￥13980万"},{"rid":"5","name":"致我们终将逝去的青春","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥2290万","tboxoffice":"￥71206万"},{"rid":"6","name":"圣诞玫瑰(new)","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥1390万","tboxoffice":"￥1390万"},{"rid":"7","name":"一路狂奔(new)","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥350万","tboxoffice":"￥350万"},{"rid":"8","name":"被解救的姜戈","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥309万","tboxoffice":"￥1664万"},{"rid":"9","name":"临终囧事","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥285万","tboxoffice":"￥660万"},{"rid":"10","name":"西柏坡2：王二小","wk":"2013.5.20--2013.5.26（单位：人民币）","wboxoffice":"￥25万","tboxoffice":"￥45万"}]
     */

    private String resultcode;
    private String reason;
    /**
     * rid : 1
     * name : 中国合伙人
     * wk : 2013.5.20--2013.5.26（单位：人民币）
     * wboxoffice : ￥20900万
     * tboxoffice : ￥31700万
     */

    private List<ResultBean> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String rid;
        private String name;
        private String wk;
        private String wboxoffice;
        private String tboxoffice;

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWk() {
            return wk;
        }

        public void setWk(String wk) {
            this.wk = wk;
        }

        public String getWboxoffice() {
            return wboxoffice;
        }

        public void setWboxoffice(String wboxoffice) {
            this.wboxoffice = wboxoffice;
        }

        public String getTboxoffice() {
            return tboxoffice;
        }

        public void setTboxoffice(String tboxoffice) {
            this.tboxoffice = tboxoffice;
        }
    }
}
