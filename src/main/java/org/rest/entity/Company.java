package org.rest.entity;


public class Company {

    private int id;
    private String title;
    private String founded;


    public Company() {
    }

    public Company(String title, String founded) {
        this.title = title;
        this.founded = founded;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", founded='" + founded + '\'' +
                '}';
    }
}