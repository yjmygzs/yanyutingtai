package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.base.R;
import com.example.yanyutingtai.domain.Collect;
import com.example.yanyutingtai.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collect")
public class CollectController {
    @Autowired
    CollectService collectService;
    @GetMapping("/getCollectById/{user_id}")
    public R getCollectById(@PathVariable int user_id){
        List<Collect> collects = collectService.getCollectById(user_id);
        return R.success("成功",collects);
    }
    @PostMapping("/addCollect")
    public R addCollect(@RequestBody Collect collect){
        boolean result = collectService.addCollect(collect);
        if (result){
            return R.success("收藏成功",true);
        }else {
            return R.error("收藏失败");
        }
    }
    @DeleteMapping("/deleteCollect")
    public R deleteCollect(@RequestParam int user_id,@RequestParam int song_id){
        boolean result = collectService.deleteCollect(user_id, song_id);
        if (result){
            return R.success("取消成功",false);
        }else {
            return R.error("取消失败");
        }
    }
    @PostMapping("/isCollect")
    public R isCollect(@RequestBody Collect collect){
        Boolean result = collectService.isCollect(collect);
        if (result){
            return R.success("已收藏",true);
        }else {
            return R.success("未收藏",false);
        }
    }
}
