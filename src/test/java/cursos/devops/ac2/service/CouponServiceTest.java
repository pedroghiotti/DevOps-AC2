package cursos.devops.ac2.service;

import cursos.devops.ac2.dto.CouponDTO;
import cursos.devops.ac2.entity.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CouponServiceTest {

    @Autowired CouponService couponService;

    @Test
    public void ShouldCreateCouponProperly() {
        // Arrange
        CouponDTO couponDTO = new CouponDTO(25d, false);

        // Action
        couponService.createCoupon(couponDTO);

        //Assertion
        assertEquals(couponService.getAllCoupons().size(), 1);

        assertEquals(Coupon.fromDTO(couponService.getCouponById(1L)).hashCode(), Coupon.fromDTO(couponDTO).hashCode());
    }

}
