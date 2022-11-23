package com.zph.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zph.Utils.R;
import com.zph.model.TagModel;

import java.util.List;

public interface TagService extends IService<TagModel> {
    R<List<TagModel>> tagAll();
}
