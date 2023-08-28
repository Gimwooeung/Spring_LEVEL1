package com.sparta.level1.service;

import com.sparta.level1.dto.RequestDto;
import com.sparta.level1.dto.ResponseDto;
import com.sparta.level1.dto.ResponseDtoTwo;
import com.sparta.level1.entity.Api;
import com.sparta.level1.repository.ApiRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApiService {
    private final ApiRepository apiRepository;

    public ApiService(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public ResponseDto createApi(RequestDto requestDto) {
        // RequestDto -> Entity //서비스에서 작동
        Api api = new Api(requestDto);
        Calendar cal = Calendar.getInstance();        // getInstance 메소드를 호출해 객체 생성
        SimpleDateFormat date = new SimpleDateFormat("yyyy년-MM월-dd일-HH시-mm분-ss초"); // 포매팅 설정하기
        String time = date.format(cal.getTime()); // time이라는 변수에 포매팅한 getTime값을 넣어주기
        api.setTime(time); // api객체에 넣어주기
        System.out.println(time);

        // DB 저장 //Repository
        Api saveapi = apiRepository.save(api);

        // Entity -> ResponseDto
        ResponseDto responseDto = new ResponseDto(api);
        return responseDto;
    }

    public List<ResponseDtoTwo> getAllApi() {
        // DB 조회
        return apiRepository.findAll();
    }

    public List<ResponseDtoTwo> getApiSelect(long id) {
        // DB 조회
        return getAllApi().stream().filter(a->a.getTime().equals(apiRepository.findById(id).getTime())).collect(Collectors.toList());
    }


    public RequestDto updateApi(Long id, RequestDto requestDto) {
                //해당 내용이 DB에 존재하는지 확인

        Api api = apiRepository.findById(id);
        if (api != null) {
            // Api 내용 수정하기
            apiRepository.update(id, requestDto);

            return requestDto;
        } else {
            throw new IllegalArgumentException("선택한 내용은 존재하지 않습니다");
        }
    }
    public Map<String, Object> deleteApi(Long id) {
        Map<String, Object> response = new HashMap<>();

        // 해당 내용이 DB에 존재하는지 확인
        Api api = apiRepository.findById(id);
        if (api != null) {
            // Api 내용 삭제
            apiRepository.delete(id);

            response.put("success", true);
            return response;
        } else {
            response.put("success", false);
            response.put("message", "선택한 내용은 존재하지 않습니다.");
            return response;
        }
    }
}

