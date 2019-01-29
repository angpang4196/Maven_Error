package com.biz.error.sql;

public class ErrorSQL {

	public static final String ER_ALL = " SELECT * FROM tbl_or_error ";

	public static final String ER_FIND_CODE = " SELECT * FROM tbl_or_error WHERE or_er_code = #{or_er_code} ";

	public static final String ER_INSERT = " INSERT INTO tbl_or_error VALUES( #{or_er_code}, #{or_er_stanSql} "
			+ " , #{or_er_cause}, #{or_er_action}) ";

	public static final String ER_UPDATE = " UPDATE tbl_or_error SET or_er_stanSql = #{or_er_stanSql},"
			+ "  or_er_cause = #{or_er_cause}, or_er_action = #{or_er_action}" + " where or_er_code = #{or_er_code} ";

	public static final String ER_DELETE = " DELETE FROM tbl_or_error WHERE or_er_code = #{or_er_code} ";

}
