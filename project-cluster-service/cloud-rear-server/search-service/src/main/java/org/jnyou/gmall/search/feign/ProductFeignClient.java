package org.jnyou.gmall.search.feign;

import org.jnyou.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *
 * @className ProductFeignClient
 * @author: JnYou xiaojian19970910@gmail.com
 **/
@FeignClient("product-service")
public interface ProductFeignClient {

    @GetMapping("/product/attr/info/{attrId}")
    public R attrInfo(@PathVariable("attrId") Long attrId);

    @GetMapping("/product/brand/infos")
    public R infos(@RequestParam("brandIds") List<Long> brandIds);

}