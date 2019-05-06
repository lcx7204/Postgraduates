package com.yixuan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixuan.common.ServerResponse;
import com.yixuan.dao.ArticleMapper;
import com.yixuan.entity.Article;
import com.yixuan.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/14 15:00
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @Override
    public ServerResponse addArticle(Article article) {
        if (article == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = articleMapper.insert(article);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("发布成功");
        }
        return ServerResponse.createByErrorMessage("发布失败");
    }

    /**
     * 分页获取文章列表信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getArticleList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList = articleMapper.getArticleListByAdmin("10%","30%");
        PageInfo pageResult = new PageInfo(articleList);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 根据文章ID获取文章详情
     * @param articleId
     * @return
     */
    @Override
    public ServerResponse getArticleById(String articleId) {
        if ("".equals(articleId)){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        Article article = articleMapper.selectByPrimaryKey(articleId);
        return ServerResponse.createBySuccess(article);
    }

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    @Override
    public ServerResponse updateArticle(Article article) {
        if (article==null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = articleMapper.updateByPrimaryKeySelective(article);
        if (resultCount>0){
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @Override
    public ServerResponse deleteArticle(String articleId) {
        if ("".equals(articleId)){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = articleMapper.deleteByPrimaryKey(articleId);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    //小程序

    /**
     * 小程序获取文章列表
     * @return
     */
    @Override
    public ServerResponse<List<Article>> wxGetArticleList(String articleCategory) {
        //只获取分类为10开头的
        List<Article> articleList = articleMapper.getArticleList(articleCategory);
        return ServerResponse.createBySuccess(articleList);
    }

    /**
     * 小程序根据关键字搜索
     * @param articleName
     * @return
     */
    @Override
    public ServerResponse<List<Article>> wxGetArticleByKey(String articleName) {
        if (articleName == null || articleName == ""){
            return ServerResponse.createByErrorMessage("请输入内容后搜索");
        }
        List<Article> articleList = new ArrayList<>();
        articleName = "%"+articleName+"%";
        articleList = articleMapper.selectByArticleName(articleName);
        return ServerResponse.createBySuccess(articleList);
    }
}
