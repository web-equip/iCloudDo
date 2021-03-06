package org.jnyou.gmall.productservice.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.jnyou.gmall.productservice.annotation.EagleEye;
import org.jnyou.gmall.productservice.entity.AttrEntity;
import org.jnyou.gmall.productservice.service.AttrAttrgroupRelationService;
import org.jnyou.gmall.productservice.service.AttrService;
import org.jnyou.gmall.productservice.service.CategoryService;
import org.jnyou.gmall.productservice.vo.AttrGroupRelationVo;
import org.jnyou.gmall.productservice.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.jnyou.gmall.productservice.entity.AttrGroupEntity;
import org.jnyou.gmall.productservice.service.AttrGroupService;
import org.jnyou.common.utils.PageUtils;
import org.jnyou.common.utils.R;



/**
 * 属性分组
 *
 * @author jnyou
 * @email xiaojian19970910@gmail.com
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 列表
     */
    @GetMapping("/list/{catId}")
    @EagleEye(desc = "属性分组查询")
    //@RequiresPermissions("productservice:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params,@PathVariable Long catId){
        PageUtils page = attrGroupService.queryPage(params,catId);

        return R.ok().put("page", page);
    }


    /**
     * 获取分类下所有分组&关联属性  /product/attrgroup/{catelogId}/withattr
     */
    @GetMapping("/{catelogId}/withattr")
    @EagleEye(desc = "获取分类下所有分组&关联属性")
    public R getAttrGroupWithAttrs(@PathVariable Long catelogId){
        List<AttrGroupWithAttrsVo> attrGroupWithAttrsVos = attrGroupService.getAttrGroupWithAttrsByCatId(catelogId);
        return R.ok().put("data", attrGroupWithAttrsVos);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("productservice:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long [] catelogPath = categoryService.findCatIdPath(attrGroup.getCatelogId());
        attrGroup.setCatelogPath(catelogPath);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("productservice:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 保存新建关联的属性  [{attrId: 1, attrGroupId: 6}]
     */
    @PostMapping("/attr/relation")
    public R saveRelations(@RequestBody List<AttrGroupRelationVo> relationVos){
        attrAttrgroupRelationService.saveRelations(relationVos);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("productservice:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 根据分组ID查询关联的所有基本属性（规格参数）
     */
    @GetMapping("/{attrGroupId}/attr/relation")
    public R attrGroupRelation(@PathVariable("attrGroupId") Long attrGroupId){
        List<AttrEntity> data = attrService.getRelationAttr(attrGroupId);

        return R.ok().put("data",data);
    }

    /**
     * 获取当前分组没有关联的属性
     */
    @GetMapping("/{attrGroupId}/noattr/relation")
    public R attrGroupNoRelation(@RequestParam Map<String, Object> params,@PathVariable("attrGroupId") Long attrGroupId){
        PageUtils page = attrService.getRelationNoAttr(params,attrGroupId);
        return R.ok().put("page",page);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("productservice:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

    /**
     * 移除该分组下关联的属性
     */
    @PostMapping("/attr/relation/delete")
    public R deleteRelation(@RequestBody AttrGroupRelationVo[] attrGroupIds){
        attrService.deleteRelation(attrGroupIds);
        return R.ok();
    }



}
