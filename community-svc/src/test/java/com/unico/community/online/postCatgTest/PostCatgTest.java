package com.unico.community.online.postCatgTest;


import com.unico.community.online.postCatg.service.PostCatgService;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostCatgTest {
    @Rule
    public final TestName testName = new TestName();
    private final JdbcTemplate template;
    private final PostCatgService service;

    public PostCatgTest(JdbcTemplate template,PostCatgService service){
        this.template = template;
        this.service = service;
    }

    @Before
    public void setup(){
        if ("findAll_test_01".equals(testName.getMethodName())) {
            bacthUpdateQuery("" +
                    "insert into " +
                    "(POST_CATG_UUID, POST_CATG_NM, POST_CATG_USE_YN, REGN_NM) " +
                    "valuess ('test', 'test', 1, '경기도');");
        }
    }

    @After
    public void tearDown(){
        if ("findAll_test_01".equals(testName.getMethodName())) {
            bacthUpdateQuery("" +
                    "delete from " +
                    "TB_POST_CATG_M  " +
                    "where POST_CATG_UUID = 'test' and POST_CATG_NM = 'test'and POST_CATG_USE_YN = 1 and REGN_NM = '경기도';");
        }
    }


    @Test
    public void findAll_test_01() {
        Assertions.assertThat(
            service
            .findAll()
            .stream()
            .allMatch(postCatgDTO -> postCatgDTO.getPostCatgUuid().equals("test") &&
                    postCatgDTO.getPostCatgNm().equals("test") &&
                    postCatgDTO.isPostCatgUseYn() &&
                    postCatgDTO.getRegnNm().equals("경기도"))
        ).isTrue();

    }


    private void bacthUpdateQuery(String sqls){
        template.batchUpdate(sqls.split(";"));
    }
}
