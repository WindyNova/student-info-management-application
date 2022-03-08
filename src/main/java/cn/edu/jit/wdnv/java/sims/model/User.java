package cn.edu.jit.wdnv.java.sims.model;

/**
 * Table: user
 */
public class User {
    /**
     * Column: username
     * Type: CHAR(12)
     */
    private String username;

    /**
     * Column: password
     * Type: CHAR(12)
     */
    private String password;

    /**
     * Column: level
     * Type: CHAR(6)
     */
    private String level;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}