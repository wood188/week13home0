package com.qf.controller;

import com.qf.pojo.Goods;
import com.qf.service.GoodsService;
import com.qf.utils.Msg;
import com.qf.utils.Upload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Value("${qiniu.url}")
    private String url;
    @Autowired
    private Upload up;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/showall")
    @RequiresPermissions(value = {"select"})
    public String goodsFinfAll() {
        return "showgoods";
    }

    @RequestMapping("/showall1")
    @ResponseBody
    public Msg<Goods> showall1() {
        Msg<Goods> msg = new Msg<>();
        List<Goods> list = goodsService.goodsFinfAll();
        msg.setRows(list);
        msg.setTotal(10);
        return msg;
    }

    @RequestMapping("goodsadd")
    @RequiresPermissions(value = {"insert"})
    @ResponseBody
    public String goodsAdd(Goods goods, @RequestParam("file") MultipartFile file) {
        try {
            //上传图片
            String upload = up.upload(file);
            goods.setGimg(url + upload);
            int res = goodsService.goodsAdd(goods);
            return "{\"title\":\"seccess\"}";
        } catch (Exception e) {
            return "{\"title\":\"Error\"}";
        }
    }

    @RequestMapping("goodsupdate")
    @RequiresPermissions(value = {"update"})
    @ResponseBody
    public String goodsUpadteById(Goods goods, @RequestParam("file") MultipartFile file) {
        try {
            //上传图片
            if (!file.getOriginalFilename().trim().equals("")) {
                String upload = up.upload(file);
                goods.setGimg(url + upload);
            }
            int res = goodsService.goodsUpadteById(goods);
            return "{\"title\":\"seccess\"}";
        } catch (Exception e) {
            return "{\"title\":\"Error\"}";
        }
    }

    @RequestMapping("/goodsdelete")
    @ResponseBody
    @RequiresPermissions(value = {"delete"})
    public String goodsDeleteById(String gid) {
        int res = goodsService.goodsDeleteById(Integer.valueOf(gid));
        if (res != 1) {
            return "{\"title\":\"success\",\"msg\":\"删除成功\"}";
        } else {
            return "{\"title\":\"Error\",\"msg\":\"删除失败\"}";
        }
    }
}
