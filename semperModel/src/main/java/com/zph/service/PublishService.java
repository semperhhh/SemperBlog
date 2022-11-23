package com.zph.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zph.Utils.R;
import com.zph.model.PostListModel;

public interface PublishService extends IService<PostListModel> {

    /**
     * 新建文章
     * @param postListModel
     * @return
     */
    R<String> send(PostListModel postListModel);
}
