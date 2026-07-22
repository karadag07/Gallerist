package com.karadag.galeri.service;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestGallerist;
import com.karadag.galeri.dto.ResponseGallerist;
import com.karadag.galeri.entity.Gallerist;
import com.karadag.galeri.mapper.GalleristMapper;
import com.karadag.galeri.repository.GalleristRepository;
import com.karadag.galeri.service.IService.IGalleristService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleristServiceImpl implements IGalleristService {

    private final GalleristRepository galleristRepository;
    private final GalleristMapper galleristMapper;

    @Override
    public ResponseGallerist saveGallerist(RequestGallerist request) {
        Gallerist gallerist = galleristMapper.toEntity(request);

        Gallerist savedGallerist = galleristRepository.save(gallerist);

        return galleristMapper.toResponse(savedGallerist);
    }
}
