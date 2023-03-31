package ch07;

import javax.servlet.http.HttpServletRequest;

public class MuUtil {
	public static int parseInt(HttpServletRequest request, String name) {
		return Integer.parseInt(request.getParameter(name));
	}
}
