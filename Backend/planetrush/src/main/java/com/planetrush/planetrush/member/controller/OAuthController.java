package com.planetrush.planetrush.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planetrush.planetrush.core.template.response.BaseResponse;
import com.planetrush.planetrush.member.controller.request.KakaoLoginReq;
import com.planetrush.planetrush.member.controller.request.KakaoLogoutReq;
import com.planetrush.planetrush.member.service.OAuthService;
import com.planetrush.planetrush.member.service.dto.LoginDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OAuthController extends MemberController {

	private final OAuthService oAuthService;

	@PostMapping("/auth/login/kakao")
	public ResponseEntity<BaseResponse<LoginDto>> doKakaoLogin(@RequestBody KakaoLoginReq req) {
		LoginDto res = oAuthService.kakaoLogin(req.getAccessToken());
		return ResponseEntity.ok(BaseResponse.ofSuccess(res));
	}

	@PostMapping("/auth/logout/kakao")
	public ResponseEntity<BaseResponse<?>> doKakaoLogout(@RequestBody KakaoLogoutReq req) {
		oAuthService.kakaoLogout(req.getAccessToken());
		return ResponseEntity.ok(BaseResponse.ofSuccess());
	}

}
