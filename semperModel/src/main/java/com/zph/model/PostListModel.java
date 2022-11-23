package com.zph.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "t_postlist")
public class PostListModel {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String title;
    private Long createTime;
    private Long updateTime;
    private String category;

    @TableField(exist = false)
    private String tagString;

    @TableField(exist = false)
    private List<String> tags;

    /**
     * 文章内容
     */
    private String content;
}
