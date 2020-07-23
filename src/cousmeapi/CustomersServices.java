/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cousmeapi;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author jennifer.okosisi
 */
public class CustomersServices {
    public String getToken() throws NoSuchAlgorithmException, KeyManagementException{
           TokenReponse tokenResponse = null;
            String processCode = "";
       
             String username = "09cc4f8d76f2_demo";
            String password = "bCG#v4*Mj0*TZb9_g7uW^";
    
        try{
            
            TokenReques tokenRequest = new TokenReques(username, password);
            Gson gson = new Gson();
          
             String jsonParameters = gson.toJson(tokenRequest);
             
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustManager = getTrustManager();
            sslContext.init(null, trustManager, new SecureRandom());
            HttpsURLConnection .setDefaultSSLSocketFactory(sslContext.getSocketFactory());
                
            URL url = new URL ("https://api.kvg.com.ng/auth/demo");
             HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
             con.setDoOutput(true);
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
             
             con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
           con.setRequestProperty("Content-Type", "application/json; utf-8");
           
           try(OutputStream os = con.getOutputStream()) 
            {
                        byte[] input = jsonParameters.getBytes("utf-8");
                        os.write(input, 0, input.length);           
            }
            
             int responseCode = con.getResponseCode();
           
                    if (responseCode != 200)
                    {
                throw new  ServerException("Failed : HTTP error code here: " + responseCode);
            }
 
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer response = new StringBuffer();
            String output;
 
            while ((output = in.readLine()) != null)
            {
                // System.out.println("This is output " + output);
                response.append(output);
            }
 
            in.close();
             String output2 = response.toString();
            
            tokenResponse = gson.fromJson(output2, TokenReponse.class);
            processCode = tokenResponse.getAccessCode();
            
            //System.out.println(processCode);

 
          } catch (MalformedURLException e) {
 
            e.printStackTrace();
 
          } catch (IOException e) {
 
            e.printStackTrace();
          }
       return processCode;
      }
      private TrustManager[] getTrustManager() {
        TrustManager[] certs = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String t) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String t) {
            }
        }
        };
        return certs;
      }
          

    public String getCustomerAcc(String customer_no) throws NoSuchAlgorithmException, KeyManagementException, IOException 
    {
        System.out.println("Inside Customer method");
        String accessNo = getToken();

//        TokenResponse tokenResponse = null;
        try {
            
            CustomerRequest req = new CustomerRequest(customer_no);
            Gson gson = new Gson();
            
            String jsonParameters = gson.toJson(req);
            
            // Create a context that doesn’t check certificates.
                    SSLContext sslContext = SSLContext.getInstance("TLS");
                    TrustManager[] trustManager = getTrustManager();
                    sslContext.init(null, trustManager, new SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        
                       
               URL url = new URL ("https://api.kvg.com.ng/demo/energy/aedc/postpaid/customer");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
           // ONLY FOR POST REQUEST
            con.setDoOutput(true);
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            // ONLY FOR POST REQUEST
            
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Authorization", "Bearer " + accessNo);
             
            try(OutputStream os = con.getOutputStream()) 
            {
                        byte[] input = jsonParameters.getBytes("utf-8");
                        os.write(input, 0, input.length);           
            }
            
             int responseCode = con.getResponseCode();
             
                
             if(responseCode != 200)
             {
                throw new ServerException("Failed : HTTP error code here: " + responseCode);
             }
            
            
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer response = new StringBuffer();
            String output;
            
            while ((output = in.readLine()) != null)
            {
                System.out.println(output);
                response.append(output);
            }
            in.close();
        } 
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return accessNo;
      }
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException
    {
        CustomersServices s = new CustomersServices();
        s.getCustomerAcc("123");
    }

}
