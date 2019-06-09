package com.wd.tech.bean;

public class LoginBean {



    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * headPic : http://mobile.bwstudent.com/images/tech/default/tech.jpg
         * nickName : qqqqqqq
         * phone : 18813145182
         * pwd : k2Krj2dtgiGOnuvkJBm3sUhZYUX03yrhGARknfrBdfulMrn41RLnrkXwtuWaVTaviRdD4o5BZ5u0BYhRw10wK/jVKmPXsv8YpP9U9rYAMWKE0SIjZP1Eu9OhNMc2uk7+I1N9vfPsabgIppm/TjmbhUnJsqrFUVxm/wn/eX8OfEU=
         * sessionId : 1559717703152760
         * userId : 760
         * userName : M5pc3z18813145182
         * whetherFaceId : 0
         * whetherVip : 2
         */

        private String headPic;
        private String nickName;
        private String phone;
        private String pwd;
        private String sessionId;
        private int userId;
        private String userName;
        private int whetherFaceId;
        private int whetherVip;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWhetherFaceId() {
            return whetherFaceId;
        }

        public void setWhetherFaceId(int whetherFaceId) {
            this.whetherFaceId = whetherFaceId;
        }

        public int getWhetherVip() {
            return whetherVip;
        }

        public void setWhetherVip(int whetherVip) {
            this.whetherVip = whetherVip;
        }
    }
}
