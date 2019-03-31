package com.pursuit.handy_helper_app;

class Job {

    private Job job;
    private String address;
    private String date;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }
    public String getJob(){
        return String.valueOf(job);
    }

    public void setDate(String date) {
        this.date = date;
    }
}
