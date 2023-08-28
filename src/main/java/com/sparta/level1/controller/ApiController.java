package com.sparta.level1.controller;

import com.sparta.level1.dto.RequestDto;
import com.sparta.level1.dto.ResponseDto;
import com.sparta.level1.dto.ResponseDtoTwo;
import com.sparta.level1.service.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") // URL에서 api가 공통부분이여서 중복제거
public class ApiController {
    // ApiController -> ApiService -> ApiRepository 현재 강한 결합
    //약하게 만들어보자
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/post") //입력
    public ResponseDto createApi(@RequestBody RequestDto requestDto) {
        return apiService.createApi(requestDto);
    }

    @GetMapping("/posts") // 모두 조회
    public List<ResponseDtoTwo> getAllApi() {
        return apiService.getAllApi();

    }

    @GetMapping("/post/{id}") // 선택 조회
    public List<ResponseDtoTwo> getApiSelect(@PathVariable long id) {
        return apiService.getApiSelect(id);
    }

    @PutMapping("post/{id}")
    public RequestDto updateApi(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        return apiService.updateApi(id, requestDto);
    }

    @DeleteMapping("post/{id}")
    public Map<String, Object> deleteApi(@PathVariable Long id) {
        return apiService.deleteApi(id);
    }
}