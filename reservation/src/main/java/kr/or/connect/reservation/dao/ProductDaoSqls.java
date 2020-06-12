package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	//특정카테고리 공연정보
	public static final String SELECT_PAGING = "select "
			+"d.product_id,"
			+ " d.id AS displayInfoId"
			+ ", d.place_name," +
			"p.description AS productDescription, p.content AS productContent,\r\n" + 
			"f.save_file_name AS productImageUrl\r\n" + 
			"from product p\r\n" + 
			"join product_image i on(i.product_id=p.id) " +
			"join file_info f on(i.file_id=f.id)\r\n" + 
			"join display_info d on(d.product_id=p.id) " +
			"WHERE p.CATEGORY_ID = :cate AND i.type= 'th'\r\n" + 
			"ORDER BY p.id limit :start, :limit";
	//전체 공연정보리스트
	public static final String SELECT_PAGING_ALL = "select\r\n" + 
			"d.product_id, d.id AS displayInfoId, d.place_name,\r\n" +
			"p.description AS productDescription, p.content AS productContent,\r\n" + 
			"f.save_file_name AS productImageUrl\r\n" + 
			"from product p\r\n" + 
			"join product_image i on(i.product_id=p.id) "+
			"join file_info f on(i.file_id=f.id)\r\n" +
			"join display_info d on(d.product_id=p.id) " +
			"WHERE i.type= 'th'\r\n" + 
			"ORDER BY p.id limit :start, :limit";

	public static final String SELECT_COUNT = "SELECT count(*) FROM product WHERE CATEGORY_ID = :cate";
	public static final String SELECT_COUNT_ALL = "SELECT count(*) FROM product";
	
	//전시정보 한개 조회
	public static final String SELECT_BY_ID = "SELECT "
			+ "id AS displayInfoId,"
			+ "product_id,"
			+ "opening_hours,"
			+ "place_name,"
			+ "place_lot,"
			+ "place_street,"
			+ "tel AS telephone,"
			+ "homepage,"
			+ "email,"
			+ "create_date,"
			+ "modify_date "
			+ "FROM display_info WHERE id = :displayInfoId";

	//한줄평 조회
	public static final String SELECT_ALL_COMMENT = "SELECT"
			+ " A.id					 	AS commentId"
			+ ",A.product_id				AS productId"				
			+ ",A.reservation_info_id   	AS reservationInfoId"  
			+ ",A.score               		AS score"              
			+ ",A.comment              		AS comment"            
			+ ",A.create_date           	AS createDate"         
			+ ",A.modify_date           	AS modifyDate"         
			+ ",B.reservation_name       	AS reservationName"    
			+ ",B.reservation_tel  			AS reservationTelephone"
			+ ",B.reservation_email      	AS reservationEmail"  
			+ ",B.reservation_date       	AS reservationDate"    
			+ " "
			+ "from reservation_user_comment AS A "
			+ "join reservation_info AS B on(A.reservation_info_id=B.id) "
			+ "join reservation_user_comment_image AS C on(B.id=C.reservation_info_id) "
			+ "join file_info AS D on(C.file_id=D.id)"

			+ "where A.product_id = :productId "
			+ "order by A.create_date desc limit 1, :limit";
	
	public static final String SELECT_COMMENT_COUNT = "SELECT count(*) from reservation_user_comment";
	public static final String DELETE_BY_ID = "DELETE FROM display_info WHERE id = :id";
}