package com.udemy.testdata;

import com.udemy.models.User;

public interface UserData {

    User newUser = new User("lena" + System.currentTimeMillis(), "lena"+ System.currentTimeMillis() + "@appcreative.net", "Udemy123Ud" );
    User createdUser = new User("lena233", "lena233@appcreative.net", "Udemy123Ud");

}
