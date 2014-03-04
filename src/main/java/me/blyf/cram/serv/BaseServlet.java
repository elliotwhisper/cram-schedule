package me.blyf.cram.serv;

import java.io.StringWriter;

import javax.servlet.http.HttpServlet;

import me.blyf.cram.util.Const;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public abstract class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 5361970252965740279L;
	
	protected byte[] getByteArray(String template, VelocityContext context){
    	StringWriter sw = new StringWriter();
        Template t = Velocity.getTemplate(template);
        t.merge(context, sw);
        return sw.toString().getBytes(Const.ENCODING);
    }
}
