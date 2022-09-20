package uz.exemple.less58_twitterui_multiview_java.model;

public class Story {
    private int profile;
    private String fullname;

    public Story(int profile, String fullname) {
        this.profile = profile;
        this.fullname = fullname;
    }

    public int getProfile() {
        return profile;
    }

    public String getFullname() {
        return fullname;
    }
}
