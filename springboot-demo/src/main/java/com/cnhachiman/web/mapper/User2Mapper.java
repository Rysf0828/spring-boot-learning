package com.cnhachiman.web.mapper;

import com.cnhachiman.web.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface User2Mapper {

    List<User> findById(@Param("id") Long id);
}
