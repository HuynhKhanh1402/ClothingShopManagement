/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Administrator
 */
public class BCryptUtil {
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(14));
    }
    
    public static boolean check(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
