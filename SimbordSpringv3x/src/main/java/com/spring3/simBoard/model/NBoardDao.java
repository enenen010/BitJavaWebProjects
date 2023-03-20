package com.spring3.simBoard.model;

import java.util.List;

public interface NBoardDao{

	int SelectCount(NBoardDto bean);

	List<NBoardDto> SelectList(NBoardDto bean, int page, int pagemax);

	NBoardDto SelectOne(String nqid);

	int InsertOne(NBoardDto bean);

	int UpdateOne(NBoardDto bean);

	int DeleteOne(String nqid);

}