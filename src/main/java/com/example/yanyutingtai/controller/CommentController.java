package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.base.BaseResult;
import com.example.yanyutingtai.base.R;
import com.example.yanyutingtai.domain.Comment;
import com.example.yanyutingtai.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/SongListId")
    public R getCommentBySongListId(int songListId){
        List<Comment> comments = commentService.getCommentBySongListId(songListId);
        return R.success("查询评论成功",comments);
    }
    @GetMapping("/SongId")
    public R getCommentBySongId(int songId){
        List<Comment> comments = commentService.getCommentBySongId(songId);
        return R.success("查询评论成功",comments);
    }
    @PostMapping("/addComment")
    public R addComment(@RequestBody Comment comment){
        boolean result = commentService.addComment(comment);
        if(result){
            return R.success("发表成功");
        }else {
            return R.error("发表失败");
        }
    }
    @GetMapping("/deleteComment")
    public BaseResult deleteCommentById(int id){
        boolean result = commentService.deleteComment(id);
        if(result){
            return BaseResult.success("删除成功！");
        }else {
            return BaseResult.fail("删除失败！");
        }
    }
    @GetMapping("/getCommentBySongListId2")
    public BaseResult getCommentBySongListId2(@RequestParam("pageIndex")int pageIndex,
                                              @RequestParam("pageSize")int pageSize,
                                              @RequestParam("songlistId")int songListId){
        List<Comment> comments = commentService.getCommentBySongListId2((pageIndex-1) *
                        pageSize, pageSize,songListId);
        int count = commentService.countCommentById(songListId);
        Map<String,Object> map = new HashMap<>();
        map.put("commentlist",comments);
        map.put("commentcount",count);
        return BaseResult.success(map);
    }
    @GetMapping("/getCommentBySongId2")
    public BaseResult getCommentBySongId2(@RequestParam("pageIndex")int pageIndex,
                                          @RequestParam("pageSize")int pageSize,
                                          @RequestParam("songId")int songId){
        List<Comment> comments = commentService.getCommentBySongId2((pageIndex-1) *
                pageSize, pageSize,songId);
        int count = commentService.countCommentById2(songId);
        Map<String,Object> map = new HashMap<>();
        map.put("commentlist",comments);
        map.put("commentcount",count);
        return BaseResult.success(map);
    }
}
