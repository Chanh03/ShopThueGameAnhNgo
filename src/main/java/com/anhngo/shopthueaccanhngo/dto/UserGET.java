package com.anhngo.shopthueaccanhngo.dto;

import com.anhngo.shopthueaccanhngo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGET {
    private String username;
//    private String password;
    private Boolean enabled;
    private String phone;
    private String email;
    private String fullName;
    private Date ngayTao;
    private String address;
    private String hinhAnh;
    private Long money;

    public UserGET(User user) {
        this.username = user.getUsername();
//        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.fullName = user.getFullName();
        this.ngayTao = user.getNgayTao();
        this.address = user.getAddress();
        this.hinhAnh = user.getHinhAnh();
        this.money = user.getMoney();
    }
}
