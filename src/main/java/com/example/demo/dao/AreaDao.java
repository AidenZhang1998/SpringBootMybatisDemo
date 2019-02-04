package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Area;

/**
 * 对区域的crud操作接口
 *
 */
public interface AreaDao {
	/**
	 * 返回所有区域信息
	 *
	 */
   List<Area> Queryareas();
   /**
	 * 查询一条区域信息
	 *
	 */
   Area FindById(int  areaId);
   /**
	 * 增加一条信息
	 *
	 */
   int Insert(Area area);
   /**
	 * 修改一条信息
	 *
	 */
   int Update(Area area);
   /**
	 * 删除
	 *
	 */
   int Delete(int areaId);
}
