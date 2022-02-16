package com.heypli.springboottest.app.book;


import com.heypli.springboottest.app.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

// JPA테스트가 끝날때마다 자동으로 테스트에 사용한 데이터 롤백
@DataJpaTest
// Replace.Any를 사용하면 내장된 데이터 소스를 사용하고
// Replace.NONE을 설정하면 ActiveProfiles에 설정한 환경값에 따라 적용된다.
// spring.test.database.replace: NONE 도 가능
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE,
        connection = EmbeddedDatabaseConnection.H2)
//@ActiveProfiles("dev")
public class JpaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;



}
