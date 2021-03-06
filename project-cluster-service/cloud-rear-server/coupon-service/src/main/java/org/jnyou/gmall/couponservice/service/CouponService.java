package org.jnyou.gmall.couponservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jnyou.common.utils.PageUtils;
import org.jnyou.gmall.couponservice.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author jnyou
 * @email xiaojian19970910@gmail.com
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

