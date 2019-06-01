package com.imooc.sell.controller;

import com.imooc.sell.domain.ProductCategory;
import com.imooc.sell.domain.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductInfoService;
import com.imooc.sell.viewObject.ProductInfoVO;
import com.imooc.sell.viewObject.ProductVO;
import com.imooc.sell.viewObject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：BuyerProductController
 * <dd>类描述：买家商品
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/22
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list(){

        ResultVO resultVO = new ResultVO();
        List<ProductVO> productVOList = new ArrayList<>();

        try{
            //1.查询所有上架商品
            List<ProductInfo> productInfoList = productInfoService.findUpAll();
            //2.查询类目(一次性查询)
            List<Integer> categoryTypeList = productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());
            List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
            //3.数据拼装
            for (ProductCategory category : productCategoryList) {
                ProductVO productVO = new ProductVO();
                productVO.setCategoryName(category.getCategoryName());
                productVO.setCategoryType(category.getCategoryType());
                List<ProductInfoVO> list = new ArrayList<>();
                for (ProductInfo productInfo : productInfoList) {

                    if(productInfo.getCategoryType().equals(category.getCategoryType())){
                        ProductInfoVO infoVO = new ProductInfoVO();
                        BeanUtils.copyProperties(productInfo,infoVO);
                        list.add(infoVO);
                    }
                }
                productVOList.add(productVO);
                productVO.setProductInfoVOList(list);
            }
            resultVO.setCode(0);
            resultVO.setMsg("成功");
            resultVO.setData(productVOList);

        }catch (Exception e){
            ProductVO productVO = new ProductVO();
            ProductInfoVO productInfoVO = new ProductInfoVO();
            ArrayList<ProductInfoVO> list = new ArrayList<>();
            list.add(productInfoVO);
            productVO.setProductInfoVOList(list);
            resultVO.setCode(1);
            resultVO.setMsg("失败");
            resultVO.setData(productVO);
            e.printStackTrace();
        }


        return resultVO;
    }
}
