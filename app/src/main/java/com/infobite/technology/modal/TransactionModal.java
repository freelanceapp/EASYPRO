package com.infobite.technology.modal;

public class TransactionModal {

    private String invoiceno;
    private String date;
    private String packages;
    private String paymentmethod;
    private int viewdetailimage;

    public TransactionModal(String invoiceno, String date, String packages, String paymentmethod, int viewdetailimage) {
        this.invoiceno = invoiceno;
        this.date = date;
        this.packages = packages;
        this.paymentmethod = paymentmethod;
        this.viewdetailimage = viewdetailimage;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public int getViewdetailimage() {
        return viewdetailimage;
    }

    public void setViewdetailimage(int viewdetailimage) {
        this.viewdetailimage = viewdetailimage;
    }
}
