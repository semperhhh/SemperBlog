package com.zph.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zph.Utils.PageR;
import com.zph.Utils.QueryBean;
import com.zph.Utils.R;
import com.zph.model.PostListModel;
import com.zph.model.PostListModelDto;
import com.zph.model.TagModel;
import com.zph.service.PostListService;
import com.zph.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@Slf4j
public class HomeController {

    @Autowired
    private PostListService postListService;

    @Autowired
    @Qualifier(value = "tagServiceImpl")
    private TagService tagService;

    @GetMapping("/postlist")
    public R<PageR<PostListModelDto>> postlist(QueryBean queryBean) {
        try {
            PageR<PostListModelDto> lists = postListService.lists(queryBean);
            return R.success(lists);
        } catch (Exception e) {
            return R.error("错误");
        }
    }

    @GetMapping("/delete")
    public R<String> delete(@RequestParam String id) {
        try {
            return postListService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("错误");
        }
    }

    @GetMapping("/tag/all")
    public R<List<TagModel>> tagAll() {
        try {
            return tagService.tagAll();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("error");
        }
    }
}
