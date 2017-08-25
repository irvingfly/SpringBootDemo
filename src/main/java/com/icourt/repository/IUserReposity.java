

package com.icourt.repository;

import com.icourt.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Zhangtengfei
 * @date 2017-8-23
 * 实现jpa接口，方便数据库操作
 */
public interface IUserReposity extends JpaRepository<com.icourt.entity.UserDO, Integer> {

    @Modifying
    @Query("update UserDO u set u.userName = ?1 ,u.age=?2 where u.id=?3")
    int updateUserById(@Param("userName") String userName,@Param("age") Integer age, @Param("id") Integer id);
}
