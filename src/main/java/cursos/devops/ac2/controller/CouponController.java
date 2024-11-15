package cursos.devops.ac2.controller;

import cursos.devops.ac2.dto.CouponDTO;
import cursos.devops.ac2.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/coupons")
public class CouponController {

    @Autowired private CouponService couponService;

    @GetMapping
    public List<CouponDTO> getCoupons() {
        return couponService.getAllCoupons();
    }

    @PostMapping
    public void createCoupon(@RequestBody CouponDTO couponDTO) {
        couponService.createCoupon(couponDTO);
    }

}
