package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Article;


public class ArticleDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TPJPA");
		if(entityManager==null) {
			entityManager=entityManagerFactory.createEntityManager();
		}
		
		return entityManager;
	}
	
	public  int insertArticle(Article article) {
		int res=0;
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(article);
		getEntityManager().getTransaction().commit();
		if(findid(article.getCode())!=null)
			res=1;
			
		return res;
	}
	
	public List<Article> selectAll(){
		Query query=getEntityManager().createNamedQuery("Article.findAll");
		return   query.getResultList();
		
	}
	
	
	public int deleteArticle(int code)
	
	{ int res;
		Article article=getEntityManager().find(Article.class,code);
		
		if (article==null)
			res=0;
		else {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(article);
		getEntityManager().getTransaction().commit();
		
			res=1;}
		
		 
		return res;
		
	}
public int update(Article a)
	
	{int res;
		Article article=getEntityManager().find(Article.class,a.getCode());
		
		if(article==null)
			res=0;
		else {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(a);
			getEntityManager().getTransaction().commit();
			res=1;
		}
			
		 
		return res;
		
	}
public Article findid(int code){
	Article article=getEntityManager().find(Article.class,code);
	return article;

	
}

	
	
	

}
