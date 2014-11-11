package cn.com.jbp.mapper;

import cn.com.jbp.pojo.JoinActivity;
import cn.com.jbp.pojo.JoinActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoinActivityMapper {
    int countByExample(JoinActivityExample example);

    int deleteByExample(JoinActivityExample example);

    int insert(JoinActivity record);

    int insertSelective(JoinActivity record);

    List<JoinActivity> selectByExample(JoinActivityExample example);

    int updateByExampleSelective(@Param("record") JoinActivity record, @Param("example") JoinActivityExample example);

    int updateByExample(@Param("record") JoinActivity record, @Param("example") JoinActivityExample example);
}