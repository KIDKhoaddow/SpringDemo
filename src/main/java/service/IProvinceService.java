package service;

import model.Province;
import org.springframework.data.domain.Page;

public interface IProvinceService extends ICRUDService<Province>{
    public Iterable<Province> findProvinceOrderByGDPAsc();
}
