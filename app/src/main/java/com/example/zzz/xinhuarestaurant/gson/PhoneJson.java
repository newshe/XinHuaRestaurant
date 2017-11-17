package com.example.zzz.xinhuarestaurant.gson;

/**
 * Created by zzz on 2017/11/14.
 */

public class PhoneJson {


    /**
     * request_status : successful
     * return_info : {"status_code":5408,"request_message":"当前号码不存在","request_time":1510590756,"request_proof":false,"token":null}
     */

    private String request_status;
    private ReturnInfoBean return_info;

    public String getRequest_status() {
        return request_status;
    }

    public void setRequest_status(String request_status) {
        this.request_status = request_status;
    }

    public ReturnInfoBean getReturn_info() {
        return return_info;
    }

    public void setReturn_info(ReturnInfoBean return_info) {
        this.return_info = return_info;
    }

    public static class ReturnInfoBean {
        /**
         * status_code : 5408
         * request_message : 当前号码不存在
         * request_time : 1510590756
         * request_proof : false
         * token : null
         */

        private int status_code;
        private String request_message;
        private int request_time;
        private boolean request_proof;
        private Object token;

        public int getStatus_code() {
            return status_code;
        }

        public void setStatus_code(int status_code) {
            this.status_code = status_code;
        }

        public String getRequest_message() {
            return request_message;
        }

        public void setRequest_message(String request_message) {
            this.request_message = request_message;
        }

        public int getRequest_time() {
            return request_time;
        }

        public void setRequest_time(int request_time) {
            this.request_time = request_time;
        }

        public boolean isRequest_proof() {
            return request_proof;
        }

        public void setRequest_proof(boolean request_proof) {
            this.request_proof = request_proof;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }
    }
}
