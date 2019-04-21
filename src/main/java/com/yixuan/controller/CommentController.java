package com.yixuan.controller;

import com.yixuan.common.Const;
import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Comment;
import com.yixuan.entity.User;
import com.yixuan.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author:linchengxin
 * @Date:2019/4/13 21:48
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private ICommentService iCommentService;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addComment(@RequestBody Comment comment){
        return iCommentService.addComment(comment);
    }

    /**
     * 根据文章ID获取评论列表
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/getCommentByArticleId",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getCommentByArticleId(String articleId){
        return iCommentService.getCommentByArticleId(articleId);
    }
}
