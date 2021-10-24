package jsons;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String createClient = request.getParameter("createC_addClient");
		String updateClient = request.getParameter("updateC_updateClient");
		String deleteClient = request.getParameter("deleteC_deleteClient");
		String showClient = request.getParameter("showC_showClient");
		String createVendor = request.getParameter("createV_addVendor");
		String updateVendor = request.getParameter("updateV_updateVendor");
		String deleteVendor = request.getParameter("deleteV_deleteVendor");
		String showVendor = request.getParameter("showV_showVendor");

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

		if (createClient != null) {
			System.out.println("ENTRO A CREAR UN CLIENTE");
			this.addClient(request, response);
		}

		if (updateClient != null) {
			System.out.println("ENTRO A ACTUALIZAR UN CLIENTE");
			this.updateClient(request, response);
		}

		if (deleteClient != null) {
			System.out.println("ENTRO A ELIMINAR UN CLIENTE");
			this.deleteClient(request, response);
		}

		if (showClient != null) {
			System.out.println("ENTRO A BUSCAR UN CLIENTE");
			this.askClient(request, response);
		}
		if (createVendor != null) {
			System.out.println("ENTRO A CREAR UN PROVEDOR");
			this.addVendor(request, response);
		}

		if (updateVendor != null) {
			System.out.println("ENTRO A ACTUALIZAR UN PROVEDOR");
			this.updateVendor(request, response);
		}

		if (deleteVendor != null) {
			System.out.println("ENTRO A ELIMINAR UN PROVEDOR");
			this.deleteVendor(request, response);
		}

		if (showVendor != null) {
			System.out.println("ENTRO A BUSCAR UN PROVEDOR");
			this.askVendor(request, response);
		}
	}

	// CRUD Users
	
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
			result = TestJSON.addUser(user);
			String page = "/JSP_Create_User.jsp";

			if (result == 200) {
				resultAdd = true;
				request.setAttribute("resultAddUser", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else if (result == 300) {
				request.setAttribute("resultAddUser", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
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
			result = TestJSON.updateUser(user);
			if (result == 200) {
				resultUpdate = true;
				request.setAttribute("resultUpdateUser", resultUpdate);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("resultUpdateUser", resultUpdate);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		Long auxId = Long.parseLong(request.getParameter("deleteU_userId"));
		int result = 0;
		String page = "/JSP_Delete_User.jsp";
		boolean resultDelete = false;
		try {
			result = TestJSON.deleteUser(auxId);
			if (result == 200) {
				resultDelete = true;
				request.setAttribute("resultDeleteUser", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("resultDeleteUser", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}

	
	
	//CRUD Clients
	
	public void addClient(HttpServletRequest request, HttpServletResponse response) {
		Clients client = new Clients();
		client.setClient_id(Long.parseLong(request.getParameter("createC_clientId")));
		client.setClient_name(request.getParameter("createC_clientName"));
		client.setClient_address(request.getParameter("createC_address"));
		client.setClient_phone(request.getParameter("createC_phone"));
		client.setClient_email(request.getParameter("createC_emailClient"));
		int result = 0;
		boolean resultAdd = false;

		try {
			result = TestJSON.addClient(client);
			String page = "/JSP_Create_Client.jsp";

			if (result == 200) {
				resultAdd = true;
				request.setAttribute("resultAddClient", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else if (result == 300) {
				request.setAttribute("resultAddClient", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateClient(HttpServletRequest request, HttpServletResponse response) {
		Clients client = new Clients();
		client.setClient_id(Long.parseLong(request.getParameter("updateC_clientId")));
		client.setClient_name(request.getParameter("updateC_clientName"));
		client.setClient_address(request.getParameter("updateC_address"));
		client.setClient_phone(request.getParameter("updateC_phone"));
		client.setClient_email(request.getParameter("updateC_emailClient"));
		int result = 0;
		String page = "/JSP_Update_Client.jsp";
		boolean resultUpdate = false;
		try {
			result = TestJSON.updateClient(client);
			if (result == 200) {
				resultUpdate = true;
				request.setAttribute("resultUpdateClient", resultUpdate);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("resultUpdateClient", resultUpdate);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteClient(HttpServletRequest request, HttpServletResponse response) {
		Long auxId = Long.parseLong(request.getParameter("deleteC_clientId"));
		int result = 0;
		String page = "/JSP_Delete_Client.jsp";
		boolean resultDelete = false;
		try {
			result = TestJSON.deleteUser(auxId);
			if (result == 200) {
				resultDelete = true;
				request.setAttribute("resultDeleteClient", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("resultDeleteClient", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void askClient(HttpServletRequest request, HttpServletResponse response) {

		try {
			Long clientId = Long.parseLong(request.getParameter("showC_clientId"));
			Clients client = TestJSON.askClient(clientId);
			String page = "/JSP_Show_Client.jsp";
			request.setAttribute("resultShowClient", client);
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
			dispacher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//CRUD Vendors
	
	public void addVendor(HttpServletRequest request, HttpServletResponse response) {
		Vendors vendor = new Vendors();
		vendor.setVendor_nit(Long.parseLong(request.getParameter("createV_vendorNit")));
		vendor.setVendor_name(request.getParameter("createV_vendorName"));
		vendor.setVendor_city(request.getParameter("createV_vendorCity"));
		vendor.setVendor_address(request.getParameter("createV_vendorAddress"));
		vendor.setVendor_phone(request.getParameter("createV_vendorEmail"));
		int result = 0;
		boolean resultAdd = false;

		try {
			result = TestJSON.addVendor(vendor);
			String page = "/JSP_Create_Vendor.jsp";

			if (result == 200) {
				resultAdd = true;
				request.setAttribute("resultAddVendor", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else if (result == 300) {
				request.setAttribute("resultAddVendor", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateVendor(HttpServletRequest request, HttpServletResponse response) {
		Vendors vendor = new Vendors();
		vendor.setVendor_nit(Long.parseLong(request.getParameter("updateV_vendorNit")));
		vendor.setVendor_name(request.getParameter("updateV_vendorName"));
		vendor.setVendor_city(request.getParameter("updateV_vendorCity"));
		vendor.setVendor_address(request.getParameter("updateV_vendorAddress"));
		vendor.setVendor_phone(request.getParameter("updateV_vendorEmail"));
		int result = 0;
		boolean resultAdd = false;

		try {
			result = TestJSON.updateVendor(vendor);
			String page = "/JSP_Update_Vendor.jsp";

			if (result == 200) {
				resultAdd = true;
				request.setAttribute("resultUpdateVendor", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else if (result == 300) {
				request.setAttribute("resultUpdateVendor", resultAdd);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteVendor(HttpServletRequest request, HttpServletResponse response) {
		Long auxId = Long.parseLong(request.getParameter("deleteV_vendorNit"));
		int result = 0;
		String page = "/JSP_Delete_Vendor.jsp";
		boolean resultDelete = false;
		try {
			result = TestJSON.deleteVendor(auxId);
			if (result == 200) {
				resultDelete = true;
				request.setAttribute("resultDeleteVendor", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("resultDeleteVendor", resultDelete);
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
				try {
					dispacher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void askVendor(HttpServletRequest request, HttpServletResponse response) {

		try {
			Long clientId = Long.parseLong(request.getParameter("showV_vendorNit"));
			Vendors vendor = TestJSON.askVendor(clientId);
			String page = "/JSP_Show_Vendor.jsp";
			request.setAttribute("resultShowVendor", vendor);
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
			dispacher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//Verify Users , Clients , Vendors
	
	public void verifyUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("passwordUser");
		Users user = TestJSON.verifyAdmin();
		if (userName.equals(user.getUser()) && password.equals(user.getPassword())) {
			System.out.println("ENTRO AQUI");
			String page = "/JSP_Principal_Menu_Admin.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(page);
			try {
				dispacher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			String page = "/index.jsp";
			request.setAttribute("resultValidateUser", false);
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
			try {
				dispacher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	//Reports
	
	public void listUsers(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Users> list = TestJSON.listUsers();
			String page = "/JSP_Show_Users.jsp";
			request.setAttribute("list", list);
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher(page);
			dispacher.forward(request, response);
		} catch (Exception e) {
			System.out.println("ERROR AL LISTAR");
			e.printStackTrace();
		}

	}
}
