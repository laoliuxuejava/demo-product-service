package com.example.demo.api.controller;

import com.example.demo.app.service.GoodsService;
import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.Goods;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author guser
 * @Date 2022/11/29
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody Goods goods) {
        return goodsService.add(goods);
    }

    /**
     * 根据商品编码删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        return goodsService.deleteById(id);
    }

    /**
     * 商品列表展示
     * @return
     */
    @GetMapping
    public Result selectAll() {
        return goodsService.selectAll();
    }

    /**
     * 商品入库
     * @param id 商品编码
     * @param count 入库数量
     * @return
     */
    @PutMapping("update/inGoods")
    public Result inGoods(@RequestParam Long id, @RequestParam Integer count) {
        return goodsService.inOrOutGoods(id, count);
    }

    /**
     * 商品出库
     * @param id 商品编码
     * @param count 出库数量
     * @return
     */
    @PutMapping("update/outGoods")
    public Result outGoods(@RequestParam Long id, @RequestParam Integer count) {
        return goodsService.inOrOutGoods(id, -count);
    }

    @PostMapping("updatePrice")
    public Result updatePrice(@RequestParam Long id, @RequestParam Double price) {
        return goodsService.updatePrice(id, price);
    }

}
