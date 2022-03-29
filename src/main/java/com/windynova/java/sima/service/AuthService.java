package com.windynova.java.sima.service;

import javax.servlet.http.HttpSession;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
public interface AuthService {
    void register(String name, String sex, String grade, String password);
    User login(HttpSession session);;
}
