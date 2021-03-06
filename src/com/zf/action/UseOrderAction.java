package com.zf.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.FinancialListDao;
import com.zf.dao.UseOrderDao;
import com.zf.entity.Order;
import com.zf.entity.util.menuUtil;
import com.zf.entity.util.orderUtil2;


/**
 *     对订单的增删改查的操作 order
 *     上启页面 ，从页面坚守数据（.jsp），添加到数据库
 *     下启dao工程，链接数据库
 *     更新数据
 * @author Administrator
 *
 */
public class UseOrderAction {
	private static final String DateTime = null;
	private UseOrderDao useOrderDao = new UseOrderDao();
	private Order order1 = new Order();
    private FinancialListDao fd1 = new FinancialListDao();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();

	public UseOrderDao getUseOrderDao() {
		return useOrderDao;
	}


	public void setUseOrderDao(UseOrderDao useOrderDao) {
		this.useOrderDao = useOrderDao;
	}


	public Order getOrder1() {
		return order1;
	}


	public void setOrder1(Order order1) {
		this.order1 = order1;
	}

	/**
	 * addOrder()订单的添加
	 * 
	 * 
	 */
	public String addOrder(Order order){
		useOrderDao.addOrder(order);
		selOrder();
		return "ok";
	}

	/**
	 * updateOrder()订单的添加
	 * 
	 * 
	 */
	public String updateOrder(String orderId,float totalPrice,int orderStatus){
		useOrderDao.updateOrder(orderId,totalPrice,orderStatus);
		selOrder();
		return "ok";
	}



	/**
	 * delOrder()订单的删除
	 * 
	 * 
	 */
	public String  delOrder(){
		int orderId =Integer.parseInt( request.getParameter("orderId"));	
		useOrderDao.delOrder(orderId);
		selOrder();
		return "ok";

	}

	/**
	 * selOrder()订单的查询 全部
	 * 
	 * 
	 */
	public String  selOrder(){
		List<Order> orderList = useOrderDao.selOrder();
		session.setAttribute("orderList", orderList);
		return "ok";
	}




	/**
	 * selMhOrder()订单的条件查询
	 * 
	 * 
	 */
	public String  selMhOrder(){
		String startTimeStr = null;
		String endTimeStr = null;
		String mhOredrSeatId = null;
		startTimeStr = request.getParameter("startTime");
		endTimeStr = request.getParameter("endTime");
		mhOredrSeatId = request.getParameter("mhOredrSeatId");      
		List<Order> orderList = useOrderDao.selMhOrder(startTimeStr, endTimeStr, mhOredrSeatId);

		session.setAttribute("orderList", orderList);
		return "ok";
	}
	
	/**
	 * 数据统计
	 */
     public String getStatistic(){
    	 String startTimeStr = request.getParameter("startTime");
 		 String  endTimeStr = request.getParameter("endTime");
    	 //得到 最优菜品，最差菜品
    	 List<menuUtil> menuUtillist1 = fd1.getGoodMenu(startTimeStr, endTimeStr);
    	 session.setAttribute("goodmenuList", menuUtillist1);
    	 List<menuUtil> menuUtillist2 = fd1.getBadMenu(startTimeStr, endTimeStr);
    	 session.setAttribute("badmenuList", menuUtillist2);
    	 orderUtil2 orderUtil2 = fd1.getOrderPrice(startTimeStr, endTimeStr);
    	 session.setAttribute("orderUtil2", orderUtil2);
    	 return "financialList";
     }

}
