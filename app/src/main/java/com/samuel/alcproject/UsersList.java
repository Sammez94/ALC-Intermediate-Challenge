package com.samuel.alcproject;

/**
 * Created by USER on 8/29/2017.
 */

public class UsersList {




        private String login;
        private String avatar_url;
        private String html_url;


        public String getLogin() {
            return login;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public String getHtml_url() {
            return html_url;
        }


        public UsersList(String login, String gitUrl, String avatar_url) {
            this.login = login;
            this.avatar_url = avatar_url;
            this.html_url = gitUrl;

        }

    }


