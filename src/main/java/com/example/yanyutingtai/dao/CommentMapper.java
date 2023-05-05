package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    //根据歌单ID查询评论
    List<Comment> getCommentBySongListId(int songListId);
    //后台根据歌单ID查询评论（带分页）
    List<Comment> getCommentBySongListId2(int startIndex,int pageSize,int songListId);
    //根据歌曲ID查询评论
    List<Comment> getCommentBySongId(int songId);
    //后台根据歌曲ID查询评论（带分页）
    List<Comment> getCommentBySongId2(int startIndex,int pageSize,int songId);
    //前台用户提交评论
    int addComment(Comment comment);
    //前台用户删除评论
    int deleteComment(int id);
    //根据歌单ID查询评论总数
    int countCommentById(int id);
    //根据歌单ID查询评论总数
    int countCommentById2(int id);
}
