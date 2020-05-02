package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	//특정카테고리 공연정보
	public static final String SELECT_PAGING = "select\r\n" + 
			"d.product_id, d.id, p.description, p.content,\r\n" + 
			"f.file_name, f.save_file_name,\r\n" + 
			"d.place_name " +
			"from product p\r\n" + 
			"join product_image i on(i.product_id=p.id) " +
			"join file_info f on(i.file_id=f.id)\r\n" + 
			"join display_info d on(d.product_id=p.id) " +
			"WHERE p.CATEGORY_ID = :cate AND i.type= 'th'\r\n" + 
			"ORDER BY p.id DESC limit :start, :limit";
	//전체 공연정보리스트
	public static final String SELECT_PAGING_ALL = "select\r\n" + 
			"d.product_id, d.id, p.description, p.content,\r\n" + 
			"f.file_name, f.save_file_name,\r\n" + 
			"d.place_name " +
			"from product p\r\n" + 
			"join product_image i on(i.product_id=p.id) "+
			"join file_info f on(i.file_id=f.id)\r\n" +
			"join display_info d on(d.product_id=p.id) " +
			"WHERE i.type= 'th'\r\n" + 
			"ORDER BY p.id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE FROM product WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM product WHERE CATEGORY_ID = :cate";
	
	public static final String SELECT_COUNT_ALL = "SELECT count(*) FROM product";
	public static final String SELECT_BY_ID = "SELECT id, description FROM product WHERE id = :productid";
}