/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cousmeapi;

/**
 *
 * @author jennifer.okosisi
 */
public class CustomersResponse {
      private String customer_no;
    private String name;
    private String address;
    private String tariff;
    private Double outstanding;
    private String meter;
    private String is_prepaid;
    private Integer code;
   private String message;

   
    @Override
    public String toString() {
        return "CustomersResponse{" + "customer_no=" + customer_no + ", name=" + name + ", address=" + address + ", tariff=" + tariff + ", outstanding=" + outstanding + ", meter=" + meter + ", is_prepaid=" + is_prepaid + ", code=" + code + ", message=" + message + '}';
    }

    public CustomersResponse(String customer_no, String name, String address, String tariff, Double outstanding, String meter, String is_prepaid, Integer code, String message) {
        this.customer_no = customer_no;
        this.name = name;
        this.address = address;
        this.tariff = tariff;
        this.outstanding = outstanding;
        this.meter = meter;
        this.is_prepaid = is_prepaid;
        this.code = code;
        this.message = message;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public Double getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(Double outstanding) {
        this.outstanding = outstanding;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getIs_prepaid() {
        return is_prepaid;
    }

    public void setIs_prepaid(String is_prepaid) {
        this.is_prepaid = is_prepaid;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
   