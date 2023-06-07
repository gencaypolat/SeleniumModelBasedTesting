// Generated by GraphWalker (http://www.graphwalker.org)
package com.company;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/company/addToCart.json")
public interface login {

    @Vertex()
    void v_loginPage();

    @Vertex()
    void v_openAccount();

    @Vertex()
    void v_homePage();

    @Vertex()
    void v_StartVertex();

    @Edge()
    void e_goLoginPage();

    @Edge()
    void e_typeCredentials();

    @Edge()
    void e_goHomePage();

    @Edge()
    void e_clickContinue();

    @Edge()
    void e_logout();

    @Edge()
    void e_reLogin();

    @Vertex()
    void v_closeAccount();
}
