package com.zph.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_post_tag")
public class PostTagModel {
    private Long postId;
    private Long tagId;
}
