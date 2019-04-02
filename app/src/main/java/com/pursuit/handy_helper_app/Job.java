package com.pursuit.handy_helper_app;

class Job {

    private String address;
    private String date;
    private String note;

    public Job(String date, String address, String note) {
        this.date = date;
        this.address = address;
        this.note = note;
    }

    public Job() {
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    public void setAddress(String address) { this.address = address; }

    public void setDate(String date) { this.date = date; }
    public void setNote(String note) { this.note = note; }
}