package com.naver.myhome1.sample4;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Autowired 사용해 보기
 * - @Autowired은 생성자나 메서드, 멤버변수 위에 모두 사용할 수 있습니다.
 * - 자동 주입 기능을 사용하면 스프링 컨테이너는 알아서 의존 객체를 찾아서 주입해 줍니다.
 * - 즉, 해당 타입에 할당할 수 있는 빈 객체를 찾아서 주입합니다.
 * - @Autowired 애노테이션을 적용하면 반드시 주입할 의존 객체가 존재해야 합니다.
 * - 만약 @Autowired가 붙은 객체가 메모리에 없다면 스프링 컨테이너가 NoSuchBeanDefinitionException 을 발생시킵니다.
 *
 *   자동 주입 기능을 위한 두 가지 사용
 *   1) 자동 주입 대상에 @Autowired 애노테이션 사용
 *   2) XML 설정에 <context:annotation-config/> 사용
 */

/**
 * @Qualifier("m1") 생략한 경우 오류 발생
 *
 * MessageBean 타입의 빈이 "m"과 "m1" 두 개가 존재해서 어떤 객체를 주입할지 모르기 때문에 발생하는 예외입니다.
 *
 * @Qualifier annotation을 이용해서 주입될 객체의 아이디나 이름을 지정할 수 있습니다.
 *
 * @Autowired와 @Qualifier을 한 번에 처리할 수 있는 것이 @Resource입니다.
 */

@Component
public class MessageMultiple {

    private MessageBean messageBean;

    //해당 타입에 할당할 수 있는 빈 객체를 찾아서 자동 주입됩니다.
    //반드시 주입할 의존 객체가 존재해야합니다.

    @Autowired
    @Qualifier("m1")
    public void setBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }

    public MessageMultiple() {
        System.out.println("MessageMultiple 생성자입니다.");
    }

    public void print() {
        messageBean.sayHello("Spring");
    }
}
