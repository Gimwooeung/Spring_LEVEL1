package com.sparta.level1.controller;

import com.sparta.level1.dto.RequestDto;
import com.sparta.level1.dto.ResponseDto;
import com.sparta.level1.entity.Api;
import com.sparta.level1.service.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/post") //입력
    public ResponseDto createApi(@RequestBody RequestDto requestDto) {
        return apiService.createApi(requestDto);
    }

    @GetMapping("/posts") // 모두 조회
    public List<ResponseDto> getAllApi() {
        return apiService.getAllApi();
    }

    @GetMapping("/post/{id}") // 선택 조회
    public ResponseDto getApiSelect(@PathVariable Long id) {
        return apiService.getApiSelect(id);
    }

    @PutMapping("post/{id}")
    public ResponseDto updateApi(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        Api updatedApi = apiService.updateApi(id, requestDto);
        ResponseDto responseDto = new ResponseDto(updatedApi);
        return responseDto;
    }


    @DeleteMapping("post/{id}")
    public Map<String, Boolean> deleteApi(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        boolean success = apiService.deleteApi(id, requestBody.get("password"));
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", success);
        return response;
    }
}