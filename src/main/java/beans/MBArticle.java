package beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleDAO;
import model.Article;

public class MBArticle implements Serializable {
	private static final long serialVersionUID=1L;
	private Article article=new Article();
	private List<Article> articles=new ArrayList<>();
	private ArticleDAO a=new ArticleDAO();
	
	
	//getter & setter
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<Article> getArticles() {
		articles=a.selectAll();
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void inserer() {
		if (a.insertArticle(article)!=0)
			System.out.println("insertion effectuée");
		else
			System.out.println("insertion non effectuée");
	}
	 public void supprimer() {
		 if(a.deleteArticle(article.getCode())!=0)
			 System.out.println("suppression effectue");
		 else
			 System.out.println("suppression non effectue");
	}
	public void modifier(){
		if (a.update(article)!=0)
			System.out.println("modification effectuée");
		else
			System.out.println("modification non effectuée");
	}
	 

	
	
	
	

}

