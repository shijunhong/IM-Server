package net.qiujuer.web.italker.push;

import net.qiujuer.web.italker.push.provider.GsonProvider;
import net.qiujuer.web.italker.push.service.AccountService;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

public class Application extends ResourceConfig {
    public Application(){
//        注册逻辑处理的包名
//        packages("net.qiujuer.web.italker.push.service");
        packages(AccountService.class.getPackage().getName());
        //注册json解析器
//        register(JacksonJaxbJsonProvider.class);
        register(GsonProvider.class);
        //注册日志打印输出
        register(Logger.class);

    }
}
