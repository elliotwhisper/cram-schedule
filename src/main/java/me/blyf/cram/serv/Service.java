package me.blyf.cram.serv;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Service extends HttpServlet{
    private static final long serialVersionUID = -6406211214643989367L;

    @Override
    public void init() throws ServletException {
        String prop = BaseServlet.class.getClassLoader().getResource("velocity.properties").getFile();
        Velocity.init(prop);
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            System.out.println(sdf.format(new Date(1402761600000L)));
            System.out.println(new Date().getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VelocityContext context = new VelocityContext();
        context.put("name", "elliot");
        StringWriter sw = new StringWriter();
        Template template = Velocity.getTemplate("vm/index.vm", "utf8");
        template.merge(context, sw);
        resp.getOutputStream().write(sw.toString().getBytes());
        System.out.println(req.getRequestURL().toString());
        System.out.println(req.getServletPath());
    }
}
