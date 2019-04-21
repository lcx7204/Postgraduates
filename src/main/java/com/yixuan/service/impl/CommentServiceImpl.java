package com.yixuan.service.impl;

import com.yixuan.common.ServerResponse;
import com.yixuan.dao.CommentMapper;
import com.yixuan.entity.Comment;
import com.yixuan.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author:linchengxin
 * @Date:2019/4/11 17:28
 */
@Service
public class CommentServiceImpl implements ICommentService{

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public ServerResponse addComment(Comment comment) {
        if (comment == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        String commentId = UUID.randomUUID().toString().replace("-","");
        Date commentDate = new Date();
        comment.setCommentId(commentId);
        comment.setCommentDate(commentDate);
        int resultCount = commentMapper.insert(comment);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("评论成功");
        }
        return ServerResponse.createByErrorMessage("评论失败");
    }

    /**
     * 根据文章ID获取评论列表
     * @param articleId
     * @return
     */
    @Override
    public ServerResponse<List<Comment>> getCommentByArticleId(String articleId) {
        if (articleId == null || articleId == ""){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        List<Comment> commentList = commentMapper.selectByArticleId(articleId);
        return ServerResponse.createBySuccess(commentList);
    }
}
