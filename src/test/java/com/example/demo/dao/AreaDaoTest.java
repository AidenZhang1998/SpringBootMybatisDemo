package com.example.demo.dao;



import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;



import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Area;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

	@Autowired
	AreaDao areaDao;
	@Test
	@Ignore
	public void testQueryareas() {
		List<Area> areas=areaDao.Queryareas();
		assertEquals(3, areas.size());
	}

	@Test
	public void testFindById() {
		Area area=areaDao.FindById(1);
		System.out.println(area.toString());
	}

	@Test
	@Ignore
	public void testInsert() {
		Area area = new Area();
		area.setAreaName("食堂");
		area.setPriority(15);
		areaDao.Insert(area);
	}

	@Test
	public void testUpdate() {
		List<Area> areaList = areaDao.Queryareas();
		for (Area area : areaList) {
			System.out.println(area.getAreaName());
			if ("食堂".equals(area.getAreaName())) {
				// 对比之前的priority值
				
				area.setAreaName("一号食堂");
				area.setPriority(9);
				Date date=new Date();
				area.setLastEditTime(date);
				int effectedNum = areaDao.Update(area);
				assertEquals(1, effectedNum);
			}
		}
	}

	@Test
	@Ignore
	public void testDelete() {
		areaDao.Delete(15);
		List<Area> areas=areaDao.Queryareas();
		assertEquals(3, areas.size());
	}

}
