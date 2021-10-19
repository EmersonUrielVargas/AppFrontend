package jsons;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("Agregar");
		String eliminar = request.getParameter("Eliminar");
		String actualizar = request.getParameter("Actualizar");
		String ingresar = request.getParameter("Ingresar");

		if (agregar != null) {
			this.addUser(request, response);
		}
		if (listar != null) {
			this.listUsers(request, response);
		}
		if (eliminar != null) {
			this.deleteUser(request, response);
		}
		if (actualizar != null) {
			this.updateUser(request, response);
		}
		if (ingresar != null) {
			this.verifyUser(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String createUser = request.getParameter("createU_addUser");
		String updateUser = request.getParameter("updateU_updateUser");
		String deleteUser = request.getParameter("deleteU_deleteUser");
		String showUser = request.getParameter("showU_showUser");

		if (createUser != null) {
			System.out.println("ENTRO A CREAR UN USUARIO");
			this.addUser(request, response);
		}

		if (updateUser != null) {
			System.out.println("ENTRO A ACTUALIZAR UN USUARIO");
			this.updateUser(request, response);
		}

		if (deleteUser != null) {
			System.out.println("ENTRO A ELIMINAR UN USUARIO");
			this.deleteUser(request, response);
		}

		if (showUser != null) {
			System.out.println("ENTRO A BUSCAR UN USUARIO");
			this.askUser(request, response);
		}
	}

	public void askUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long userId = Long.parseLong(request.getParameter("showU_userId"));
			Users user = TestJSON.askUser(userId);
			String page = "/JSP_Show_User.jsp";
			request.setAttribute("resultShowUser", user);
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
			dispacher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void addUser(HttpServletRequest request, HttpServletResponse response) {
		Users user = new Users();
		String auxId = request.getParameter("createU_userId");
		user.setUser_id(Long.parseLong(auxId));
		user.setUser_name(request.getParameter("createU_userName"));
		user.setUser_email(request.getParameter("createU_emailUser"));
		user.setUser(request.getParameter("createU_user"));
		user.setPassword(request.getParameter("createU_password"));
		int result = 0;
		boolean resultAdd = false;

		try {
			result = TestJSON.postJSON(user);
			String page = "/JSP_Create_User.jsp";

			if (result == 200) {
				resultAdd = true;
				request.setAttribute("resultAddUser", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (result == 300) {
				request.setAttribute("resultAddUser", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(resultAdd);

	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response) {
		Users user = new Users();
		String auxId = request.getParameter("updateU_userId");
		user.setUser_id(Long.parseLong(auxId));
		user.setUser_name(request.getParameter("updateU_userName"));
		user.setUser_email(request.getParameter("updateU_emailUser"));
		user.setUser(request.getParameter("updateU_user"));
		user.setPassword(request.getParameter("updateU_password"));
		int result = 0;
		String page = "/JSP_Update_User.jsp";
		boolean resultUpdate = false;
		try {
			result = TestJSON.putJSON(user);
			if (result == 200) {
				resultUpdate = true;
				request.setAttribute("resultUpdateUser", resultUpdate);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				request.setAttribute("resultUpdateUser", resultUpdate);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Users> list = TestJSON.getJSON();
			String page = "/JSP_Show_Users.jsp";
			request.setAttribute("list", list);
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
			dispacher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL LISTAR");
			e.printStackTrace();
		}

	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		Long auxId = Long.parseLong(request.getParameter("deleteU_userId"));
		int result = 0;
		String page = "/JSP_Delete_User.jsp";
		boolean resultDelete = false;
		try {
			result = TestJSON.deleteJSON(auxId);
			if (result == 200) {
				resultDelete = true;
				request.setAttribute("resultDeleteUser", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				request.setAttribute("resultDeleteUser", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void verifyUser(HttpServletRequest request, HttpServletResponse response) {
		String user = request.getParameter("userName");
		String password = request.getParameter("passwordUser");

		if (user.equals("admin") && password.equals("password")) {
			String page = "/JSP_Principal_Menu_Admin.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(page);
			try {
				dispacher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String page = "/index.jsp";
			request.setAttribute("resultValidateUser", false);
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
			try {
				dispacher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
