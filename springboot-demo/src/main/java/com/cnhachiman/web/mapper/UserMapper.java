package com.cnhachiman.web.mapper;

import com.cnhachiman.web.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE id= #{id} ")
    List<User> findById(@Param("id") Long id);
}
