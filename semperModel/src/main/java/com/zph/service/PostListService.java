package com.zph.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zph.Utils.PageR;
import com.zph.Utils.QueryBean;
import com.zph.Utils.R;
import com.zph.model.PostListModel;
import com.zph.model.PostListModelDto;

public interface PostListService extends IService<PostListModel> {

    /**
     * 列表数据
     * @return
     */
    public PageR<PostListModelDto> lists(QueryBean queryBean);

    /**
     * 删除数据
     * @param id
     * @return
     */
    public R<String> delete(String id);
}
