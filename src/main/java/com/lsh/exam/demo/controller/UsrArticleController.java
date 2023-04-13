package com.lsh.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsh.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	
	int articlesLastId;
	
	private List<Article> articles;
	
	public UsrArticleController() {
		articlesLastId = 0;
		articles = new ArrayList<>();
		
		makeTestData();
	}

	private void makeTestData() {
		
		int id = articlesLastId + 1;
		for(id = 1; id < 11; id++) {
			String title = "제목임"+id;
			String body = "내용임"+id;
			
			Article article = new Article(id, title, body);
			
			articles.add(article);
			articlesLastId = id;
		}
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		articlesLastId = id;
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
	
		return articles;
	}
	
	  
}
