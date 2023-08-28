package com.sparta.level1.repository;

import com.sparta.level1.dto.RequestDto;
import com.sparta.level1.dto.ResponseDto;
import com.sparta.level1.dto.ResponseDtoTwo;
import com.sparta.level1.entity.Api;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Setter
@Getter
@Repository
public class ApiRepository {
    private final JdbcTemplate jdbcTemplate;

    public ApiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Api save(Api api) {
        // DB 저장
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO api (title, author, pw, contents, time) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, api.getTitle());
                    preparedStatement.setString(2, api.getAuthor());
                    preparedStatement.setString(3, api.getPw());
                    preparedStatement.setString(4, api.getContents());
                    preparedStatement.setString(5, api.getTime());
                    return preparedStatement;
                },
                keyHolder);
        // DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        api.setId(id);

        return api;
    }

    public List<ResponseDtoTwo> findAll() {
        // DB 조회
        String sql = "SELECT * FROM api";
        ArrayList<ResponseDto> ApiResponsedata = (ArrayList<ResponseDto>)
                jdbcTemplate.query(sql, new RowMapper<ResponseDto>() {
                    @Override
                    public ResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                        return new ResponseDto(
                                new Api(
                                        rs.getLong("id"),
                                        rs.getString("title"),
                                        rs.getString("author"),
                                        rs.getString("pw"),
                                        rs.getString("contents"),
                                        rs.getString("time")
                                )
                        );
                    }
                });
            return ApiResponsedata.stream().sorted((a1,a2)->a2.getTime().compareTo(a1.getTime()))
                    .map(f->new ResponseDtoTwo(f.getTitle(),f.getAuthor(),f.getContents(),f.getTime()))
                    .collect(Collectors.toList());
    }

    public void update(Long id, RequestDto requestDto) {
        String sql = "UPDATE api SET title = ?, author = ?, pw = ?, contents = ? WHERE id = ?";
        jdbcTemplate.update(sql, requestDto.getTitle(), requestDto.getAuthor(), requestDto.getPw(), requestDto.getContents(), id);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM api WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Api findById(Long id) {
        // DB 조회
        String sql = "SELECT * FROM api WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Api api = new Api();
                api.setTitle(resultSet.getString("title"));
                api.setAuthor(resultSet.getString("author"));
                api.setPw(resultSet.getString("pw"));
                api.setContents(resultSet.getString("contents"));
                api.setTime(resultSet.getString("time"));
                return api;
            } else {
                return null;
            }
        }, id);
    }

    public Api api(Long id) {
        // DB 조회
        String sql = "SELECT * FROM api WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Api api = new Api();
                api.setTitle(resultSet.getString("title"));
                api.setAuthor(resultSet.getString("author"));
                api.setPw(resultSet.getString("pw"));
                api.setContents(resultSet.getString("contents"));
                api.setTime(resultSet.getString("time"));
                return api;
            } else {
                return null;
            }
        }, id);
    }
}