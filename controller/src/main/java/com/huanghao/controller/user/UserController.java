package com.huanghao.controller.user;

import com.huanghao.Result;
import com.huanghao.bo.b.user.LoginBO;
import com.huanghao.service.BUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author HuangHao
 * @date 2021/8/9 23:29
 */
@RestController
@RequestMapping("/b/user")
public class UserController {

    @Resource
    private BUserService bUserService;


    @PostMapping("/login")
    public Result login(@Valid @RequestBody LoginBO loginBO) {
        return Result.ok(bUserService.compareUsernameAndPassword(loginBO));
    }
}
