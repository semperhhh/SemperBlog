package com.zph.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zph.Utils.PHDateFormatUtil;
import com.zph.Utils.PageR;
import com.zph.Utils.QueryBean;
import com.zph.Utils.R;
import com.zph.mapper.PostlistMapper;
import com.zph.model.PostListModel;
import com.zph.model.PostListModelDto;
import com.zph.service.PostListService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostlistServiceImpl extends ServiceImpl<PostlistMapper, PostListModel> implements PostListService {

    @Override
    public PageR<PostListModelDto> lists(QueryBean queryBean) {
        Page<PostListModel> page = new Page<>(queryBean.getCurrentPage(), queryBean.getPageSize());
        LambdaQueryWrapper<PostListModel> query = new LambdaQueryWrapper<>();
        query.orderByDesc(PostListModel::getId);
        page(page, query);
        List<PostListModel> list = page.getRecords();

        List<PostListModelDto> result = list.stream().map((item) -> {
            PostListModelDto dto = new PostListModelDto();
            BeanUtils.copyProperties(item, dto);
            Long createTime = item.getCreateTime();
            if (createTime != null) {
                dto.setCreateTimeString(PHDateFormatUtil.dateFormat(createTime, "yyyy-MM-dd"));
            }
            return dto;
        }).collect(Collectors.toList());
        return new PageR<>(page.getTotal(), result);
    }

    @Override
    public R<String> delete(String id) {
        boolean b = removeById(id);
        return b ? R.success("删除成功") : R.error("删除失败");
    }
}
