package com.spring3.simBoard.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class NBoardDaoImpl implements NBoardDao {
	JdbcTemplate jdbcTemplate;


	public NBoardDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int SelectCount(NBoardDto bean) {
		String sql="select count(*) from NBOARD where sub like ? and id like ?";
		int result = jdbcTemplate.queryForInt(sql, "%"+bean.getSub()+"%","%"+bean.getId()+"%");
		return result;
	}
	
	@Override
	public List<NBoardDto> SelectList(NBoardDto bean,int page, int pagemax) {
		String sql="select * from NBOARD where sub like ? and id like ? order by wdate desc LIMIT ?, ?";
		System.out.println(jdbcTemplate);
		List<NBoardDto> list =jdbcTemplate.query(sql,new RowMapper<NBoardDto>() {
			
			@Override
			public NBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new NBoardDto(rs.getString("NQID"),rs.getString("CONTENT"),rs.getString("IMG")
						,rs.getString("SUB"),rs.getString("ID"),rs.getDate("wDate"));
			}
		},"%"+bean.getSub()+"%","%"+bean.getId()+"%",(page-1)*pagemax,pagemax);
		return list;
	}
	
	@Override
	public NBoardDto SelectOne(String nqid) {
		String sql="select * from NBOARD where nqid = ?";
		NBoardDto boardDto = jdbcTemplate.queryForObject(sql, new RowMapper<NBoardDto>() {

			@Override
			public NBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new NBoardDto(rs.getString("NQID"),rs.getString("CONTENT"),rs.getString("IMG")
						,rs.getString("SUB"),rs.getString("ID"),rs.getDate("wDate"));
			}
		}, nqid);
		return boardDto;
	}
	
	@Override
	public int InsertOne(NBoardDto bean) {
		String sql="insert into NBOARD(nqid,content,img,sub,id,wdate) ";
		sql+="values(?,?,?,?,?,now())";
		return jdbcTemplate.update(sql, 
				bean.getNqid(), 
				bean.getContent(), 
				bean.getImg(), 
				bean.getSub(), 
				bean.getId());
	}
	
	@Override
	public int UpdateOne(NBoardDto bean) {
		String sql="update NBOARD set content=?,img=?,sub=?,id=? ";
		sql+="where nqid=?";
		return jdbcTemplate.update(sql,
				bean.getContent(), 
				bean.getImg(), 
				bean.getSub(), 
				bean.getId(), 
				bean.getNqid());
	}
	
	@Override
	public int DeleteOne(String nqid) {
		String sql="delete from NBOARD ";
		sql+="where nqid=?";
		return jdbcTemplate.update(sql, nqid);
	}
}
