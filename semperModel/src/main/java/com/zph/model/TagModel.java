package com.zph.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@TableName(value = "t_tag")
public class TagModel {
    /**
     * tagid
     */
    @NotBlank
    private String tagId;
    /**
     * tagName
     */
    @NotBlank
    private String tagName;
}
