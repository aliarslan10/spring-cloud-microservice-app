package com.example.aliarslan.client.account.model;

/**
 * It should have same fields with same naming with AccountResponse (in AccountController)
 * for correct mapping to prevent null fields.
 */
public class AccountServiceResponse {
    private String userId;
    private String username;
    private String mailAddress;
    private String isActive;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getIsActive() {
        return isActive;
    }
}
