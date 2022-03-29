package com.windynova.java.sima.service;

import javax.servlet.http.HttpSession;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
public interface UserService {
    void register(String name, String grade, String password);
    User login(HttpSession session);;
}
