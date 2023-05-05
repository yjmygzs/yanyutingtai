package com.example.yanyutingtai.service;

import com.example.yanyutingtai.domain.Comment;

import java.util.List;

public interface CommentService {
    //根据歌单ID查询评论
    List<Comment> getCommentBySongListId(int songListId);
    //根据歌曲ID查询评论
    List<Comment> getCommentBySongId(int songId);
    //前台用户添加评论
    boolean addComment(Comment comment);
    //前台用户删除评论
    boolean deleteComment(int id);
    //后台根据歌单ID查询评论（带分页）
    List<Comment> getCommentBySongListId2(int startIndex,int pageSize,int songListId);
    //根据歌单ID查询评论总数
    int countCommentById(int id);
    //后台根据歌曲ID查询评论（带分页）
    List<Comment> getCommentBySongId2(int startIndex,int pageSize,int songId);
    //根据歌曲ID查询评论总数
    int countCommentById2(int id);
}
