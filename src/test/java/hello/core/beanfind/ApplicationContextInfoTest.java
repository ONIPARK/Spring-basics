package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("全てのBean名を出力する")
    void findAllBean() {
        // Beanに定義された名前を登録
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // AppContextからBeanを取り出す。
            Object bean = ac.getBean(beanDefinitionName);
            // beanDefinitionName = Key / bean = value
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }
    }@Test
    @DisplayName("アプリケーションBean名を出力する")
    void findApplicationBean() {
        // Beanに定義された名前を登録
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // getBeanDefinition()はビーンのmetadata情報
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // Role ROLE_APPLICATION: 私がアプリケーションで利用するために登録したBean
            // Role ROLE_INFRASTRUCTURE: Springが内部で使用するBean
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                // 私がアプリケーションで利用するために登録したBean
                Object bean = ac.getBean(beanDefinitionName);
                // beanDefinitionName = Key / bean = value
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
