package com.huanghao.controller.user;

import com.huanghao.Result;
import com.huanghao.bo.b.user.LoginBO;
import com.huanghao.constant.CookieConstant;
import com.huanghao.controller.BaseController;
import com.huanghao.service.BUserService;
import com.huanghao.util.CookieUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author HuangHao
 * @date 2021/8/9 23:29
 */
@RestController
@RequestMapping("/b/user")
public class UserController extends BaseController {

    @Resource
    private BUserService bUserService;


    @PostMapping("/login")
    public Result login(@Valid @RequestBody LoginBO loginBO, HttpServletRequest request, HttpServletResponse response) {
        // 1.验证登录信息，并生成token
        String token = bUserService.bLogin(loginBO);

        // 2.写入cookie
        CookieUtil.setCookie(request, response, CookieConstant.B_USER_LOGIN_TOKEN, token);

        return Result.ok(token);
    }

    @PostMapping("/logout")
    public Result logout(@RequestParam String token, HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(request, response, CookieConstant.B_USER_LOGIN_TOKEN);
        bUserService.bLogout(token);
        return Result.ok("ok");
    }

    @GetMapping("/getBUserByToken")
    public Result getBUser(@RequestParam String token) {
        return Result.ok(bUserService.getBUserByToken(token));
    }

    @GetMapping("/getPermissionMenu")
    public Result getPermissionMenu(@RequestParam String token) {
        return Result.ok(bUserService.getPermissionMenu(token));
    }


}
