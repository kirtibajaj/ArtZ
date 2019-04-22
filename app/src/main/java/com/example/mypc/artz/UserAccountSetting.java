package com.example.mypc.artz;

import android.os.Parcel;
import android.os.Parcelable;

public class UserAccountSetting implements Parcelable {

    private String description;
    private String display_name;
    private long followers;
    private long following;
    private long posts;
    private String profile_photo;
    private String user_name;
    private String web_link;
    private String user_id;

    public UserAccountSetting(String description, String display_name, long followers,
                               long following, long posts, String profile_photo, String username,
                               String website, String user_id) {
        this.description = description;
        this.display_name = display_name;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.profile_photo = profile_photo;
        this.user_name = username;
        this.web_link = website;
        this.user_id = user_id;
    }

    public UserAccountSetting() {

    }

    protected UserAccountSetting(Parcel in) {
        description = in.readString();
        display_name = in.readString();
        followers = in.readLong();
        following = in.readLong();
        posts = in.readLong();
        profile_photo = in.readString();
        user_name = in.readString();
        web_link = in.readString();
        user_id = in.readString();
    }

    public static final Creator<UserAccountSetting> CREATOR = new Creator<UserAccountSetting>() {
        @Override
        public UserAccountSetting createFromParcel(Parcel in) {
            return new UserAccountSetting(in);
        }

        @Override
        public UserAccountSetting[] newArray(int size) {
            return new UserAccountSetting[size];
        }
    };

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getFollowing() {
        return following;
    }

    public void setFollowing(long following) {
        this.following = following;
    }

    public long getPosts() {
        return posts;
    }

    public void setPosts(long posts) {
        this.posts = posts;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String username) {
        this.user_name = username;
    }

    public String getWebsite() {
        return web_link;
    }

    public void setWebsite(String website) {
        this.web_link = website;
    }


    @Override
    public String toString() {
        return "UserAccountSettings{" +
                "description='" + description + '\'' +
                ", display_name='" + display_name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", posts=" + posts +
                ", profile_photo='" + profile_photo + '\'' +
                ", username='" + user_name + '\'' +
                ", website='" + web_link + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(display_name);
        dest.writeLong(followers);
        dest.writeLong(following);
        dest.writeLong(posts);
        dest.writeString(profile_photo);
        dest.writeString(user_name);
        dest.writeString(web_link);
        dest.writeString(user_id);
    }
}

