package com.lsh.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lsh.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {
	
	// select * from article where id = ?
	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(@Param("id") int id);

	@Select("SELECT * FROM article ORDER BY id DESC")
	public List<Article> getArticles();
	
	
	public Article writeArticle(String title, String body);
	
	// delete from article where id = ?
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(@Param("id") int id);
	
	// update from article set title = ?, `body` = ?, updateDate = now() where id = ?
	@Update("UPDATE article SET title = #{title}, `body` = #{body}, updateDate = NOW WHERE id = #{id}")
	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
}
