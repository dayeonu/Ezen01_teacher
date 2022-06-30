package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() {
		System.out.println("DispatcherServlet Init()-------------------------");
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("uri ==> " + uri + " : " +  path);
	
		//2. HandlerMapping�� ���ؼ� path�� �ش��ϴ� Controller�� �˻��Ѵ�.
		Controller ctrl = handlerMapping.getController(path);
		//3. �˻��� Controller�� ����
		String viewName = ctrl.handleRequest(request, response); // login
		
		//4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ���� �˻�
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);  //./login.jsp
			System.out.println("view======> " + view);
		}else {
			view = viewName;
		}
		//5. �˻��� ȭ������ �̵�
		response.sendRedirect(view);
	}
	
	/*private void process(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		request.setCharacterEncoding("utf-8");
		//1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("uri ==> " + uri + " : " +  path);
		//2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б�ó���Ѵ�.
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
			
			String id = request.getParameter("id");
			String passwrod = request.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(passwrod);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			if(user != null){
				//���ǵ��
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			}
			
		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			request.setCharacterEncoding("utf-8");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			String regDate = request.getParameter("regDate");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			//vo.setRegDate(regDate);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			request.setCharacterEncoding("utf-8");

			int seq = Integer.parseInt(request.getParameter("seq")); 
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			vo.setTitle(title);
			vo.setContent(content);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			
			request.setCharacterEncoding("utf-8");

			String seq =  request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
			
			request.setCharacterEncoding("utf-8");
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
		
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			response.sendRedirect("getBoard.jsp");
			
			
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			
			request.setCharacterEncoding("utf-8");
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			//3. �˻� ����� ������ �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			response.sendRedirect("getBoardList.jsp");
		}
	}*/

}
