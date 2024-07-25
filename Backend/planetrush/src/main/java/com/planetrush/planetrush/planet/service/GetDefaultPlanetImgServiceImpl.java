package com.planetrush.planetrush.planet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planetrush.planetrush.image.repository.DefaultPlanetImgRepository;
import com.planetrush.planetrush.planet.domain.image.DefaultPlanetImg;
import com.planetrush.planetrush.planet.service.dto.GetDefaultPlanetImgDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetDefaultPlanetImgServiceImpl implements GetDefaultPlanetImgService {

	private final DefaultPlanetImgRepository defaultPlanetImgRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<GetDefaultPlanetImgDto> getAllImgUrls() {
		List<DefaultPlanetImg> images = defaultPlanetImgRepository.findAll();
		return images.stream()
			.map(img -> GetDefaultPlanetImgDto.builder()
				.imgId(img.getId())
				.imgUrl(img.getImgUrl())
				.build())
			.toList();
	}

}
