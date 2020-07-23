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
public class CustomerRequest {
    private String customer_no;

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public CustomerRequest(String customer_no) {
        this.customer_no = customer_no;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" + "customer_no=" + customer_no + '}';
    }
    
    
    
}
