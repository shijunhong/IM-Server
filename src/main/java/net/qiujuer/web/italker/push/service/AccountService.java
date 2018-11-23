package net.qiujuer.web.italker.push.service;


import net.qiujuer.web.italker.push.bean.api.account.RegisterModel;
import net.qiujuer.web.italker.push.bean.api.card.UserCard;
import net.qiujuer.web.italker.push.bean.db.User;
import net.qiujuer.web.italker.push.factory.UserFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//127.0.0.1/api/account/...
@Path("/account")
public class AccountService {
    @POST
    @Path("/register")
    //指定请求与返回的响应体为JSON
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserCard register(RegisterModel model) {

        User user = UserFactory.register(
                model.getAccount(),
                model.getPassword(),
                model.getName());

        if (null != user) {
            UserCard card = new UserCard();
            card.setName(user.getName());
            card.setPhone(user.getPhone());
            card.setSex(user.getSex());
            card.setIsFollow(true);
            card.setModifyAt(user.getUptadeAt());
            return card;
        }

        return null;
    }

    @POST
    @Path("/test")
    //指定请求与返回的响应体为JSON
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int test() {

//        User user = UserFactory.register(
//                model.getAccount(),
//                model.getPassword(),
//                model.getName());
//
//        if (null != user) {
//            UserCard card = new UserCard();
//            card.setName(user.getName());
//            card.setPhone(user.getPhone());
//            card.setSex(user.getSex());
//            card.setIsFollow(true);
//            card.setModifyAt(user.getUptadeAt());
//            return card;
//        }

        return 111;
    }

}
