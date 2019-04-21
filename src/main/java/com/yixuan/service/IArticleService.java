package com.yixuan.service;

import com.github.pagehelper.PageInfo;
import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Article;

import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/14 15:00
 */
public interface IArticleService {
    /**
     * 添加文章
     * @param article
     * @return
     */
    ServerResponse addArticle(Article article);

    /**
     * 分页获取文章列表信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getArticleList(Integer pageNum, Integer pageSize);

    /**
     * 根据文章ID获取文章详情
     * @param articleId
     * @return
     */
    ServerResponse getArticleById(String articleId);

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    ServerResponse updateArticle(Article article);

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    ServerResponse deleteArticle(String articleId);

    //小程序

    /**
     * 小程序获取文章列表
     * @return
     */
    ServerResponse<List<Article>> wxGetArticleList(String articleCategory);
}
