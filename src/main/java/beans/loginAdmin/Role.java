package beans.loginAdmin;

import java.util.List;

public class Role {

    //  Danh sách vai trò
    private List<String> roles;

    //  Constructor chỉ nhận vào danh sách vai trò
    public Role(List<String> roles) {
        this.roles = roles;
    }

    //  Phương thức kiểm tra vai trò
    public boolean accept(String role) {
        if (role == null) return false;
        return roles.contains(role);
    }

    //  Getter and setter
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
