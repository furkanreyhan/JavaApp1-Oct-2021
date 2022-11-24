package com.olcaycetin.app.service.rest.place.service;

import com.olcaycetin.app.service.rest.place.dto.PlaceInfoSaveDTO;
import com.olcaycetin.app.service.rest.place.mapper.IPlaceInfoMapper;
import org.csystem.app.weather.repository.data.dal.WeatherInfoAppHelper;
import org.springframework.stereotype.Service;

@Service
public class PlaceInfoService {
    public final WeatherInfoAppHelper m_placeInfoServiceHelper;
    public final IPlaceInfoMapper m_placeInfoMapper;

    public PlaceInfoService(WeatherInfoAppHelper placeInfoServiceHelper, IPlaceInfoMapper placeInfoMapper)
    {
        m_placeInfoServiceHelper = placeInfoServiceHelper;
        m_placeInfoMapper = placeInfoMapper;
    }

    public PlaceInfoSaveDTO savePlaceInfo(PlaceInfoSaveDTO placeInfoDTO)
    {
        var pi = m_placeInfoMapper.toPlaceInfo(placeInfoDTO);
        m_placeInfoServiceHelper.savePlaceInfo(pi);

        return m_placeInfoMapper.toPlaceInfoDto(pi);
    }

    public void deleteById(int id)
    {
        m_placeInfoServiceHelper.deletePlaceInfoById(id);
    }

}
