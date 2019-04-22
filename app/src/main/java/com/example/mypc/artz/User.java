package com.example.mypc.artz;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String user_id;
    private long phone_no;
    private String email;
    private String user_name;

    public User(String user_id, long phone_number, String email, String username) {
        this.user_id = user_id;
        this.phone_no = phone_number;
        this.email = email;
        this.user_name = username;
    }

    public User() {

    }
    protected User(Parcel in) {
        user_id = in.readString();
        phone_no = in.readLong();
        email = in.readString();
        user_name = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getPhone_number() {
        return phone_no;
    }

    public void setPhone_number(long phone_number) {
        this.phone_no = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String username) {
        this.user_name = username;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", phone_number='" + phone_no + '\'' +
                ", email='" + email + '\'' +
                ", username='" + user_name + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_id);
        dest.writeLong(phone_no);
        dest.writeString(email);
        dest.writeString(user_name);
    }
}


