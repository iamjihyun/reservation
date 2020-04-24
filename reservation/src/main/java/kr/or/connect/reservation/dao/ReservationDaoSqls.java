package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_PAGING = "SELECT * FROM product p join category c on(c.id=p.category_id) WHERE CATEGORY_ID = :cate ORDER BY p.id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE FROM product WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM product WHERE CATEGORY_ID = :cate";
	public static final String SELECT_PAGING_ALL = "SELECT * FROM product ORDER BY id DESC limit :start, :limit";
	public static final String SELECT_COUNT_ALL = "SELECT count(*) FROM product";
}