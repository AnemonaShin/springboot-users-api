package cl.potion.api.entity;

import java.math.BigInteger;
import java.util.Date;

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
@Table(name = "Potion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PotionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "potion_id", unique = true, nullable = false, columnDefinition = "BIGINT")
    BigInteger id;
    @Column(unique = true, nullable = false)
    String name;
    @Column(nullable = false)
    String type;
    @Column(nullable = false)
    Date createAt;
    @Column(nullable = false)
    Date updatedAt;
}
