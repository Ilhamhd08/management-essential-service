package id.co.projectjava.ip.me.controller;

import id.co.projectjava.ip.me.dto.request.PageDataRequestDto;
import id.co.projectjava.ip.me.dto.response.ResponseDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/form/{formCode}")
public interface BaseFormController {

    @PostMapping("/config")
    ResponseEntity<ResponseDto<Map<String, Object>>> requestConfig(@PathVariable String formCode, @RequestBody(required = false)PageDataRequestDto pageDataRequestDto);

    @PostMapping("/list")
    ResponseEntity<ResponseDto<Map<String, Object>>> list(@PathVariable String formCode, @RequestBody(required = false) PageDataRequestDto pageDataRequestDto);

    @PostMapping("/create")
    ResponseEntity<ResponseDto<Map<String, Object>>> create(@PathVariable String formCode, @RequestBody Map<String, Object> body, @RequestParam(required = false) Boolean approval);

    @PostMapping("/update")
    ResponseEntity<ResponseDto<Map<String, Object>>> update(@PathVariable String formCode, @RequestBody Map<String, Object> body, @RequestParam(required = false ) Boolean approval);
/*
    @PostMapping("/delete")
    ResponseEntity<ResponseDto<Map<String, Object>>> delete(@PathVariable String formCode, @Query("key") String key);*/

}
