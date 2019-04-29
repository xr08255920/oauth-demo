package com.yejf.oauth.dto;

import lombok.Data;

@Data
public class BaiduAccessTokenDTO {
    /**
     * expires_in : 2592000
     * refresh_token : 22.559686f712eb8711e330bf89f04dde33.315360000.1871904959.923039760-16085652
     * access_token : 21.05e7d3b41dbd729beb2231d46a4898ce.2592000.1559136959.923039760-16085652
     * session_secret : 951a2afc1f196c12b8711e87d8efb090
     * session_key : 9mnRdL4nL/jvqVaeuzRj0AgNXnsIuU4TscCnZ/64My1WEDEbalnnloZXY84XqiYj7IlT/GS6hQlX30MuoYA5u/ZoGxW1K9NQAA==
     * scope : basic
     */

    private int expires_in;
    private String refresh_token;
    private String access_token;
    private String session_secret;
    private String session_key;
    private String scope;

}
