package ua.kiev.prog;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetListServlet extends HttpServlet {
	
	private MessageList msgList = MessageList.getInstance();
	private UsersMap usersMap = UsersMap.getInstance();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException 
	{
		OutputStream os = resp.getOutputStream();

		HttpSession http_session = req.getSession(false);
		if (http_session == null)
			os.write("Error".getBytes());

		String fromStr = req.getParameter("from");
		int from = Integer.parseInt(fromStr);

		String json = msgList.toJSON(from);
		if (json != null)
			os.write(json.getBytes());

		String user_name = (String) http_session.getAttribute("login");
		User user = usersMap.getUser(user_name);

		String private_messages = "PRIVATE:" + user.toJSON();

		if (private_messages != null)
			os.write(private_messages.getBytes());
	}
}
