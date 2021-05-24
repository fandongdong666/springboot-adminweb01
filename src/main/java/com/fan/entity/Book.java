package com.fan.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author fan
 * @since 2021-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 书名
     */
    private String name;

    /**
     * 价格
     */
    private Double price;

    /**
     * 作者
     */
    private String author;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 书的图片
     */
    private String imgPath="static/images/blog/blog-thumb-1.jpg";

    public void setImgPath(String imgPath) {
        if(imgPath==null && "".equals(imgPath)){
            this.imgPath = "static/images/blog/blog-thumb-1.jpg";
        }
        this.imgPath = imgPath;
    }
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;


}
