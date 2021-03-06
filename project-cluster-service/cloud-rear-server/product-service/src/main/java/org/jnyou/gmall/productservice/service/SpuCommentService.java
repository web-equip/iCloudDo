package org.jnyou.gmall.productservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jnyou.common.utils.PageUtils;
import org.jnyou.gmall.productservice.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author jnyou
 * @email xiaojian19970910@gmail.com
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

