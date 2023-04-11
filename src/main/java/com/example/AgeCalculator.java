package com.example;

import java.time.LocalDate;
import java.time.Period;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculator extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
      LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
      LocalDate now = LocalDate.now();
      Period period = Period.between(birthdate, now);
      int age = period.getYears();
      response.getWriter().write("Your age is " + age + " years.");
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}

