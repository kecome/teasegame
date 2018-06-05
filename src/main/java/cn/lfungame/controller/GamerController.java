package cn.lfungame.controller;

import cn.lfungame.model.Gamer;
import cn.lfungame.service.GamerService;
import cn.lfungame.util.ResponseMsg;
import cn.lfungame.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xuke
 * @Date: 2018/6/4 14:47
 * @Description:
 */
@RestController
@RequestMapping("/gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    /**
     * 更新玩家信息
     * @param gamer
     * @return
     */
    @PostMapping("/update")
    Object updateGamer(@RequestBody Gamer gamer) {
        ResponseMsg msg = new ResponseMsg();
        System.out.println("当前用户id:" + UserUtil.getCurrentUserId());
        gamer.setId(UserUtil.getCurrentUserId());
        gamerService.updateGamer(gamer);
        msg.setMessage("更新成功");
        return msg;
    }
}