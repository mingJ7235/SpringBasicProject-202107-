package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    //    private DataSource dataSource;//properties를 보고 bean으로 설정해준다.
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) { //생성자로 DI 주입 !
//        this.dataSource = dataSource;
//    }

    //직접 자바코드로 스프링 빈 등록하기
    @Bean
    public MemberService memberService () {
        return new MemberService(memberRepository);
    }

    //개방 폐쇄원칙에 철저하다.. !! OCP !

    //조립하기
//    @Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }

    //AOP bean으로 등록하기
//    @Bean
//    public TimeTraceAop timeTraceAop () {
//        return new TimeTraceAop();
//    }
}
