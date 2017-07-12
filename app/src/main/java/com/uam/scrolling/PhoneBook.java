package com.uam.scrolling;

import android.graphics.Bitmap;

/**
 * Created by Iforce on 7/12/2017.
 */

public class PhoneBook {
    private Bitmap uAvatar;
    private String uName;
    private String uPhone;
    private String uEmail;

    public PhoneBook(Bitmap avatar, String name, String phone, String email) {
        uAvatar = avatar;
        uName = name;
        uPhone = phone;
        uEmail = email;
    }

    public void setAvatar(Bitmap avatar) {
        uAvatar = avatar;
    }
    public Bitmap getAvatar() {
        return uAvatar;
    }

    public void setName(String name) {
        uName = name;
    }
    public String getName() {
        return uName;
    }

    public void setPhone(String phone) {
        uPhone = phone;
    }
    public String getPhone() {
        return uPhone;
    }

    public void setEmail(String email) {
        uEmail = email;
    }
    public String getEmail() {
        return uEmail;
    }
}
