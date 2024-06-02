package com.wingman.clothingshopmanagement.util;

import org.mindrot.jbcrypt.BCrypt;


public class BCryptUtil {
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(14));
    }
    
    public static boolean check(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
