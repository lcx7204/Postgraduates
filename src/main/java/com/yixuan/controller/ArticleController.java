package com.yixuan.controller;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Article;
import com.yixuan.service.IArticleService;
import com.yixuan.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * @Author:linchengxin
 * @Date:2019/4/14 14:58
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private IFileService iFileService;
    @Autowired
    private IArticleService iArticleService;
    @Value("${article.savePath}")
    private String articleSavePath;
    @Value("${article.url}")
    private String url;

    /**
     * 发布文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/addArticle")
    @ResponseBody
    public ServerResponse addArticle(@RequestBody Article article){
        String articleId = UUID.randomUUID().toString().replace("-","");
        Integer praiseNum = 0;
        Date publishDate = new Date();
        article.setArticleId(articleId);
        article.setPraiseNum(praiseNum);
        article.setPublishDate(publishDate);
        return iArticleService.addArticle(article);
    }

    /**
     * 文章富文本上传图片
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/articleUpload",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String uploadPic(@RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        //开始上传图片
        String path = articleSavePath;
        String targetFileName = iFileService.upload(file,path);
        if (targetFileName =="" || targetFileName.isEmpty()){
            String msg = "上传失败";
            return msg;
        }
        String newUrl = url + targetFileName;
        response.addHeader("Access-Control-Allow-Headers","X-File-Name");
        return newUrl;
    }

    /**
     * 分页获取文章列表信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getArticleList",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getArticleList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iArticleService.getArticleList(pageNum,pageSize);
    }

    /**
     * 根据ID获取文章详情
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/getArticleById",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getArticleById(String articleId){
        return iArticleService.getArticleById(articleId);
    }

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    @RequestMapping(value = "/updateArticle",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateArticle(@RequestBody Article article){
        return iArticleService.updateArticle(article);
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/deleteArticle",method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse deleteArticle(String articleId){
        return iArticleService.deleteArticle(articleId);
    }

    //小程序

    /**
     * 微信获取文章列表
     * @return
     */
    @RequestMapping(value = "/wxGetArticleList",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse wxGetArticleList(String articleCategory){
        return iArticleService.wxGetArticleList(articleCategory);
    }
}
