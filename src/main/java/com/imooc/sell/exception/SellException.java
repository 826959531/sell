package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：SellException
 * <dd>类描述：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/28
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
