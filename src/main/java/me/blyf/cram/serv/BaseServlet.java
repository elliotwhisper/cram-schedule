package me.blyf.cram.serv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.velocity.app.Velocity;


public class BaseServlet extends HttpServlet{
    private static final long serialVersionUID = -5494369847253378008L;
    
    @Override
    public void init() throws ServletException {
        String prop = BaseServlet.class.getClassLoader().getResource("velocity.properties").getFile();
        Velocity.init(prop);
    }
    
}
