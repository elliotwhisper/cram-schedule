package me.blyf.cram.serv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.velocity.app.Velocity;

public class Service extends HttpServlet{
    private static final long serialVersionUID = -6406211214643989367L;

    @Override
    public void init() throws ServletException {
        String prop = Service.class.getClassLoader().getResource("velocity.properties").getFile();
        Velocity.init(prop);
        System.out.println("a");
    }
}
