package org.testingacademy.ex15_DataDrivenTesting;

import org.testng.annotations.Test;

public class DataDrivenExcel {

    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void test_VWOLogin(String email, String password) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Simulate a simple login logic
        if (email.equalsIgnoreCase("admin@example.com") && password.equals("admin123")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Invalid email or password.");
        }
    }
}
