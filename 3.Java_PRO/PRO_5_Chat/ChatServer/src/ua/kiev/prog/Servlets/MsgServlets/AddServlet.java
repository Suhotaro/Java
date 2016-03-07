package ua.kiev.prog.Servlets.MsgServlets;

import ua.kiev.prog.Msg.Message;
import ua.kiev.prog.Msg.MessageList;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {

	private MessageList msgList = MessageList.getInstance();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException 
	{

		HttpSession http_session = req.getSession(false);
		if (http_session == null)
			resp.setStatus(400); // Bad request

		InputStream is = req.getInputStream();
		byte[] buf = new byte[req.getContentLength()];
		is.read(buf);
		
		Message msg = Message.fromJSON(new String(buf));
		if (msg != null)
			msgList.add(msg);
		else
			resp.setStatus(400); // Bad request
	}
}
