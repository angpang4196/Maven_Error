package com.biz.error.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.error.sql.ErrorSQL;
import com.biz.error.vo.ErrorVO;

public interface ErrorDao {

	@Select(ErrorSQL.ER_ALL)
	public List<ErrorVO> selectAll();

	@Select(ErrorSQL.ER_FIND_CODE)
	public ErrorVO FindById(String or_er_code);

	@Insert(ErrorSQL.ER_INSERT)
	public int insert(ErrorVO vo);

	@Update(ErrorSQL.ER_UPDATE)
	public int update(ErrorVO vo);

	@Delete(ErrorSQL.ER_DELETE)
	public int delete(String or_er_code);

}
