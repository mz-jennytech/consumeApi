/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cousmeapi;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jennifer.okosisi
 */
public class TokenReponse {
    
     private String accessCode;
    private String username;
     private String issuedOn;
     private String ResponseMessage;
     private String validUntil;
   private Integer ResponseCode;

    @Override
    public String toString() {
        return "TokenReponse{" + "accessCode=" + accessCode + ", username=" + username + ", issuedOn=" + issuedOn + ", ResponseMessage=" + ResponseMessage + ", validUntil=" + validUntil + ", ResponseCode=" + ResponseCode + '}';
    }

    public String getAccessCode() {
        return accessCode;
        }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(String issuedOn) {
        this.issuedOn = issuedOn;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String ResponseMessage) {
        this.ResponseMessage = ResponseMessage;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(Integer ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public TokenReponse(String accessCode, String username, String issuedOn, String ResponseMessage, String validUntil, Integer ResponseCode) {
        this.accessCode = accessCode;
        this.username = username;
        this.issuedOn = issuedOn;
        this.ResponseMessage = ResponseMessage;
        this.validUntil = validUntil;
        this.ResponseCode = ResponseCode;
    }

}
//
//    String getToken() throws NoSuchAlgorithmException, KeyManagementException {
//        CustomersServices c = new CustomersServices();
//        return c.getToken();
//       }
//    }
