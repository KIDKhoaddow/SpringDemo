package DAO;

import model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProvinceRepository extends JpaRepository<Province,Long>  {
  @Query(value = "select * from province p order by p.gdp_province asc ", nativeQuery = true)
    Iterable<Province> findAllOrderByGDPAsc();
}
