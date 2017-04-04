package com.portier.oauth.examples;

/**
 * This class stores the access token.
 * @author dpj
 *
 */
public class AccessTokenData {

    /**
     *** instance variables.
     **/
    private String accessToken;
     /**
     *** instance variables.
     **/
    private String refreshToken;

    /**
     ** gets the access token.
     ** @return access token
    */
    public String getAccessToken() {
      return accessToken;
    }
    /**
     * Sets access token.
     * @param accessToken access token.
     */
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Returns the refresh token.
     * @return refresh token.
     */
    public String getRefreshToken() {
      return refreshToken;
    }

    /**
     * Sets refresh token.
     * @param refreshToken refresh token.
     */
    public void setRefreshToken(final String refreshToken) {
       this.refreshToken = refreshToken;
    }
}