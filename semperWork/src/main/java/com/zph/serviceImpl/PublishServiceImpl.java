package com.zph.serviceImpl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zph.Utils.PHDateFormatUtil;
import com.zph.Utils.R;
import com.zph.mapper.PostTagMapper;
import com.zph.mapper.PostlistMapper;
import com.zph.mapper.TagMapper;
import com.zph.model.PostListModel;
import com.zph.model.PostTagModel;
import com.zph.service.PublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@Slf4j
public class PublishServiceImpl extends ServiceImpl<PostlistMapper, PostListModel> implements PublishService {

    @Autowired
    private PostTagMapper postTagMapper;

    @Override
    @Transactional
    public R<String> send(PostListModel postListModel) {
        if (postListModel.getCreateTime() == null) {
            postListModel.setCreateTime(PHDateFormatUtil.toTimeStamp());
        }

        // TODO: 2022/11/23 mybatis plus 多表

        // 文章保存
        boolean b = save(postListModel);

        // tag保存
        if (StringUtils.isNotBlank(postListModel.getTagString())) {
            String tagString = postListModel.getTagString();
            String[] tag = tagString.split(",");
            for (String s : tag) {
                PostTagModel model = new PostTagModel();
                model.setPostId(Long.valueOf(postListModel.getId()));
                model.setTagId(Long.valueOf(s));
                postTagMapper.insert(model);
            }
        }

        if (b) {
            return R.success(postListModel.getId().toString());
            // TODO: 2022/11/22 消息队列发送列表刷新 
        } 
        return R.error("保存失败");
    }
}
