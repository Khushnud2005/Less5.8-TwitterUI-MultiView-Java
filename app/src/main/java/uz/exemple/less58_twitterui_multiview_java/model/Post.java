package uz.exemple.less58_twitterui_multiview_java.model;

public class Post {
    private int profile;
    private String fullname;
    private int photo;
    private Integer photo2 = null;
    String video = null;

    public Post(int profile, String fullname, String video) {
        this.profile = profile;
        this.fullname = fullname;
        this.video = video;
    }
    public Post(int profile, String fullname, int photo) {
        this.profile = profile;
        this.fullname = fullname;
        this.photo = photo;
    }
    public Post(int profile, String fullname, int photo,int photo2) {
        this.profile = profile;
        this.fullname = fullname;
        this.photo = photo;
        this.photo2 = photo;
    }


    public int getProfile() {
        return profile;
    }

    public String getFullname() {
        return fullname;
    }

    public int getPhoto() {
        return photo;
    }
    public Integer getPhoto2() {
        return photo2;
    }

    public String getVideo() {
        return video;
    }
}
