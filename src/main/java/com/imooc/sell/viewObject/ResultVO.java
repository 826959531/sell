package com.imooc.sell.viewObject;

import lombok.Data;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：ResultVO
 * <dd>类描述：
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
@Data
public class ResultVO<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态描述，提示信息
     */
    private String msg;
    /**
     * 返回的具体内容
     */
    private T data;
}
