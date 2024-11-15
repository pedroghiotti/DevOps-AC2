package cursos.devops.ac2.service;

import cursos.devops.ac2.dto.CouponDTO;
import cursos.devops.ac2.entity.Coupon;
import cursos.devops.ac2.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponService {

    @Autowired private CouponRepository couponRepository;

    public Coupon createCoupon(CouponDTO couponDTO) {
        Coupon newCoupon = Coupon.fromDTO(couponDTO);
        couponRepository.save(newCoupon);
        return newCoupon;
    }

    public List<CouponDTO> getAllCoupons() {
        List<Coupon> coupons = couponRepository.findAll();
        return coupons.stream().map(CouponDTO::fromEntity).collect(Collectors.toList());
    }

    @Transactional
    public CouponDTO getCouponById(Long id) {
        return CouponDTO.fromEntity(couponRepository.getById(id));
    }

}
