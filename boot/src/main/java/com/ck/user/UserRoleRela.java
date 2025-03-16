package ck.tools.user;

import ck.tools.role.Role;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ct_user_role_rela")
@IdClass(UserRoleRela.UserRoleRelaId.class)
public class UserRoleRela {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRoleRela() {}

    public UserRoleRela(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static class UserRoleRelaId implements Serializable {
        private Long userId;
        private Long roleId;

        public UserRoleRelaId() {}

        public UserRoleRelaId(Long userId, Long roleId) {
            this.userId = userId;
            this.roleId = roleId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            UserRoleRelaId that = (UserRoleRelaId) o;

            if (!userId.equals(that.userId)) return false;
            return roleId.equals(that.roleId);
        }

        @Override
        public int hashCode() {
            int result = userId.hashCode();
            result = 31 * result + roleId.hashCode();
            return result;
        }
    }
}
