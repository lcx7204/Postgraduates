package com.yixuan.dao;

import com.yixuan.entity.Article;
import com.yixuan.entity.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * 获取文章列表信息
     * @param articleCategory
     * @return
     */
    List<Article> getArticleList(String articleCategory);

    List<Article> getArticleListByAdmin(@Param("articleCategory1") String articleCategory1, @Param("articleCategory2") String articleCategory2);

    /**
     * 根据文章标题搜索文章
     * @param articleName
     * @return
     */
    List<Article> selectByArticleName(String articleName);
}