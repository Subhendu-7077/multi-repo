package com.example.servlet_demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servlet_demo.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel user = new UserModel();
		user.setId(1);
		user.setName("Subhendu Behera");
		user.setEmail("bsubhendu76560@gmail.com");
		user.setPhone("70777516242");
		user.setAddress("Kendrapara");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);

		// Set response type and write JSON
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}
}