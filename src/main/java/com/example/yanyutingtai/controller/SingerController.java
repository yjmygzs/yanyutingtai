package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.base.BaseResult;
import com.example.yanyutingtai.base.R;
import com.example.yanyutingtai.domain.Singer;
import com.example.yanyutingtai.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "singer")
public class SingerController {
    @Autowired
    SingerService singerService;
    /**
     * 查询所有
     * @param pageIndex
     * @param pageSize
     * @param searchValue
     * @return
     */
    @GetMapping
    public BaseResult allSinger(@RequestParam("pageIndex")int pageIndex,
                                @RequestParam("pageSize")int pageSize,
                                @RequestParam("searchValue") Object searchValue){
        List<Singer> singerList = singerService.allSinger((pageIndex-1) * pageSize,
                                    pageSize,searchValue);
        int singerCount = singerService.countSinger();
        Map<String,Object> map = new HashMap<>();
        map.put("singerlist",singerList);
        map.put("singercount",singerCount);
        return BaseResult.success(map);
    }
    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResult delete(@PathVariable int id) {
        boolean result = singerService.deleteById(id);
        if(result){
            return BaseResult.success("删除成功！");
        }else {
            return BaseResult.fail("删除失败！");
        }
    }
    /**
     * 添加歌手信息
     * @param singer
     * @return
     */
    @PostMapping
    public BaseResult addSinger(@RequestBody Singer singer){
        boolean result = singerService.addSinger(singer);
        if(result){
            return BaseResult.success("添加成功！");
        }else {
            return BaseResult.fail("添加失败！");
        }
    }
    /**
     * 根据ID获取歌手信息
     */
    @GetMapping("/{id}")
    public BaseResult getSingerById(@PathVariable int id){
        Singer singer = singerService.getSingerById(id);
        return BaseResult.success(singer);
    }
    /**
     * 更新歌手信息
     */
    @PutMapping
    public BaseResult updateSinger(@RequestBody Singer singer){
        boolean result = singerService.updateSinger(singer);
        if(result) {
            return BaseResult.success("更新成功！");
        }else {
            return BaseResult.fail("更新失败");
        }
    }
    //统计歌手总数
    @GetMapping("/countSinger")
    public BaseResult countSinger(){
        return BaseResult.success(singerService.countSinger());
    }
    //按照性别统计歌手数量
    @GetMapping("/countSingerGender")
    public BaseResult countSingerGender(){
        return BaseResult.success(singerService.countSingerGender());
    }
    //查询所有歌手
    @GetMapping("/allSinger2")
    public R allSinger2(){
        List<Singer> singers = singerService.allSinger2();
        return R.success("成功",singers);
    }
    //根据性别查询歌手
    @GetMapping("/getSingerByGender")
    public R getSingerByGender(@RequestParam("sex") String gender){
        List<Singer> getSingerByGender = singerService.getSingerByGender(gender);
        return R.success("成功",getSingerByGender);
    }
}