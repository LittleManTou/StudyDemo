package com.mantou.utils;

import com.github.pagehelper.PageInfo;
import com.mantou.entity.PageRequest;
import com.mantou.entity.PageResult;


public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
