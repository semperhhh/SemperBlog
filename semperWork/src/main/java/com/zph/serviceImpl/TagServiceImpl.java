package com.zph.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zph.Utils.R;
import com.zph.mapper.TagMapper;
import com.zph.model.TagModel;
import com.zph.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class TagServiceImpl extends ServiceImpl<TagMapper, TagModel> implements TagService {

    @Override
    public R<List<TagModel>> tagAll() {
        return R.success(list());
    }
}
