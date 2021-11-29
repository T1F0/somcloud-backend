package com.som.springboot.generationAlgorithm.controller;

import com.som.springboot.generationAlgorithm.service.GAService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scheme")
@Api(tags = "调度管理")
public class GAController {

	GAService gaService = new GAService();

	@GetMapping("/start")
	@ApiOperation("开始计算")
	public String start() {
			return gaService.start();
		}
}
