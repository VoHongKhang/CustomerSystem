/**
 * @(#)T002.java 01-00 2023/06/13
 *
 * Copyright(C) 2021 by FUJINET CO., LTD.
 * 
 * Version 1.00.
 */
package fjs.cs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fjs.cs.common.Constants;
import fjs.cs.dao.T002Dao;
import fjs.cs.dto.T002Dto;

/**
 * T002
 * 
 * @version 1.00
 * @since 1.00
 * @author Huy-NDQ-TTV
 * 
 */
public class T002 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Init man hinh
	 * 
	 * @param HttpServletRequest  req
	 * @param HttpServletResponse resp
	 * @return RequestDispatcher
	 * @throws ServletException, IOException
	 * @since 1.00
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher myRD = null;

		// Khai bao list customer
		T002Dao customerDao = new T002Dao();
		List<T002Dto> listCustomer = customerDao.getListCustomer();

		// Kích thước trang (số dòng dữ liệu hiển thị trên mỗi trang)
		int pageSize = 15;

		// Trang hiện tại (mặc định là trang đầu tiên)
		int currentPage = 1;
		String currentPageParam = req.getParameter("currentPage");
		if (currentPageParam != null) {
			currentPage = Integer.parseInt(currentPageParam);
		}

		// Tổng số trang
		int totalPages = (int) Math.ceil((double) listCustomer.size() / pageSize);

		// Tính vị trí bắt đầu và vị trí kết thúc của dữ liệu trên trang hiện tại
		int startIdx = (currentPage - 1) * pageSize;
		int endIdx = Math.min(startIdx + pageSize, listCustomer.size());

		// Lấy danh sách dữ liệu hiển thị trên trang hiện tại
		List<T002Dto> currentPageData = listCustomer.subList(startIdx, endIdx);

		// Gửi thông tin phân trang và danh sách dữ liệu sang JSP
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("dataList", currentPageData);

		// Chuyển hướng sang JSP để hiển thị dữ liệu và nút điều hướng
		myRD = req.getRequestDispatcher(Constants.T002_SEARCH);
		myRD.forward(req, resp);
	}

	/**
	 * Event man hinh
	 * 
	 * @param HttpServletRequest  req
	 * @param HttpServletResponse resp
	 * @return RequestDispatcher
	 * @throws ServletException, IOException
	 * @since 1.00
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
