package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.CommentMapper;
import com.example.yanyutingtai.domain.Comment;
import com.example.yanyutingtai.domain.Singer;
import com.example.yanyutingtai.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> getCommentBySongListId(int songListId){
        return commentMapper.getCommentBySongListId(songListId);
    }
    @Override
    public List<Comment> getCommentBySongId(int songId){
        return commentMapper.getCommentBySongId(songId);
    }
    @Override
    public boolean addComment(Comment comment){
        return commentMapper.addComment(comment)>0;
    }
    @Override
    public boolean deleteComment(int id){
        return commentMapper.deleteComment(id)>0;
    }
    @Override
    public List<Comment> getCommentBySongListId2(int startIndex,int pageSize,int songListId){
        return commentMapper.getCommentBySongListId2(startIndex,pageSize,songListId);
    }
    @Override
    public int countCommentById(int id){
        return commentMapper.countCommentById(id);
    }
    @Override
    public List<Comment> getCommentBySongId2(int startIndex,int pageSize,int songId){
        return commentMapper.getCommentBySongId2(startIndex,pageSize,songId);
    }
    @Override
    public int countCommentById2(int id){
        return commentMapper.countCommentById2(id);
    }
}
