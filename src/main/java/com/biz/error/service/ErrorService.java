package com.biz.error.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.biz.error.dao.ErrorDao;
import com.biz.error.dao.db.OracleSqlFactory;
import com.biz.error.vo.ErrorVO;

public class ErrorService {

	List<ErrorVO> erList;
	SqlSessionFactory sessionFactory;

	public ErrorService() {
		erList = new ArrayList();
		OracleSqlFactory sqlFactory = new OracleSqlFactory();
		this.sessionFactory = sqlFactory.getSessionFactory();
	}

	public void readFile() {

		FileReader fr;
		BufferedReader buffer;

		String strFile = "src/main/java/com/biz/error/오라클DB(12700~19399).txt";

		try {
			fr = new FileReader(strFile);
			buffer = new BufferedReader(fr);

			while (true) {

				String reader1 = buffer.readLine();
				String reader2 = buffer.readLine();
				String reader3 = buffer.readLine();

				if (reader1 == null)
					break;

				ErrorVO vo = new ErrorVO();

				String[] strSp1 = reader1.split(":");
				vo.setOr_er_code(strSp1[0]);
				vo.setOr_er_stanSql(strSp1[1]);

				String[] strSp2 = reader2.split(":");
				vo.setOr_er_cause(strSp2[1]);

				String[] strSp3 = reader3.split(":");
				vo.setOr_er_action(strSp3[1]);

				erList.add(vo);
				System.out.println("에러코드 : " + vo.getOr_er_code());
				System.out.println("에러명 : " + vo.getOr_er_stanSql());
				System.out.println("원인 : " + vo.getOr_er_cause());
				System.out.println("조치 : " + vo.getOr_er_action());

				// errorInsert(vo);

			}

			buffer.close();
			fr.close();

			System.out.println("DB추가완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readFile2() {
		FileReader fr;
		BufferedReader buffer;

		String strFileName = "src/main/java/com/biz/error/오라클DB(19400~24279).txt";
		try {
			fr = new FileReader(strFileName);
			buffer = new BufferedReader(fr);

			while (true) {
				String reader1 = buffer.readLine();
				String reader2 = buffer.readLine();
				String reader3 = buffer.readLine();
				String reader4 = buffer.readLine();
				String reader5 = buffer.readLine();
				String reader6 = buffer.readLine();

				if (reader1 == null)
					break;

				ErrorVO vo = new ErrorVO();

				String erCode = reader1.substring(0, 9);
				String erName = reader1.substring(10, reader1.length());
				vo.setOr_er_code(erCode);
				vo.setOr_er_stanSql(erName);

				String[] strSp2 = reader2.split(":");
				vo.setOr_er_cause(strSp2[1]);

				String[] strSp3 = reader4.split(":");
				vo.setOr_er_action(strSp3[1]);

				erList.add(vo);
	//			System.out.println("에러코드 : " + vo.getOr_er_code());
	//			System.out.println("에러명 : " + vo.getOr_er_stanSql());
    //			System.out.println("원인 : " + vo.getOr_er_cause());
    //				System.out.println("조치 : " + vo.getOr_er_action());

			//	 errorInsert(vo);

			}

			buffer.close();
			fr.close();

			System.out.println("DB추가완료");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void errorInsert(ErrorVO vo) {
		SqlSession session = this.sessionFactory.openSession();

		ErrorDao dao = session.getMapper(ErrorDao.class);

		int intRet = dao.insert(vo);

		session.commit();
		session.close();

	}

}
