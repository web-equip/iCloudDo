package org.jnyou.gmall.productservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jnyou.common.utils.PageUtils;
import org.jnyou.gmall.productservice.entity.SpuInfoEntity;
import org.jnyou.gmall.productservice.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author jnyou
 * @email xiaojian19970910@gmail.com
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo spuSaveVo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    void up(Long spuId);
}

