package com.imooc.sell;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：aa
 * <dd>类描述：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/29
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
public class aa {
    public static void main(String[] args) {

        String s = "5465465465465432198765432";

        String s1 = s.replace("1987", "aaaa");

        System.out.println(s);
        System.out.println(s1);

        s = s.replaceFirst("5465","oooo").replace("654321","99999");
        System.out.println(s);
    }
}
