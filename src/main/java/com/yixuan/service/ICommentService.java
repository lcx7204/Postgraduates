package com.yixuan.service;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Comment;

import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/11 17:28
 */
public interface ICommentService {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    ServerResponse addComment(Comment comment);

    /**
     * 根据文章ID获取评论列表
     * @param articleId
     * @return
     */
    ServerResponse<List<Comment>> getCommentByArticleId(String articleId);
}
