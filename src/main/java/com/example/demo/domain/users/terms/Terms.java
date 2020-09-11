package com.example.demo.domain.users.terms;

import com.example.demo.domain.admins.admin.AdminUser;
import com.example.demo.domain.users.terms.enums.TermsType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "terms")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Terms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "terms_type", nullable = false)
    private TermsType termsType;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    @Column(name = "contents", columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Column(name = "required_yn", nullable = false)
    private Boolean required;

    @Column(name = "order_no", nullable = false)
    private Long orderNo;

    @Column(name = "use_yn", nullable = false)
    private Boolean useYn;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private AdminUser createdBy;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private AdminUser updatedBy;
}
