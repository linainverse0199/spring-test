package com.example.demo.dao;

import com.example.demo.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository("userDao")
@Slf4j
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;

    private final RowMapper<User> mapper = (rs, num) -> {
        User user = new User("", LocalDateTime.now());
        user.setName(rs.getString("name"));
        user.setId(rs.getLong("id"));
        return user;
    };

    public User getOne(long id) {

        return jdbc.queryForObject("select * from user where id=?", mapper, id);
    }

    public List<User> getList() {
        return jdbc.query("select * from user", mapper);
    }

    public User save(User user) {
        // jdbc.update("insert into user (id, name, birthday) values (?, ?, ?)", user.getId(), user.getName(), user.getBirthday());
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into USER (name, birthDate) values (?, ?)", Types.VARCHAR, Types.TIMESTAMP)
                .newPreparedStatementCreator(Arrays.asList(user.getName(),user.getBirthDate()));
        KeyHolder kh = new GeneratedKeyHolder();
        jdbc.update(psc, kh);
        user.setId(kh.getKey().longValue());
        return user;
    }

}
