package com.zph.controller;

import com.zph.Utils.R;
import com.zph.model.PostListModel;
import com.zph.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publish")
public class PublishController {

    @Autowired
    private PublishService publishService;

    @PostMapping("/send")
    public R<String> send(@RequestBody PostListModel postListModel) {
        try {
            return publishService.send(postListModel);
        } catch (Exception e) {
            return R.error("send error");
        }

    }
}
