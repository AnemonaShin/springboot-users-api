package cl.users.api.model;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false, columnDefinition = "BIGINT")
    BigInteger id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String lastName;
    @Column(unique = true, nullable = false)
    String email;
    @Column(nullable = false)
    String address;
    @Column(nullable = false)
    Date createAt;
    @Column(nullable = false)
    Date updatedAt;
    @Column(nullable = false)
    Boolean active;

}
