package com.offcn.controller;

import com.offcn.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangzz
 * @date 2019/12/25 14:10
 */

@RestController
@RequestMapping("/user")
public class UserController {
    //线程安全集合
    List<User> list = Collections.synchronizedList(new ArrayList<User>());

    //创建用户
    @PostMapping("/")
    @ApiOperation(value = "新增用户" ,notes = "补充描述")
    @ApiImplicitParam(name = "user",value = "传递json类型的参数",dataType = "User")
    /*@RequestMapping(method = RequestMethod.POST,path = "/")*/
    public String add(@RequestBody User user){

        try {
            list.add(user);
            return "add-success";
        } catch (Exception e) {
            e.printStackTrace();
            return "add-fail";
        }

    }
    //查询用户列表
    @GetMapping("/")
    @ApiOperation(value = "查询用户列表" ,notes = "补充描述")
    public List<User> findAll(){
        return list;
    }

    //根据id 查询单个用户
    @GetMapping("/{id}")
    @ApiOperation(value = "查询单个用户" ,notes = "补充描述")
    @ApiImplicitParam(name = "id",value = "传递用户id",dataType = "Long")
    public User findOne(@PathVariable("id") Long id){
        for (User user : list) {
            if (user.getId().longValue()==id.longValue()){
                return user;
            }
        }
        return null;
    }

    //更新指定用户
    @PutMapping("/{id}")
    @ApiOperation(value = "更新指定用户" ,notes = "补充描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "传递用户id", dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "传递json格式数据用户", dataType = "User")
    }
    )

    public String update(@PathVariable("id") Long id, @RequestBody User user){
        for (User user1 : list) {
            if (user1.getId().longValue()==id.longValue()){
                user1.setName(user.getName());
                user1.setAge(user.getAge());
                return "update-success";
            }
        }
        return "update-fail";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除单个用户" ,notes = "补充描述")
    @ApiImplicitParam(name = "id",value = "传递用户id",dataType = "Long")
    public String delete(@PathVariable("id") Long id){
        for (User user : list) {
            if (user.getId().longValue()==id.longValue()){
                list.remove(user);
                return "update-success";
            }
        }
        return "update-fail";

    }
}
