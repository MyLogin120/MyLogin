package com.project.mylogin;

public class LoginManager {

    public boolean validateUser(User user) {
        // Logika sederhana untuk validasi login
        // Anda bisa mengganti ini dengan validasi yang lebih kompleks (misal dari database).
        return "admin".equals(user.getUsername()) && "admin".equals(user.getPassword());
    }
}