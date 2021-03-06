package cn.blatter.network.controller;

import cn.blatter.network.common.ServiceResponse;
import cn.blatter.network.domain.Menu;
import cn.blatter.network.mapper.MenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tanyao
 * @Date 2020/7/22 17:26
 */
@Slf4j
@RestController
public class MenuController {

	@Autowired
	private MenuMapper menuMapper;

	@RequestMapping(value = "/menus", method = RequestMethod.GET)
	public ServiceResponse getMenus() {
		log.info("开始查询导航菜单...");
		List<Menu> menus = menuMapper.findAll();
		if (menus != null) {
			log.info("导航菜单查询成功：" + menus);
			return ServiceResponse.createBySuccess("查询成功", menus);
		}
		log.info("导航菜单查询失败！");
		return ServiceResponse.createByErrorMessage("查询列表失败");
	}
}
