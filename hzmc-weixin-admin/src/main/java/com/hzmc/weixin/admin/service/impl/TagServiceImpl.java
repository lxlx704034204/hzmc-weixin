package com.hzmc.weixin.admin.service.impl;

import com.hzmc.weixin.admin.base.BaseServiceImpl;
import com.hzmc.weixin.admin.dao.mapper.WxTagMapper;
import com.hzmc.weixin.admin.dao.model.WxTag;
import com.hzmc.weixin.admin.dao.model.WxTagExample;
import com.hzmc.weixin.admin.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TagService实现
* Created by wph on 2017/5/4.
*/
@Service
@Transactional
public class TagServiceImpl extends BaseServiceImpl<WxTagMapper, WxTag, WxTagExample> implements TagService {

    private static Logger LOGGER = LoggerFactory.getLogger(TagServiceImpl.class);

    @Autowired
    WxTagMapper tagMapper;

}