package com.swaiotos.launcher.kidsmode.home.model;

import java.util.List;

public class HomePageData {

        private int recommendId;
        private String backgroundImage;
        private String recommendTitle;
        private long timestamp;
        private List<SubRecommendsBean> subRecommends;

        public int getRecommendId() {
            return recommendId;
        }

        public void setRecommendId(int recommendId) {
            this.recommendId = recommendId;
        }

        public String getBackgroundImage() {
            return backgroundImage;
        }

        public void setBackgroundImage(String backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        public String getRecommendTitle() {
            return recommendTitle;
        }

        public void setRecommendTitle(String recommendTitle) {
            this.recommendTitle = recommendTitle;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<SubRecommendsBean> getSubRecommends() {
            return subRecommends;
        }

        public void setSubRecommends(List<SubRecommendsBean> subRecommends) {
            this.subRecommends = subRecommends;
        }

        public static class SubRecommendsBean {
            /**
             * sequence : 8
             * recommendId : 1118
             * backgroundImage : http://beta-wisdom-img.skysrt.com/icon/2020/02/11/8359769918033552.png
             * recommendTitle : 儿童模式推介位1
             * startType : 5
             * onclickEvent : {"bywhat":"action","exception":{},"byvalue":"{param1:param11}","data":"d1=d11","dowhat":"startActivity","packagename":"com.coocaa.xxx1","params":{}}
             */

            private int sequence;
            private int recommendId;
            private String backgroundImage;
            private String recommendTitle;
            private int startType;
            private String onclickEvent;

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public int getRecommendId() {
                return recommendId;
            }

            public void setRecommendId(int recommendId) {
                this.recommendId = recommendId;
            }

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
            }

            public String getRecommendTitle() {
                return recommendTitle;
            }

            public void setRecommendTitle(String recommendTitle) {
                this.recommendTitle = recommendTitle;
            }

            public int getStartType() {
                return startType;
            }

            public void setStartType(int startType) {
                this.startType = startType;
            }

            public String getOnclickEvent() {
                return onclickEvent;
            }

            public void setOnclickEvent(String onclickEvent) {
                this.onclickEvent = onclickEvent;
            }
        }
}
